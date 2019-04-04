package com.vladaver87.multithreaded_matrix_mult;

public class ParallelMatrixMultiply extends Thread implements IMultiply{
	private final int[][] resultArr;
	private final Matrix matrix1;
	private final Matrix matrix2;
	Matrix result;
	private int startIndex;
	
	public ParallelMatrixMultiply(Matrix matrix1, Matrix matrix2, int startIndex) {
		this.startIndex = startIndex;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		resultArr = new int[matrix1.getRow()][matrix2.getCol()];
	}
	

	public Matrix multiply(Matrix matrix1, Matrix matrix2) throws InterruptedException {
		int rowCount = matrix1.getRow();
		int colCount = matrix2.getCol();
		if (rowCount != colCount) throw new RuntimeException("Multiply is not avalable");
		Thread thread = new ParallelMatrixMultiply(matrix1, matrix2, startIndex);
			thread.start();
			thread.join();

		return result;
	}
	
	@Override
	public void run() {
		for (int i = startIndex; i < matrix1.getRow(); i++) {
			for (int j = startIndex; j < matrix2.getCol(); j++) {
				for (int k = 0; k < matrix1.getCol(); k++) {
					resultArr[i][j] += matrix1.getElement(i, k) * matrix2.getElement(k, j);

				}
			}
		}	
		result = new Matrix(resultArr);
	}
	
	

}
