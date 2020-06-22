package com.competition.service.mail;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.competition.config.MailConfig;
import com.competition.jpa.model.mail.MailTemplate;
import com.competition.jpa.model.mail.NewsLetter;
import com.competition.jpa.repository.mail.NewsLetterRepository;

@Service
@SuppressWarnings("unchecked")
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailTemplateService mailTemplateService;
	
	@Autowired
	private NewsLetterRepository newsLetterRepository;
	
	@Autowired
	private VelocityEngine velocity;
	
	public MailService() {
		AnnotationConfigApplicationContext ct = new AnnotationConfigApplicationContext(MailConfig.class);
		this.mailSender = ct.getBean(JavaMailSender.class);
	}
	
	
	public <T extends Object> T sendNewsLetter() throws Exception {
		try {
			SimpleMailMessage sm = new SimpleMailMessage();
			
			List<NewsLetter> sub = newsLetterRepository.findAll();
			
			MailTemplate temp = mailTemplateService.seMailTemplateByBatchId("NewsLetter");
			
			HashMap<String, Object> model = new HashMap<>();
			
//			velocity.mergeTemplate(temp.getBatchId(), temp.getContent(), model);
			
			for(NewsLetter s : sub) {
				
				sm.setTo(s.getUserEMail());
				sm.setSubject(temp.getTitle());
				sm.setText(temp.getContent());
				
				mailSender.send(sm);
			}
			
			return (T) Boolean.TRUE;
		} catch (Exception e) {
			return (T) e;
		}
		
	}
	
	public void sendWithAttch(String to, String subject, String text, String attch) throws Exception {
		MimeMessage m = mailSender.createMimeMessage();
		
		MimeMessageHelper h = new MimeMessageHelper(m, true);
		
		h.setTo(to);
		h.setSubject(subject);
		h.setText(text);
		
		FileSystemResource file = new FileSystemResource(new File(attch));
		
		h.addAttachment("Invoice", file);
		
		mailSender.send(m);
	}
}
