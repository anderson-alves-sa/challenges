package org.devtrace.challenges;

public class MatrixPathsFinder {

    final static int DIMENSION = 4;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String RESET = "\033[0m";

    static int endPointX, endPointY;

    public static int countAllUniquePaths(final int[][] matrix, final int[] startAndEnd) throws InterruptedException {

        final boolean[][] visited = new boolean[DIMENSION][DIMENSION];
        final int limit = DIMENSION - 1;
        endPointX = startAndEnd[2];
        endPointY = startAndEnd[3];
        int pathsCount = 0;

        return countMatrixPaths(matrix, visited, startAndEnd[0], startAndEnd[1], pathsCount, limit);

    }

    /**
     * {1, 1, 1, 1},
     * {1, 1, 0, 1},
     * {0, 1, 0, 1},
     * {1, 1, 1, 1}};
     */

    private static int countMatrixPaths(int[][] matrix, boolean[][] visited, int x, int y, int pathsCount, int limit) throws InterruptedException {


        if (x == endPointX && y == endPointY) {
            pathsCount++;
            return pathsCount;
        }

        visited[x][y] = true;

        printMatrix(matrix, x, y);
        printMatrix(visited);
        System.out.println(pathsCount);
        System.out.println("--------");

        if (isValid(x, y, limit) && matrix[x][y] == 1) {
            // down
            if (x + 1 < DIMENSION && !visited[x + 1][y]) {
                pathsCount = countMatrixPaths(matrix, visited, x + 1, y, pathsCount, limit);
            }
            // up
            if (x - 1 >= 0 && !visited[x - 1][y]) {
                pathsCount = countMatrixPaths(matrix, visited, x - 1, y, pathsCount, limit);
            }
            // left
            if (y + 1 < DIMENSION && !visited[x][y + 1]) {
                pathsCount = countMatrixPaths(matrix, visited, x, y + 1, pathsCount, limit);
            }
            //right
            if (y - 1 >= 0 && !visited[x][y - 1]) {
                pathsCount = countMatrixPaths(matrix, visited, x, y - 1, pathsCount, limit);
            }

        }

        visited[x][y] = false;

        printMatrix(visited);
        System.out.println("backtracking");

        return pathsCount;
    }

    private static void printMatrix(final int[][] matrix, final int x, final int y) {

        for (int i = 0; i < matrix.length; i++) {
            String rowPrint = "";
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == x && j == y){
                    rowPrint = rowPrint.concat(ANSI_RED + matrix[i][j] + RESET + "     ");
                } else {
                    rowPrint = rowPrint.concat(matrix[i][j] + "     ");
                }
            }
            System.out.println(rowPrint);
        }
        System.out.println("--------");
    }

    private static void printMatrix(final boolean[][] matrix) {

        for (boolean[] rows : matrix) {
            String rowPrint = "";
            for (boolean cell : rows) {
                if(cell) {
                    rowPrint = rowPrint.concat(ANSI_RED + cell + RESET + "  ");
                } else
                    rowPrint = rowPrint.concat(cell + " ");
            }
            System.out.println(rowPrint);
        }
        System.out.println("--------");
    }

    private static boolean isValid(final int x, final int y, final int limit) {
        return !(x < 0 || y < 0 || x > limit || y > limit);
    }


}
