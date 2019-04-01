package com.vladaver87.multithreaded_matrix_mult;

public class SimpleMatrixMultiply implements IMultiply {

	public Matrix multiply(Matrix matrix1, Matrix matrix2) {
		int rowCount = matrix1.getData().length;
		int colCount = matrix2.getData()[0].length;
		final int sumLength = matrix2.getData().length;
		Matrix result = Matrix.createNewMatrix(rowCount, colCount);
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				for (int k = 0; k < sumLength; k++) {
					result.getData()[i][j] += matrix1.getData()[i][k] * matrix2.getData()[k][j];

				}
			}
		}
		return result;
	}

}
