package org.hunter;

import java.util.*;

public class CourseSchedule2Again2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Integer> inDegree = new HashMap<>();
        Map<Integer,List<Integer>> adj = new HashMap<>();

        Set<Integer> inDegreeZero = new HashSet<>();
        Set<Integer> totalCourses = new HashSet<>();

        for (int i = 0; i < prerequisites.length; ++i) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];

            adj.putIfAbsent(from, new ArrayList<>());
            adj.get(from).add(to);

            totalCourses.add(from);
            totalCourses.add(to);

            inDegree.putIfAbsent(to, 0);
            inDegree.putIfAbsent(from, 0);
            inDegree.put(to, inDegree.get(to) + 1);
            inDegreeZero.remove(to);
            if (inDegree.get(from) == 0) {
                inDegreeZero.add(from);
            }
        }

        if (totalCourses.size() != numCourses) {
            for (int i = 0; i < numCourses; ++i) {
                if(!totalCourses.contains(i)) {
                    inDegreeZero.add(i);
                }
            }
        }

        List<Integer> courses = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>(inDegreeZero);
        while (!queue.isEmpty()) {
            int course = queue.poll();
            courses.add(course);
            for(int c : adj.getOrDefault(course, List.of())) {
                Integer idegree = inDegree.get(c);
                if (idegree != null) {
                    if (idegree - 1 == 0) {
                        inDegree.remove(c);
                        queue.add(c);
                    }else {
                        inDegree.put(c, idegree - 1);
                    }
                }
            }
        }
        if (courses.size() != numCourses) {
            return new int [] {};
        }
        int [] ans = new int[courses.size()];
        int i = 0;
        for (int course : courses) {
            ans[i++] = course;
        }
        return ans;
    }

}
