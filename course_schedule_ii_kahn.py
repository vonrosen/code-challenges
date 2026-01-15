class Solution:
    def findOrder(self, numCourses: int, prerequisites: list[List[int]]) -> list[int]:
        adj = {}
        in_degree = {}
        for edge in prerequisites:
            course = edge[0]
            pre = edge[1]
            if course not in adj:
                adj[course] = []
            adj[course].append(pre)
            if course not in in_degree:
                in_degree[course] = 0
            if pre not in in_degree:
                in_degree[pre] = 0
            in_degree[pre] += 1

        for course in range(numCourses):
            if course not in adj:
                adj[course] = []
            if course not in in_degree:
                in_degree[course] = 0

        queue = deque()
        for course, ind in in_degree.items():
            if ind == 0:
                queue.append(course)

        courses = []
        seen = set()
        while len(queue) > 0:
            course = queue.popleft()

            if course in seen:
                return []

            seen.add(course)
            courses.append(course)

            for next_course in adj[course]:
                if next_course in in_degree:                    
                    in_degree[next_course] = in_degree[next_course] - 1
                    if in_degree[next_course] == 0:
                        queue.append(next_course)
                        del in_degree[next_course]

        #in case of a cycle which causes vertices not to be processed since
        #their in degree never goes to 0 like [[0,2],[1,2],[2,0]]. 1 goes to 2 but 2 has indegree of 2 to start. then cycle between 0 and 2 means no other indegree 0 nodes available and exit loop processing only node 1
        if len(courses) != numCourses:
            return []

        courses.reverse()
        return courses
