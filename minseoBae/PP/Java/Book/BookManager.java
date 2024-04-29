package com.example.day13.실습;

import java.util.*;

public class BookManager {
    Map<Integer, Book> books = new HashMap<>();
    int key = 0;
    public void addBook(Book b) {
        books.put(++key, b);
    }

    public void displayBooks() {
        for(Book b : books.values()) {
            System.out.println(b);
        }
    }

    public void sortBooksByYear() {
        Collections.sort(mapKeysToList(books));
        System.out.println("정렬 후");
        for(Book b : books.values()) {
            System.out.println(b);
        }
    }

    public static List<Integer> mapKeysToList(Map<Integer, Book> map) {
        return new ArrayList<>(map.keySet());
    }
}
