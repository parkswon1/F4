import java.util.ArrayDeque;
import java.util.Deque;

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        int[][] maps = { { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 }, {
                        0, 0, 0, 0, 0 } };
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int N = maps[0].length; // x좌표 크기
        int M = maps.length; // y좌표 크기를 가져와줍니다
        int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // 북남동서 이동 좌표
        maps[0][0] = 0; // 0,0 첫 시작부분은 방문했으니까 벽으로 만들어서 다시 못오게 만들어 줍니다.
        Deque<Integer[]> que = new ArrayDeque<>(); // que
        Integer[] start = { 0, 0, 1 }; // que 첫좌표를 넣어줬어요 y,x,z
        que.add(start);
        // BFS
        int x, y, z, my, mx, mz;
        while (!que.isEmpty()) { // 새로 방문한 노드가 하나라도 있다면 계속 BFS동작
            Integer[] node = que.removeFirst(); // [1,2,3,4] -> 1 [2,3,4]
            y = node[0]; // 현제 위치 y좌표
            x = node[1]; // 현제 위치 x좌표
            z = node[2]; // 지금까지의 이동 거리
            for (int[] mv : move) { // mv = [1,0]
                my = mv[0] + y; // 현재 y좌표 + 1
                mx = mv[1] + x; // 현재 x좌표 + 1
                mz = z + 1; // 움직인 횟수 추가 +1
                if (0 <= my && my < M && 0 <= mx && mx < N) { // 움직안 좌표 검사 맵밖으로 나갔는지
                    if (my == M - 1 && mx == N - 1) {// 오른쪽 맨 아래 도착시
                        return mz;
                    } else if (maps[my][mx] == 1) {// 1로 표시된 부분으로만 이동
                        maps[my][mx] = 0; // 이동했으니까 이동한 부분은 0
                        Integer[] nextnode = { my, mx, mz }; // que새로 도착한 곳을 넣어줍니다.
                        que.add(nextnode); // ㅇque에 넣어주기
                    }
                }
            }
        }
        return -1;
    }
}
