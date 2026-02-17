package com.jayanth.crime.controller;

import com.jayanth.crime.model.CrimeRecord;
import com.jayanth.crime.service.CrimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CrimeController {

    private final CrimeService crimeService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws Exception {

        List<CrimeRecord> records = crimeService.processCSV(file);
        model.addAttribute("records", records);

        return "index";
    }
}
