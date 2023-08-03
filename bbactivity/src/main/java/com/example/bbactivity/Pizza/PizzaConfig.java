package com.example.bbactivity.Pizza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class PizzaConfig {
    @Bean
    CommandLineRunner commandLineRunner(PizzaRepository repository){
        return args -> {
            Pizza peperoni =new Pizza(
                    "Pepenironi Pizza",
                    LocalDate.of(2023, JULY,30),
                    LocalDate.of(2023, AUGUST,28)
            );

            Pizza doublecheese=new Pizza(
                    "DoubleCheese Pizza",
                    LocalDate.of(2023, JULY,30),
                    LocalDate.of(2023, AUGUST,15)
            );

            repository.saveAll(
                    List.of(peperoni,doublecheese)
            );

        };
    }
}
