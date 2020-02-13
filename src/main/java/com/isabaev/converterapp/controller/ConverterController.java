package com.isabaev.converterapp.controller;

import com.isabaev.converterapp.entity.Valute;
import com.isabaev.converterapp.service.ValuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ConverterController {

    @Autowired
    ValuteService valuteService;


    @GetMapping("/converter")
    public String converter(Model model){

        valuteService.updateValuteDataBase();

        model.addAttribute("allValutes", valuteService.getActualValutes());

        return "converter1";
    }


}
