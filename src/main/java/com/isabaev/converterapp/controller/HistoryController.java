package com.isabaev.converterapp.controller;


import com.isabaev.converterapp.entity.Conversion;
import com.isabaev.converterapp.entity.User;
import com.isabaev.converterapp.service.ConversionsService;
import org.aspectj.runtime.internal.Conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    ConversionsService conversionService;

    @GetMapping("/history")
    public String showAllOperationOfUser(@AuthenticationPrincipal User user, Model model) {


        model.addAttribute("allConversions", conversionService.findAllByUser(user));


        return "history";
    }

    @PostMapping("/history")
    public String showHistoryInSelectedDay(Model model,
                                           @AuthenticationPrincipal User user,
                                           @ModelAttribute("fromDate") String from) throws ParseException {


        String pattern = "dd-MM-yyyy";
        SimpleDateFormat ft = new SimpleDateFormat(pattern);


        if (!isValid(from, pattern)) {
            model.addAttribute("allConversions", conversionService.findAllByUser(user));
            model.addAttribute("dateError", "Введите корректную дату");

            return "/history";
        }

        Date date = ft.parse(from);

        List<Conversion> conversions = conversionService.findAllByUserAndDate(user, date);


        model.addAttribute("allConversions", conversions);

        return "history";

    }




    public boolean isValid(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
