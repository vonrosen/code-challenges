	package org.hunter;

	class numberofislands {

		public int numIslands(char[][] grid) {
			int ans = 0;
			for(int row = 0; row < grid.length; ++row){
				for(int col = 0; col < grid[row].length; ++col){
					ans += dfs(grid, row, col);
				}
			}
			return ans;
		}

		int [][] dirs = new int[][]{
				{-1, 0},
				{0, 1},
				{1, 0},
				{0, -1}
		};

		int dfs(char [][] grid, int row, int col){
			if(!valid(grid, row, col)){
				return 0;
			}
			grid[row][col] = '2';
			for(int [] dir : dirs){
				dfs(grid, row + dir[0], col + dir[1]);
			}
			return 1;
		}

		boolean valid(char [][] grid, int row, int col){
			if(row < 0 || row > grid.length - 1){
				return false;
			}
			if(col < 0 || col > grid[row].length - 1){
				return false;
			}
			if(grid[row][col] == '0'){
				return false;
			}
			if(grid[row][col] == '2'){
				return false;
			}
			return true;
		}
	}
