package com.saaws88.stringTypeSpecifier.FileManager;

import java.util.List;

public interface FileParser <T> {

  boolean validate(String line);

  void add(String line);

  List<T> getList();
}
