package com.example.restmodule.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotEnoughMoney.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value());
    }

//    @ExceptionHandler(NotEnoughMoney.class)
//    public ResponseEntity springHandleNotFound(HttpServletResponse response) throws IOException {
//        CustomErrorResponse errors = new CustomErrorResponse();
//        errors.setTimestamp(LocalDateTime.now());
//        errors.setError(ex.getMessage());
//        errors.setStatus(HttpStatus.NOT_FOUND.value());
//
//        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
//    }


}
