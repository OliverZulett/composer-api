package com.milankascomposer.composerapi.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionsHandlerController {

//	@ExceptionHandler(JsonMappingException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public ErrorDetails jsonMappingExceptionHandler(JsonMappingException ex) {
//		return new ErrorDetails("Invalid field in body request", ex.getMessage());
//	}
//
//	@ExceptionHandler(JsonParseException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public ErrorDetails jsonParseExceptionHandler(JsonParseException ex) {
//		return new ErrorDetails("Invalid field in body request", ex.getMessage());
//	}
//
//	@ExceptionHandler(IllegalArgumentException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public ErrorDetails illegalArgumentExceptionHandler(IllegalArgumentException ex) {
//		return new ErrorDetails("Invalid field in body request", ex.getMessage());
//	}
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public ErrorDetails MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
//		return new ErrorDetails("Validation failed", Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
//	}
//
//	@ExceptionHandler(ConstraintViolationException.class)
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ResponseBody
//	public ErrorDetails sqlExceptionHandler(ConstraintViolationException ex) {
//		return new ErrorDetails("SQL Error", ex.getCause().getMessage());
//	}
//
//	@ExceptionHandler(HibernateException.class)
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ResponseBody
//	public  ErrorDetails hibernateExceptionHandler(HibernateException ex) {
//		return new ErrorDetails("Hibernate Error", ex.getCause().getMessage());
//	}
//
//	@ExceptionHandler(ResourceNotFoundException.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	@ResponseBody
//	public ErrorDetails resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
//		return new ErrorDetails("Item not found", ex.getMessage());
//	}
//
//	@ExceptionHandler(PasswordExistingException.class)
//	@ResponseStatus(value = HttpStatus.CONFLICT)
//	@ResponseBody
//	public ErrorDetails passwordExistingExceptionHandler(PasswordExistingException ex) {
//		return new ErrorDetails("Password conflict", ex.getMessage());
//	}

}
