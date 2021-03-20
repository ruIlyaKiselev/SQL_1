package DatabaseTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SqlParser {
    public static String parseSqlToString(String filename) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNext()) {
            result.append(scanner.nextLine());
        }

        return result.toString();
    }
}
