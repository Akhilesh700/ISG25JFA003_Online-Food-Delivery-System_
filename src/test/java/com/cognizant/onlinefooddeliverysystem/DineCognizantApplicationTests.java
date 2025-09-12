package com.cognizant.onlinefooddeliverysystem;

import com.cognizant.onlinefooddeliverysystem.service.MenuService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AllArgsConstructor
class DineCognizantApplicationTests {
	private final MenuService service;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void viewAllMenu(){
//		service.getAllMenu();
//	}

}
