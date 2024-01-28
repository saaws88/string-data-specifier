package com.saaws88.stringTypeSpecifier.Statistics.implementations;

import com.saaws88.stringTypeSpecifier.Statistics.StatisticsCalc;

import java.util.Collections;
import java.util.List;

public class IntsStatisticsCalculator implements StatisticsCalc<Long> {

  @Override
  public Long min(List<Long> lines) {
    return Collections.min(lines);
  }

  @Override
  public Long max(List<Long> lines) {

    return Collections.max(lines);

  }

  public Long sum(List<Long> lines) {

    Long sum = 0L;

    for (Long line : lines) {

      sum += line;

    }

    return sum;
  }

  public Double average(List<Long> lines) {

    Long sum = sum(lines);
    return (double) sum / lines.size();

  }
}
