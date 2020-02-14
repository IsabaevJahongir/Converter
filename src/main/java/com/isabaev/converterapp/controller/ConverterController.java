package com.isabaev.converterapp.controller;

import com.isabaev.converterapp.entity.Conversion;
import com.isabaev.converterapp.entity.Valute;
import com.isabaev.converterapp.service.ValuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConverterController {

    @Autowired
    ValuteService valuteService;


    @GetMapping("/converter1")
    public String converter1(Model model) {

        valuteService.updateValuteDataBase();

        model.addAttribute("allValutes", valuteService.getActualValutes());

        return "converter1";
    }


    @GetMapping("/converter")
    public String converter(Model model) {

        model.addAttribute("allValutes", valuteService.getActualValutes());

        return "converter";
    }


    //   @ResponseBody
    @PostMapping("/converter")
    public String calculate(Model model,
                            @ModelAttribute("fromValute") Long from,
                            @ModelAttribute("toValute") Long to,
                            @ModelAttribute("fromAmount") String strAmount) {

        Valute fromValute = valuteService.findValuteById(from);
        Valute toValute = valuteService.findValuteById(to);

        double amount = Double.parseDouble(strAmount);
        double valueFrom = fromValute.getValue()/fromValute.getNominal();
        double valueTo = toValute.getValue()/toValute.getNominal();

        Conversion conversion = new Conversion(fromValute, toValute, amount);

        model.addAttribute("conversion", conversion);
        model.addAttribute("result", valueFrom / valueTo * amount);


        return "calculate";


    }


}
