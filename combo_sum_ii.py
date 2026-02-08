class Solution:
    def combinationSum2(self, candidates: list[int], target: int) -> list[list[int]]:
        candidates.sort()
        def comboSum2(candidates, index, curTarget, target, curAns, ans):
            if curTarget == target:
                ans.append(curAns.copy())
                return
            if index > len(candidates) - 1:
                return
            if curTarget > target:
                return

            last = -1
            for i in range(index, len(candidates)):
                if candidates[i] == last:
                    continue
                last = candidates[i]
                curAns.append(candidates[i])
                comboSum2(candidates, i + 1, curTarget + candidates[i], target, curAns, ans)
                curAns.pop()

        ans = []
        comboSum2(candidates, 0, 0, target, [], ans)
        return ans


solution = Solution()
print(solution.combinationSum2([10,1,2,7,6,1,5], 8))
# print(solution.combinationSum2(
#     [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1], 30))