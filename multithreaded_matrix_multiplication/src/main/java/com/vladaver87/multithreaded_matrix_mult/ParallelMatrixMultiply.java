package com.vladaver87.multithreaded_matrix_mult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelMatrixMultiply implements IMultiply {

	public Matrix multiply(Matrix matrix1, Matrix matrix2) throws InterruptedException {
		int rowCount = matrix1.getRow();
		int colCount = matrix2.getCol();
		final int[][] result = new int[rowCount][colCount];
		if (rowCount != colCount)
			throw new RuntimeException("Multiply is not avalable");
		Thread[][] threads = new Thread[matrix1.getRow()][matrix2.getCol()];
		ExecutorService service = Executors.newFixedThreadPool(4);
		long start = System.nanoTime();
		for (int i = 0; i < threads.length; i++) {
			for (int j = 0; j < threads[0].length; j++) {
				service.execute(new MultiplyJob(matrix1, matrix2, i, j, result));
				
			}		
		}		
		service.shutdown();
		try {
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		long finish = System.nanoTime();
		long time = finish - start;
		
		System.out.println("Время работы параллельного перемножения " + time);		
		return new Matrix(result);
	}

}
