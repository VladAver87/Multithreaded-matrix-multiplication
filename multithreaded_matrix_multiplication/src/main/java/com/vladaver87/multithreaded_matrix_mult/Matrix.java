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
		final Random random = new Random();
		for (int i = 0; i < row; i++) {
			for (int j  = 0; j < col; j++) {
				data[i][j] = random.nextInt(100);		
			}
		}
	}
	
	public static Matrix createNewMatrix(int row, int col) {
		return new Matrix(row, col);
	}

	public int[][] getData() {
		return data;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public static void printMatrix(Matrix matrix) {
		for (int i = 0; i < matrix.row; i++) {
			for (int j  = 0; j < matrix.col; j++) {
				System.out.print(" " + matrix.data[i][j]);
			}
			System.out.println();
		}
	}
}
