package com.marsoft.vicod.actors.exceptions;

import java.util.ArrayList;
import java.util.List;


public abstract class VicodException extends Exception {

	private static final long serialVersionUID = -7482635401716007171L;

	private final int code;

	private final List<VicodError> errorList = new ArrayList<>();

	public VicodException(final int code, final String message) {
		super(message);
		this.code = code;
	}

	public VicodException(final int code, final String message, final List<VicodError> errorList) {
		super(message);
		this.code = code;
		this.errorList.addAll(errorList);
	}

	public int getCode() {
		return this.code;
	}

	public List<VicodError> getErrorList() {
		return errorList;
	}
}
