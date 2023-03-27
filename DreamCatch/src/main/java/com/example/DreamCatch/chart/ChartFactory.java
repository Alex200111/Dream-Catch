package com.example.DreamCatch.chart;

import org.springframework.stereotype.Component;

@Component
public class ChartFactory {
    public Chart createChart(String chartType) {
        if (chartType == null) {
            return null;
        }
        if (chartType.equalsIgnoreCase("durata")) {
            return new ChartDurata();
        } else if (chartType.equalsIgnoreCase("stres")) {
            return new ChartStres();
        } else if (chartType.equalsIgnoreCase("energie")) {
            return new ChartEnergie();
        }
        return null;
    }
}
