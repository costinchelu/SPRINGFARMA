package ro.springmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.springmongo.entity.Produs;
import ro.springmongo.entity.RaportCantitateSauPret;
import ro.springmongo.entity.RaportProducatori;
import ro.springmongo.service.ProdusService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProdusRestController {

    @Autowired
    ProdusService produsService;


    // CREATE
    @PostMapping("/creare")
    public Produs createProdus(@RequestBody Produs produs) {
        return produsService.salveaza(produs);
    }


    // READ
    @GetMapping("/select/toate")
    public List<Produs> selectAll() {
        return produsService.selectAll();
    }

    // http://localhost:8080/api/select/id/5fe8b4295da78c48bb5d5c20
    @GetMapping("/select/id/{id}")
    public Produs selectProdusDupaId(@PathVariable String id) {
        return produsService.selectProdusDupaId(id);
    }

    // http://localhost:8080/api/select/den-com?denComerciala=Bimagan%200,1%20Mg/Ml
    @GetMapping("select/den-com")
    public List<Produs> selectProdusDupaDenComerciala(@RequestParam String denComerciala) {
        return produsService.selectProdusDupaDenComerciala(denComerciala);
    }

    // http://localhost:8080/api/select/prod-si-den-dci?producator=Labormed%20Pharma&denDci=codeinum
    // http://localhost:8080/api/select/prod-si-den-dci?producator=&denDci=codeinum
    @GetMapping("select/prod-si-den-dci")
    public List<Produs> selectProdusDupaProducatorSiDenDci(
            @RequestParam(required = false) String producator, @RequestParam String denDci) {
        return produsService.selectProdusDupaProducatorSiDenDci(producator, denDci);
    }

    // http://localhost:8080/api/select/prod-sau-den-dci?denComerciala=Codeina%20Fosfat%20Lph%2015%20Mg&denDci=bimatoprostum
    // http://localhost:8080/api/select/prod-sau-den-dci?denComerciala=&denDci=bimatoprostum
    @GetMapping("select/prod-sau-den-dci")
    public List<Produs> selectProdusDupaDenComercialaSauDenDci(
            @RequestParam String denComerciala, @RequestParam String denDci) {
        return produsService.selectProdusDupaDenComercialaSauDenDci(denComerciala, denDci);
    }

    // http://localhost:8080/api/select/pret-mai-mare?pret=8.9
    @GetMapping("select/pret-mai-mare")
    public List<Produs> selectProdusDupaPretMaiMareSauEgal(@RequestParam double pret) {
        return produsService.selectProdusDupaPretMaiMareSauEgal(pret);
    }

    // http://localhost:8080/api/select/indicatie?indicatie=antiinflamator&indicatie=antibiotic
    @GetMapping("select/indicatie")
    public List<Produs> selectProdusDupaIndicatia(@RequestParam String... indicatie) {
        return produsService.selectProdusDupaIndicatia(indicatie);
    }

    // http://localhost:8080/api/select/producator-ca?producator=phar
    @GetMapping("select/producator-ca")
    public List<Produs> selectProdusDupaProducatorCa(@RequestParam String producator) {
        return produsService.selectProdusDupaProducatorCa(producator);
    }

    // http://localhost:8080/api/select/den-com-incepe-cu?denComerciala=Alg
    @GetMapping("select/den-com-incepe-cu")
    public List<Produs> selectProdusDupaDenComercialaIncepeCu(@RequestParam String denComerciala) {
        return produsService.selectProdusDupaDenComercialaIncepeCu(denComerciala);
    }


    // UPDATE
    @PutMapping("/actualizare")
    public Produs actualizeazaProdus(@RequestBody Produs produs) {
        return produsService.salveaza(produs);
    }


    // DELETE
    @DeleteMapping("/stergere/{id}")
    public String stergeProdus(@PathVariable String id) {
        return produsService.stergeProdus(id);
    }

    // AGREGARE 1
    // http://localhost:8080/api/agregare/1?pret=4
    @GetMapping("agregare/1")
    public List<RaportProducatori> raportProducatori(@RequestParam(defaultValue = "4") double pret) {
        return produsService.raportProducatori(pret);
    }

    // AGREGARE 2
    // http://localhost:8080/api/agregare/2?cantitate=5&pret=40
    @GetMapping("agregare/2")
    public List<RaportCantitateSauPret> raportCantitateSauPret(
            @RequestParam(defaultValue = "5") int cantitate, @RequestParam(defaultValue = "40") double pret) {
        return produsService.raportCantitateSauPret(cantitate, pret);
    }
}
