class Solution:
    def myPow(self, x: float, n: int) -> float:
        def myPow2(x, n):
            n = abs(n)
            if n == 0:
                return 1
            if n % 2 == 0:
                ans = self.myPow(x * x, int(n / 2))
            else:
                ans = x * self.myPow(x * x, int((n - 1) / 2))
            return ans
        ans = myPow2(x, n)
        return 1 / ans if n < 0 else ans



solution = Solution()

for i in range(11):
    print(solution.myPow(2, i), end = " ")

print("")

for i in range(11):
    print(solution.myPow(2, -i), end = " ")