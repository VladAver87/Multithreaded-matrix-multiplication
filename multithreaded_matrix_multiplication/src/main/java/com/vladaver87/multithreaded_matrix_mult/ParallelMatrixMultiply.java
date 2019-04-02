package com.vladaver87.multithreaded_matrix_mult;

public class ParallelMatrixMultiply implements Runnable, IMultiply{
	private final int[][] resultArr;
	private final Matrix matrix1;
	private final Matrix matrix2;
	
	public ParallelMatrixMultiply(Matrix matrix1, Matrix matrix2) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		resultArr = new int[matrix1.getRow()][matrix2.getCol()];
	}
	

	public Matrix multiply(Matrix matrix1, Matrix matrix2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void run() {
		resultArr[i][j] += matrix1.getElement(i, k) * matrix2.getElement(k, j);
		
	}

}
