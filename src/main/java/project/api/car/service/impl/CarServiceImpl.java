package project.api.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import project.api.car.exceptions.carExceptions.CarNotFound;
import project.api.car.model.Car;
import project.api.car.model.dto.CarDTO;
import project.api.car.repository.CarRepository;
import project.api.car.service.CarService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    @Override
    public List<CarDTO> findAll(Specification<Car> spec, Pageable pageable) {
        List<Car> car = carRepository.findAll(spec,pageable).getContent();
        if(car.isEmpty()){
            throw new CarNotFound("NOT FOUND");
        }

        return car.stream().map((x) -> CarDTO.builder()
                .id(x.getId())
                .brand(x.getBrand())
                .model(x.getModel())
                .modelYear(x.getModelYear())
                .available(x.getAvailable())
                .build()).collect(Collectors.toList());
    }
}
