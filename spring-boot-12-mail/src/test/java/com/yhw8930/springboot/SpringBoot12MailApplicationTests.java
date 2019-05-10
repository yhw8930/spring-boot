package com.yhw8930.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot12MailApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void testSimpleMail() {
        //封装简单的邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件主题
        message.setSubject("放假通知");
        message.setText("春节放假7天");
        //发件人
        message.setFrom("1170930576@qq.com");
        //收件人
        message.setTo("18392583359@163.com");
        javaMailSender.send(message);
    }

    @Test
    public void testMimeMail() throws MessagingException {
        //创建一个发送复杂消息对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //通过消息帮助对象，来设置发送的内容
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        //邮件主题

        messageHelper.setSubject("放假通知");
        //第二个参数为true时表示html
        messageHelper.setText("<h2 style='color:red'>春节放假7天</h2>", true);
        //上传文件
        messageHelper.addAttachment("1.jpg",new File("C:\\Users\\11709\\Desktop\\学习文档\\杨海威.jpg"));
        messageHelper.addAttachment("2.pdf",new File("C:\\Users\\11709\\Desktop\\学习文档\\杨海威.pdf"));
        //发件人
        messageHelper.setFrom("1170930576@qq.com");
        //收件人
        messageHelper.setTo("18392583359@163.com");
        javaMailSender.send(mimeMessage);
    }

}
