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

    // Task 24: Interactive Stock Status Search
    // This endpoint searches for a book by ID and checks if it is available or sold out.
    @GetMapping("/check-stock")
    public String checkStock(@RequestParam int bookId) {

        for (InventoryBook book : inventoryBooks) {

            if (book.getBookId() == bookId) {

                if (book.getStockCount() > 0) {
                    return "Available: " + book.getTitle()
                            + " | Price: " + book.getPrice()
                            + " OMR | Stock: " + book.getStockCount();
                } else {
                    return "Sold out: " + book.getTitle()
                            + " is currently not available in stock.";
                }
            }
        }

        return "This bookstore does not carry a book with ID: " + bookId;
    }
    // Task 25: Bulk Low-Stock Reorder Report
    // This endpoint checks which books have stock less than or equal to the given threshold
    @GetMapping("/low-stock-report")
    public String lowStockReport(@RequestParam int threshold) {

        String report = "";

        for (InventoryBook book : inventoryBooks) {

            if (book.getStockCount() <= threshold) {
                report = report + "Title: " + book.getTitle()
                        + " | Stock: " + book.getStockCount()
                        + "\n";
            }
        }

        if (report.equals("")) {
            return "No books currently need reordering.";
        }

        return "Low Stock Reorder Report:\n" + report;
    }
}
