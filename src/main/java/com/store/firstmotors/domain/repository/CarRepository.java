package com.store.firstmotors.domain.repository;
import com.store.firstmotors.api.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
