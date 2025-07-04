package com.maron.restaurantapi.controller;

import com.maron.restaurantapi.model.Dish;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final List<Dish> dishes = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishes;
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable Long id) {
        return dishes.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Dish not found"));
    }

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        dish.setId(nextId++);
        dishes.add(dish);
        return ResponseEntity.ok(dish);
    }


    @PutMapping("/{id}")
    public Dish updateDish(@PathVariable Long id, @RequestBody Dish updatedDish) {
        Dish dish = getDishById(id);
        dish.setName(updatedDish.getName());
        dish.setPrice(updatedDish.getPrice());
        return dish;
    }

    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishes.removeIf(d -> d.getId().equals(id));
    }
}
