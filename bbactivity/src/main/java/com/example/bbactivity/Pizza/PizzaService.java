package com.example.bbactivity.Pizza;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizza(){
        return pizzaRepository.findAll();

    }

    public void addNewPizza(Pizza pizza) {
        Optional<Pizza> pizzaOptional=pizzaRepository
                .findPizzaByName(pizza.getName());
        if(pizzaOptional.isPresent()){
            throw new IllegalStateException("Pizza Already in inventory");
        }
        pizzaRepository.save(pizza);

    }

    public void deletePizza(String pizzaName) {

        if (pizzaRepository.findPizzaByName(pizzaName) == null){

            throw new IllegalStateException(
                    "Pizza with name" + pizzaName +"does not exists");
        }
        pizzaRepository.delete(pizzaRepository.findPizzaByName(pizzaName));
    }
}
