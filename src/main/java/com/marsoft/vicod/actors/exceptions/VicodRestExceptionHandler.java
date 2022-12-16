package com.marsoft.vicod.actors.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marsoft.vicod.actors.rest.VicodResponse;
import com.marsoft.vicod.actors.utils.ExceptionConstants;


@ControllerAdvice
@SuppressWarnings({ "rawtypes", "unchecked" })
public class VicodRestExceptionHandler {

	
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public VicodResponse unhandledErrors(HttpServletRequest req, Exception ex) {
		return new VicodResponse(ExceptionConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
	}

	
	
	@ExceptionHandler({ VicodException.class })
	@ResponseBody
	public VicodResponse handleLmException(final HttpServletRequest request, final HttpServletResponse response,
			final VicodException ex) {
		response.setStatus(ex.getCode());
		return new VicodResponse(ExceptionConstants.ERROR, String.valueOf(ex.getCode()), ex.getMessage(),
				ex.getErrorList());
	}
	

	
}
