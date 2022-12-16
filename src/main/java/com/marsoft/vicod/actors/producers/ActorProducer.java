package com.marsoft.vicod.actors.producers;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marsoft.vicod.actors.rest.ActorRest;


@Component
public class ActorProducer {
	
	Logger log = LoggerFactory.getLogger(ActorProducer.class);
	
	String topic = "actors-topic";
	
	@Autowired
    KafkaTemplate<String, String> kafkaTemplate;	
	@Autowired
    ObjectMapper objectMapper;
	
	
	
	public ListenableFuture<SendResult<String, String>> sendActorEvent(ActorRest actor) throws JsonProcessingException {
		String key = actor.getBrockerId();
        String value = objectMapper.writeValueAsString(actor);

        ProducerRecord<String, String> producerRecord = buildProducerRecord(key, value, topic);

        ListenableFuture<SendResult<String, String>> listenableFuture =  kafkaTemplate.send(producerRecord);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                handleSuccess(key, value, result);
            }
        });

        return listenableFuture;
    }
	
	
	
	private ProducerRecord<String, String> buildProducerRecord(String key, String value, String topic) {
		List<Header> recordHeaders = new ArrayList<>();
	    Header header = new RecordHeader("event-source", "scanner".getBytes());
	    recordHeaders.add(header);	
	    return new ProducerRecord<>(topic, null, key, value, recordHeaders);
	}
	
	
	
	private void handleFailure(String key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }
    }

    
    
    private void handleSuccess(String key, String value, SendResult<String, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, 
        		result.getRecordMetadata().partition());
    }

    
    
}