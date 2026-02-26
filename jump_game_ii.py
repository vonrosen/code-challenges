import sys

class Solution2:
    def jump(self, nums: list[int]) -> int:

        mem = [-1] * len(nums)
        def jump(index, nums, mem):
            if index > len(nums) - 1:
                return sys.maxsize
            if index == len(nums) - 1:
                return 0

            if mem[index] != -1:
                return mem[index]

            ans = sys.maxsize
            for i in range(1, nums[index] + 1):
                ans = min(ans, 1 + jump(index + i, nums, mem))

            mem[index] = ans
            return ans

        return jump(0, nums, mem)

#TLE
class Solution:
    #TLE
    def jump(self, nums: list[int]) -> int:

        mem = {}
        def jump(index, nums, count, mem):
            if index > len(nums) - 1:
                return sys.maxsize
            if index == len(nums) - 1:
                return count

            if index in mem:
                if count in mem[index]:
                    return mem[index][count]

            ans = sys.maxsize
            for i in range(1, nums[index] + 1):
                ans = min(ans, jump(index + i, nums, count + 1, mem))

            mem[index] = {}
            mem[index][count] = ans
            return ans

        return jump(0, nums, 0, mem)

solution = Solution2()
print(solution.jump([2,3,1,1,4]))
print(solution.jump([2,3,0,1,4]))
print(solution.jump([2,1]))
print(solution.jump([1,2,1,1,1]))
