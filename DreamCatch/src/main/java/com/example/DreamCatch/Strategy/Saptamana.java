package com.example.DreamCatch.Strategy;

import com.example.DreamCatch.chart.Chart;
import com.example.DreamCatch.chart.ChartFactory;
import com.example.DreamCatch.service.ChartService;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class Saptamana implements Strategy {

    private final ChartFactory chartFactory;

    private final ChartService chartService;

    public void strategie(Date date, String metrica, int idUser){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date datePlusSevenDays = calendar.getTime();

        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date dateMinusSevenDays = calendar.getTime();

        Chart chart = chartFactory.createChart(metrica);
        List<Tuple> date2 = chartService.getChartList(dateMinusSevenDays,datePlusSevenDays,metrica,idUser);
        chart.draw(date2);
    }
}
