package edu.fra.uas.NotenBerechnungsProjekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NotendurschnittsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/berechne", method = RequestMethod.POST)
    @ResponseBody
    public String berechneNotendurchschnitt(@RequestParam("noten") String noten) {
        String[] notenArray = noten.split(",");
        double summe = 0;
        for (String note : notenArray) {
            summe += Double.parseDouble(note.trim());
        }
        double durchschnitt = summe / notenArray.length;
        return "Der Notendurchschnitt ist: " + durchschnitt;
    }
}