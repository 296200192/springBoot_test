package com.yanzi.study.lession7.core;

import com.yanzi.study.lession7.entity.MailEntity;
import com.yanzi.study.lession7.enums.MailContentTypeEnum;
import org.apache.logging.log4j.util.PropertiesUtil;

import java.util.List;
import java.util.Properties;

public class MailSender {
    //邮件实体
    private static MailEntity mail = new MailEntity();

    /**
     * 设置邮件标题
     * @param title
     * @return
     */
    public MailSender title (String title){
        mail.setTitle(title);
        return this;
    }

    /**
     * 设置邮件内容
     * @param content
     * @return
     */
    public MailSender content(String content){
        mail.setContent(content);
        return this;
    }

    /**
     * 设置邮件格式
     * @return
     */
    public MailSender contentType(MailContentTypeEnum typeEnum){
        mail.setContentType(typeEnum.getValue());
        return this;
    }

    /**
     * 设置请求目标邮件地址
     * @param targets
     * @return
     */
    public MailSender targets(List<String> targets){
        mail.setList(targets);
        return this;
    }

    /**
     * 执行发送邮件
     * @throws Exception
     */
    public void send() throws Exception{
        //默认使用HTML内容发送
        if(mail.getContentType()==null)
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        if(mail.getTitle()==null || mail.getTitle().length()==0)
            throw new Exception("邮件标题设置，调用title方法设置");
        if(mail.getContent()==null || mail.getContent().length()==0)
            throw new Exception("邮件内容没有设置，调用content方法设置");
        if(mail.getList().size()==0)
            throw new Exception("没有接受者邮箱地址，调用targets方法设置");
        //读取/resource/mail_zh_CN.properties文件内容
        final PropertiesUtil properties =  new PropertiesUtil("mail");
        //创建Properties类用于记录邮箱的一些属性
        final Properties props = new Properties();
        //表示SMTP发送邮箱，必须进行身份验证
        props.put("mail.smtp.auth","true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host",properties.getStringProperty("mail.smtp.service"));


    }


}
