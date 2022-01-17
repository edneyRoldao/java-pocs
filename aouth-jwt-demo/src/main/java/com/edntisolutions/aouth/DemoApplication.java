package com.edntisolutions.aouth;

import com.edntisolutions.aouth.api.model.Ecommerce;
import com.edntisolutions.aouth.api.model.Store;
import com.edntisolutions.aouth.api.repository.EcommerceRepository;
import com.edntisolutions.aouth.api.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private EcommerceRepository ecommerceRepository;

	@Autowired
	private StoreRepository storeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ecommerce ecommerce = Ecommerce.builder().name("test ecommerce").build();
		Store store = Store.builder().description("test store").ecommerce(ecommerce).build();
		storeRepository.save(store);
	}

}
