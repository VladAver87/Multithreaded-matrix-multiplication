package com.vladaver87.multithreaded_matrix_mult;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Matrix m1 = new Matrix(2, 2);
		Matrix m2 = new Matrix(2, 2);
		SimpleMatrixMultiply simpleMatrixMultiply = new SimpleMatrixMultiply();
		ParallelMatrixMultiply parallelMatrixMultiply = new ParallelMatrixMultiply();
		Matrix.printMatrix(simpleMatrixMultiply.multiply(m1, m2));
		System.out.println(" ");
		Matrix.printMatrix(parallelMatrixMultiply.multiply(m1, m2));
	}

}
