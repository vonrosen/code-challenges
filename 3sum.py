#Input: nums = [-1,0,1,2,-1,-4]
#Output: [[-1,-1,2],[-1,0,1]]

# [-4,-1,-1,0,1,2]

#O(n^2), O(1)
#optimizations:
# - break if nums[i] > 0
# - skip dupes when iterating nums
# - skip dupes when finding a match and incrementing start and decrementing high such that start is
# - positioned at the next element that is not equal to the value where start was a match
class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:

        def twoSum(start, end, nums, target):
            ans = []

            if end - start + 1 < 2:
                return ans

            while start < end:
                sum = nums[start] + nums[end]
                if sum < target:
                    start += 1
                elif sum > target:
                    end -= 1
                else:
                    ans.append([nums[start], nums[end]])
                    start += 1
                    end -= 1
                    while start < end and nums[start] == nums[start - 1]:
                        start += 1

            return ans

        ans = []
        nums.sort()
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            if nums[i] > 0:
                return ans
            target = -nums[i]
            twos = twoSum(i + 1, len(nums) - 1, nums, target)
            if len(twos) > 0:
                for two in twos:
                    ans.append([nums[i], two[0], two[1]])

        return ans


solution = Solution()
print(solution.threeSum([-1,0,1,2,-1,-4]))
print(solution.threeSum([0,0,0,0]))
print(solution.threeSum([-2,0,1,1,2]))
