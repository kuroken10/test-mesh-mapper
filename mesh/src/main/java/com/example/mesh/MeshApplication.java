package com.example.mesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mesh.controller.MainController;

@SpringBootApplication
public class MeshApplication implements CommandLineRunner {

	@Autowired
	private MainController mainController;

	public static void main(String[] args) {
		SpringApplication.run(MeshApplication.class, args);
	}

	@Override
	public void run(String... strings){

		mainController.strat();
	}

}
