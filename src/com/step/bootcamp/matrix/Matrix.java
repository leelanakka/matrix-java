package com.step.bootcamp.matrix;

import java.util.ArrayList;

class Matrix {

    private final ArrayList<ArrayList<Integer>> matrix;

    private Matrix(ArrayList<ArrayList<Integer>> inputMatrix) {
        this.matrix = inputMatrix;
    }

    static Matrix validateInputMatrix(ArrayList<ArrayList<Integer>> inputMatrix) throws MatrixException {
        int noOfColumns = inputMatrix.get(0).size();
        for (ArrayList<Integer> integers : inputMatrix) {
            if (noOfColumns != integers.size()) {
                throw new MatrixException("Invalid matrix");
            }
        }
        return new Matrix(inputMatrix);
    }

    private void validateMatrixForAdditionAndSubtraction(Matrix matrix) throws MatrixException {
        boolean isRowsEqual = matrix.matrix.size() == this.matrix.size();
        boolean isColumnsEqual = matrix.matrix.get(0).size() == this.matrix.get(0).size();
        if (isRowsEqual && isColumnsEqual) {
            return;
        }
        throw new MatrixException("invalid matrix size to add with existing size");
    }

    Matrix transpose() throws MatrixException {
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
        return validateInputMatrix(resultMatrix);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return this.matrix.equals(matrix.matrix);
    }

    Matrix add(Matrix otherMatrix) throws MatrixException {
        validateMatrixForAdditionAndSubtraction(otherMatrix);
        int noOfRows = otherMatrix.matrix.size();
        int noOfColumns = otherMatrix.matrix.get(0).size();
        int totalElements = noOfRows + noOfColumns;
        ArrayList<ArrayList<Integer>> addedMatrix = getArrayLists(noOfRows);

        for (int index = 0; index < totalElements; index++) {
            int noOfElementInRow = index / noOfRows;
            int noOfColumn = index % noOfRows;
            Integer elementInMainMatrix = this.matrix.get(noOfElementInRow).get(noOfColumn);
            Integer elementInOtherMatrix = otherMatrix.matrix.get(noOfElementInRow).get(noOfColumn);
            addedMatrix.get(noOfElementInRow).add(elementInMainMatrix + elementInOtherMatrix);
        }
        return validateInputMatrix(addedMatrix);
    }

    Matrix subtract(Matrix otherMatrix) throws MatrixException {
        validateMatrixForAdditionAndSubtraction(otherMatrix);
        int noOfRows = otherMatrix.matrix.size();
        int noOfColumns = otherMatrix.matrix.get(0).size();
        int totalElements = noOfRows + noOfColumns;
        ArrayList<ArrayList<Integer>> result = getArrayLists(noOfRows);

        for (int i = 0; i < totalElements; i++) {
            Integer first = this.matrix.get(i / noOfRows).get(i % noOfRows);
            Integer second = otherMatrix.matrix.get(i / noOfRows).get(i % noOfRows);
            result.get(i / noOfRows).add(first - second);
        }
        return validateInputMatrix(result);
    }

    private ArrayList<ArrayList<Integer>> getArrayLists(int noOfRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < noOfRows; i++) {
            result.add(new ArrayList<>());
        }
        return result;
    }
}
