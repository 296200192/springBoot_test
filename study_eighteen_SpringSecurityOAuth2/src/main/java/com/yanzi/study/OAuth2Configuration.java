package com.yanzi.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class OAuth2Configuration {

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Autowired
        private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

        @Autowired
        private CustomLogoutSuccessHandler customLogoutSuccessHandler;


        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
            .exceptionHandling()
            .authenticationEntryPoint(customAuthenticationEntryPoint)
            .and()
            .logout()
            .logoutUrl("/oauth/logout")
            .logoutSuccessHandler(customLogoutSuccessHandler)
            .and()
            .authorizeRequests()
            .antMatchers("/hello/")
            .permitAll()
            .antMatchers("/secure/**")
            .authenticated();
        }

        @Configuration
        @EnableAuthorizationServer
        protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter implements EnvironmentAware{

            private static final String ENV_OAUTH = "authentication.oauth.";
            private static final String PROP_CLIENTID = "clientid";
            private static final String PROP_SECRET = "secret";
            private static final String PROP_TOKEN_VALIDITY_SECONDS = "tokenValidityInSeconds";

            @Autowired
            private DataSource dataSource;

            private Binder binder;
            @Bean
            public TokenStore tokenStore(){
                return new JdbcTokenStore(dataSource);
            }

            @Autowired
            @Qualifier("authenticationManagerBean")
            private AuthenticationManager authenticationManager;

            @Override
            public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
                endpoints
                .tokenStore(tokenStore())
                .authenticationManager(authenticationManager);
            }

            @Override
            public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//                clients
//                .inMemory()
//                .withClient(System.getenv(ENV_OAUTH))
//                .scopes("read","write")
//                .authorities(Authorities.ROLE_ADMIN.name(), Authorities.ROLE_USER.name());
            }

            @Override
            public void setEnvironment(Environment environment) {

            }
        }
    }

}
