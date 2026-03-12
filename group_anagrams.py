class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        ans_dict = {}
        for str in strs:
            sorted_str = "".join(sorted(str))
            ans_dict.setdefault(sorted_str, [])
            ans_dict[sorted_str].append(str)

        return list(ans_dict.values())

solution = Solution()
print(solution.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))



