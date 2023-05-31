package project.api.car.exceptions.carExceptions;

public class CarNotFound extends RuntimeException{
    public CarNotFound(String message) {
        super(message);
    }
}
