import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.HashMap;
class Result {
    public static int connectedCell(int[][] matrix) {
        
        int maximum = 0;

        for (int cell_i = 0; cell_i < matrix.length; cell_i++) {
            for (int cell_j = 0; cell_j <  matrix[0].length; cell_j++) {
                if(matrix[cell_i][cell_j] == 0 || matrix[cell_i][cell_j] == 2)
                    continue;
                HashMap<String,String> region = new HashMap<String,String>();
                region = getRegion(matrix,cell_i,cell_j,region);
                maximum = Math.max(maximum, region.size());
            }
        }
        return  maximum;

    }


   public static HashMap<String,String> getRegion(int[][] matrix, int row, int column,  HashMap<String,String> region)   {

        if(row > matrix.length-1 || row <0 )
            return region;

        if(column > matrix[0].length-1 || column <0 )
            return region;

        if(matrix[row][column] == 0 || matrix[row][column] == 2)
            return region;

        region.put(String.format("%d%d",row,column),"");
        matrix[row][column] = 2;

        region = getRegion(matrix,row,column+1,region);
        region = getRegion(matrix,row,column-1,region);
        region = getRegion(matrix,row+1,column,region);
        region = getRegion(matrix,row-1,column,region);
        region = getRegion(matrix,row+1,column+1,region);
        region = getRegion(matrix,row+1,column-1,region);
        region = getRegion(matrix,row-1,column+1,region);
        region = getRegion(matrix,row-1,column-1,region);

        return region;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        //fill the matrix from console input
        int n = scan.nextInt();
        int m = scan.nextInt();
        int matrix[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                matrix[grid_i][grid_j] = scan.nextInt();
            }
        }
        scan.close();

        int result = Result.connectedCell(matrix);

        System.out.println(result);
    }
}
