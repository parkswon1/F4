package com.example.day14.실습;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String filePath = "src/com/example/day14/실습/texts.txt";
        TextFileManager fileManager = new TextFileManager();
        UserInputHandler inputHandler = new UserInputHandler();

        List<String> userInput = inputHandler.getUserInput();
        fileManager.writeToFile(filePath, userInput);

        List<String> fileContent = fileManager.readFromFile(filePath);
        System.out.println("Content of the file:");
        fileContent.forEach(System.out::println);
    }
}