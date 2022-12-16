package com.marsoft.vicod.actors.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

import com.marsoft.vicod.actors.utils.MessageBrockerConstants;

@Configuration
@Profile(MessageBrockerConstants.ACTORS_TOPIC)
public class AutoCreateConfig {
	
	@Bean
    public NewTopic libraryEvents(){
        return TopicBuilder.name(MessageBrockerConstants.ACTORS_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }
	
	

}
