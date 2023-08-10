package com.yadwy.yadwy.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<APIResponse> myResourceNotFoundException(ResourceNotFoundException e) {
//        String message = e.getMessage();
//
//        APIResponse res = new APIResponse(message, false);
//
//        return new ResponseEntity<APIResponse>(res, HttpStatus.NOT_FOUND);
//    }

}
