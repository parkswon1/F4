package com.example.day15.실습.FileReadWriteApp;

import java.io.*;

public class FileReaderTask implements Runnable {
    private final String filePath;

    public FileReaderTask(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        try {
            BufferedReader kb = new BufferedReader(new FileReader(filePath));
            System.out.println(filePath + "의 내용은 다음과 같습니다...");
            String fileContent;
            while((fileContent = kb.readLine()) != null) {
                System.out.println(fileContent);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found" + filePath);
        } catch (IOException e) {
            System.out.println("IO Error" + filePath);;
        }
    }
}
