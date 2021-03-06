package com.example.newprojectoption.ws;


import com.example.newprojectoption.bean.MyModule;
import com.example.newprojectoption.service.MyModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/module")
public class MyModuleProvided {

    @Autowired
    private MyModuleService myModuleService;

    @GetMapping("/code/{code}")
    public MyModule findByCode(@PathVariable String code) {
        return myModuleService.findByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public MyModule findByLibelle(@PathVariable String libelle) {
        return myModuleService.findByLibelle(libelle);
    }

    @GetMapping("/")
    public List<MyModule> findAll() {
        return myModuleService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody MyModule myModule) {
        return myModuleService.save(myModule);
    }

    @PutMapping("/")
    public MyModule update(@RequestBody MyModule myModule) {
        return myModuleService.update(myModule);
    }

   @PostMapping("/delete-multiple-by-code")
    public int deleteByCode(@RequestBody List<MyModule> myModules) {
        return myModuleService.deleteByCode(myModules);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return myModuleService.deleteByCode(code);
    }
}
