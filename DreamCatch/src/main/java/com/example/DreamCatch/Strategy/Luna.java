package com.example.DreamCatch.Strategy;

import com.example.DreamCatch.chart.Chart;
import com.example.DreamCatch.chart.ChartFactory;
import com.example.DreamCatch.service.ChartService;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class Luna implements Strategy{

    private final ChartFactory chartFactory;

    private final ChartService chartService;

    public void strategie(Date date, String metrica, int idUser){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,30);
        Date datePlus = calendar.getTime();

        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        Date dateMinus = calendar.getTime();

        Chart chart = chartFactory.createChart(metrica);
        List<Tuple> date2 = chartService.getChartList(dateMinus,datePlus,metrica,idUser);
        chart.draw(date2);
    }
}
