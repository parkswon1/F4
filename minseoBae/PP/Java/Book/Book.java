package com.example.day13.실습;

public class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "제목 = " + title + '\'' +
                " 저자 = " + author + '\'' +
                " 출판 년도 = " + publicationYear;
    }
}
