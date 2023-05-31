package project.api.car.repository;

import org.apache.catalina.UserDatabase;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import project.api.car.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>,
        PagingAndSortingRepository<Car, Integer>, JpaSpecificationExecutor<Car> {




}
