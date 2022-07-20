package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> listCars;

    {
        listCars = new ArrayList<>();
        listCars.add(new Car("BMW", 3, 'C'));
        listCars.add(new Car("Audi", 1, 'A'));
        listCars.add(new Car("Mercedes", 600, 'E'));
        listCars.add(new Car("VAZ", 2110, 'B'));
        listCars.add(new Car("BMW", 5, 'D'));
    }

    public List<Car> requestCarList(int i) {
        if ((i > 0) && (i < 5)) return listCars.subList(0, i);
        else return listCars;
    }
}
