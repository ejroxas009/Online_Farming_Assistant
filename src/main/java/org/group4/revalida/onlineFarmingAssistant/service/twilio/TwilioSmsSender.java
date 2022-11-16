package org.group4.revalida.onlineFarmingAssistant.service.twilio;

import org.group4.revalida.onlineFarmingAssistant.config.TwilioConfiguration;
import org.group4.revalida.onlineFarmingAssistant.model.twilio.SmsRequest;
import org.group4.revalida.onlineFarmingAssistant.repo.twilio.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSmsSender  {
	
	private final TwilioConfiguration twilioConfiguration;
	
	
	@Autowired
	public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
		super();
		this.twilioConfiguration = twilioConfiguration;
	}



	
	public void sendSms(String phoneNumber) {
		PhoneNumber to =  new PhoneNumber(phoneNumber);
		PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
		String message = "A new ads is posted in the marketplace";
		MessageCreator creator = Message.creator(to, from, message);
		creator.create();
	}

}
