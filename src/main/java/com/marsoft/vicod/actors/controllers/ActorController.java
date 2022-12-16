package com.marsoft.vicod.actors.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.marsoft.vicod.actors.exceptions.VicodException;
import com.marsoft.vicod.actors.producers.ActorProducer;
import com.marsoft.vicod.actors.rest.ActorRest;
import com.marsoft.vicod.actors.rest.EventType;
import com.marsoft.vicod.actors.rest.VicodResponse;
import com.marsoft.vicod.actors.services.ActorService;
import com.marsoft.vicod.actors.utils.RestConstants;


@RestController
@RequestMapping(RestConstants.ACTORS)
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	@Autowired
	private ActorProducer actorProducer;
	
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodResponse<List<ActorRest>> getAllActors() throws VicodException {
		return new VicodResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK, actorService.getAllActors());
	}
	
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodResponse<ActorRest> createActor(@RequestBody ActorRest actor) throws VicodException, JsonProcessingException {
		ActorRest actorResponse = actorService.createActor(actor);
		if(actorResponse == null) {
			return new VicodResponse<>(RestConstants.FAIL, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), RestConstants.NOK);
		} else {
			actorResponse.setBrockerId("actor-" + actorResponse.getActorId());
			actorResponse.setEventType(EventType.NEW);
			actorProducer.sendActorEvent(actorResponse);
			return new VicodResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), RestConstants.OK, actorResponse);
		}
	}
	
	
	
	@PutMapping(value = RestConstants.ID + RestConstants.ACTOR, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodResponse<ActorRest> updateActor(@PathVariable Long id, @RequestBody ActorRest actor) throws VicodException {
		ActorRest actorResponse = actorService.updateActor(id, actor);
		if(actorResponse == null) {
			return new VicodResponse<>(RestConstants.FAIL, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), RestConstants.NOK);
		} else {
			actorResponse.setBrockerId("actor-" + actorResponse.getActorId());
			actorResponse.setEventType(EventType.UPDATE);
			return new VicodResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK, actorResponse);
		}
	}
	
	
	
	@DeleteMapping(value = RestConstants.ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodResponse<ActorRest> deleteActor(@PathVariable Long id) throws VicodException {
		ActorRest actorResponse = actorService.deleteActor(id);
		if(actorResponse == null) {
			return new VicodResponse<>(RestConstants.FAIL, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), RestConstants.NOK);
		} else {
			return new VicodResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK, actorResponse);
		}
	}
	
	

}