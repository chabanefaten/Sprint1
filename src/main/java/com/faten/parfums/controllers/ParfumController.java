package com.faten.parfums.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faten.parfums.entities.Parfum;
import com.faten.parfums.service.ParfumService;


@Controller
public class ParfumController {
	@Autowired
	ParfumService parfumService;

    @GetMapping("/ListeParfums") 
    public String listeParfums(ModelMap modelMap,
    		@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "2") int size)
    {
    	Page<Parfum> pars = parfumService.getAllParfumsParPage(page, size);
        modelMap.addAttribute("parfums", pars);
        modelMap.addAttribute("pages", new int[pars.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeParfums";
    }

    @GetMapping("/showCreate") // Use @GetMapping for GET requests
    public String showCreate() {
        return "createParfum";
    }

    @PostMapping("/saveParfum") // Use @PostMapping for POST requests
    public String saveParfum(@ModelAttribute("parfum") Parfum parfum,
                             @RequestParam("date") String date,
                             ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(date);
        parfum.setDateCreation(dateCreation);

        Parfum saveParfum = parfumService.saveParfum(parfum);
        String msg = "parfum enregistré avec Id " + saveParfum.getIdParfum();
        modelMap.addAttribute("msg", msg);
        return "createParfum";
    }

    @GetMapping("/supprimerParfum") // Use @GetMapping for GET requests
    public String supprimerParfum(@RequestParam("id") Long id,
                                  ModelMap modelMap, 
                                  @RequestParam (name="page",defaultValue = "0") int page,
                                  @RequestParam (name="size", defaultValue = "2") int size)
                                  {
        parfumService.deleteParfumById(id);
        Page<Parfum> pars = parfumService.getAllParfumsParPage(page,size);
        modelMap.addAttribute("parfums", pars);
        modelMap.addAttribute("pages", new int[pars.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listeParfums";
    }

    @GetMapping("/modifierParfums") // Use @GetMapping for GET requests
    public String editerParfum(@RequestParam("id") Long id,
                               ModelMap modelMap) {
        Parfum p = parfumService.getParfum(id);
        modelMap.addAttribute("parfum", p);
        return "editerParfum";
    }

    @PostMapping("/updateParfum") // Use @PostMapping for POST requests
    public String updateParfum(@ModelAttribute("parfum") Parfum parfum,
                               @RequestParam("date") String date,
                               ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(date);
        parfum.setDateCreation(dateCreation);

        parfumService.updateParfum(parfum);
        List<Parfum> pars = parfumService.getAllParfums();
        modelMap.addAttribute("parfums", pars);
        return "listeParfums";
    }
   
}
