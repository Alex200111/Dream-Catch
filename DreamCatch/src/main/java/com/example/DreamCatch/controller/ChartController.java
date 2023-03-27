package com.example.DreamCatch.controller;

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
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/chart")
@CrossOrigin(origins = "http://localhost:3000")
public class ChartController {

    @Autowired
    private ChartFactory chartFactory;

    @Autowired
    private ChartService chartService;

    @GetMapping("/{metrica}/{idUser}")
    public byte[] getChart(@PathVariable String metrica, @PathVariable int idUser){
        Chart chart = chartFactory.createChart(metrica);
        List<Tuple> date = chartService.getChartList(metrica,idUser);
        chart.draw(date);

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
