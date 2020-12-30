package com.myfood.registerservice.service;

import com.myfood.registerservice.entity.Restaurant;
import com.myfood.registerservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {

        Optional<Restaurant> newRestaurant = restaurantRepository.findById(restaurant.getId());

        if (newRestaurant.isPresent()) {

            return restaurantRepository.save(restaurant);
        }
        return null;
    }

    public boolean deleteRestaurant(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if (restaurant.isPresent()) {
            restaurantRepository.delete(restaurant.get());
            return true;
        } else {
            return false;
        }
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }
}
