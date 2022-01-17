package com.feignstudy.demo;

import com.feignstudy.demo.clients.ViaCepClient;
import com.feignstudy.demo.dtos.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ViaCepClient client;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AddressDTO addressDTO = client.getAddress("02343030");
		System.out.println(addressDTO);
	}

}
