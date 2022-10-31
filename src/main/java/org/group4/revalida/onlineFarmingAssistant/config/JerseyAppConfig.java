package org.group4.revalida.onlineFarmingAssistant.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyAppConfig extends ResourceConfig {

	public JerseyAppConfig() {
		packages("org.group4.revalida.onlineFarmingAssistant.resource");
	}
}
