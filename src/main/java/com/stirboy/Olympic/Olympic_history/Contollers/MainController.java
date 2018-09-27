package com.stirboy.Olympic.Olympic_history.Contollers;

import java.util.ArrayList;
import java.util.List;

import com.stirboy.Olympic.Olympic_history.Athletes.Athletes;
import com.stirboy.Olympic.Olympic_history.Athletes.AthletesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/athletes")
public class MainController {

    @Autowired
    private AthletesRepository AthletesRepository;

    @GetMapping(path="/{id}")
    public @ResponseBody Athletes getAthlete(@PathVariable Integer id){
        return AthletesRepository
        .findById(id).get();
    }

    //error is here
    // @GetMapping(path="/{findName}")
    // public List<Athletes> findNameTable(@PathVariable String findName){
    //     return AthletesRepository.findByName(findName);
    // }

    @GetMapping(path="/firstTen")
    public String getFirstTen(Model model){
        List<Athletes> a = new ArrayList<>();
        for(int i = 1; i <= 10; ++i){
            a.add(AthletesRepository.findById(i).get());
        }
        model.addAttribute("athletes", a);

        return "firstTen";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Athletes> getAll(){
        return AthletesRepository.findAll();
    }

}