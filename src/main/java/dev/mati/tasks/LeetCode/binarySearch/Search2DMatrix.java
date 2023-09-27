package dev.mati.tasks.LeetCode.binarySearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] arr2d = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(arr2d,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        //first find the rigth (there is a chance of occurance the target) row in m steps, where m = matrix.length
        //then binary search in given row
        int top = 0;
        int bottom = matrix.length - 1;
        while(top <= bottom) {
            int m = (top + bottom) / 2;
            int s = matrix[m][0];
            int e = matrix[m][matrix[m].length - 1];
            if(target >= s && target <= e)
                return binarySearch(matrix[m],target);
            else if (target < s)
                bottom = m - 1;
            else
                top = m + 1;
        }
        return false;
    }
    public static boolean binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while(s <= e) {
            int m = (s + e) / 2;
            if(arr[m] == target)
                return true;
            else if (arr[m] < target) {
                s = m + 1;
            } else
                e = m - 1;
        }
        return false;
    }

    public static boolean searchMatrixEachRow(int[][] matrix, int target) {
        boolean found = false;
        int i = 0;
        while(i < matrix.length) {
            found = isTargetInRow(matrix[i],target);
            if(found == true)
                return true;
            i++;
        }
        return false;
    }
    public static boolean isTargetInRow(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        if(arr[s] > target || arr[e] < target)
            return false;
        return binarySearch(arr,target);
    }
}
