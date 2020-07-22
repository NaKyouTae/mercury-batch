package com.mercury.process.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.jpa.repository.mail.MailTemplateRepository;
import com.mercury.util.BeanUtil;

@Component
@SuppressWarnings("unchecked")
public class MailTemplateProcess {
	@Autowired
	private MailTemplateRepository mailTemplateRepository;
	
	public MailTemplateProcess() {
		try {
			this.mailTemplateRepository = (MailTemplateRepository) BeanUtil.getBean("mailTemplateRepository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends Object> T seMailTemplateByType(String type) throws Exception {
		try {
			return (T) mailTemplateRepository.findByType(type);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seMailTemplates() throws Exception {
		try {
			return (T) mailTemplateRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seMailTemplate(String idx) throws Exception {
		try {
			return (T) mailTemplateRepository.findByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
