package com.example.DreamCatch.Decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;

import java.awt.*;

public class ColorStres implements ChartDecorator{

    @Override
    public void decorate(JFreeChart chart) {
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        double mStres=0;
        int cont=0;
        for (int i = 0; i < plot.getDataset().getColumnCount(); i++){
            int stres =(int) plot.getDataset().getValue(0, i);
            cont++;
            mStres=mStres+stres;
        }
        mStres=mStres/cont;
        if (mStres > 2.0) {
            renderer.setSeriesPaint(0, Color.red);
        } else {
            renderer.setSeriesPaint(0, Color.GREEN);
        }
    }
}
