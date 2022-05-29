package ru.vsu.cs.obukhov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public static List<State> sort(int[] data) {
        List<State> states = new ArrayList<>();
        int counter = 0;
        states.add(counter, new State(Arrays.copyOf(data, data.length), 0, 0));
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                counter++;
                states.add(counter, new State(Arrays.copyOf(data, data.length), i, j));
                counter++;
                if (data[j] > (data[j + 1])) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
                states.add(counter, new State(Arrays.copyOf(data, data.length), i, j));
            }
        }
        return states;
    }
}


