class Solution:
    ans = 0
    def change(self, amount: int, coins: list[int]) -> int:
        if amount == 0:
            return 1
        mem = {}
        return self.count(amount, coins, 0, 0, mem)

    def count(self, amount, coins, total, index, mem):
        if amount == total:
            return 1
        if total > amount:
            return 0
        if index > len(coins) - 1:
            return 0

        if index in mem and total in mem[index]:
            return mem[index][total]

        ans = self.count(amount, coins, total + coins[index], index, mem) + self.count(amount, coins, total, index + 1, mem)

        if index not in mem:
            mem[index] = {}
        mem[index][total] = ans
        return ans

x = Solution()
print(x.change(500, [1,2,5]))