package com.edntisolutions.yamlstudy;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        try {
            List<Float> scale = Arrays.asList(0.75f, 1.5f, 2f);
            Float v = scale.get(3);

        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

}
