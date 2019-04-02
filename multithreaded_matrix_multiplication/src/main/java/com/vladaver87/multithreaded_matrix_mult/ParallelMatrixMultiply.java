package com.vladaver87.multithreaded_matrix_mult;

public class ParallelMatrixMultiply extends Thread implements IMultiply{
	private final int[][] resultArr;
	private final Matrix matrix1;
	private final Matrix matrix2;
	Matrix result;
	private int startIndex;
	private int endIndex;
	
	public ParallelMatrixMultiply(Matrix matrix1, Matrix matrix2, int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		resultArr = new int[matrix1.getRow()][matrix2.getCol()];
	}
	

	public Matrix multiply(Matrix matrix1, Matrix matrix2) throws InterruptedException {
		int rowCount = matrix1.getRow();
		int colCount = matrix2.getCol();
		if (rowCount != colCount) throw new RuntimeException("Multiply is not avalable");
		Thread[] threads = new Thread[matrix1.getRow() * matrix2.getCol()];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new ParallelMatrixMultiply(matrix1, matrix2, startIndex++, endIndex++);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
 
			threads[i].join();
		}
		return result;
	}
	
	@Override
	public void run() {
		for (int i = startIndex; i < endIndex; i++) {
			for (int j = startIndex; j < endIndex; j++) {
				for (int k = startIndex; k < matrix1.getCol(); k++) {
					resultArr[i][j] += matrix1.getElement(i, k) * matrix2.getElement(k, j);

				}
			}
		}	
		result = new Matrix(resultArr);
	}
	
	

}
