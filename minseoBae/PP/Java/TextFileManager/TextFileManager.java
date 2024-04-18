package com.example.day14.실습;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileManager {
    public void writeToFile(String fileName, List<String> content) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (String line : content) {
                printWriter.println(line);
            }
            System.out.println("입력하신 문장이" + fileName + "에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
    }

    public List<String> readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<String> list = new ArrayList<>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
        return null;
    }
}
