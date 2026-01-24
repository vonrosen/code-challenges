#Input: nums = [-1,0,1,2,-1,-4]
#Output: [[-1,-1,2],[-1,0,1]]

# [-4,-1,-1,0,1,2]

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

            return ans

        ans = []
        dedupe = set()
        nums.sort()
        for i in range(len(nums)):
            target = -nums[i]
            twos = twoSum(i + 1, len(nums) - 1, nums, target)
            if len(twos) > 0:
                for two in twos:
                    two_tuple = (nums[i], two[0], two[1])
                    if two_tuple not in dedupe:
                        ans.append([nums[i], two[0], two[1]])
                        dedupe.add(two_tuple)

        return ans

solution = Solution()
print(solution.threeSum([-1,0,1,2,-1,-4]))
print(solution.threeSum([0,0,0,0]))
print(solution.threeSum([-2,0,1,1,2]))
