package kyongseo.ChatProject.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {

        String hostName = "localhost";
        int portNumber = 12345; // 서버와 동일한 포트 번호 사용

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try{
            // 서버 연결
            socket = new Socket(hostName, portNumber);
            // 서버로 데이터 보내기 위한 out 객체 생ㅇ성
            out = new PrintWriter(socket.getOutputStream(), true);
            // 서버로부터 데이터 읽기 위한 in 객체 생성
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner stdIn = new Scanner(System.in);

            // 닉네임 직접 입력 받기
            System.out.print("Enter your nickname: ");
            String nickname = stdIn.nextLine();
            out.println(nickname); // 서버에 닉네임을 전송

            // 서버로부터 메시지를 읽어 화면에 출력하는 메시지 수신 스레드 생성
            Thread readThread = new Thread(new ServerMessageReader(in));
            readThread.start(); // 메시지 읽기 스레드 시작

            // 사용자 입력 처리
            String userInput;
            while (true) {
                userInput = stdIn.nextLine();

                // '/bye'를 입력하면 클라이언트 종료
                if ("/bye".equals(userInput)) {
                    out.println(userInput);
                    break;
                }

                // 서버에 메시지를 전송합니다.
                out.println(userInput);
            } // while

            // 클라이언트와 서버는 명시적으로 close를 합니다. close를 할 경우 상대방쪽의 readLine()이 null을 반환됩니다. 이 값을 이용하여 접속이 종료된 것을 알 수 있습니다.
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Exception caught when trying to connect to " + hostName + " on port " + portNumber);
            e.printStackTrace();
        }
    }
}