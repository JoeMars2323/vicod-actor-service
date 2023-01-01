package com.marsoft.vicod.actors.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marsoft.vicod.actors.entities.Actor;
import com.marsoft.vicod.actors.exceptions.InternalServerErrorException;
import com.marsoft.vicod.actors.exceptions.NotFoundException;
import com.marsoft.vicod.actors.exceptions.VicodException;
import com.marsoft.vicod.actors.repositories.ActorRepository;
import com.marsoft.vicod.actors.rest.ActorRest;
import com.marsoft.vicod.actors.utils.ExceptionConstants;
import com.marsoft.vicod.actors.utils.LogConstants;

@Service
public class ActorServiceImpl implements ActorService {

	private Logger log = LoggerFactory.getLogger(ActorServiceImpl.class);

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private ActorRepository actorRepository;

	@Override
	@Transactional
	public List<ActorRest> getAllActors() throws VicodException {
		List<Actor> actorList = actorRepository.findAll();
		List<ActorRest> actorResponseList = new ArrayList<ActorRest>();
		for (Actor a : actorList) {
			ActorRest ar = new ActorRest(a.getActorName(), a.getActorBirthName(), a.getCountry(), a.getBirthday());
			actorResponseList.add(ar);
		}

		// List<ActorRest> actorResponseList =
		// actorRepository.findAll().stream().map(actor ->
		// modelMapper.map(actor, ActorRest.class)).collect(Collectors.toList());
		return actorResponseList;
	}

	@Override
	@Transactional
	public ActorRest createActor(final ActorRest actorRest) throws VicodException {
		log.info(LogConstants.CREATE_ACTOR_BEGIN);
		ActorRest actorResponse = null;
		try {
			Actor actor = modelMapper.map(actorRest, Actor.class);
			actorResponse = modelMapper.map(actorRepository.save(actor), ActorRest.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
		}
		log.info(actorResponse.toString());
		log.info(LogConstants.CREATE_ACTOR_END);
		return actorResponse;
	}

	@Override
	@Transactional
	public ActorRest updateActor(Long id, ActorRest actorRest) throws VicodException {
		log.info(LogConstants.UPDATE_ACTOR_BEGIN);
		ActorRest tvshowResponse = null;
		if (actorRest.getActorId() != null) {
			try {
				Actor actor = modelMapper.map(actorRest, Actor.class);
				actor = actorRepository.save(actor);
				tvshowResponse = modelMapper.map(actor, ActorRest.class);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new InternalServerErrorException(e.getMessage());
			}
		} else {
			throw new NotFoundException(ExceptionConstants.ACTOR_NOT_FOUND);
		}
		log.info(tvshowResponse.toString());
		log.info(LogConstants.UPDATE_ACTOR_END);
		return tvshowResponse;
	}

	@Override
	@Transactional
	public ActorRest deleteActor(Long id) throws VicodException {
		log.info(LogConstants.DELETE_ACTOR_BEGIN);
		ActorRest tvshowResponse = null;
		try {
			Actor actor = actorRepository.getReferenceById(id);
			actorRepository.delete(actor);
			tvshowResponse = modelMapper.map(actor, ActorRest.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
		}
		log.info(tvshowResponse.toString());
		log.info(LogConstants.DELETE_ACTOR_END);
		return tvshowResponse;
	}

}