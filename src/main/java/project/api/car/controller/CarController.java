package project.api.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.api.car.model.dto.CarDTO;
import project.api.car.repository.specification.CarRepositorySpecification;
import project.api.car.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;
    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<CarDTO>> findAll(@RequestParam("page")Integer page,
                                                @RequestParam("size")Integer size,
                                                @RequestParam(required = false, value = "available") Boolean available,
                                                @RequestParam(required = false, value = "brand") String brand){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAll(
                Specification.where(CarRepositorySpecification.available(available)),
                pageable));
    }



}
