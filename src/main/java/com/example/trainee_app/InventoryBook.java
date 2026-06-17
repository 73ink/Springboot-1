package com.example.trainee_app;

public class InventoryBook {

    // Task 22: Inventory Book Data Structure
    // These private variables store the book inventory details.
    private int bookId;
    private String title;
    private double price;
    private int stockCount;

    // This constructor creates a new InventoryBook object with all required data.
    public InventoryBook(int bookId, String title, double price, int stockCount) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.stockCount = stockCount;
    }

}
