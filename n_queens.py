class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        def solve(i, j, n, rows, cols, diag, ant_diag, n_queens, board, ans):
            if n_queens == n:
                ans.append(board.copy())
                return

            for row in range(i, n):
                for col in range(j, n):
                    d = row - col
                    a = row + col
                    if row in rows:
                        continue
                    if col in cols:
                        continue
                    if d in diag:
                        continue
                    if a in ant_diag:
                        continue

                    board[row] = board[row][:col] + "Q" + board[row][col + 1:]
                    rows.add(row)
                    cols.add(col)
                    diag.add(d)
                    ant_diag.add(a)
                    solve(row + 1, 0, n, rows, cols, diag, ant_diag, n_queens + 1, board, ans)
                    rows.discard(row)
                    cols.discard(col)
                    diag.discard(d)
                    ant_diag.discard(a)
                    board[row] = board[row][:col] + "." + board[row][col + 1:]

        board = ["." * n for _ in range(n)]
        rows = set()
        cols = set()
        diag = set()
        anti_diag = set()

        ans = []
        solve(0, 0, n, rows, cols, diag, anti_diag, 0, board, ans)
        return ans

solution = Solution()
print(solution.solveNQueens(1))
print(solution.solveNQueens(2))
print(solution.solveNQueens(4))
print(solution.solveNQueens(9))