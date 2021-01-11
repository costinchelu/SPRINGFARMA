package ro.springmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.springmongo.entity.Produs;
import ro.springmongo.entity.RaportCantitateSauPret;
import ro.springmongo.entity.RaportProducatori;
import ro.springmongo.repository.ProdusRepository;

import java.util.List;


@Service
public class ProdusService {

    @Autowired
    ProdusRepository produsRepository;


    public Produs salveaza(Produs produs) {
        return produsRepository.save(produs);
    }

    public List<Produs> selectAll() {
        return produsRepository.findAll(Sort.by(Sort.Order.asc("denComerciala")));
    }

    public Produs selectProdusDupaId(String id) {
        return produsRepository.findById(id).get();
    }

    public String stergeProdus(String id) {
        produsRepository.deleteById(id);
        return "Produsul cu ID " + id + " a fost sters din BD";
    }



    public List<Produs> selectProdusDupaDenComerciala(String denComerciala) {
        return produsRepository.findByDenComerciala(denComerciala);
    }

    public List<Produs> selectProdusDupaProducatorSiDenDci(String producator, String denDci) {
        return produsRepository.findByProducatorAndDci_DenDci(producator, denDci);
    }

    public List<Produs> selectProdusDupaDenComercialaSauDenDci(String denComerciala, String denDci) {
        return produsRepository.findByDenComercialaOrDci_DenDci(denComerciala, denDci);
    }

    public List<Produs> selectProdusDupaPretMaiMareSauEgal(double pret) {
        return produsRepository.findByPretGreaterThanEqual(pret);
    }

    public List<Produs> selectProdusDupaIndicatia(String... indicatie) {
        return produsRepository.findByIndicatiiContaining(indicatie);
    }

    public List<Produs> selectProdusDupaProducatorCa(String producator) {
        return produsRepository.findByProducatorLike(producator);
    }

    public List<Produs> selectProdusDupaDenComercialaIncepeCu(String denComerciala) {
        return produsRepository.findByDenComercialaStartsWith(denComerciala);
    }



    public List<RaportProducatori> raportProducatori(double pret) {
        return produsRepository.raportProducatori(pret).getMappedResults();
    }

    public List<RaportCantitateSauPret> raportCantitateSauPret(int cantitate, double pret) {
        return produsRepository.raportCantitateSauPret(cantitate, pret).getMappedResults();
    }

}
