package com.vladaver87.multithreaded_matrix_mult;

public class SimpleMatrixMultiply implements IMultiply {

	public int[][] multiply(int[][] matrix1, int[][] matrix2) {
		int rowCount = matrix1.length;
		int colCount = matrix2[0].length;
		final int sumLength = matrix2.length;
		int[][] result = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				for (int k = 0; k < sumLength; k++) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];

				}
			}
		}
		return result;
	}

}
