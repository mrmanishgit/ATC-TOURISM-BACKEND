package com.aja.service;

import java.util.List;

import com.aja.entity.ChatBotFaq;
import com.aja.entity.Users;

public interface ChatBotFaqService {

	public ChatBotFaq savechatBotFaq(ChatBotFaq chatBotFaq);

	public List<ChatBotFaq> getAllFaqs();

	public ChatBotFaq getFaqById(Long faqId);
	
	public ChatBotFaq updaBotFaq(long id , ChatBotFaq chatBotFaq);
	

}
