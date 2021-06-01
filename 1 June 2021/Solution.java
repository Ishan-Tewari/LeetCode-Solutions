class Solution {

    int[][] visited;

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        visited = new int[m][n];

        int maxArea = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1 && visited[i][j] == 0){
                    int area = 0;
                    maxArea = Math.max(dfs(grid,i,j,area), maxArea);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, int area){
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) return area;
        if (visited[i][j] == 1 || grid[i][j] == 0) return area;

        visited[i][j] = 1;
        area++;

        int[] iIter = {-1,1,0,0};
        int[] jIter = {0,0,-1,1};

        for (int k = 0; k < iIter.length; k++){
            area = dfs(grid, i + iIter[k], j + jIter[k], area);
        }

        return area;
    }
}
