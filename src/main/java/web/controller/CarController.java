package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    static List<Car> carsList = new ArrayList<>();
    @Autowired
    private CarService carService;

    {

        Car car1 = new Car("Toyota", 2021, "Red");
        carsList.add(car1);

        Car car2 = new Car("Honda", 2020, "Blue");
        carsList.add(car2);

        Car car3 = new Car("BMW", 2019, "Black");
        carsList.add(car3);

        Car car4 = new Car("Ford", 2018, "White");
        carsList.add(car4);

        Car car5 = new Car("Mazda", 2017, "Silver");
        carsList.add(car5);

    }


    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", defaultValue = "5") String count, ModelMap model) {
        List<String> messages = new ArrayList<>();
        List<Car> subcarsList = carService.getTheNumberOfCars(carsList, Integer.valueOf(count));
        for (Car car : subcarsList) {
            messages.add(car.getModel() + " " + car.getSeries() + " " + car.getColor());
        }
        model.addAttribute("messages", messages);
        System.out.println(count);
        return "cars";
    }
}
