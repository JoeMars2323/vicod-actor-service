package com.marsoft.vicod.actors.services;

import java.util.List;

import com.marsoft.vicod.actors.exceptions.VicodException;
import com.marsoft.vicod.actors.rest.ActorRest;

public interface ActorService {
	
	public List<ActorRest> getAllActors() throws VicodException;
	
	public ActorRest createActor(final ActorRest actorRest) throws VicodException;
	
	public ActorRest updateActor(Long id, ActorRest actorRest) throws VicodException;
	
	public ActorRest deleteActor(Long id) throws VicodException;
	

}
