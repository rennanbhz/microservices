package com.myfood.registerservice.controller;

import com.myfood.registerservice.domain.MenuDTO;
import com.myfood.registerservice.entity.Menu;
import com.myfood.registerservice.exception.NotFoundException;
import com.myfood.registerservice.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @PostMapping("/create")
    public ResponseEntity createMenu(@RequestBody MenuDTO menuDTO) {

        try {
            Menu menu = menuService.createMenu(menuDTO);

            MenuDTO dto = new MenuDTO();
            if (menu != null) {
                dto.setName(menu.getName());
                dto.setPrice(menu.getPrice());
                dto.setRestaurant(menu.getRestaurant().getId());
            }

            return Objects.nonNull(menu) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMenu(@PathVariable("id") Long id, @RequestBody MenuDTO menuDTO) {

        Menu menu = Menu.create(menuDTO);
        menu.setId(id);

        Menu updatemenu = menuService.updateMenu(menu);
        return Objects.nonNull(updatemenu) ? ResponseEntity.ok(updatemenu) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMenu(@PathVariable("id") Long id) {
        return menuService.deleteMenu(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity getMenuById(@PathVariable("id") Long id) {
        Optional<Menu> menu = menuService.getMenuById(id);
        return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.notFound().build();
    }
}
