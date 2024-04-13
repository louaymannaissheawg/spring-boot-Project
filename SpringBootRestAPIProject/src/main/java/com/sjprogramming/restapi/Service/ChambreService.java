package com.sjprogramming.restapi.Service;

import com.sjprogramming.restapi.entity.Chambre;
import com.sjprogramming.restapi.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Transactional
    public Chambre ajouterChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Transactional(readOnly = true)
    public List<Chambre> obtenirToutesChambres() {
        return chambreRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Chambre> obtenirChambreParId(Long chambreId) {
        return chambreRepository.findById(chambreId);
    }

    @Transactional
    public Chambre modifierChambre(Long chambreId, Chambre chambreMaj) {
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new IllegalArgumentException("Chambre non trouvée"));

        chambre.setNumeroChambre(chambreMaj.getNumeroChambre());
        chambre.setTypeChambre(chambreMaj.getTypeChambre());
        chambre.setBloc(chambreMaj.getBloc());
        chambre.setReservations(chambreMaj.getReservations());

        return chambreRepository.save(chambre);
    }

    @Transactional
    public void supprimerChambre(Long chambreId) {
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new IllegalArgumentException("Chambre non trouvée"));
        chambreRepository.delete(chambre);
    }
}
