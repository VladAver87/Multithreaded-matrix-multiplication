package com.vladaver87.multithreaded_matrix_mult;

public class SimpleMatrixMultiply implements IMultiply {

	public Matrix multiply(Matrix matrix1, Matrix matrix2) {
		int rowCount = matrix1.getRow();
		int colCount = matrix2.getCol();
		if (rowCount != colCount) throw new RuntimeException("Multiply is not avalable");
		final int [][]resultArr = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				for (int k = 0; k < matrix1.getCol(); k++) {
					resultArr[i][j] += matrix1.getElement(i, k) * matrix2.getElement(k, j);

				}
			}
		}
		Matrix result = new Matrix(resultArr);
		return result;
	}
	
}
