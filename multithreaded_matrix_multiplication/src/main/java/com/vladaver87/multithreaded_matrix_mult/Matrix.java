package com.vladaver87.multithreaded_matrix_mult;

import java.util.Random;

public final class Matrix {
	private final int row;
	private final int col;
	private final int[][]data;

	private Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		data = new int[row][col];
	}
	
	public static Matrix createNewMatrix(int row, int col) {
		return new Matrix(row, col);
	}

	public Matrix fillNewMatrix() {
		final Random random = new Random();
		Matrix result = new Matrix(row, col);
		for (int i = 0; i < row; i++) {
			for (int j  = 0; j < col; j++) {
				result.data[i][j] = random.nextInt(100);		
			}
		}
		return result;
	}

	public void printMatrix(Matrix matrix) {
		for (int i = 0; i < row; i++) {
			for (int j  = 0; j < col; j++) {
				System.out.print(" " + matrix.data[i][j]);
			}
			System.out.println();
		}
	}
}
