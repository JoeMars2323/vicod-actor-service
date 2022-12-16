package com.marsoft.vicod.actors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marsoft.vicod.actors.entities.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
