package com.example.day15.실습.FileReadWriteApp;

import java.io.*;

public class FileReadWriterApp {
    public static void main(String[] args) throws InterruptedException {
        Thread FileReader = new Thread(new FileReaderTask("src/com/example/day15/실습/FileReadWriteApp/input.txt"));
        Thread FileWriter = new Thread(new FileWriterTask("src/com/example/day15/실습/FileReadWriteApp/output.txt"));

        FileWriter.start();
        FileReader.start();
    }
}
