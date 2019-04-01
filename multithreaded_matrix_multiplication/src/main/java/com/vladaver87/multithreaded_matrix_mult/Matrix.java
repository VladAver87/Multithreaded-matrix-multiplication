package com.vladaver87.multithreaded_matrix_mult;

import java.util.Random;

public class Matrix {
	private int row;
	private int col;

	public Matrix(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int[][] fillNewMatrix() {
		int[][] result = new int[row][col];
		final Random random = new Random();

		for (int i = 0; i < row; i++) {
			for (int j  = 0; j < col; j++) {
				result[i][j] = random.nextInt(100);		
			}
		}
		return result;
	}

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < row; i++) {
			for (int j  = 0; j < col; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
}
