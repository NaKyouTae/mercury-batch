package com.mercury.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.process.mail.MailTemplateProcess;

@Service
@SuppressWarnings("unchecked")
public class MailTemplateService {
	
	@Autowired
	private MailTemplateProcess mailTemplateProcess = new MailTemplateProcess();
	
	public <T extends Object> T seMailTemplateByType(String type) throws Exception {
		try {
			return (T) mailTemplateProcess.seMailTemplateByType(type);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seMailTemplates() throws Exception {
		try {
			return (T) mailTemplateProcess.seMailTemplates();
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seMailTemplate(String idx) throws Exception {
		try {
			return (T) mailTemplateProcess.seMailTemplate(idx);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}
