# Input: nums = [90,7,3], p = 3, rem = 1
#               [90,97,100]
#               [90,97,100]

# Input: nums = [3,1,4,2], p = 6 rem = 4
                    #8
# Input: nums = [3,1,8,2], p = 6 rem = 4
                    #12
# Output: 1
# what remainder do i need at 2, 6 - 2 = 4
# prefix sum is 4 what remainder do i need to make it divisible by 6
#4 + 2 = 6, (4 - 6) = 2
#10 + 2 = 12, (10 - 6) = 4
#16 + 2 = 18, (16 - 6) = 10

#bad solution O(n^2)
class Solution3:
    def minSubarray(self, nums: list[int], p: int) -> int:
        total = 0
        for i in range(len(nums)):
            total += nums[i]

        if total % p == 0:
            return 0

        ans = 1000000000000
        for i in range(len(nums)):
            s = 0
            if i == 0:
                end = len(nums) - 1
            else:
                end = len(nums)
            for k in range(i, end):
                s += nums[k]
                if (total - s) % p == 0:
                    ans = min(ans, k - i + 1)

        if ans == 1000000000000:
            return -1

        return ans

#bad solution. doesn't account for subarrays
class Solution2:
    ans = 0
    def minSubarray(self, nums: list[int], p: int) -> int:
        def findMax(i, s, l, nums, p):
            if s % p == 0 and s > 0:
                self.ans = max(self.ans, l)

            if i > len(nums) - 1:
                return

            findMax(i + 1, s + nums[i], l + 1, nums, p)
            findMax(i + 1, s, l, nums, p)

        findMax(0, 0, 0, nums, p)

        if self.ans == 0:
            return -1
        else:
            return len(nums) - self.ans

# Input: nums = [90,7,3], p = 3, rem = 1
#               [90,97,100]
#               [0,1,1] = moduluses of p of prefix sums

# S = sum array
# sub = sum subarray
# (S - sub) % p == 0
# S % p == sub % p
# remainder == sub % p
# what do we need when we are on an element with prefix sum % mod to find if
# a subarray sum % p exists that is equal to remainder?
# we need a previous prefix sum % mod which is equals to (prefix sum - remainder) % p
import sys
class Solution:
    def minSubarray(self, nums: list[int], p: int) -> int:
        total = 0
        for i in range(len(nums)):
            total += nums[i]
        rem = total % p
        if rem == 0:
            return 0
        prefix_sums = { 0 : -1 }
        prefix_sum = 0
        ans = len(nums)
        for i in range(len(nums)):
            num = nums[i]
            prefix_sum += num
            target = (((prefix_sum % p) - rem) + p) % p
            if target in prefix_sums:
                last_index = prefix_sums[target]
                ans = min(ans, i - last_index)
            prefix_sums[prefix_sum % p] = i

        if ans == len(nums):
            return -1
        else:
            return ans

solution = Solution()
print(solution.minSubarray([26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3], 26))
print(solution.minSubarray([1,2,3], 7))
print(solution.minSubarray([12,7,16,4,4,13,13,8], 61))
print(solution.minSubarray([3,6,8,1], 8))
print(solution.minSubarray([3,1,4,2], 6))
print(solution.minSubarray([1,2,3], 3))
print(solution.minSubarray([6,3,5,2], 9))
