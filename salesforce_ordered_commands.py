from collections import deque

#salesforce ptms interview questions
#given dependencies for commands return them in the correct execution order
class Solution:
    def command_order(self, commands: list[list[str]]) -> list[str]:
        adj = {}
        in_degree = {}
        for edge in commands:
            command = edge[0]
            pre = edge[1]
            if command not in adj:
                adj[command] = []
            if pre not in adj:
                adj[pre] = []
            if pre not in in_degree:
                in_degree[pre] = 0
            if command not in in_degree:
                in_degree[command] = 0
            adj[command].append(pre)
            in_degree[pre] += 1

        queue = deque()
        for c, i in in_degree.items():
            if i == 0:
                queue.append(c)

        ordered_commands = []
        while len(queue) > 0:
            command = queue.popleft()
            ordered_commands.append(command)

            for next_command in adj[command]:
                if next_command in in_degree:
                    in_degree[next_command] = in_degree[next_command] - 1
                    if in_degree[next_command] == 0:
                        queue.append(next_command)
                        del in_degree[next_command]

        ordered_commands.reverse()
        return ordered_commands

solution = Solution()
print(solution.command_order([["a", "b"]]))
print(solution.command_order([["a", "b"],["c", "b"]])) #[b,c,a]
print(solution.command_order([["a", "b"], ["b", "c"],["x","b"]])) #[a,x,b,c]
