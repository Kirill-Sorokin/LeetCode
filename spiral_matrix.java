import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traverse Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> spiral = sol.spiralOrder(matrix);
        for (int num : spiral) {
            System.out.print(num + " ");
        }
    }
}
