package com.saaws88.stringTypeSpecifier.FileManager.Implementations;

import com.saaws88.stringTypeSpecifier.FileManager.FileParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IntegerParser implements FileParser<Long> {

  private final List<Long> list = new ArrayList<>();
  @Override
  public boolean validate(String line) {

    return line.chars().allMatch(Character::isDigit);

  }

  @Override
  public void add(String line) {

    list.add(Long.parseLong(line));

  }

  @Override
  public List<Long> getList() {
    return list;
  }

}
