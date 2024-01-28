package com.saaws88.stringTypeSpecifier.Statistics.implementations;

import com.saaws88.stringTypeSpecifier.Statistics.StatisticsCalc;

import java.util.Collections;
import java.util.List;

public class FloatsStatisticsCalculator implements StatisticsCalc<Float> {


  @Override
  public Float min(List lines) {
    return (Float) Collections.min(lines);
  }

  @Override
  public Float max(List lines) {
    return (Float) Collections.max(lines);
  }

  public Float sum(List<Float> lines) {

    Float sum = 0F;

    for (Float line : lines) {

      sum += line;

    }

    return sum;
  }

  public Float average(List<Float> lines) {

    Float sum = sum(lines);
    return sum / lines.size();

  }
}
