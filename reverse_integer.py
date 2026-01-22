class Solution:
    def reverse(self, x: int) -> int:
        max_int = ((2 ** 32) / 2) - 1
        min_int = -((2 ** 32) / 2)

        s_value = str(x)
        is_neg = False
        if s_value[0:1] == "-":
            s_value = s_value.replace("-", "")
            is_neg = True

        s_value = "".join(reversed(s_value))
        i_value = int(s_value)
        if is_neg:
            i_value = -i_value

        if i_value < min_int or i_value > max_int:
            return 0

        return i_value