class Solution:
    def rotate(self, matrix: list[list[int]]) -> None:
        length = len(matrix)
        r, c, nr, nc = 0, 0, 0, 0
        while length > 1:
            c = r
            top = r
            bottom = r + length - 1
            left = c
            right = c + length - 1
            for i in range(length - 1):
                #top to right
                tmp = matrix[r][c]
                nr = top + i
                nc = right
                tmp1 = matrix[nr][nc]
                matrix[nr][nc] = tmp
                # right to bottom
                nc = right - i
                nr = bottom
                tmp2 = matrix[nr][nc]
                matrix[nr][nc] = tmp1
                # bottom to left
                nr = bottom - i
                nc = left
                tmp3 = matrix[nr][nc]
                matrix[nr][nc] = tmp2
                # left to top
                nc = left + i
                nr = top
                matrix[nr][nc] = tmp3
                c += 1
            r += 1

            length -= 2

        print('done')

solution = Solution()
solution.rotate([[1,2,3],[4,5,6],[7,8,9]])
solution.rotate([[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]])
