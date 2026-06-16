package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
// Taking Input One by One using @RequestParam
    private static List<Book> books = new ArrayList<>();

    @GetMapping("/add-book")
    public String addBook(@RequestParam int id, @RequestParam String name, @RequestParam int authorId) {
        //added authorId
        Book newBook = new Book(id, name, authorId);

        books.add(newBook);

        return "Book added successfully!";
    }
// Viewing the Whole Bookshelf (Show All API)
    @GetMapping("/all-books")
    public List<Book> getAllBooks() {

        return books;
    }
// Searching for a Book by its Unique ID
    @GetMapping("/find-by-id")
    public Book findById(@RequestParam int id) {
        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
//    Finding Books by Name (The Search Filter)
@GetMapping("/find-by-Name")
public Book findByName(@RequestParam String name) {
    for (Book book : books) {

        if (book.getName().equalsIgnoreCase(name)) {
            return book;
        }
    }
    return null;
}

    //Handling the "Not Found" Scenario Cleanly
    @GetMapping("/search-msg")
    public String searchMessage(@RequestParam int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return "Found: " + book.getName();
            }
        }

        return "Sorry, that book ID is not available.";
    }


}