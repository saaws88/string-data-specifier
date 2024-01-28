package com.saaws88.stringTypeSpecifier;

import com.saaws88.stringTypeSpecifier.FileManager.FileParser;
import com.saaws88.stringTypeSpecifier.FileManager.IOProcessor;
import com.saaws88.stringTypeSpecifier.FileManager.Implementations.DecimalParser;
import com.saaws88.stringTypeSpecifier.FileManager.Implementations.IntegerParser;
import com.saaws88.stringTypeSpecifier.FileManager.Implementations.StringParser;
import com.saaws88.stringTypeSpecifier.Statistics.implementations.FloatsStatisticsCalculator;
import com.saaws88.stringTypeSpecifier.Statistics.implementations.IntsStatisticsCalculator;
import com.saaws88.stringTypeSpecifier.Statistics.implementations.StringsStatisticsCalculator;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

  @Option(name = "-p", usage = "add prefix to file names")
  private String fileNamePrefix;

  @Option(name = "-s", usage = "print short statistics info")
  private boolean shortStats;

  @Option(name = "-f", usage = "print full statistics info")
  private boolean fullStats;

  @Option(name = "-a", usage = "allow to add new lines to existing files")
  private boolean addToExistingFiles;

  @Option(name = "-o", usage = "change output files path")
  private String outputDirectory;

  @Argument
  private List<String> arguments;

  public static void main(String[] args) throws IOException {

    new App().run(args);

  }

  private void run(String... args) throws IOException {

    IOProcessor ioProcessor = new IOProcessor();

    FileParser<Long> intParser = new IntegerParser();
    FileParser<Float> floatParser = new DecimalParser();
    FileParser<String> stringParser = new StringParser();

    List<FileParser> parsers = List.of(intParser, floatParser, stringParser);

    CmdLineParser cmdLineParser = new CmdLineParser(this);

    try {
      cmdLineParser.parseArgument(args);
    } catch (CmdLineException clEx) {
      System.out.printf("Ошибка парсинга командной строки: %s\n", clEx);
    }

    arguments = Arrays.stream(args).toList();

    List<String> ignored = Arrays.asList("-o", "-p", "-s", "-f", "-a", "-o", outputDirectory, fileNamePrefix);

    List<String> inputFiles = arguments.stream()
      .filter(arg -> !ignored.contains(arg))
      .toList();

    String intPath = "integers.txt";
    String floatPath = "floats.txt";
    String stringPath = "strings.txt";

    if (arguments.contains("-p")) {

      intPath = fileNamePrefix + intPath;
      floatPath = fileNamePrefix + floatPath;
      stringPath = fileNamePrefix + stringPath;

    }

    if (arguments.contains("-o")) {

      boolean file = new File(outputDirectory).mkdir();

      intPath = outputDirectory + intPath;
      floatPath = outputDirectory + floatPath;
      stringPath = outputDirectory + stringPath;

    }

    if (arguments.contains("-a")) {
      List<String> existingFiles = new ArrayList<>();

      existingFiles.add(intPath);
      existingFiles.add(floatPath);
      existingFiles.add(stringPath);

      ioProcessor.readFromFiles(existingFiles, parsers);


    }

    ioProcessor.readFromFiles(inputFiles, parsers);

    if (arguments.contains("-s") || arguments.contains("-f")) {

      System.out.printf(
        "Количество записей в файлах:\n%s: %d, %s: %d, %s: %d\n",
        intPath, intParser.getList().size(),
        floatPath, floatParser.getList().size(),
        stringPath, stringParser.getList().size());

      if (arguments.contains("-f")) {

        IntsStatisticsCalculator iCalc = new IntsStatisticsCalculator();
        FloatsStatisticsCalculator flCalc = new FloatsStatisticsCalculator();
        StringsStatisticsCalculator strCalc = new StringsStatisticsCalculator();

        System.out.println("Статистика по файлам:");
        System.out.printf(
          "%s: максимальное число - %d, минимальное число - %d, сумма чисел - %d среднее число - %.2f\n",
          intPath,
          iCalc.max(intParser.getList()),
          iCalc.min(intParser.getList()),
          iCalc.sum(intParser.getList()),
          iCalc.average(intParser.getList())
        );
        System.out.printf(
          "%s: максимальное число - %f, минимальное число - %f, сумма чисел - %f среднее число - %f\n",
          floatPath,
          flCalc.max(floatParser.getList()),
          flCalc.min(floatParser.getList()),
          flCalc.sum(floatParser.getList()),
          flCalc.average(floatParser.getList())
        );
        System.out.printf(
          "%s: количество символов в самой длинной строке - %d, в самой короткой строке - %d\n",
          stringPath,
          strCalc.max(stringParser.getList()),
          strCalc.min(stringParser.getList())
        );

      }
    }

    ioProcessor.writeToFile(intParser.getList(), intPath);
    ioProcessor.writeToFile(floatParser.getList(), floatPath);
    ioProcessor.writeToFile(stringParser.getList(), stringPath);

  }

}

