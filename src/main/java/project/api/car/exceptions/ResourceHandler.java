package project.api.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.api.car.exceptions.carExceptions.CarNotFound;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(CarNotFound.class)
    public ResponseEntity<String> CarNotFound(CarNotFound carNotFound){
        String errorMessage = carNotFound.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }


}
