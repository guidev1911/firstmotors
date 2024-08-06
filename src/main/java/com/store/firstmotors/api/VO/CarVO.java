package com.store.firstmotors.api.VO;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id", "brand", "model", "year", "power", "price","color","units","speed"})
public class CarVO extends RepresentationModel<CarVO> implements Serializable {


    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String brand;
    private String model;
    private String color;
    private BigDecimal price;
    private Integer year;
    private Integer units;
    private Integer power;
    private Double speed;


    public CarVO() {}


    public Long getKey() {
        return key;
    }


    public void setKey(Long key) {
        this.key = key;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Integer getYear() {
        return year;
    }


    public void setYear(Integer year) {
        this.year = year;
    }


    public Integer getUnits() {
        return units;
    }


    public void setUnits(Integer units) {
        this.units = units;
    }


    public Integer getPower() {
        return power;
    }


    public void setPower(Integer power) {
        this.power = power;
    }


    public Double getSpeed() {
        return speed;
    }


    public void setSpeed(Double speed) {
        this.speed = speed;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(brand, color, key, model, power, price, speed, units, year);
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarVO other = (CarVO) obj;
        return Objects.equals(brand, other.brand) && Objects.equals(color, other.color)
                && Objects.equals(key, other.key) && Objects.equals(model, other.model)
                && Objects.equals(power, other.power) && Objects.equals(price, other.price)
                && Objects.equals(speed, other.speed) && Objects.equals(units, other.units)
                && Objects.equals(year, other.year);
    }

}