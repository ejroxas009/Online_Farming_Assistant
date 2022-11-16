package org.group4.revalida.onlineFarmingAssistant.service.twilio;

import org.group4.revalida.onlineFarmingAssistant.model.twilio.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioSampleService {
	
	private final TwilioSmsSender twilioSmsSender;

	@Autowired
	public TwilioSampleService(TwilioSmsSender twilioSmsSender) {
		super();
		this.twilioSmsSender = twilioSmsSender;
	}
	
	public void sendSms(String phoneNumber) {
		twilioSmsSender.sendSms(phoneNumber);
	}
	

}
