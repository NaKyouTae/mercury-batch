package com.mercury.service.token;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.token.TokenBlock;
import com.mercury.process.token.TokenBlockProcess;
import com.mercury.util.DateUtil;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class TokenBlockService {

	private static final TokenBlockProcess TokenBlockProcess = new TokenBlockProcess();

	public <T extends Object> T getTokenBlock() throws Exception {
		return (T) TokenBlockProcess.getBlockList();
	}

	public <T extends Object> T deTokenBlock() throws Exception {
		Boolean result = Boolean.FALSE;
		List<TokenBlock> list = getTokenBlock();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

		for (TokenBlock l : list) {
			Date insert = format.parse(l.getInsertDate());
			Date now = format.parse(DateUtil.now());

			long d = insert.getTime() - now.getTime();

			if (d >= 0 && 31 >= d) {
				result = TokenBlockProcess.deBlockList(l);
			}
		}

		return (T) result;
	}
}
