package io.github.johnshen1990.javacodelab.javabasic.lintcode.bfs;

import java.util.*;

/**
 * Author: zhun.shen
 * Date: 2017-07-15 20:34
 * Description:
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        new CourseScheduleII().findOrder(numCourses, prerequisites);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] result = new int[0];

        if(numCourses <= 0) {
            return result;
        }

        if(prerequisites == null || prerequisites.length == 0) {
            result = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        // 计算每个节点的入度
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++) {
            if(!indegreeMap.containsKey(prerequisites[0][i])) {
                indegreeMap.put(prerequisites[0][i], 1);
            } else {
                indegreeMap.put(prerequisites[0][i], indegreeMap.get(prerequisites[0][i]) + 1);
            }
        }

        if(indegreeMap.keySet().size() == numCourses) {
            return result;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(!indegreeMap.containsKey(i)) {
                queue.offer(i);
            }
        }

        List<Integer> r = new ArrayList<>();
        while(!queue.isEmpty()) {
            int course = queue.poll();
            r.add(course);

            List<Integer> afterCourse = findAfterCourse(prerequisites, course);
            for(int i : afterCourse) {
                if(indegreeMap.containsKey(i) && indegreeMap.get(i) > 0) {
                    queue.offer(i);

                    // 入度减1
                    indegreeMap.put(i, indegreeMap.get(i) - 1);
                }
            }
        }

        result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            result[i] = r.get(i);
        }

        return result;
    }

    List<Integer> findAfterCourse(int[][] prerequisites, int course) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++) {
            if(prerequisites[i][1] == course) {
                result.add(prerequisites[0][i]);
            }
        }
        return result;
    }
}
