class Solution:
    #O(n^target) where n = len(candidates), O(1)
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []

        def combo_sum(index, candidates, cur_ans, sum, target):
            if sum == target:
                ans.append(cur_ans.copy())
                return
            if sum > target:
                return
            if index > len(candidates) - 1:
                return
            cur_ans.append(candidates[index])
            combo_sum(index, candidates, cur_ans, sum + candidates[index], target)
            cur_ans.pop()
            combo_sum(index + 1, candidates, cur_ans, sum, target)

        combo_sum(0, candidates, [], 0, target)

        return ans
