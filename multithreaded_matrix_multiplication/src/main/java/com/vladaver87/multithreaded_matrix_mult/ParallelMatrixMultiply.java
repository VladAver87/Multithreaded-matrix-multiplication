package com.vladaver87.multithreaded_matrix_mult;

public class ParallelMatrixMultiply implements IMultiply{

	

	public Matrix multiply(Matrix matrix1, Matrix matrix2) throws InterruptedException {
		int rowCount = matrix1.getRow();
		int colCount = matrix2.getCol();
		 final int[][] result = new int[rowCount][colCount];
		if (rowCount != colCount) throw new RuntimeException("Multiply is not avalable");
		int threadCount = matrix1.getRow() * matrix2.getCol();
		final int cellsForThread = (rowCount * colCount) / threadCount;
        int firstIndex = 0;
		Thread[] threads = new Thread[threadCount];
			for (int i = 0; i < threads.length; i++) {
				int lastIndex = firstIndex + cellsForThread;
				threads[i] = new Thread(new MultiplyJob(matrix1, matrix2, firstIndex, lastIndex, result));
				threads[i].start();	
				firstIndex = lastIndex;
				
			}
			
	        try {
	            for (Thread thread : threads)
	            	thread.join();
	        }
	        catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
		return new Matrix(result);
	}	

}
