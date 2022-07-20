package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;

@Controller
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCarCount(@RequestParam(value = "count", defaultValue = "5") int count, Model model){
        model.addAttribute("cars", carService.requestCarList(count));
        return "/cars";
    }
}
