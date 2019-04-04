package com.vladaver87.multithreaded_matrix_mult;

public class MultiplyJob implements Runnable{

	private int[][] resultArr;
	private final Matrix matrix1;
	private final Matrix matrix2;
	private int startIndex;
	private int endIndex;
	
	public MultiplyJob(Matrix matrix1, Matrix matrix2, int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		resultArr = new int[matrix1.getRow()][matrix2.getCol()];
	}

	public int[][] getResultArr() {
		return resultArr;
	}

	
	public void run() {
		for (int k = 0; k < resultArr.length; k++) {
			resultArr[startIndex][endIndex] += matrix1.getElement(startIndex, k) * matrix2.getElement(k, endIndex);				
		}	
	}

}
