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
    // added the getter and setter methods for all variables
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
