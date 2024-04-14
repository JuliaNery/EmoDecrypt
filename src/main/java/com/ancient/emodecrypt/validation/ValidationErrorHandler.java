package com.ancient.emodecrypt.validation;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ValidationErrorHandler {

    record ValidationErrorResponse(String campo, String mensagem){
        public ValidationErrorResponse(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationErrorResponse> handle(MethodArgumentNotValidException exception){
        return exception.getFieldErrors()
                .stream()
                .map(ValidationErrorResponse::new)
                .toList();
    }
}
