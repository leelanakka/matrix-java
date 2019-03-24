package com.step.bootcamp.matrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixTest {
    @Test
    void shouldReturnTheTransposeOfAnMatrix() throws MatrixException {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1, 2)));
        input.add(new ArrayList<>(asList(3, 4)));

        Matrix matrix = Matrix.validateInputMatrix(input);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(1, 3)));
        expected.add(new ArrayList<>(asList(2, 4)));
        Matrix expectedOutput = Matrix.validateInputMatrix(expected);
        assertEquals(expectedOutput, matrix.transpose());
    }

    @Test
    void shouldThrowErrorIfTheMatrixIsNotValid() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1, 2)));
        input.add(new ArrayList<>(asList(3, 4, 5)));

        assertThrows(MatrixException.class, () -> Matrix.validateInputMatrix(input));
    }

    @Test
    void shouldReturnTheTransposeOfAnMatrixForThreeByThreeMatrix() throws MatrixException {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1, 2, 5)));
        input.add(new ArrayList<>(asList(3, 4, 6)));

        Matrix matrix = Matrix.validateInputMatrix(input);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(1, 3)));
        expected.add(new ArrayList<>(asList(2, 4)));
        expected.add(new ArrayList<>(asList(5, 6)));

        Matrix expectedOutput = Matrix.validateInputMatrix(expected);
        assertEquals(expectedOutput, matrix.transpose());
    }

    @Test
    void shouldReturnTheTransposeOfAnMatrixForOneByTwoSize() throws MatrixException {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Collections.singletonList(1)));
        input.add(new ArrayList<>(Collections.singletonList(3)));

        Matrix matrix = Matrix.validateInputMatrix(input);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(1, 3)));

        Matrix expectedOutput = Matrix.validateInputMatrix(expected);
        assertEquals(expectedOutput, matrix.transpose());
    }


    @Test
    void shouldAddTheTwoMatrixAndReturnTheSumOfMatrix() throws MatrixException {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1, 2)));
        input.add(new ArrayList<>(asList(3, 4)));

        Matrix matrix = Matrix.validateInputMatrix(input);

        ArrayList<ArrayList<Integer>> anotherMatrix = new ArrayList<>();
        anotherMatrix.add(new ArrayList<>(asList(1, 3)));
        anotherMatrix.add(new ArrayList<>(asList(2, 4)));
        Matrix addableMatrix = Matrix.validateInputMatrix(anotherMatrix);


        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(2, 5)));
        expected.add(new ArrayList<>(asList(5, 8)));

        Matrix expectedOutput = Matrix.validateInputMatrix(expected);

        assertEquals(expectedOutput, matrix.add(addableMatrix));
    }

    @Test
    void shouldThrowExceptionIfTheFirstMatrixSizeAndSecondMatrixSizeAreDifferent() throws MatrixException {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1, 2)));
        input.add(new ArrayList<>(asList(3, 4)));

        Matrix matrix = Matrix.validateInputMatrix(input);

        ArrayList<ArrayList<Integer>> anotherMatrix = new ArrayList<>();
        anotherMatrix.add(new ArrayList<>(asList(1, 3)));
        anotherMatrix.add(new ArrayList<>(asList(2, 4)));
        anotherMatrix.add(new ArrayList<>(asList(2, 4)));

        Matrix addableMatrix = Matrix.validateInputMatrix(anotherMatrix);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(2, 5)));
        expected.add(new ArrayList<>(asList(5, 8)));

        assertThrows(MatrixException.class, () -> matrix.add(addableMatrix));
    }

    @Test
    void shouldSubtractTheGivenMatrices() throws MatrixException {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(4, 9)));
        input.add(new ArrayList<>(asList(10, 6)));

        Matrix matrix = Matrix.validateInputMatrix(input);

        ArrayList<ArrayList<Integer>> anotherList = new ArrayList<>();
        anotherList.add(new ArrayList<>(asList(1, 3)));
        anotherList.add(new ArrayList<>(asList(2, 4)));
        Matrix anotherMatrix = Matrix.validateInputMatrix(anotherList);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(3, 6)));
        expected.add(new ArrayList<>(asList(8, 2)));

        Matrix expectedOutput = Matrix.validateInputMatrix(expected);

        assertEquals(expectedOutput, matrix.subtract(anotherMatrix));
    }

}