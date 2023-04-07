package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.List;


@Service
public class CarServicelmp implements CarService {


    @Override
    public List<Car> getTheNumberOfCars(List<Car> cars, Integer i) {
        if (cars.size() >= i) {
            return cars.subList(0, i);
        } else {
            return cars;
        }
    }
}
