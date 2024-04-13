package com.sjprogramming.restapi.Service;

import com.sjprogramming.restapi.entity.Universite;
import com.sjprogramming.restapi.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {

    private final UniversiteRepository universiteRepository;

    @Autowired
    public UniversiteService(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    // Create
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    // Read
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    public Optional<Universite> getUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }

    // Update
    public Universite updateUniversite(Long id, Universite updatedUniversite) {
        Universite universite = universiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Universite not found for id: " + id));

        universite.setNomUni(updatedUniversite.getNomUni());
        universite.setFoyer(updatedUniversite.getFoyer());

        return universiteRepository.save(universite);
    }

    // Delete
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }
}
