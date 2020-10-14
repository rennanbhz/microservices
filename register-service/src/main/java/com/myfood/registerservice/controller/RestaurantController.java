package com.myfood.registerservice.controller;

import com.myfood.registerservice.domain.RestaurantDTO;
import com.myfood.registerservice.entity.Restaurant;
import com.myfood.registerservice.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @PostMapping("/create")
    public ResponseEntity createCliente (@RequestBody RestaurantDTO restaurantDTO) {

        try {

            return ResponseEntity.ok(restaurantService.createRestaurant(Restaurant.restaurantMapper(restaurantDTO)));

        } catch (Exception e) {

           return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRestaurant (@PathVariable ("id") Long id, @RequestBody RestaurantDTO restaurantDTO) {

        Restaurant restaurant = Restaurant.restaurantMapper(restaurantDTO);
        restaurant.setId(id);

        Restaurant updateRestaurant = restaurantService.updateRestaurant(restaurant);
        return Objects.nonNull(updateRestaurant) ? ResponseEntity.ok(updateRestaurant) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient (@PathVariable("id") Long id) {
        return restaurantService.deleteRestaurant(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity getClientById (@PathVariable("id") Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        return restaurant.isPresent() ? ResponseEntity.ok(restaurant.get()) : ResponseEntity.notFound().build();
    }
}
