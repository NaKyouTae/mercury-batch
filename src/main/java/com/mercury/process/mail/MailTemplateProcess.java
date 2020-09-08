package com.mercury.process.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.config.ApplicationContextProvider;
import com.mercury.jpa.repository.mail.MailTemplateRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class MailTemplateProcess {
	@Autowired
	private MailTemplateRepository mailTemplateRepository;

	public MailTemplateProcess() {
		try {
			this.mailTemplateRepository = ApplicationContextProvider.getBean("mailTemplateRepository");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public <T extends Object> T seMailTemplateByType(String type)
			throws Exception {
		return (T) mailTemplateRepository.findByType(type);
	}

	public <T extends Object> T seMailTemplates() throws Exception {
		return (T) mailTemplateRepository.findAll();
	}

	public <T extends Object> T seMailTemplate(String idx) throws Exception {
		return (T) mailTemplateRepository.findByIdx(idx);
	}
}
