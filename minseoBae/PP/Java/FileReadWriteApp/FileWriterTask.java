package com.example.day15.실습.FileReadWriteApp;

import java.io.*;

public class FileWriterTask implements Runnable {
    private final String filePath;

    public FileWriterTask(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter outTxt = new PrintWriter(filePath)) {
            System.out.print("내용 작성 : ");
            String fileContent = br.readLine();
            System.out.println();
            outTxt.println(fileContent);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found" + filePath);
        } catch (IOException e) {
            System.out.println("IO Error" + filePath);
            ;
        }
    }
}