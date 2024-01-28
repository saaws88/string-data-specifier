package com.saaws88.stringTypeSpecifier.Statistics.implementations;

import com.saaws88.stringTypeSpecifier.Statistics.StatisticsCalc;

import java.util.List;

public class StringsStatisticsCalculator implements StatisticsCalc<String> {

  @Override
  public Integer min(List<String> lines) {

    return lines.stream()
      .map(String::length)
      .min(Integer::compare)
      .get();

  }

  @Override
  public Integer max(List<String> lines) {

    return lines.stream()
      .map(String::length)
      .max(Integer::compare)
      .get();

  }
}
