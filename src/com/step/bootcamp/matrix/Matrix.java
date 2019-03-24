package com.step.bootcamp.matrix;

import java.util.ArrayList;
import java.util.Objects;

class Matrix {

    private final ArrayList<ArrayList<Integer>> inputMatrix;

    Matrix(ArrayList<ArrayList<Integer>> inputMatrix) {
        this.inputMatrix = inputMatrix;
    }

    Matrix transpose() {
        ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();
        int noOfColumns = this.inputMatrix.get(0).size();
        for (int columnIndex = 0; columnIndex < noOfColumns; columnIndex++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            for (ArrayList<Integer> inputMatrix1 : this.inputMatrix) {
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
        return inputMatrix.equals(matrix.inputMatrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputMatrix);
    }

    public Matrix add(ArrayList<ArrayList<Integer>> addable) {
        int noOfRows = addable.size();
        int noOfColumns = addable.get(0).size();
        int totalElements = noOfRows + noOfColumns;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < noOfRows; i++) {
            result.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < totalElements; i++) {
            Integer first = this.inputMatrix.get(i / noOfRows).get(i % noOfRows);
            Integer second = addable.get(i / noOfRows).get(i % noOfRows);
            result.get(i / noOfRows).add(first + second);
        }
        return new Matrix(result);
    }
}
