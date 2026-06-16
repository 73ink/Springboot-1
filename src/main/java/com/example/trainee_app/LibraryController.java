package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    private static List<Author> authorList = new ArrayList<>();
    private static List<Book> bookList = new ArrayList<>();

    @GetMapping("/add-author")
    public String addAuthor(@RequestParam int id,
                            @RequestParam String name,
                            @RequestParam String biography) {

        Author newAuthor = new Author(id, name, biography);

        authorList.add(newAuthor);

        return "Author added successfully!";
    }

    @GetMapping("/all-authors")
    public List<Author> getAllAuthors() {

        return authorList;
    }

    @GetMapping("/add-relational-book")
    public String addRelationalBook(@RequestParam int id,
                                    @RequestParam String name,
                                    @RequestParam int authorId) {

        boolean authorExists = false;

        for (Author author : authorList) {

            if (author.getId() == authorId) {
                authorExists = true;
                break;
            }
        }

        if (authorExists) {

            Book newBook = new Book(id, name, authorId);

            bookList.add(newBook);

            return "Book added successfully with a valid author!";
        } else {

            return "Error: Author does not exist in the author registry.";
        }
    }

    @GetMapping("/author-report")
    public String authorReport(@RequestParam String authorName) {

        Author foundAuthor = null;

        for (Author author : authorList) {

            if (author.getName().equalsIgnoreCase(authorName)) {
                foundAuthor = author;
                break;
            }
        }

        if (foundAuthor == null) {
            return "Error: Author not found.";
        }

        StringBuilder booksWritten = new StringBuilder();

        for (Book book : bookList) {

            if (book.getAuthorId() == foundAuthor.getId()) {
                booksWritten.append(book.getName()).append(", ");
            }
        }

        String finalBooks;

        if (booksWritten.length() == 0) {
            finalBooks = "None";
        } else {
            finalBooks = booksWritten.substring(0, booksWritten.length() - 2);
        }

        return "Author Name: " + foundAuthor.getName()
                + " | Biography: " + foundAuthor.getBiography()
                + " | Books Written: " + finalBooks;
    }

}
