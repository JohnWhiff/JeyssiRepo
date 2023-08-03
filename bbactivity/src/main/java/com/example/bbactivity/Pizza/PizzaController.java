package com.example.bbactivity.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/pizza")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController (PizzaService pizzaService){
        this.pizzaService=pizzaService;
    }
    @GetMapping
    public List<Pizza> getPizza(){
        return pizzaService.getPizza();
    }
    @PostMapping
    public void registerNewPizza(@RequestBody Pizza pizza){
        pizzaService.addNewPizza(pizza);
    }
    @DeleteMapping(path="{pizzaName}")
    public void deletePizza(
             @PathVariable("pizzaName") String pizzaName){
        pizzaService.deletePizza(pizzaName);


    }

}
