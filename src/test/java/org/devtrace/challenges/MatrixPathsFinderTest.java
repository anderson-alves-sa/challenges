package org.devtrace.challenges;

import org.junit.Assert;
import org.junit.Test;

public class MatrixPathsFinderTest {

    final int[][] matrix =
            {
                    {1, 1, 1, 1},
                    {1, 1, 0, 1},
                    {0, 1, 0, 1},
                    {1, 1, 1, 1}
            };

    @Test
    public void countAllPaths() throws InterruptedException {
        final int[] startAndEndPoints = {0, 0, 3, 3};
        final int pathsCount = MatrixPathsFinder.countAllUniquePaths(matrix, startAndEndPoints);

        Assert.assertEquals(4, pathsCount);
    }


}
