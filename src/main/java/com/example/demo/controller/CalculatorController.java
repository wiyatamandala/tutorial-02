package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;
import com.example.demo.model.CalculatorModel;

@Controller
public class CalculatorController {
    @RequestMapping(value="/calculatorView", method = RequestMethod.GET)
    public String getHalamanKalkulator(){
        return "calculatorView";
    }
    @RequestMapping(value="/calculatorView", method = RequestMethod.POST)
    public String proses(@RequestParam("angka1")int a_satu, @RequestParam("angka2")int a_dua, @ModelAttribute (name = "penjumlahan") CalculatorModel penjumlahan, ModelMap model){
    	penjumlahan.setAngka_satu(a_satu);
    	penjumlahan.setAngka_dua(a_dua);
    	model.addAttribute("satu", penjumlahan.getAngka_satu());
    	model.addAttribute("dua", penjumlahan.getAngka_satu());
    	
    	int hasil = penjumlahan.proses(a_satu, a_dua);
    	model.addAttribute("hasil", hasil);
    	
    	String terbilang = penjumlahan.terbilang(hasil);
    	model.addAttribute("terbilang", terbilang);
        return "calculatorView";        
    } 
}
