package com.cars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.api.dto.CarDTO;
import com.cars.api.model.Car;
import com.cars.api.repositories.CarRepository;


@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    
    public void create(CarDTO req) {
        repository.save(new Car(req));
    }

    
    public List<Car> listAll() {
        return repository.findAll();
    }

    
    public void update(Long id, CarDTO req) {
        repository.findById(id).map(car -> {
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setDataFabricacao(req.dataFabricacao());
            car.setValor(req.valor());
            car.setAnoModelo(req.anoModelo());
            return repository.save(car);
        });
    }

    
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
