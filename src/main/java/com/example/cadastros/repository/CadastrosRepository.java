package com.example.cadastros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.cadastros.Cadastros;

public interface CadastrosRepository extends CrudRepository<Cadastros, Long> {

  List<Cadastros> findByLastName(String lastName);

  Cadastros findById(long id);
}