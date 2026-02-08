import sys

class Solution:
    def search(self, nums: list[int], target: int) -> int:

        def local_min(nums, start, end):
            while start <= end:
                mid = int(start + (end - start) / 2)
                l = sys.maxsize if mid == start else nums[mid - 1]
                r = sys.maxsize if mid == end else nums[mid + 1]

                if l > nums[mid] < r:
                    return mid

                if l < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            return -1

        lm1 = local_min(nums, 0, int(len(nums) / 2))
        lm2 = local_min(nums, int(len(nums) / 2), len(nums) - 1)
        print(min(nums[lm1], nums[lm2]))

solution = Solution()
# print(solution.search([0,1,2,3], 3))
# print(solution.search([1,2,3,0], 3))
# print(solution.search([3,0,1,2], 3))
# print(solution.search([6,7,0,1,2,3,4,5], 7))
solution.search([2,3,4,5,1], 1)




