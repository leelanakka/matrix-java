package com.step.bootcamp.matrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {
    @Test
    void shouldReturnTheTransposeOfAnMatrix() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1, 2)));
        input.add(new ArrayList<>(asList(3, 4)));

        Matrix matrix = new Matrix(input);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(1, 3)));
        expected.add(new ArrayList<>(asList(2, 4)));
        Matrix expectedOutput = new Matrix(expected);
        assertEquals(expectedOutput, matrix.transpose());
    }

    @Test
    void shouldReturnTheTransposeOfAnMatrixForThreeByThreeMatrix() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1, 2, 5)));
        input.add(new ArrayList<>(asList(3, 4, 6)));

        Matrix matrix = new Matrix(input);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(1, 3)));
        expected.add(new ArrayList<>(asList(2, 4)));
        expected.add(new ArrayList<>(asList(5, 6)));

        Matrix expectedOutput = new Matrix(expected);
        assertEquals(expectedOutput, matrix.transpose());
    }

    @Test
    void shouldReturnTheTransposeOfAnMatrixForOneByTwoSize() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1)));
        input.add(new ArrayList<>(asList(3)));

        Matrix matrix = new Matrix(input);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(1, 3)));

        Matrix expectedOutput = new Matrix(expected);
        assertEquals(expectedOutput, matrix.transpose());
    }


    @Test
    void shouldAddTheTwoMatrixAndReturnTheSumOfMatrix() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(asList(1, 2)));
        input.add(new ArrayList<>(asList(3, 4)));

        Matrix matrix = new Matrix(input);

        ArrayList<ArrayList<Integer>> addable = new ArrayList<>();
        addable.add(new ArrayList<>(asList(1, 3)));
        addable.add(new ArrayList<>(asList(2, 4)));
        Matrix addableMatrix = new Matrix(addable);


        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(asList(2, 5)));
        expected.add(new ArrayList<>(asList(5, 8)));

        Matrix expectedOutput = new Matrix(expected);

        assertEquals(expectedOutput, matrix.add(addable));
    }
}