package com.aja.service;

import java.util.List;

import com.aja.entity.ChatBotFaq;
import com.aja.entity.Users;

public interface ChatBotFaqService {

	ChatBotFaq savechatBotFaq(ChatBotFaq chatBotFaq);

	List<ChatBotFaq> getAllFaqs();

	ChatBotFaq getFaqById(Long faqId);
	
	ChatBotFaq updaBotFaq(long id , ChatBotFaq chatBotFaq);
	

}
