package ro.springmongo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.springmongo.entity.Produs;
import ro.springmongo.entity.RaportCantitateSauPret;
import ro.springmongo.entity.RaportProducatori;
import ro.springmongo.service.ProdusService;

import java.util.List;


@Controller
public class ProdusController {

    @Autowired
    ProdusService produsService;


    // CREATE
    @RequestMapping("/nou")
    public String paginaProdusNou(Model model) {
        Produs produs = new Produs();
        model.addAttribute("produs", produs);
        return "adauga-produs";
    }

    @PostMapping("/salvare")
    public String createProdus(@ModelAttribute("produs") Produs produs, Model model) {
        model.addAttribute("produs", produs);
        produsService.salveaza(produs);
        return "redirect:/select/toate";
    }

    // READ
    @GetMapping("/select/toate")
    public String paginaToateProdusele(Model model) {
        List<Produs> produse = produsService.selectAll();
        model.addAttribute("produse", produse);
        return "toate-produsele";
    }

    // UPDATE
    @RequestMapping("/actualizare/{id}")
    public ModelAndView paginaActualizareProdus(@PathVariable(name = "id") String id) {
        ModelAndView mv = new ModelAndView("editeaza-produs");
        Produs produs = produsService.selectProdusDupaId(id);
        mv.addObject("produs", produs);
        return mv;
    }

    // DELETE
    @RequestMapping("/stergere/{id}")
    public String stergeProdus(@PathVariable (name = "id") String id) {
        produsService.stergeProdus(id);
        return "redirect:/select/toate";
    }

    // SELECTII DIVERSE
    // http://localhost:8080/api/select/id/5fe8b4295da78c48bb5d5c20
    @GetMapping("/select/id/{id}")
    public Produs selectProdusDupaId(@PathVariable String id) {
        return produsService.selectProdusDupaId(id);
    }


    // URL rapoarte
    @GetMapping("/rapoarte")
    public String paginaRapoarte(Model model) {
        return "rapoarte";
    }

    // http://localhost:8080/select/indicatie?indicatie=antiinflamator&indicatie=antitusiv
    @GetMapping("/indicatie")
    public String selectProdusDupaIndicatia(@RequestParam String indicatie, Model model) {
        List<Produs> produse = produsService.selectProdusDupaIndicatia(indicatie);
        model.addAttribute("produse", produse);
        model.addAttribute("indicatie", indicatie);
        return "raport-indicatie";
    }

    // AGREGARE 1
    // http://localhost:8080/agregare/1?pret=4
    @GetMapping("agregare/1")
    public String raportProducatori(
            @RequestParam(defaultValue = "0") double pret,
            Model model) {
        List<RaportProducatori> produse = produsService.raportProducatori(pret);
        model.addAttribute("produse", produse);
        model.addAttribute("pret", pret);
        return "agregare-producatori";
    }

    // AGREGARE 2
    // http://localhost:8080/agregare/2?cantitate=5&pret=40
    @GetMapping("agregare/2")
    public String raportCantitateSauPret(
            @RequestParam(defaultValue = "0") int cantitate,
            @RequestParam(defaultValue = "0") double pret,
            Model model) {
        List<RaportCantitateSauPret> produse = produsService.raportCantitateSauPret(cantitate, pret);
        model.addAttribute("produse", produse);
        model.addAttribute("cantitate", cantitate);
        model.addAttribute("pret", pret);
        return "raport-cantitate-pret";
    }
}
