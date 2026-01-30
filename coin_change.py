class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        mem: dict[int, int] = {}
        return self._coin_change(coins, amount, mem)

    def _coin_change(self, coins: list[int], amount: int, mem: dict[int, int]) -> int:
        if amount < 0:
            return -1

        if amount == 0:
            return 0

        if amount in mem:
            return mem[amount]

        ans = -1
        for coin in coins:
            tmp = self._coin_change(coins, amount - coin, mem)
            if tmp == -1:
                continue
            if ans == -1:
                ans = 1 + tmp
            else:
                ans = min(1 + tmp, ans)

        mem[amount] = ans
        return ans

solution = Solution()
print(solution.coinChange([1,2,5], 11))
print(solution.coinChange([2], 3))
print(solution.coinChange([1], 0))


