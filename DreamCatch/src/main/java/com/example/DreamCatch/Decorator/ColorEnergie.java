package com.example.DreamCatch.Decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;

import java.awt.*;

public class ColorEnergie implements ChartDecorator{

    @Override
    public void decorate(JFreeChart chart) {
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        double mEnergie=0;
        int cont=0;
        for (int i = 0; i < plot.getDataset().getColumnCount(); i++){
            int energie =(int) plot.getDataset().getValue(0, i);
            cont++;
            mEnergie=mEnergie+energie;
        }
        mEnergie=mEnergie/cont;
        if (mEnergie < 3.0) {
            renderer.setSeriesPaint(0, Color.red);
        } else {
            renderer.setSeriesPaint(0, Color.GREEN);
        }
    }
}
