package com.vladaver87.multithreaded_matrix_mult;

public class ParallelMatrixMultiply implements IMultiply{
	private int startIndex;
	
	public ParallelMatrixMultiply(int startIndex) {
		this.startIndex = startIndex;
	}
	

	public Matrix multiply(Matrix matrix1, Matrix matrix2) throws InterruptedException {
		int rowCount = matrix1.getRow();
		int colCount = matrix2.getCol();
		if (rowCount != colCount) throw new RuntimeException("Multiply is not avalable");
		Multiplayer multiplayer = new Multiplayer(matrix1, matrix2, startIndex);
		Thread thread = new Thread(multiplayer);
			thread.start();
			thread.join();
			
		return new Matrix(multiplayer.getResultArr());
	}	

}
