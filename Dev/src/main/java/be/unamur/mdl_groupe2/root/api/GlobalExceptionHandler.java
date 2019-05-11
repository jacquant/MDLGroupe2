package be.unamur.mdl_groupe2.root.api;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import be.unamur.mdl_groupe2.root.models.response.OperationResponse;
import be.unamur.mdl_groupe2.root.models.response.OperationResponse.ResponseStatusEnum;

/*
@ControllerAdvice tells your spring application that this class will do the exception handling for your application.
@RestController will make it a synonyme and let this class render the response.
Use @ExceptionHandler annotation to define the class of Exception it will catch. (A Base class will catch all the Inherited and extended classes)
*/
@ControllerAdvice
@RestController
@CrossOrigin(origins = { "http://localhost:8181", "http://localhost:8080" }, maxAge = 3000)
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public OperationResponse handleBaseException(DataIntegrityViolationException e) {
        OperationResponse resp = new OperationResponse();
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage(e.getRootCause().getMessage());
        return resp;
    }

}

