package org.group4.revalida.onlineFarmingAssistant.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.group4.revalida.onlineFarmingAssistant.resource.shared.CORSResponseFilter;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyAppConfig extends ResourceConfig {

	public JerseyAppConfig() {
		register(CORSResponseFilter.class);
		packages("org.group4.revalida.onlineFarmingAssistant.resource");
		
	}
}
