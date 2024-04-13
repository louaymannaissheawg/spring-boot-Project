package com.sjprogramming.restapi.repository;

import com.sjprogramming.restapi.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    @Modifying
    @Query("DELETE FROM Chambre c WHERE c.bloc.idBloc = :blocId")
    void deleteByBlocId(@Param("blocId") Long blocId);
}
