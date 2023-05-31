package project.api.car.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.api.car.model.Car;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
    private Integer id;
    private String brand;
    private String model;
    private Integer modelYear;
    private Boolean available;

    public static Car convertToCar(CarDTO dto){
        return Car.builder()
                .id(dto.getId())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .modelYear(dto.getModelYear())
                .available(dto.getAvailable())
                .build();
    }

    public static CarDTO convertToCarDTO(Car car){
        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .modelYear(car.getModelYear())
                .available(car.getAvailable())
                .build();
    }

}
