package jins.studyBackend.aop;

import jins.studyBackend.aop.exception.NoUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice// exceptionhandler를 쓰기위한 어노테이션
public class ErrorHandler {
    @ExceptionHandler(NoUserException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String noUser(){
        return "no user!";
    }
}
