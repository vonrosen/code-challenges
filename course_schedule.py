#[[1,0],[0,1]]
class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        adj = {}
        seen = set()
        for pre in prerequisites:
            course = pre[0]
            p = pre[1]
            if course not in adj:
                adj[course] = []
            adj[course].append(p)

        for course in range(numCourses):
            if course not in adj:
                adj[course] = []

        for course in range(numCourses):
            if not self.dfs(adj, course, set(), seen):
                return False

        return True

    def dfs(self, adj, course, path, seen):
        if course in path:
            return False

        if course in seen:
            return True

        path.add(course)
        seen.add(course)
        ans = True

        for pre in adj[course]:
            if not self.dfs(adj, pre, path, seen):
                return False

        path.remove(course)
        return ans