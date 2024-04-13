package com.sjprogramming.restapi.Service;

import com.sjprogramming.restapi.entity.Etudiant;
import com.sjprogramming.restapi.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Transactional
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Transactional(readOnly = true)
    public List<Etudiant> obtenirTousEtudiants() {
        return etudiantRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Etudiant> obtenirEtudiantParId(Long etudiantId) {
        return etudiantRepository.findById(etudiantId);
    }

    @Transactional
    public Etudiant modifierEtudiant(Long etudiantId, Etudiant etudiantMaj) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé"));

        etudiant.setNom(etudiantMaj.getNom());
        etudiant.setPrenom(etudiantMaj.getPrenom());
        etudiant.setCin(etudiantMaj.getCin());
        etudiant.setEcole(etudiantMaj.getEcole());
        etudiant.setDateNaissance(etudiantMaj.getDateNaissance());

        return etudiantRepository.save(etudiant);
    }

    @Transactional
    public void supprimerEtudiant(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé"));
        etudiantRepository.delete(etudiant);
    }
}
