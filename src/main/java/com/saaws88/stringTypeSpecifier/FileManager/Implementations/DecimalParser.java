package com.saaws88.stringTypeSpecifier.FileManager.Implementations;

import com.saaws88.stringTypeSpecifier.FileManager.FileParser;

import java.util.ArrayList;
import java.util.List;

public class DecimalParser implements FileParser <Float> {

  private final List<Float> list = new ArrayList<>();

  @Override
  public boolean validate(String line) {

    try {
      Float.parseFloat(line);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }

  }

  @Override
  public void add(String line) {

    list.add(Float.parseFloat(line));

  }

  @Override
  public List<Float> getList() {
    return list;
  }
}
