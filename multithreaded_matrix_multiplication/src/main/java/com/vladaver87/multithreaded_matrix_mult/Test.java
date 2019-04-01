package com.vladaver87.multithreaded_matrix_mult;

public class Test {

	public static void main(String[] args) {
		Matrix m1 = Matrix.createNewMatrix(2, 2);
		Matrix m2 = Matrix.createNewMatrix(2, 2);
		SimpleMatrixMultiply simpleMatrixMultiply = new SimpleMatrixMultiply();

		Matrix.printMatrix(simpleMatrixMultiply.multiply(m1, m2));
	}

}
