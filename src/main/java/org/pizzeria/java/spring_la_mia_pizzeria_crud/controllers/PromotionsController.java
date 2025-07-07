package org.pizzeria.java.spring_la_mia_pizzeria_crud.controllers;

import org.pizzeria.java.spring_la_mia_pizzeria_crud.model.Promotion;
import org.pizzeria.java.spring_la_mia_pizzeria_crud.repo.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/promotions")
public class PromotionsController {

    @Autowired
    private PromotionRepository promotionRepo;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("promotion") Promotion promotion, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "promotions/create";
        }

        promotionRepo.save(promotion);

        return "redirect:/menu/pizza/" + promotion.getPizza().getId();
    }

}
