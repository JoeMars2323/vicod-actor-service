package com.marsoft.vicod.actors.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

public class NotFoundException extends VicodException {
	private static final long serialVersionUID = -6870732210014274010L;

	public NotFoundException(final String message) {
		super(HttpStatus.NOT_FOUND.value(), message);
	}

	public NotFoundException(final String message, final VicodError data) {
		super(HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}
}
