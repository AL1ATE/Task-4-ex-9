package ru.vsu.cs.obukhov;

import java.util.Arrays;

public class State {
    private final int[] arr;
    private final int tempI;
    private final int tempJ;

    @Override
    public String toString() {
        return "SortState{" +
                "arr=" + Arrays.toString(arr) +
                ", tempI=" + tempI +
                ", tempJ=" + tempJ +
                '}' + "\n";
    }

    public State(int[] arr, int tempI, int tempJ) {
        this.arr = arr;
        this.tempI = tempI;
        this.tempJ = tempJ;
    }

    public int[] getArr() {
        return arr;
    }

    public int getTempJ() {
        return tempJ;
    }
}