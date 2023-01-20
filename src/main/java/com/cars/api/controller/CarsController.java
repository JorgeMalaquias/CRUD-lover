
package com.cars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarDTO;
import com.cars.api.model.Car;
import com.cars.api.repositories.CarRepository;
import com.cars.api.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class CarsController {

    @Autowired
    private CarService service;

    @PostMapping
    public void create(@RequestBody @Valid CarDTO req) {
        service.create(req);
    }

    @GetMapping
    public List<Car> listAll() {
        return service.listAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
        service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
