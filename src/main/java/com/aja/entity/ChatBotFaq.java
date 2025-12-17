package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD

@Entity
public class ChatBotFaq {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long faQId;
=======
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ChatBotFaq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long faqId;

	private String question;

	private String answer;
>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1
}
