package com.sjprogramming.restapi.repository;

import com.sjprogramming.restapi.entity.Foyer;
import com.sjprogramming.restapi.entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {

}