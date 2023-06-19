package com.example.DreamCatch.chart;

import com.example.DreamCatch.Decorator.ChartDecorator;
import com.example.DreamCatch.Decorator.ColorStres;
import jakarta.persistence.Tuple;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ChartStres implements Chart{

    private ChartDecorator chartDecorator=new ColorStres();
    public void draw(List<Tuple> stres) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(Tuple result : stres) {
            dataset.addValue(result.get(0,Integer.class),"Val",result.get(1, Date.class));
        }

        JFreeChart chart = ChartFactory.createBarChart("Stres","Data","Valori",dataset, PlotOrientation.VERTICAL,false,false,false);

        if (chartDecorator != null) {
            chartDecorator.decorate(chart);
        }

        File file= new File("./src/main/resources/stres.png");
        try {
            ChartUtils.saveChartAsPNG(file, chart, 400, 600);
        }catch (IOException ex){
            System.out.println(ex);
        };
    }
}
