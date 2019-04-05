package com.vladaver87.multithreaded_matrix_mult;

public class ParallelMatrixMultiply implements IMultiply{

	

	public Matrix multiply(Matrix matrix1, Matrix matrix2) throws InterruptedException {
		int rowCount = matrix1.getRow();
		int colCount = matrix2.getCol();
		final int[][] result = new int[rowCount][colCount];
		if (rowCount != colCount) throw new RuntimeException("Multiply is not avalable");
		Thread[][] threads = new Thread[matrix1.getRow()][matrix2.getCol()];
			for (int i = 0; i < threads.length; i++) {
				for (int j = 0; j < threads[0].length; j++) {
				threads[i][j] = new Thread(new MultiplyJob(matrix1, matrix2, i, j , result));
				threads[i][j].start();	
				threads[i][j].join();
				}
			}
			
			
		return new Matrix(result);
	}	

}
