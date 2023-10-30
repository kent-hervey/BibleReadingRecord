package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BibleRecordGeneator {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Read the JSON file into a list of BibleBook objects
        List<BibleBook> bibleBooks;

            bibleBooks =        objectMapper.readValue(new File("bible_books.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, BibleBook.class));

         //Print the contents
        //extracted(bibleBooks);

        //Create Bible Reading record
        createBibleReadingRecord(bibleBooks);


    }

    private static void extracted(List<BibleBook> bibleBooks) {
        for (BibleBook book : bibleBooks) {
            System.out.print("Name: " + book.getName());
            System.out.print("Number of Chapters: " + book.getNumChapters());
        }
    }

    private static void createBibleReadingRecord(List<BibleBook> bibleBooks) {
//        Character blackSquare = '\u25A1';
//        blackSquare = '\u26DD';
        String blackSquare = "|__|";
        for (BibleBook book : bibleBooks) {
            System.out.println(book.getName() + " " + book.getNumChapters());
            int numberOfSquares = book.getNumChapters();
            for(int i=0; i<numberOfSquares; i++) {
                System.out.print((blackSquare));
            }
            System.out.println();
        }
    }
}
