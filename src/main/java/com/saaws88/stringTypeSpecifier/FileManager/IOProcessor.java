package com.saaws88.stringTypeSpecifier.FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class IOProcessor {

  public static <T> void writeToFile(List<T> list, String filePath) throws IOException {

    if (!list.isEmpty()) {

      PrintWriter writer = new PrintWriter(filePath);

      for (T value : list) {
        writer.println(value);
      }

      writer.close();

    }
  }
  public static void readFromFiles(List<String> filePaths, List<FileParser> parsers) {
    for (String filePath : filePaths) {
      try {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = fileReader.readLine()) != null) {

          String finalLine = line;
          var parser = parsers
            .stream()
            .filter(p -> p.validate(finalLine))
            .findFirst()
            .orElseThrow();
          parser.add(line);

        }

      } catch (IOException e) {
        System.out.printf("Файл %s не найден, создан новый файл\n", filePath);
      }
    }
  }

}
