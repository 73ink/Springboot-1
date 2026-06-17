package com.example.trainee_app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {

    // Task 23: Master Bookstore Catalog Controller
    // This list works as an in-memory database for bookstore inventory books.
    private static List<InventoryBook> inventoryBooks = new ArrayList<>();

    // This endpoint receives book details from the URL and adds the book to the inventory list.
    @GetMapping("/add-inventory-book")
    public String addInventoryBook(@RequestParam int bookId,
                                   @RequestParam String title,
                                   @RequestParam double price,
                                   @RequestParam int stockCount) {

        InventoryBook newBook = new InventoryBook(bookId, title, price, stockCount);

        inventoryBooks.add(newBook);

        return "Inventory book added successfully!";
    }

    // Extra Check: View All Inventory Books
    // This endpoint is helpful for testing because it shows all books added to the inventory.
    @GetMapping("/all-inventory-books")
    public List<InventoryBook> getAllInventoryBooks() {

        return inventoryBooks;
    }
}
