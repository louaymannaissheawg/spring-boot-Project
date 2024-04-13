package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

}
