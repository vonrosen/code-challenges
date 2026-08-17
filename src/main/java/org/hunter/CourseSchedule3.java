package org.hunter;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *
 * [[100,200],[200,1300],[1000,1250],[2000,3200]]
 *
 * on day i what is the maximum number of courses you can take given you have already
 * taken set of courses
 *
 * 10k max courses
 * if uses backtracking permutations then o(10k!). impossibly slow
 *
 * greedy? nope
 * sort by last day and filter out all with duration > last day
 *
 *
 * [[5,5],[4,6],[2,6]]
 *
 *
 *
 * fails with greedy on both duration and lastday
 * [[5,11],[3,5],[10,20],[4,20],[10,16]]
 * ans = 3
 *
 *  sorted
 *  [[3,5],[5,11],[10,16],[4,20],[10,20]]
 *
 *
 *
 * [[5,11],[3,5],[10,20],[4,20],[10,16]]
 * 6        2    10       16    6
 *
 *
 * [[7,17],[3,12],[10,20],[9,10],[5,20],[10,19],[4,18]]
 *
 * [[3,12],[4,18],[7,17],[5,20],[10,20],[9,10],[10,19]]
 *
 *[[5,5],[4,6],[2,6]]
 *
 * [[5,5],[2,6],[4,6]]
 *
 *
 *
 *
 */
public class CourseSchedule3 {

    public static void main(String [] args) {
//        int [][] courses = {{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}};
//        int [][] courses = {{5,5},{4,6},{2,6}};
        int [][] courses = {{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}};
        CourseSchedule3 c = new CourseSchedule3();
        System.out.println(c.scheduleCourse(courses));
    }

    public int scheduleCourse4(int[][] courses) {
        Integer [] mem = new Integer[10_000];
        return scheduleCourse(courses, 0, new HashSet<>());
    }

    int scheduleCourse(int [][] courses, int day, Set<Integer> path) {
        int ans = 0;
        for (int i = 0; i < courses.length; ++i) {
            int ans2 = 0;
            if (!path.contains(i)) {
                path.add(i);
                int duration = courses[i][0];
                int lastDay = courses[i][1];
                if (day + duration <= lastDay) {
                    ans2 = 1 + Math.max(ans2, scheduleCourse(courses, day + duration, path));
                }
                path.remove(i);
            }
            ans = Math.max(ans, ans2);
        }
        return ans;
    }

    /**
     * [[7,17],[3,12],[10,20],[9,10],[5,20],[10,19],[4,18]]
     *
     *
     * ans = 4
     *
     * heap sorted by last day
     * [[9,10],[3,12],[7,17],[4,18],[10,19],[5,20],[10,20]]
     *
     * used sorted by duration
     * [[3,12],[4,18],[5,20],[7,17],[9,10],[10,19],[10,20]]
     *
     * [3,12],[7,17],[4,18],[5,20]
     *
     *
     *
     * [[5,5],[4,6],[2,6]]
     * heap = [[5,5],[4,6],[2,6]]
     *
     *
     * [[6,7],[2,10],[10,11],[8,14],[5,15],[5,16],[2,19],[3,19]]
     *
     * [6,7],[2,10],[5,16],[2,19],[3,19]
     *
     * expected = 5
     *
     *
     *
     * @param courses
     * @return
     */
    public int scheduleCourse(int[][] courses) {
        Queue<int[]> heap = new PriorityQueue<>((int[] c1, int[] c2) -> {
            int lastDay1 = c1[1];
            int lastDay2 = c2[1];
            if (lastDay1 < lastDay2) {
                return -1;
            }
            if (lastDay1 > lastDay2) {
                return 1;
            }
            int duration1 = c1[0];
            int duration2 = c2[0];
            if (duration1 < duration2) {
                return -1;
            }
            if(duration1 > duration2) {
                return 1;
            }
            return 0;
        });
        Queue<int []> used = new PriorityQueue<>((int[] c1, int[] c2) -> {
            int duration1 = c1[0];
            int duration2 = c2[0];
            if (duration1 < duration2) {
                return 1;
            }
            if(duration1 > duration2) {
                return -1;
            }
            return 0;
        });
        for (int i = 0; i < courses.length; ++i) {
            if (courses[i][0] <= courses[i][1]) {
                heap.add(courses[i]);
            }
        }
        int ans = 0;
        int day = 0;
        while (!heap.isEmpty()) {
            int [] course = heap.poll();
            int duration = course[0];
            int lastDay = course[1];
            if (day + duration <= lastDay) {
                used.add(course);
                ans++;
                day += duration;
            }else if (!used.isEmpty() && used.peek()[0] > duration) {
                int [] usedCourse = used.poll();
                used.add(course);
                day -= usedCourse[0];
                day += duration;
            }
        }
        return ans;
    }
}
