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
		Matrix matrix = new Matrix(row, col);
		matrix.fillNewMatrix(matrix);
		return matrix;
	}

	private Matrix fillNewMatrix(Matrix matrix) {
		final Random random = new Random();
		for (int i = 0; i < row; i++) {
			for (int j  = 0; j < col; j++) {
				matrix.data[i][j] = random.nextInt(100);		
			}
		}
		return matrix;
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
