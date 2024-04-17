package cote;

import java.util.Stack;

public class 인형뽑기 {
    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int n = board.length; // 보드의 크기

        for (int pos : moves) {
            pos--; // 배열 인덱스는 0부터 시작하므로 1을 빼줌
            int doll = 0; // 크레인으로 집은 인형의 모양

            // 크레인으로 인형을 집어올림
            for (int i = 0; i < n; i++) {
                if (board[i][pos] != 0) {
                    doll = board[i][pos]; // 인형을 집어 올리고
                    board[i][pos] = 0; // 해당 위치의 인형을 없앰
                    break;
                }
            }

            if (doll == 0) continue; // 인형을 집지 못한 경우

            // 바구니에 담는 부분
            if (!stack.isEmpty() && stack.peek() == doll) {
                // 연속된 인형이 있는 경우
                stack.pop(); // 바구니에서 인형 제거
                answer += 2; // 제거된 인형 개수 증가
            } else {
                stack.push(doll); // 인형을 바구니에 담음
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }
}
