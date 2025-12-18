package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.entity.ChatBotFaq;
import com.aja.repository.ChatBotFaqRepo;
import com.aja.service.ChatBotFaqService;

@Service
public class ChatBotFaqServiceImpl implements ChatBotFaqService {

	@Autowired
	private ChatBotFaqRepo chatBotFaqRepo;

	@Override
	public ChatBotFaq savechatBotFaq(ChatBotFaq chatBotFaq) {
		// TODO Auto-generated method stub
		return chatBotFaqRepo.save(chatBotFaq);
	}

	@Override
	public List<ChatBotFaq> getAllFaqs() {
		// TODO Auto-generated method stub
		return chatBotFaqRepo.findAll();
	}

	@Override
	public ChatBotFaq getFaqById(Long faqId) {
		// TODO Auto-generated method stub
		return chatBotFaqRepo.findById(faqId).orElse(null);
	}

	@Override
	public ChatBotFaq updaBotFaq(long id, ChatBotFaq chatBotFaq) {
		// TODO Auto-generated method stub
		
		ChatBotFaq chatBotFaq2=chatBotFaqRepo.findById(id).orElse(null);
		chatBotFaq2.setQuestion(chatBotFaq.getQuestion());
		chatBotFaq2.setAnswer(chatBotFaq.getAnswer());
		return chatBotFaqRepo.save(chatBotFaq2);
		
	}

}
