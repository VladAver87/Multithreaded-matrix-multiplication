package com.vladaver87.multithreaded_matrix_mult;

public class MultiplyJob implements Runnable{

	private int[][] result;
	private final Matrix matrix1;
	private final Matrix matrix2;
	private int firstIndex;
	private int lastIndex;
	
	public MultiplyJob(Matrix matrix1, Matrix matrix2, int firstIndex, int lastIndex, int[][] result) {
		this.result = result;
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
	}

	
	private void sum(int i, int j) {
			for (int k = 0; k < result.length; k++) {
				result[i][j] += matrix1.getElement(i, k) * matrix2.getElement(k, j);				
			}	
	}
	
	public void run() {
		for (int index = firstIndex; index < lastIndex; ++index) {
			sum(index, index);
		}
	}

}
