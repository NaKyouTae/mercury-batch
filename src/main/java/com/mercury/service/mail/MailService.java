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
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.config.MailConfig;
import com.mercury.jpa.model.mail.MailTemplate;
import com.mercury.jpa.model.mail.NewsLetter;
import com.mercury.jpa.repository.mail.NewsLetterRepository;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class MailService {

	@Autowired
	private MailTemplateService mailTemplateService = new MailTemplateService();

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private NewsLetterRepository newsLetterRepository;

	private String tempLocation = "/bin/main/mailTemplate/";

	public MailService() {
		AnnotationConfigApplicationContext ct = new AnnotationConfigApplicationContext(
				MailConfig.class);
		this.mailSender = ct.getBean(JavaMailSender.class);
		this.newsLetterRepository = ApplicationContextProvider
				.getBean("newsLetterRepository");
	}

	public void sendTempMail(String target, String title, String text)
			throws Exception {
		MimeMessage sm = this.mailSender.createMimeMessage();

		sm.setRecipient(RecipientType.TO, new InternetAddress(target));
		sm.setSubject(title);
		sm.setText(text, "UTF-8", "html");

		this.mailSender.send(sm);
	}

	public <T extends Object> T veloTemp(String temp) throws Exception {
		VelocityEngine velocity = new VelocityEngine();

		velocity.init();
		velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocity.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());

		return (T) velocity.getTemplate(tempLocation + temp, "UTF-8");
	}

	public <T extends Object> T sendNewsLetter() throws Exception {
		List<NewsLetter> sub = newsLetterRepository.findAll();

		MailTemplate temp = mailTemplateService
				.seMailTemplateByType("NewsLetter");

		HashMap<String, Object> model = new HashMap<>();
		model.put("user", sub);
		VelocityContext context = new VelocityContext();
		context.put("data", model);

		StringWriter sw = new StringWriter();
		Template t = veloTemp(temp.getTempName());
		t.merge(context, sw);

		for (NewsLetter s : sub) {
			// Send Mail Html Template
			sendTempMail(s.getUserEMail(), temp.getTitle(), sw.toString());
		}

		return (T) Boolean.TRUE;
	}

	public void sendWithAttch(String to, String subject, String text,
			String attch) throws Exception {
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
