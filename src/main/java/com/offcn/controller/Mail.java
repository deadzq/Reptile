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
     //�������������ʼ�����
MimeMessage message = bean.createMimeMessage();
    //��Ӹ���������������true��������������false
MimeMessageHelper helper = new MimeMessageHelper(message, true);
helper.setFrom("fsg873551520@126.com");
helper.setTo("fsg873551520@126.com");
helper.setSubject("�������ļ��ʼ�");
helper.setText("����һ��������ļ��ʼ�,����");

  File file = new File("D:\\chart\\Plum1.pdf");

  
  helper.addAttachment("Plum1.pdf", file);
  bean.send(message);
  System.out.println("�ʼ����ͳɹ�");




	}

}
