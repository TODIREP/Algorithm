package acmicpc17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Acmicpc17144 {
    public static void main(String[] args) throws IOException {
        System.out.println(solveProblem(new InputStreamReader(System.in)));
    }

    public static int solveProblem(InputStreamReader inputStreamReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Solution17144 solution17144 = convertInput(bufferedReader);
        return solution17144.solve();
    }

    public static Solution17144 convertInput(BufferedReader bufferedReader) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int t = Integer.parseInt(stringTokenizer.nextToken());

        int[][] world = new int[r][c];
        for (int x = 0; x < r; x++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int y = 0; y < c; y++) {
                world[x][y] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        return new Solution17144(r, c, world, t);
    }
}

class Solution17144 {
    private final int[][] myWorld;
    private final int height;
    private final int width;

    private int time;

    public Solution17144(int height, int width, int[][] world, int time) {
        this.height = height;
        this.width = width;
        this.time = time;

        myWorld = new int[height][width];
        for (int x = 0; x < height; x++) {
            System.arraycopy(world[x], 0, myWorld[x], 0, width);
        }
    }

    public int solve() {
        while (time-- > 0) {
            int[][] spreaded = spread(myWorld);
            int[][] cleaned = clean(spreaded);
            for (int x = 0; x < height; x++) {
                System.arraycopy(cleaned[x], 0, myWorld[x], 0, width);
            }
        }

        return merge();
    }

    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {1, 0, -1, 0};

    public int[][] spread(int[][] world) {
        int[][] newWorld = new int[height][width];

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int current = world[x][y];
                int dust = current / 5;
                int count = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;
                    if (world[nx][ny] == -1) {
                        newWorld[nx][ny] = -1;
                        continue;
                    }

                    newWorld[nx][ny] += dust;
                    count++;
                }

                newWorld[x][y] += (current - dust * count);
            }
        }

        int[][] nextWorld = new int[height][width];
        for (int x = 0; x < height; x++) {
            System.arraycopy(newWorld[x], 0, nextWorld[x], 0, width);
        }

        return nextWorld;
    }

    public int[][] clean(int[][] world) {
        int[][] newWorld = new int[height][width];
        for (int x = 0; x < height; x++) {
            System.arraycopy(world[x], 0, newWorld[x], 0, width);
        }

        int direct = 1;
        boolean active = false;

        ArrayDeque<Wind17144> queue = new ArrayDeque<>();
        for (int x = 0; x < height; x++) {
            if (newWorld[x][0] == -1) {
                int dir = 0;
                if (active) direct = -1;
                else active = true;

                queue.add(new Wind17144(x, 0, 0));

                while (!queue.isEmpty()) {
                    Wind17144 wind = queue.pollFirst();
                    int cx = wind.x;
                    int cy = wind.y;
                    int dust = wind.dust;

                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];

                    if (nx < 0 || nx >= height || ny < 0 || ny >= width) {
                        dir = (dir + direct + 4) % 4;
                        nx = cx + dx[dir];
                        ny = cy + dy[dir];
                    }

                    int nextDust = newWorld[nx][ny];
                    if (nextDust == -1) break;
                    newWorld[nx][ny] = dust;

                    queue.add(new Wind17144(nx, ny, nextDust));
                }
            }
        }

        int[][] nextWorld = new int[height][width];
        for (int x = 0; x < height; x++) {
            System.arraycopy(newWorld[x], 0, nextWorld[x], 0, width);
        }

        return nextWorld;
    }

    public int merge() {
        int result = 0;

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int value = myWorld[x][y];
                if (value == -1) continue;
                result += value;
            }
        }

        return result;
    }
}

class Wind17144 {
    public int x, y, dust;

    public Wind17144(int x, int y, int dust) {
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}