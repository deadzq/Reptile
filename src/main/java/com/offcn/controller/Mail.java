package com.offcn.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Mail {

	public static void main(String[] args) throws Exception {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
JavaMailSenderImpl  bean = (JavaMailSenderImpl) context.getBean("mailSender");
     //创建带附件的邮件对象
MimeMessage message = bean.createMimeMessage();
    //添加附件，带附件就是true，不带附件就是false
MimeMessageHelper helper = new MimeMessageHelper(message, true);
helper.setFrom("fsg873551520@126.com");
helper.setTo("fsg873551520@126.com");
helper.setSubject("带附件的简单邮件");
helper.setText("这是一封带附件的简单邮件,正文");

  File file = new File("D:\\chart\\Plum1.pdf");

  
  helper.addAttachment("Plum1.pdf", file);
  bean.send(message);
  System.out.println("邮件发送成功");




	}

}
