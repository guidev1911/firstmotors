package com.store.firstmotors.domain.service;
import java.util.List;
import java.util.logging.Logger;

import com.store.firstmotors.api.Controller.CarController;
import com.store.firstmotors.api.VO.CarVO;
import com.store.firstmotors.api.model.Car;
import com.store.firstmotors.domain.mapper.DozerMapper;
import com.store.firstmotors.domain.repository.CarRepository;
import com.store.firstmotors.exceptions.RequiredObjectIsNullException;
import com.store.firstmotors.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private Logger logger = Logger.getLogger(CarService.class.getName());

    @Autowired
    CarRepository repository;

    public List<CarVO> findAll() {

        logger.info("Finding all cars!");

        var cars = DozerMapper.parseListObjects(repository.findAll(), CarVO.class);
        cars
                .stream()
                .forEach(p -> p.add(linkTo(methodOn(CarController.class).findById(p.getKey())).withSelfRel()));
        return cars;
    }

    public CarVO findById(Long id) {

        logger.info("Finding one car!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, CarVO.class);
        vo.add(linkTo(methodOn(CarController.class).findById(id)).withSelfRel());
        return vo;
    }

    public CarVO create(CarVO car) {

        if (car == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one car!");
        var entity = DozerMapper.parseObject(car, Car.class);
        var vo =  DozerMapper.parseObject(repository.save(entity), CarVO.class);
        vo.add(linkTo(methodOn(CarController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public CarVO update(CarVO car) {

        if (car == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one car!");

        var entity = repository.findById(car.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setBrand(car.getBrand());
        entity.setPrice(car.getPrice());
        entity.setColor(car.getColor());
        entity.setModel(car.getModel());
        entity.setPower(car.getPower());
        entity.setSpeed(car.getSpeed());
        entity.setYear(car.getYear());
        entity.setUnits(car.getUnits());

        var vo =  DozerMapper.parseObject(repository.save(entity), CarVO.class);
        vo.add(linkTo(methodOn(CarController.class).findById(vo.getKey())).withSelfRel());
        return vo;


    }

    public void delete(Long id) {

        logger.info("Deleting one car!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
