package com.saaws88.stringTypeSpecifier.FileManager.Implementations;

import com.saaws88.stringTypeSpecifier.FileManager.FileParser;

import java.util.ArrayList;
import java.util.List;

public class StringParser implements FileParser<String> {

  private final List<String> list = new ArrayList<>();

  @Override
  public boolean validate(String line) {
    return true;
  }

  @Override
  public void add(String line) {
    list.add(line);
  }

  public List<String> getList() {
    return list;
  }
}
