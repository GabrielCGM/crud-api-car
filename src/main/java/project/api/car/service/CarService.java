package project.api.car.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import project.api.car.model.Car;
import project.api.car.model.dto.CarDTO;

import java.util.List;

public interface CarService {

    List<CarDTO> findAll(Specification<Car> spec, Pageable pageable);

}
