import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import services.BibleBook;

import static java.nio.file.Files.*;

public class BibleBooksToJSON {
    public static void main(String[] args) {
        List<String> lines;
        try {
            // Read the list of books and chapters from the CSV file
            lines = readAllLines(new File("data/BibleChapters.csv").toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Create a list of Bible books with their respective chapters
        List<BibleBook> bibleBooks = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String name = parts[0];
                int numChapters = Integer.parseInt(parts[1]);
                bibleBooks.add(new BibleBook(name, numChapters));
            }
        }

        System.out.println(bibleBooks);

        // Convert the list to JSON and write to a file
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("bible_books.json"), bibleBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
