package com.vladaver87.multithreaded_matrix_mult;

public class Test {

	public static void main(String[] args) {
		Matrix m1 = new Matrix(2,2);
		Matrix m2 = new Matrix(2,2);
		Matrix result = new Matrix(2,2);
		SimpleMatrixMultiply simpleMatrixMultiply = new SimpleMatrixMultiply();
		m1.printMatrix(m1.fillNewMatrix());
		System.out.println("-----------------");
		m2.printMatrix(m2.fillNewMatrix());
		System.out.println("-----------------");
		result.printMatrix(simpleMatrixMultiply.multiply(m1.fillNewMatrix(), m2.fillNewMatrix()));
	}

}
