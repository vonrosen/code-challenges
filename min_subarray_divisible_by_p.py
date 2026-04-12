#[2,2,1,1,1], p = 3, ans = 2
#[2,1], p = 3, ans = 2

class Solution:
    def min_by_p(self, nums, p):
        ans = float('inf')
        map = { 0: -1 }
        prefix = 0
        for i in range(len(nums)):
            n = nums[i]
            prefix += n
            rem = prefix % p
            if rem in map:
                last_index = map[rem]
                ans = min(i - last_index, ans)
            map[rem] = i
        if ans == float('inf'):
            return -1
        return ans

solution = Solution()
print(solution.min_by_p([2,2,1,1,1], 3))
print(solution.min_by_p([2,1], 3))
print(solution.min_by_p([3], 3))