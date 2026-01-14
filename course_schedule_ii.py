class Solution:
    def findOrder(self, numCourses: int, prerequisites: list[List[int]]) -> list[int]:
        adj: dict[int, list[int]] = {}
        for edge in prerequisites:
            course = edge[0]
            prereq = edge[1]
            if course not in adj:
                adj[course] = []
            adj[course].append(prereq)

        for course in range(numCourses):
            if course not in adj:
                adj[course] = []

        seen: set[int] = set()
        courses: list[int] = []
        for course in range(numCourses):
            if not self.dfs(courses, course, adj, set(), seen):
                return []

        return courses

    def dfs(self, courses: list[int], course: int, adj: dict[int, list[int]], local_seen: set[int], seen: set[int]) -> bool:
        if course in local_seen:
            return False

        if course in seen:
            return True

        seen.add(course)
        local_seen.add(course)
        ans = True
        for next_course in adj[course]:
            #if there is any cycle then we cannot finish all the courses
            if not self.dfs(courses, next_course, adj, local_seen, seen):
                ans = False
                break

        local_seen.remove(course)

        if ans:
            courses.append(course)

        return ans
