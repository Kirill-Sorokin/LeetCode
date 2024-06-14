func surfaceArea(grid [][]int) int {
    n := len(grid)
    area := 0

    for i := 0; i < n; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] > 0 {
                // Add top and bottom faces
                area += 2
                
                // Add front face
                if i == 0 {
                    area += grid[i][j]
                } else {
                    area += max(0, grid[i][j] - grid[i-1][j])
                }
                
                // Add back face
                if i == n-1 {
                    area += grid[i][j]
                } else {
                    area += max(0, grid[i][j] - grid[i+1][j])
                }
                
                // Add left face
                if j == 0 {
                    area += grid[i][j]
                } else {
                    area += max(0, grid[i][j] - grid[i][j-1])
                }
                
                // Add right face
                if j == n-1 {
                    area += grid[i][j]
                } else {
                    area += max(0, grid[i][j] - grid[i][j+1])
                }
            }
        }
    }
    
    return area
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
