package com.example.accessingdatarest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "snacks", path = "snacks")
public interface SnackRepository extends JpaRepository<Snack, Long> {

    List<Snack> findByName(@Param("name") String name);

    @Query("select s from Snack s where s.snackType = :snackType ")
    List<Snack> findBySnackType(@Param("snackType") String snackType);

    @Query("select s from Snack s where s.id = :sku")
    Snack findBySku(@Param("sku") Long sku);
}
