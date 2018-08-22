package com.yanzi.study;

import com.yanzi.study.lession7.core.MailSender;
import com.yanzi.study.lession7.enums.MailContentTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        //如果需要发送HTML内容的邮件修改contentType(MailContentTypeEnum.HTML)然后content("html代码")即可。
        new MailSender()
                .title("测试SpringBoot发送邮件")
                .content("简单的文本内容发送")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{add("npe6148@dingtalk.com");}})
                .send();

    }

}
