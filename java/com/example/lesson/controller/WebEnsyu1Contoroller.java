package com.example.lesson.controller;

import com.example.lesson.LessonApplication;
import com.example.lesson.entity.Product;
import com.example.lesson.record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.lesson.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
@Controller
public class WebEnsyu1Contoroller {

    @Autowired
    private ProductService productService;
    @GetMapping("product-list")
    //@ResponseBodyを使用するとinput文字列が返されるだけとなる
    public String userList(Model model) {
        var list = productService.findAll();
        model.addAttribute("products", list);
        return "product-list";
    }

    @GetMapping("/product/{id}")
    public String output(@PathVariable("id") int id, Model model) {
        var product1 = productService.findById(id);
        model.addAttribute("product", product1);
        return "product";
    }

    @PostMapping("/product/{id}")
    public String update(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/product-list";
    }



    @GetMapping("/product-add")
    public String index(@ModelAttribute("product") Product product) {
        return "product-add";
    }

    @PostMapping("/product-add")
    public String insert(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult) {
        // バリデーション
        if(bindingResult.hasErrors()) {

            return "/product-add";
        }
        var name = product.getName();
        var price = Integer.parseInt(product.getPrice());
        productService.insert(name, price);
        return "redirect:/product-list";
    }

    @GetMapping("/update/{id}")
    public String update_menu(@ModelAttribute("product") Product product
            , @PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@Validated @ModelAttribute("product") Product product
            ,BindingResult bindingResult, @PathVariable("id") int id
            ,Model model) {
        // バリデーション
        if(bindingResult.hasErrors()) {

            return "update";
        }
        System.out.println(id);
        var name = product.getName();
        var price = Integer.parseInt(product.getPrice());
        productService.update(id, name, price);
        return "redirect:/product-list";
    }


}
