/*
"And scars are souvenirs you never lose"
- Name, The Goo Goo dolls
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;

        int top = 0;
        int bottom = height-1;

        int idxToSearch = 0;

        while(top <= bottom){
            int mid = top + (bottom - top)/2;
            
            if(matrix[mid][0] == target)
                return true;
            //see if we can bSearch in this index
            if(matrix[mid][0] < target){
                if(mid < height-1 && target < matrix[mid+1][0]){
                    idxToSearch = mid;
                    break;
                }
                if(mid == height-1 && target <= matrix[mid][width-1]){
                    idxToSearch = mid;
                    break;
                }
            }
            
            if(matrix[mid][0] < target){
                top = mid+1;
            }
            else{
                bottom = mid-1;
            }
        }

        int left = 0;
        int right = width-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(matrix[idxToSearch][mid] == target)
                return true;
            
            if(matrix[idxToSearch][mid] < target)
                left = mid+1;
            else
                right = mid-1;

        }
        return false;
    }
}
