from collections import deque

class Solution2:
    #times out n1 = len(num1), n2 = len(num2), n3 = len("1010" ^ max(len(n1, n2))
    # O((n1 * n3) + (n2 * n3)) + (n1 * n2) = timeout
    def multiply(self, num1: str, num2: str) -> str:
        bins = {
            "0": "0",
            "1": "1",
            "2": "10",
            "3": "11",
            "4": "100",
            "5": "101",
            "6": "110",
            "7": "111",
            "8": "1000",
            "9": "1001",
            "10": "1010"
        }

        #5623
        def convert_to_bin(num):
            bin = "0"
            mult = "1"
            for i in range(len(num) - 1, -1, -1):
                c = num[i]
                bin_c = bins[c]
                bin = bin_add(bin, bin_mult(bin_c, mult))
                mult = bin_mult(mult, "1010")
            return bin

        # 10
        # 11
        #  10
        # 100
        def bin_mult(n1, n2):
            l = deque()
            mult = 0
            for i in range(len(n2) - 1, -1, -1):
                if n2[i] == "0":
                    l.append(("0" * len(n1)) + ("0" * mult))
                else:
                    l.append(n1 + ("0" * mult))
                mult += 1
            ans = "0"
            while len(l) > 0:
                bin = l.popleft()
                ans = bin_add(ans, bin)
            return ans

        def bin_add(first, second):
            length = max(len(first), len(second))
            ans = ""
            carry = False
            for i in range(length - 1, -1, -1):
                if len(first) > 0:
                    char_first = first[-1]
                    first = first[:-1]
                else:
                    char_first = "0"
                if len(second) > 0:
                    char_second = second[-1]
                    second = second[:-1]
                else:
                    char_second = "0"

                if char_first == "0" and char_second == "0":
                    if carry:
                        ans = "1" + ans
                        carry = False
                    else:
                        ans = "0" + ans
                elif char_first == "0":
                    if carry:
                        ans = "0" + ans
                    else:
                        ans = "1" + ans
                elif char_first == "1" and char_second == "1":
                    if carry:
                        ans = "1" + ans
                    else:
                        ans = "0" + ans
                        carry = True
                else: #same as char_first == "0"
                    if carry:
                        ans = "0" + ans
                    else:
                        ans = "1" + ans

            if carry:
                ans = "1" + ans
            return ans

        def convert_to_num(num):
            ans = 0
            exp = 0
            for i in range(len(num) - 1, -1, -1):
                c = num[i]
                if c == "0":
                    ans += pow(2, exp) * 0
                else:
                    ans += pow(2, exp) * 1
                exp += 1
            return str(ans)

        bin1 = convert_to_bin(num1)
        bin2 = convert_to_bin(num2)
        bin_prod = bin_mult(bin1, bin2)

        return convert_to_num(bin_prod)

solution = Solution2()
print(solution.multiply("2", "3"))
print(solution.multiply("123", "3"))
print(solution.multiply("123", "456"))