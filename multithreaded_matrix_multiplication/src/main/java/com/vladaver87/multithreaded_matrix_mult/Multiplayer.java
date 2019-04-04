package com.vladaver87.multithreaded_matrix_mult;

public class Multiplayer implements Runnable{

	private int[][] resultArr;
	private final Matrix matrix1;
	private final Matrix matrix2;
	private int startIndex;
	
	public Multiplayer(Matrix matrix1, Matrix matrix2, int startIndex) {
		this.startIndex = startIndex;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		resultArr = new int[matrix1.getRow()][matrix2.getCol()];
	}

	public int[][] getResultArr() {
		return resultArr;
	}
	
	
	public void run() {
		for (int i = startIndex; i < matrix1.getRow(); i++) {
			for (int j = startIndex; j < matrix2.getCol(); j++) {
				for (int k = 0; k < matrix1.getCol(); k++) {
					resultArr[i][j] += matrix1.getElement(i, k) * matrix2.getElement(k, j);

				}
			}
		}	
	}

}
