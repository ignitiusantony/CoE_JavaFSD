package FirstWeek;

import java.util.ArrayList;
import java.util.List;

public class Tenth {
    private static class MultiplicationWorker implements Runnable {
        private final int[][] matrixA;
        private final int[][] matrixB;
        private final int[][] result;
        private final int startRow;
        private final int endRow;

        public MultiplicationWorker(int[][] matrixA, int[][] matrixB, int[][] result, 
                                  int startRow, int endRow) {
            this.matrixA = matrixA;
            this.matrixB = matrixB;
            this.result = result;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        public void run() {
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < matrixB[0].length; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < matrixB.length; k++) {
                        result[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) throws InterruptedException {
        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication");
        }

        int rows = matrixA.length;
        int cols = matrixB[0].length;
        int[][] result = new int[rows][cols];

        int numThreads = Math.min(Runtime.getRuntime().availableProcessors(), rows);
        int rowsPerThread = Math.max(1, rows / numThreads);
        
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            int startRow = i * rowsPerThread;
            int endRow = (i == numThreads - 1) ? rows : (i + 1) * rowsPerThread;

            MultiplicationWorker worker = new MultiplicationWorker(matrixA, matrixB, result, 
                                                                startRow, endRow);
            Thread thread = new Thread(worker);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        try {
            int[][] matrixA = {{1, 2}, {3, 4}};
            int[][] matrixB = {{2, 0}, {1, 2}};

            System.out.println("Matrix A:");
            printMatrix(matrixA);
            System.out.println("\nMatrix B:");
            printMatrix(matrixB);

            int[][] result = multiplyMatrices(matrixA, matrixB);

            System.out.println("\nResult Matrix:");
            printMatrix(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}