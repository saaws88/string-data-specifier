Файл собирается с использованием Apache Maven из корневой директивы командой mvn package
Плагин assemble собирает файл .jar с зависимости, по умолчанию target/stringTypeSpecifier-1.0-SNAPSHOT-jar-with-dependencies.jar

По умолчанию программа запускается командой java -jar, в качестве аргументов передается путь файлов содержащих вводные данные
Пример:

```shell
java -jar target/stringTypeSpecifier-1.0-SNAPSHOT-jar-with-dependencies.jar in.txt in2.txt
```

По результатам работы программы создаются файлы: **integers.txt float.txt и strings.txt**

Опции: 
**-p** аргументом принимает строку, добавляет префикс к названию файла

**-s** без аргументов, печатает краткую статистику, содержащую путь и наименование к файлу, а так же количество строк в каждом файле. Пример работы: 
```shell
user:/mnt/c/Users/vv.zibnitsky/Desktop/Projects/Java/string-type-specifier$ java -jar target/stringTypeSpecifier-1.0-SNAPSHOT-jar-with-dependencies.jar -s in.txt in2.txt
Количество записей в файлах:
integers.txt: 3, floats.txt: 3, strings.txt: 6
```

**-f** без аргументов, печатает полную статистику в файлах
```shell
user:/mnt/c/Users/vv.zibnitsky/Desktop/Projects/Java/string-type-specifier$ java -jar target/stringTypeSpecifier-1.0-SNAPSHOT-jar-with-dependencies.jar -f in.txt in2.txt
Количество записей в файлах:
integers.txt: 3, floats.txt: 3, strings.txt: 6
Статистика по файлам:
integers.txt: максимальное число - 1234567890123456789, минимальное число - 45, сумма чисел - 1234567890123557334 среднее число - 411522630041185790.00
floats.txt: максимальное число - 3.141500, минимальное число - -0.001000, сумма чисел - 3.140500 среднее число - 1.046833
strings.txt: количество символов в самой длинной строке - 42, в самой короткой строке - 4
``` 

**-a** без аргументов, позволяет дозаписать новые строки в существующие файлы

**-o** аргументом принимает строку, позволяет прописать путь к файлу, в качестве пути прописывается относительный путь.

Пример работы программы и обработки ошибки чтения вводного файла: 

```shell 
user:/mnt/c/Users/vv.zibnitsky/Desktop/Projects/Java/string-type-specifier$ java -jar target/stringTypeSpecifier-1.0-SNAPSHOT-jar-with-dependencies.jar -f -o ./output/ in.txt in2.txt in3.txt
Файл in3.txt не найден, создан новый файл
Количество записей в файлах:
./output/integers.txt: 3, ./output/floats.txt: 3, ./output/strings.txt: 6
Статистика по файлам:
./output/integers.txt: максимальное число - 1234567890123456789, минимальное число - 45, сумма чисел - 1234567890123557334 среднее число - 411522630041185790.00
./output/floats.txt: максимальное число - 3.141500, минимальное число - -0.001000, сумма чисел - 3.140500 среднее число - 1.046833
./output/strings.txt: количество символов в самой длинной строке - 42, в самой короткой строке - 4
```
