package com.store.firstmotors.unitTests.mockito.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.store.firstmotors.api.VO.CarVO;
import com.store.firstmotors.api.model.Car;
import com.store.firstmotors.domain.repository.CarRepository;
import com.store.firstmotors.domain.service.CarService;
import com.store.firstmotors.exceptions.RequiredObjectIsNullException;
import com.store.firstmotors.unitTests.mapper.mocks.MockCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    MockCar input;

    @InjectMocks
    private CarService service;

    @Mock
    CarRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockCar();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Car entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/car/v1/1>;rel=\"self\"]"));
        assertEquals("Tesla1", result.getBrand());
        assertEquals("S plaid1", result.getModel());
        assertEquals("roxo metálico1", result.getColor());
        assertEquals(1020, result.getPower());
        assertEquals(332.0, result.getSpeed());
        assertEquals(BigDecimal.valueOf(89000), result.getPrice());
        assertEquals(600000, result.getUnits());
        assertEquals(2021, result.getYear());

    }

    @Test
    void testCreate() {
        Car entity = input.mockEntity(1);
        entity.setId(1L);

        Car persisted = entity;
        persisted.setId(1L);

        CarVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/car/v1/1>;rel=\"self\"]"));
        assertEquals("Tesla1", result.getBrand());
        assertEquals("S plaid1", result.getModel());
        assertEquals("roxo metálico1", result.getColor());
        assertEquals(1020, result.getPower());
        assertEquals(332.0, result.getSpeed());
        assertEquals(BigDecimal.valueOf(89000), result.getPrice());
        assertEquals(600000, result.getUnits());
        assertEquals(2021, result.getYear());
    }

    @Test
    void testCreateWithNullCar() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void testUpdate() {
        Car entity = input.mockEntity(1);
        entity.setId(1L);

        Car persisted = entity;
        persisted.setId(1L);

        CarVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);


        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/car/v1/1>;rel=\"self\"]"));
        assertEquals("Tesla1", result.getBrand());
        assertEquals("S plaid1", result.getModel());
        assertEquals("roxo metálico1", result.getColor());
        assertEquals(1020, result.getPower());
        assertEquals(332.0, result.getSpeed());
        assertEquals(BigDecimal.valueOf(89000), result.getPrice());
        assertEquals(600000, result.getUnits());
        assertEquals(2021, result.getYear());
    }



    @Test
    void testUpdateWithNullCar() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDelete() {
        Car entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);
    }

    @Test
    void testFindAll() {
        List<Car> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var object = service.findAll();

        assertNotNull(object);
        assertEquals(14, object.size());

        var carOne = object.get(1);

        assertNotNull(carOne);
        assertNotNull(carOne.getKey());
        assertNotNull(carOne.getLinks());

        assertTrue(carOne.toString().contains("links: [</api/car/v1/1>;rel=\"self\"]"));
        assertEquals("Tesla1", carOne.getBrand());
        assertEquals("S plaid1", carOne.getModel());
        assertEquals("roxo metálico1", carOne.getColor());
        assertEquals(1020, carOne.getPower());
        assertEquals(332.0, carOne.getSpeed());
        assertEquals(BigDecimal.valueOf(89000), carOne.getPrice());
        assertEquals(600000, carOne.getUnits());
        assertEquals(2021, carOne.getYear());

        var carFour = object.get(4);

        assertNotNull(carFour);
        assertNotNull(carFour.getKey());
        assertNotNull(carFour.getLinks());

        assertTrue(carFour.toString().contains("links: [</api/car/v1/4>;rel=\"self\"]"));
        assertEquals("Tesla4", carFour.getBrand());
        assertEquals("S plaid4", carFour.getModel());
        assertEquals("roxo metálico4", carFour.getColor());
        assertEquals(1020, carFour.getPower());
        assertEquals(332.0, carFour.getSpeed());
        assertEquals(BigDecimal.valueOf(89000), carFour.getPrice());
        assertEquals(600000, carFour.getUnits());
        assertEquals(2021, carFour.getYear());

        var carSeven = object.get(7);

        assertNotNull(carSeven);
        assertNotNull(carSeven.getKey());
        assertNotNull(carSeven.getLinks());

        assertTrue(carSeven.toString().contains("links: [</api/car/v1/7>;rel=\"self\"]"));
        assertEquals("Tesla7", carSeven.getBrand());
        assertEquals("S plaid7", carSeven.getModel());
        assertEquals("roxo metálico7", carSeven.getColor());
        assertEquals(1020, carSeven.getPower());
        assertEquals(332.0, carSeven.getSpeed());
        assertEquals(BigDecimal.valueOf(89000), carSeven.getPrice());
        assertEquals(600000, carSeven.getUnits());
        assertEquals(2021, carSeven.getYear());
    }

}
