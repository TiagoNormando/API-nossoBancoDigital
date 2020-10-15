package br.com.Normando.NBancoDig.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@ControllerAdvice
public class WebAdviceController {
        @ExceptionHandler(value = {CreatedException.class})
        public ResponseEntity<Object> createException(Exception ex, WebRequest request) {
            return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.CREATED);
        }
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> badRequestException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {BussinesException.class})
    public ResponseEntity<Object> bussinesException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }

