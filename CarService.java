package com.ganicar.carinventory;

import com.ganicar.carinventory.Car;
import com.ganicar.carinventory.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setMake(carDetails.getMake());
        car.setModel(carDetails.getModel());
        car.setColor(carDetails.getColor());
        car.setPrice(carDetails.getPrice());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    public List<Car> findCarsByMake(String make) {
        return carRepository.findByMakeIgnoreCase(make);
    }

    public List<Car> findCarsByColor(String color) {
        return carRepository.findByColor(color);
    }
}