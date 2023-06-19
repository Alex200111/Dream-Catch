package com.example.DreamCatch.controller;

import com.example.DreamCatch.Strategy.Luna;
import com.example.DreamCatch.Strategy.Saptamana;
import com.example.DreamCatch.Strategy.Strategy;
import com.example.DreamCatch.chart.Chart;
import com.example.DreamCatch.chart.ChartFactory;
import com.example.DreamCatch.service.ChartService;
import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chart")
@CrossOrigin(origins = "http://localhost:3000")
public class ChartController {

    @Autowired
    private ChartFactory chartFactory;

    @Autowired
    private ChartService chartService;

    private Strategy strategy;

    @GetMapping("/{metrica}/{idUser}/{data}/{format}")
    public byte[] getChart(@PathVariable String metrica, @PathVariable int idUser, @PathVariable String data, @PathVariable int format) throws ParseException {


        SimpleDateFormat transform = new SimpleDateFormat("MMM dd yyyy");
        Date date=transform.parse(data);
        if(format==7){
            strategy=new Saptamana(chartFactory,chartService);
        }else{
            strategy=new Luna(chartFactory,chartService);
        }

        strategy.strategie(date,metrica,idUser);


        Path path= Paths.get("./src/main/resources/"+metrica+".png");
        byte[] img = null;
        try{
            img = Files.readAllBytes(path);
        }catch (IOException ex){
            System.out.println(ex);
        }
        return img;
    }

}
