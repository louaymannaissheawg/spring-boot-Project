package com.sjprogramming.restapi.Service;

import com.sjprogramming.restapi.entity.Bloc;
import com.sjprogramming.restapi.entity.Chambre;
import com.sjprogramming.restapi.entity.Foyer;
import com.sjprogramming.restapi.repository.BlocRepository;
import com.sjprogramming.restapi.repository.ChambreRepository;
import com.sjprogramming.restapi.repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlocService {

    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private FoyerRepository foyerRepository;

    @Transactional
    public Bloc ajouterBloc(Bloc bloc, Long foyerId) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new IllegalArgumentException("Foyer non trouvé"));

        bloc.setFoyer(foyer);
        Bloc savedBloc = blocRepository.save(bloc);

        for (int i = 0; i < bloc.getCapaciteBloc(); i++) {
            Chambre chambre = new Chambre();
            chambre.setNumeroChambre("Chambre " + (i + 1));
            chambre.setTypeChambre("Individuelle");
            chambre.setBloc(savedBloc);
            chambreRepository.save(chambre);
        }
        return savedBloc;
    }

    @Transactional(readOnly = true)
    public List<Bloc> obtenirTousBlocs() {
        return blocRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Bloc> obtenirBlocParId(Long blocId) {
        return blocRepository.findById(blocId);
    }

    @Transactional
    public Bloc modifierBloc(Long blocId, Bloc blocMaj) {
        Bloc bloc = blocRepository.findById(blocId)
                .orElseThrow(() -> new IllegalArgumentException("Bloc non trouvé"));

        bloc.setNomBloc(blocMaj.getNomBloc());
        bloc.setCapaciteBloc(blocMaj.getCapaciteBloc());
        bloc.setFoyer(blocMaj.getFoyer());
        bloc.setChambres(blocMaj.getChambres());

        return blocRepository.save(bloc);
    }

    @Transactional
    public void supprimerBloc(Long blocId) {
        Bloc bloc = blocRepository.findById(blocId)
                .orElseThrow(() -> new IllegalArgumentException("Bloc non trouvé"));

        chambreRepository.deleteByBlocId(blocId);
        blocRepository.delete(bloc);
    }
}
