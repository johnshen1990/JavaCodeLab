package io.github.johnshen1990.javacodelab.javabasic.lintcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Author: zhun.shen
 * Date: 2017-07-19 23:10
 * Description:
 */
public class KnightShortestPath {

    public static void main(String[] args) {
//        boolean[][] grid = {{false,0,0},{0,0,0},{0,0,0}};
//       new KnightShortestPath().shortestPath();
    }

     public class Point {
          public int x, y;
          public Point() { x = 0; y = 0; }
          public Point(int a, int b) { x = a; y = b; }
      }

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        int step = 0;
        if(grid == null || equalPoints(source, destination)) {
            return 0;
        }

        Queue<Point> queue = new LinkedList<>();
        for(Point point : getPossiblePoints(grid, source)) {
            queue.offer(point);
        }

        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point point = queue.poll();
                if(equalPoints(point, destination)) {
                    return step;
                }
                for(Point p : getPossiblePoints(grid, point)) {
                    queue.offer(p);
                }
            }
        }

        return -1;
    }

    public boolean equalPoints(Point point1, Point point2) {
        return point1.x == point2.x && point1.y == point2.y;
    }

    public Set<Point> getPossiblePoints(boolean[][] grid, Point start) {
        int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};
        Set<Point> allPossiblePoints = new HashSet<>();
        for(int i = 0; i < 8; i++) {
            Point point = new Point(start.x + deltaX[i], start.y + deltaY[i]);
            if(isEmpty(grid, point)) {
                allPossiblePoints.add(point);
            }
        }
        return allPossiblePoints;
    }

    public boolean isEmpty(boolean[][] grid, Point point) {
        return inBound(grid, point) && grid[point.x][point.y];
    }

    // 判断一个点是否在棋盘的范围内
    public boolean inBound(boolean[][] grid, Point point) {
        return point.x >=0
                && point.x <= grid.length - 1
                && point.y >= 0
                && point.y <= grid[0].length - 1;
    }
}
