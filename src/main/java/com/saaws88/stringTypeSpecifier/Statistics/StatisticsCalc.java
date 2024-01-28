package com.saaws88.stringTypeSpecifier.Statistics;

import java.util.List;

public interface StatisticsCalc <T> {

  public Number min(List<T> lines);

  public Number max(List<T> lines);

}
