package org.group4.revalida.onlineFarmingAssistant.repo.twilio;

import org.group4.revalida.onlineFarmingAssistant.model.twilio.SmsRequest;

public interface SmsSender {
	void sendSms(SmsRequest smsRequest);
}
