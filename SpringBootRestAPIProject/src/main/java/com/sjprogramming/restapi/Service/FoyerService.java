package com.sjprogramming.restapi.Service;

import com.sjprogramming.restapi.entity.Foyer;
import com.sjprogramming.restapi.repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerService {

    @Autowired
    private FoyerRepository foyerRepository;

    @Transactional
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Transactional(readOnly = true)
    public List<Foyer> obtenirTousFoyers() {
        return foyerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Foyer> obtenirFoyerParId(Long foyerId) {
        return foyerRepository.findById(foyerId);
    }

    @Transactional
    public Foyer modifierFoyer(Long foyerId, Foyer foyerMaj) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new IllegalArgumentException("Foyer non trouvé"));

        foyer.setNomFoyer(foyerMaj.getNomFoyer());
        foyer.setUniversite(foyerMaj.getUniversite());

        return foyerRepository.save(foyer);
    }

    @Transactional
    public void supprimerFoyer(Long foyerId) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new IllegalArgumentException("Foyer non trouvé"));
        foyerRepository.delete(foyer);
    }
}
