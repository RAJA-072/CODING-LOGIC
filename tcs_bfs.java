import java.util.*;

public class Main {
    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // Calculates rotated move directions
    static int[] move(int x, int y, int dx, int dy, int dir) {
        switch (dir) {
            case 0: return new int[]{x + dx, y + dy};        // forward
            case 1: return new int[]{x + dy, y - dx};        // right
            case 2: return new int[]{x - dy, y + dx};        // left
            case 3: return new int[]{x - dx, y - dy};        // back
        }
        return new int[]{x, y};
    }

    public static int minMoves(int[][] grid, int M, int N, int[] src, int[] dst, int dx, int dy) {
        boolean[][] visited = new boolean[M][N];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(src[0], src[1], 0));
        visited[src[0]][src[1]] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == dst[0] && p.y == dst[1]) return p.dist;

            for (int dir = 0; dir < 4; dir++) {
                int[] next = move(p.x, p.y, dx, dy, dir);
                int nx = next[0], ny = next[1];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, p.dist + 1));
                }
            }
        }
        return -1; // unreachable
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();

        int[] src = {sc.nextInt(), sc.nextInt()};
        int[] dst = {sc.nextInt(), sc.nextInt()};
        int dx = sc.nextInt();
        int dy = sc.nextInt();

        System.out.println(minMoves(grid, M, N, src, dst, dx, dy));
    }
}
