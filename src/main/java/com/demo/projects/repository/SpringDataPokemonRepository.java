package com.demo.projects.repository;

import com.demo.projects.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataPokemonRepository extends CrudRepository<Pokemon, Long> {
}
