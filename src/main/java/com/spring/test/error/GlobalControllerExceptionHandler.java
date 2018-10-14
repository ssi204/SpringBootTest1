package com.spring.test.error;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NullPointerException.class, EntityNotFoundException.class})
    @ResponseBody
    public GenericException failure(Exception exp) {
        if (exp instanceof EntityNotFoundException)
            return new GenericException("entity not found", 404);

        else{
            return new GenericException("Null Pointer", 403);
        }
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public GenericException failure1(Exception exp){
            return new GenericException("Method not right", 405);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public GenericException failure2(MethodArgumentNotValidException exp){
        List<String> l= exp.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return new GenericException(l.get(0), 401);

    }
}
