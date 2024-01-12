package com.CarSelling.project.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.CarSelling.project.entity.AnnonceEntity;

@Repository
public interface AnnonceRepository extends MongoRepository<AnnonceEntity, ObjectId> {
    @Query("{ 'etat' : ?0}")
    List<AnnonceEntity> findByEtat(Integer etat);

    @Query("{ 'statut' : ?0 }")
    List<AnnonceEntity> findByStatut(Integer statut);

    List<AnnonceEntity> findBy_id(ObjectId _id);
}