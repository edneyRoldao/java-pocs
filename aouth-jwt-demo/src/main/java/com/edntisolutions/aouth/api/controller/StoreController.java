package com.edntisolutions.aouth.api.controller;

import com.edntisolutions.aouth.api.model.Ecommerce;
import com.edntisolutions.aouth.api.model.Store;
import com.edntisolutions.aouth.api.repository.EcommerceRepository;
import com.edntisolutions.aouth.api.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("store")
public class StoreController {

    private final StoreRepository storeRepository;
    private final EcommerceRepository ecommerceRepository;

    @GetMapping
    public String createStore() {
        Ecommerce ecommerce = Ecommerce.builder().name("test ecommerce").build();
        Store store = Store.builder().description("test store").ecommerce(ecommerce).build();
        storeRepository.save(store);

        return "created";
    }

    @GetMapping("{id}")
    public ResponseEntity<Store> getStore(@PathVariable String id) {
        System.out.println(id);
        return ResponseEntity.ok(storeRepository.findById(Long.parseLong(id)).get());
    }

}
