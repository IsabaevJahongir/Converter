package com.isabaev.converterapp.controller;

import com.isabaev.converterapp.entity.Conversion;
import com.isabaev.converterapp.entity.User;
import com.isabaev.converterapp.entity.Valute;

import com.isabaev.converterapp.service.ConversionsService;
import com.isabaev.converterapp.service.UserService;
import com.isabaev.converterapp.service.ValuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class ConverterController {

    @Autowired
    UserService userService;

    @Autowired
    ValuteService valuteService;

    @Autowired
    ConversionsService conversionsService;


    @GetMapping("/converter")
    public String converter(Model model) {

        valuteService.updateValuteDataBase();

        model.addAttribute("allValutes", valuteService.getActualValutes());


        return "converter";
    }


    @PostMapping("/converter")
    public String calculate(Model model,
                            @AuthenticationPrincipal User user,
                            @ModelAttribute("fromValute") Long from,
                            @ModelAttribute("toValute") Long to,
                            @ModelAttribute("fromAmount") String strAmount) {

        valuteService.updateValuteDataBase();

        if (user == null) {
            return "redirect:/converter";
        }


        Valute fromValute = valuteService.findValuteById(from);
        Valute toValute = valuteService.findValuteById(to);

        if (!isValidDouble(strAmount)) {

            Conversion conversion = new Conversion(fromValute, toValute, 0, user, new Date());

            model.addAttribute("doubleError", "Введите корректное значение исходной суммы");
            model.addAttribute("allValutes", valuteService.getActualValutes());
            model.addAttribute("conversion", conversion);

            return "converter";
        }

        double amount = Double.parseDouble(strAmount);

        Conversion conversion = new Conversion(fromValute, toValute, amount, user, new Date());


        conversionsService.save(conversion);


        model.addAttribute("conversion", conversion);
        model.addAttribute("allValutes", valuteService.getActualValutes());


        return "converter";
    }


    @GetMapping("/exchange")
    public String showAllExchange(Model model) {
        valuteService.updateValuteDataBase();

        model.addAttribute("allValutes", valuteService.getActualValutes());

        return "exchange";
    }




    private boolean isValidDouble(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


}
