package com.example.cadastros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cadastros.repository.CadastrosRepository;

@SpringBootApplication
public class CadastrosApplication {

  private static final Logger log = LoggerFactory.getLogger(CadastrosApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CadastrosApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CadastrosRepository repository) {
    return (args) -> {
      // save a few Cadastross
      repository.save(new Cadastros("Jack", "Bauer"));
      repository.save(new Cadastros("Chloe", "O'Brian"));
      repository.save(new Cadastros("Kim", "Bauer"));
      repository.save(new Cadastros("David", "Palmer"));
      repository.save(new Cadastros("Michelle", "Dessler"));

      // fetch all Cadastross
      log.info("Cadastross found with findAll():");
      log.info("-------------------------------");
      repository.findAll().forEach(Cadastros -> {
        log.info(Cadastros.toString());
      });
      log.info("");

      // fetch an individual Cadastros by ID
      Cadastros Cadastros = repository.findById(1L);
      log.info("Cadastros found with findById(1L):");
      log.info("--------------------------------");
      log.info(Cadastros.toString());
      log.info("");

      // fetch Cadastross by last name
      log.info("Cadastros found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      log.info("");
    };
  }

}