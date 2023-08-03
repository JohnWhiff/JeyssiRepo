package com.example.bbactivity.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepository

        extends JpaRepository<Pizza,String> {
    @Query("SELECT s FROM Pizza s WHERE s.name=?1")
    Optional<Pizza> findPizzaByName(String name);

    void delete(Optional<Pizza> pizzaByName);
}
