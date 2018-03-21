package test.liuwangfang.com.reviewproject.datastructure;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 查找问题－－－找出突破点，缩小查找范围
 * 思路：
 * <p>
 * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束。
 * <p>
 * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
 * <p>
 * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
 */

class ArrayTest {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        boolean include = includeNum(array, 11);
        System.out.println("includeNum 11===" + include);
        include = includeNum(array, 14);
        System.out.println("includeNum 14===" + include);

        include = includeNum2(array, 0, array[0].length - 1, 11);
        System.out.println("includeNum 11===" + include);
        include = includeNum2(array, 0, array[0].length - 1, 14);
        System.out.println("includeNum 14===" + include);
    }

    public static boolean includeNum(int[][] array, int num) {
        System.out.println("includeNum time  start===" + System.currentTimeMillis());
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                int number = array[i][j];
                if (number == num) {
                    return true;
                }
            }
        }
        System.out.println("includeNum time  finish===" + System.currentTimeMillis());
        return false;
    }

    /**
     * 递归实现
     * 自己写的 所有的递归都可以用循环来实现  for循环是确定index是递减的 while的循环是index是在一定条件下变化
     */
    public static boolean includeNum2(int[][] array, int row, int colume, int num) {
        System.out.println("includeNum2 time  111===" + System.currentTimeMillis());
        if (row >= array.length || colume < 0) {
            return false;
        }
        if (num == array[row][colume]) {
            return true;
        } else if (num < array[row][colume]) {
            colume--;
            return includeNum2(array, row, colume, num);
        } else {
            row++;
            return includeNum2(array, row, colume, num);
        }
    }

    /**
     * while循环
     **/
    public static boolean find(int[][] matrix, int number) {

        // 输入条件判断  
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length; // 数组的行数  
        int cols = matrix[1].length; // 数组行的列数  

        int row = 0; // 起始开始的行号  
        int col = cols - 1; // 起始开始的列号  

        // 要查找的位置确保在数组之内  
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (matrix[row][col] == number) { // 如果找到了就直接退出  
                return true;
            } else if (matrix[row][col] > number) { // 如果找到的数比要找的数大，说明要找的数在当前数的左边  
                col--; // 列数减一，代表向左移动  
            } else { // 如果找到的数比要找的数小，说明要找的数在当前数的下边  
                row++; // 行数加一，代表向下移动  
            }
        }

        return false;
    }
}