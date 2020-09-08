package com.mercury.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.process.mail.MailTemplateProcess;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class MailTemplateService {

	@Autowired
	private MailTemplateProcess mailTemplateProcess = new MailTemplateProcess();

	public <T extends Object> T seMailTemplateByType(String type)
			throws Exception {
		return (T) mailTemplateProcess.seMailTemplateByType(type);
	}

	public <T extends Object> T seMailTemplates() throws Exception {
		return (T) mailTemplateProcess.seMailTemplates();
	}

	public <T extends Object> T seMailTemplate(String idx) throws Exception {
		return (T) mailTemplateProcess.seMailTemplate(idx);
	}
}
