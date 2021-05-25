package com.myfood.registerservice.service;

import com.myfood.registerservice.domain.MenuDTO;
import com.myfood.registerservice.entity.Menu;
import com.myfood.registerservice.entity.Restaurant;
import com.myfood.registerservice.repository.MenuRepository;
import com.myfood.registerservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public Menu createMenu(MenuDTO menuDTO) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(menuDTO.getRestaurant());

        if (restaurant.isPresent()) {
            Menu menu = Menu.create(menuDTO);
            menu.setRestaurant(restaurant.get());
            return menuRepository.save(menu);
        } else {
            return null;
        }
    }

    public Menu updateMenu(Menu menu) {

        Optional<Menu> newMenu = menuRepository.findById(menu.getId());

        if (newMenu.isPresent()) {

            return menuRepository.save(menu);
        }
        return null;
    }

    public boolean deleteMenu(Long id) {
        Optional<Menu> client = menuRepository.findById(id);

        if (client.isPresent()) {
            menuRepository.delete(client.get());
            return true;
        } else {
            return false;
        }
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }
}
