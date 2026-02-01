class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        ans = []
        def generateParenthesis(cur, n):
            if len(cur) == n * 2:
                if valid(cur):
                    ans.append(cur)
                return

            for p in ["(", ")"]:
                cur += p
                generateParenthesis(cur, n)
                cur = cur[:-1]

        def valid(cur):
            stack = []
            for i in range(len(cur)):
                char = cur[i]
                if char == "(":
                    stack.append("(")
                else:
                    if len(stack) == 0:
                        return False
                    else:
                        if stack[len(stack) - 1] == "(":
                            stack.pop()
                        else:
                            return False

            return len(stack) == 0

        generateParenthesis("", n)
        return ans

solution = Solution()
print(solution.generateParenthesis(3))