package kyongseo.ChatProject.client;

import java.io.BufferedReader;
import java.io.IOException;

// 서버로부터 메시지를 읽어 화면에 출력하는 역할
public class ServerMessageReader implements Runnable {
    private BufferedReader in; // 서버로부터 메시지를 읽기 위한 BufferedReader 객체

    public ServerMessageReader(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String serverLine;
            while ((serverLine = in.readLine()) != null) {
                System.out.println(serverLine); // 서버로부터 받은 메시지 출력
            }
        } catch (IOException e) {
            System.out.println("Server connection was closed.");
        }
    }
}