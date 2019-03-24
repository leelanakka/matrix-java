package com.step.bootcamp.matrix;

import java.util.ArrayList;
import java.util.Objects;

class Matrix {

    private final ArrayList<ArrayList<Integer>> matrix;

    Matrix(ArrayList<ArrayList<Integer>> inputMatrix) {
        this.matrix = inputMatrix;
    }

    Matrix transpose() {
        ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();
        int noOfColumns = this.matrix.get(0).size();
        for (int columnIndex = 0; columnIndex < noOfColumns; columnIndex++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            for (ArrayList<Integer> inputMatrix1 : this.matrix) {
                Integer element = inputMatrix1.get(columnIndex);
                newRow.add(element);
            }
            resultMatrix.add(newRow);
        }
        return new Matrix(resultMatrix);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return this.matrix.equals(matrix.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matrix);
    }

    Matrix add(Matrix anotherMatrix) {
        int noOfRows = anotherMatrix.matrix.size();
        int noOfColumns = anotherMatrix.matrix.get(0).size();
        int totalElements = noOfRows + noOfColumns;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < noOfRows; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < totalElements; i++) {
            Integer first = this.matrix.get(i / noOfRows).get(i % noOfRows);
            Integer second = anotherMatrix.matrix.get(i / noOfRows).get(i % noOfRows);
            result.get(i / noOfRows).add(first + second);
        }
        return new Matrix(result);
    }

    Matrix subtract(Matrix anotherMatrix) {
        int noOfRows = anotherMatrix.matrix.size();
        int noOfColumns = anotherMatrix.matrix.get(0).size();
        int totalElements = noOfRows + noOfColumns;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < noOfRows; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < totalElements; i++) {
            Integer first = this.matrix.get(i / noOfRows).get(i % noOfRows);
            Integer second = anotherMatrix.matrix.get(i / noOfRows).get(i % noOfRows);
            result.get(i / noOfRows).add(first - second);
        }
        return new Matrix(result);
    }
}
