package com.example.newprojectoption.ws;

import com.example.newprojectoption.bean.Etudiant;
import com.example.newprojectoption.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/Etudiant")
public class EtudiantProvided {
    @GetMapping("/cne/{cne}")
    public Etudiant findByCne(@PathVariable String cne) {
        return etudiantService.findByCne(cne);
    }
    @GetMapping("/nom/{nom}/prenon/{prenon}")
    public List<Etudiant> findByNomAndPrenom(@PathVariable String nom, @PathVariable String prenon) {
        return etudiantService.findByNomAndPrenom(nom, prenon);
    }
    @DeleteMapping("/cne/{cne}")
    public int deleteByCne(@PathVariable String cne) {
        return etudiantService.deleteByCne(cne);
    }
    @GetMapping("/")
    public List<Etudiant> findAll() {
        return etudiantService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }
    @Autowired
    private EtudiantService etudiantService;
}
