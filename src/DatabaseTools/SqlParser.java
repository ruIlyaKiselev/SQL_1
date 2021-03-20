package DatabaseTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SqlParser {
    public static List<String> parseSqlToString(String filename) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNext()) {
            result.append(scanner.nextLine());
        }

        return new ArrayList<>(Arrays.asList(result.toString().split(";")));
    }
}
