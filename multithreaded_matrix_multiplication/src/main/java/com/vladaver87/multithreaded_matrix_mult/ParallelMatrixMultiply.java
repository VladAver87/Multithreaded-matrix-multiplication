package com.vladaver87.multithreaded_matrix_mult;

public class ParallelMatrixMultiply implements IMultiply{
	private int startIndex;
	private int endIndex;
	
	public ParallelMatrixMultiply(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	

	public Matrix multiply(Matrix matrix1, Matrix matrix2) throws InterruptedException {
		int rowCount = matrix1.getRow();
		int colCount = matrix2.getCol();
		if (rowCount != colCount) throw new RuntimeException("Multiply is not avalable");
		MultiplyJob multiplayer = new MultiplyJob(matrix1, matrix2, startIndex, endIndex);
		Thread[] threads = new Thread[matrix1.getRow() * matrix2.getCol()];
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new MultiplyJob(matrix1, matrix2, startIndex, endIndex));
				threads[i].start();			
				startIndex = endIndex;
				endIndex????
			}
			
		return new Matrix(multiplayer.getResultArr());
	}	

}
