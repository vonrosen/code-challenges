#n = 2
#(())
#()()
class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        ans = []
        def generateParenthesis(cur, left_count, right_count, n):
            if len(cur) == n * 2:
                ans.append("".join(cur))
                return

            if left_count < n:
                cur.append("(")
                generateParenthesis(cur, left_count + 1, right_count, n)
                cur.pop()

            if left_count > right_count:
                cur.append(")")
                generateParenthesis(cur, left_count, right_count + 1, n)
                cur.pop()

        generateParenthesis([], 0, 0, n)
        return ans

solution = Solution()
print(solution.generateParenthesis(3))