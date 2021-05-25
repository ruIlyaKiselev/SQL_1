package DatabaseTools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class SqlParser {
    public static List<String> parseSqlToString(String sqlScript) {
        return new ArrayList<>(Arrays.asList(sqlScript.split(";" + System.lineSeparator() + "/")));
    }

    public static String getSqlQueryFromFile(Class customClass, String filename) {
        ClassLoader classLoader = customClass.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String contents = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(contents);
        return contents;
    }

    public static String getSqlQueryFromFile(String filename) {
        InputStream inputStream = SqlParser.class.getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String contents = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(contents);
        return contents;
    }
}
