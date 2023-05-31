package project.api.car.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import project.api.car.model.Car;

public class CarRepositorySpecification {

    public static Specification<Car> available(Boolean available){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("available"), available));
    }

    public static Specification<Car> brand(String brand){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("brand"), "%"+brand+"%"));
    }
}
