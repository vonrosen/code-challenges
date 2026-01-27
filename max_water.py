
# 2 1 1000 1001 1 2 -> 1000
# 8,7,2,1
#O(n), O(1)
#insight: using 2 pointers you start calculating based on the heights that are the greatest distance apart (have the greatest width)
#using left and right pointers
#once you calculate that initial area you can start moving your 2 pointers inwards but you must move them to
#a height which could possibly generate a greater area. the only height that could do that is one that is greater
#than the min height of the 2 pointers. see if the min height of the 2 pointers is the left or the right then start
#moving inwards from either the left or the right based on whether left has the min or right has the min. once you find
#a height greater than min from getting to an index with a bigger height then calc the area again and update your ans
#then repeat the algorithm with a new min value and a new determination of whether to start moving inward
#from either the left or the right of your current position
class Solution:
    def maxArea(self, height: list[int]) -> int:
        ans = 0
        left = 0
        right = len(height) - 1
        while left < right:
            min_right = False
            min_left = False
            min_value = min(height[right], height[left])
            if min_value == height[right]:
                min_right = True
            if min_value == height[left]:
                min_left = True
            ans = max(ans, (right - left) * min_value)
            if min_left:
                tmp_left = left + 1
                while tmp_left < len(height) and height[tmp_left] <= min_value:
                    tmp_left += 1
                left = tmp_left
            if min_right:
                tmp_right = right - 1
                while tmp_right >= 0 and height[tmp_right] <= min_value:
                    tmp_right -= 1
                right = tmp_right

        return ans

solution = Solution()
#this example means that the solution may not be using the highest height!
print(solution.maxArea([1,2,1]))
print(solution.maxArea([1,8,6,2,5,4,8,3,7]))
print(solution.maxArea([1,1]))
print(solution.maxArea([2,1,1000,1001,1,2]))
