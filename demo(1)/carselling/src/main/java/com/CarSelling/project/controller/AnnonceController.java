package com.CarSelling.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CarSelling.project.entity.AnnonceEntity;
import com.CarSelling.project.service.AnnonceService;

@RestController
@RequestMapping(path = "/api/annoncecontroller", method = RequestMethod.GET)
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @GetMapping("/annonce/{id}")
    public List<AnnonceEntity> getById(@PathVariable ObjectId id) {
        return this.annonceService.getAnnonceById(id);
    }

    @GetMapping("/annonces")
    public List<AnnonceEntity> getAll() {
        return this.annonceService.getAllAnnonce();
    }

    @GetMapping("/annonces/statut/{statut}") // pour recuperer si vendu ou non 0:non 1:oui
    public List<AnnonceEntity> getAllByStatut(@PathVariable Integer statut) {
        return this.annonceService.getAnnonceByStatut(statut);
    }

    @GetMapping("/annonces/etat/{etat}") // pour recuperer si valider ou non 0:non 1:oui
    public List<AnnonceEntity> getAllByEtat(@PathVariable Integer etat) {
        return this.annonceService.getAnnonceByEtat(etat);
    }

    @PostMapping("/add")
    public AnnonceEntity addNewAnnonce(@RequestBody AnnonceEntity annonceEntity) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        annonceEntity.setDate(currentDateTime);
        return this.annonceService.createAnnonce(annonceEntity);
    }

    @PutMapping("/update")
    public AnnonceEntity updateAnnonce(@RequestBody AnnonceEntity entity) throws Exception {
        return this.annonceService.updateAnnonce(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnnonce(@PathVariable ObjectId id) {
        this.annonceService.DeleteAnnonceById(id);
        // tokony mamerina page de retour
    }

    @DeleteMapping("/delete")
    public void deleteAnnonce(@RequestBody AnnonceEntity annonce) {
        this.annonceService.DeleteAnnonce(annonce);
        // tokony mamerina page de retour

    }

}
