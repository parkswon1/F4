import java.util.*;

public class ArrayTraversal {
    // 상하좌우 이동을 위한 좌표 변화량
    static int[] dr = {-1, 1, 0, 0}; // 상하 이동
    static int[] dc = {0, 0, -1, 1}; // 좌우 이동

    // BFS 탐색 함수
    static void BFS(int[][] grid) {
        int rows = grid.length; // 배열 행의 개수
        int cols = grid[0].length; // 배열 열의 개수
        boolean[][] visited = new boolean[rows][cols]; // 방문 여부를 표시하는 배열

        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
        // 시작점을 큐에 추가하고 방문 표시
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll(); // 큐에서 현재 위치를 꺼냄
            int r = curr[0]; // 현재 위치의 행
            int c = curr[1]; // 현재 위치의 열
            System.out.print(grid[r][c] + " "); // 현재 위치의 값을 출력

            // 상하좌우 인접한 칸을 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i]; // 새로운 행 좌표
                int nc = c + dc[i]; // 새로운 열 좌표
                // 새로운 좌표가 배열의 범위 내에 있고 아직 방문하지 않았다면 큐에 추가하고 방문 표시
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    // DFS 탐색 함수
    static void DFS(int[][] grid, int r, int c, boolean[][] visited) {
        int rows = grid.length; // 배열 행의 개수
        int cols = grid[0].length; // 배열 열의 개수
        visited[r][c] = true; // 현재 위치를 방문 표시
        System.out.print(grid[r][c] + " "); // 현재 위치의 값을 출력

        // 상하좌우 인접한 칸을 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i]; // 새로운 행 좌표
            int nc = c + dc[i]; // 새로운 열 좌표
            // 새로운 좌표가 배열의 범위 내에 있고 아직 방문하지 않았다면 DFS 재귀 호출
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                DFS(grid, nr, nc, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("BFS 탐색 결과:");
        BFS(grid);

        System.out.println("\nDFS 탐색 결과:");
        int rows = grid.length; // 배열 행의 개수
        int cols = grid[0].length; // 배열 열의 개수
        boolean[][] visited = new boolean[rows][cols]; // 방문 여부를 표시하는 배열
        DFS(grid, 0, 0, visited); // DFS 호출
    }
}