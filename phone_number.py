class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        digit_to_alpha = {
            2: ["a", "b", "c"],
            3: ["d", "e", "f"],
            4: ["g", "h", "i"],
            5: ["j", "k", "l"],
            6: ["m", "n", "o"],
            7: ["p", "q", "r", "s"],
            8: ["t", "u", "v"],
            9: ["w", "x", "y", "z"],
        }
        ans = []
        def calc_combos(digits, digit_to_alpha, index, cur):
            if index > len(digits) - 1:
                ans.append(cur)
                return
            digit = digits[index]
            for alpha in digit_to_alpha[int(digit)]:
                cur += alpha
                calc_combos(digits, digit_to_alpha, index + 1, cur)
                cur = cur[:-1]
        calc_combos(digits, digit_to_alpha, 0, "")
        return ans

solution = Solution()
print(solution.letterCombinations("23"))
