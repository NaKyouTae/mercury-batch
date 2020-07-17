package com.mercury.service.mail;

import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mercury.config.MailConfig;
import com.mercury.jpa.model.mail.MailTemplate;
import com.mercury.jpa.model.mail.NewsLetter;
import com.mercury.jpa.repository.mail.NewsLetterRepository;

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
			
			MimeMessage sm = this.mailSender.createMimeMessage();
			
			List<NewsLetter> sub = newsLetterRepository.findAll();
			
			MailTemplate temp = mailTemplateService.seMailTemplateByBatchId("NewsLetter");
			
			HashMap<String, Object> model = new HashMap<>();
			model.put("user", sub);
			Template velo = velocity.getTemplate(temp.getContent());
			
			VelocityContext context = new VelocityContext();
			context.put("test", model);
			StringWriter sw = new StringWriter();
			
			velo.merge(context, sw);
			for(NewsLetter s : sub) {
				
				sm.setRecipient(RecipientType.TO, new InternetAddress(s.getUserEMail()));
				sm.setSubject(temp.getTitle());
				sm.setText(sw.toString(), "UTF-8", "html");
				
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
