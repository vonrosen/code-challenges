class Solution:
    def search(self, nums: list[int], target: int) -> int:

        def find_pivot(nums):
            left = 0
            right = len(nums) - 1
            while left <= right:
                mid = int(left + (right - left) / 2)
                mid_value = nums[mid]

                if mid > 0 and mid < len(nums) - 1 and nums[mid - 1] > mid_value < nums[mid + 1]:
                    return mid

                if mid_value > nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            return left

        def bin_search(nums, target, start, end):
            while start <= end:
                mid = int(start + (end - start) / 2)
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1

        pivot = find_pivot(nums)
        if pivot == 0:
            return bin_search(nums,target, 0, len(nums) - 1)
        else:
            s1 = bin_search(nums, target, 0, pivot - 1)
            s2 = bin_search(nums, target, pivot, len(nums) - 1)
            return max(s1, s2)