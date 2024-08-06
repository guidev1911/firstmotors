package com.store.firstmotors.unitTests.mapper.mocks;

import com.store.firstmotors.api.VO.CarVO;
import com.store.firstmotors.api.model.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MockCar {


    public Car mockEntity() {
        return mockEntity(0);
    }

    public CarVO mockVO() {
        return mockVO(0);
    }

    public List<Car> mockEntityList() {
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < 14; i++) {
            cars.add(mockEntity(i));
        }
        return cars;
    }

    public List<CarVO> mockVOList() {
        List<CarVO> cars = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            cars.add(mockVO(i));
        }
        return cars;
    }

    public Car mockEntity(Integer number) {
        Car car = new Car();
        car.setId(number.longValue());
        car.setBrand("Tesla" + number);
        car.setModel("S plaid" + number);
        car.setColor("roxo metálico" + number);
        car.setPower(1020);
        car.setSpeed(332.0);
        car.setUnits(600000);
        car.setYear(2021);
        car.setPrice(BigDecimal.valueOf(89000));
        return car;
    }

    public CarVO mockVO(Integer number) {
        CarVO car = new CarVO();
        car.setKey(number.longValue());
        car.setBrand("Tesla" + number);
        car.setModel("S plaid" + number);
        car.setColor("roxo metálico" + number);
        car.setPower(1020);
        car.setSpeed(332.0);
        car.setUnits(600000);
        car.setYear(2021);
        car.setPrice(BigDecimal.valueOf(89000));
        return car;
    }

}
