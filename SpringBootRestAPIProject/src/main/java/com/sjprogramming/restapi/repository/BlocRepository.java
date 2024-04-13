package com.sjprogramming.restapi.repository;

import com.sjprogramming.restapi.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {

}