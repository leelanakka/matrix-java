package com.step.bootcamp.matrix;

import java.util.ArrayList;

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

    Matrix add(Matrix otherMatrix) {
        int noOfRows = otherMatrix.matrix.size();
        int noOfColumns = otherMatrix.matrix.get(0).size();
        int totalElements = noOfRows + noOfColumns;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < noOfRows; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < totalElements; i++) {
            Integer elementInMainMatrix = this.matrix.get(i / noOfRows).get(i % noOfRows);
            Integer elementInOtherMatrix = otherMatrix.matrix.get(i / noOfRows).get(i % noOfRows);
            result.get(i / noOfRows).add(elementInMainMatrix + elementInOtherMatrix);
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
