package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'20 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String printCars(@RequestParam("count") int count, ModelMap model) {
		Car car1 = new Car("BMW", "X5", "black");
		Car car2 = new Car("Mazda", "6", "red");
		Car car3 = new Car("Volkswagen", "Touareg", "white");
		Car car4 = new Car("Lada", "X-ray", "blue");
		Car car5 = new Car("Nissan", "Teana", "gray");
		List<Car> cars = Arrays.asList(car1, car2, car3, car4, car5);
		List<Car> carsByCount = CarService.getCarsByCount(cars, count);
		model.addAttribute("cars", carsByCount);
		return "cars";
	}
}