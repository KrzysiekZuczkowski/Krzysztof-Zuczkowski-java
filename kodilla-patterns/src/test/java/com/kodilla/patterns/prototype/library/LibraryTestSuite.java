package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Random random = new Random();
        //creating the library
        Library library = new Library("City Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n ->library.getBooks().add(new Book("Title " + n,
                        "Author" + n,
                        LocalDate.now().minusDays(random.nextInt(10000)))));

        //making a shallow copy of object Library
        Library shallowClonedLib = null;
        try {
            shallowClonedLib = library.shallowCopy();
            shallowClonedLib.setName("City Library II");
        }catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object Library
        Library deepCopyLib = null;
        try{
            deepCopyLib = library.deepCopy();
            deepCopyLib.setName("City Library III");
        }
        catch(CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(library.getBook());

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLib);
        System.out.println(deepCopyLib);

        assertEquals(4, library.getBooks().size());
        assertEquals(4, shallowClonedLib.getBooks().size());
        assertEquals(5, deepCopyLib.getBooks().size());

        //When
        library.filterBooks();

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLib);
        System.out.println(deepCopyLib);

        assertEquals(library.getBooks(), shallowClonedLib.getBooks());
        assertNotEquals(library.getBooks(), deepCopyLib.getBooks());

        //When
        for(Book book : library.getBooks())
            book.setBook();

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLib);
        System.out.println(deepCopyLib);
    }
}
