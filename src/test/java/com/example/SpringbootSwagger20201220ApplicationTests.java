package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootSwagger20201220ApplicationTests {


    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一个标题");
        message.setText("这是内容");
        //发送给谁
        message.setTo("542716134@qq.com");
        //从哪里发送的
        message.setFrom("565459244@qq.com");
        javaMailSender.send(message);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
//        MimeMessage mimeMessage = new MimeMessage();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //组装参数 到MimeMessageHelper源码中有多个构造函数，根据需要传参，第二个true表示多文件传输
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("这是一个复杂邮件的标题");
        //第二个true表示开启html解析
        helper.setText("<p style='color:red'>这个是带格式的内容，需要在后面传入第二个参数</P>",true);
        //设置附件
        helper.addAttachment("1.jpg",new File("E:\\homework\\springboot-swagger20201220\\src\\main\\resources\\static\\qq.jpg"));
        helper.addAttachment("2.jpg",new File("E:\\homework\\springboot-swagger20201220\\src\\main\\resources\\static\\qq.jpg"));
        //发送给谁
        helper.setTo("565459244@qq.com");
        //从哪里发送的
        helper.setFrom("565459244@qq.com");
        //发送
        javaMailSender.send(mimeMessage);

    }
}
