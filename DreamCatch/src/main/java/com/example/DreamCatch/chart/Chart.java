package com.example.DreamCatch.chart;

import jakarta.persistence.Tuple;

import java.util.List;

public interface Chart {
    void draw(List<Tuple> data);
}
