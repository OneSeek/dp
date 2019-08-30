package cn.oneseek.dp.utils.predict;

import java.io.IOException;

public class Test {


    public static void main(String[] args) throws IOException {
        float[] a = new float[]{
                2018f, 1f, 5f, 22f, 14f, 0f, 18f,
                33f, 4f, 278f,553f

        };
        long[] shape = new long[]{1, 11};

        float result = Predict.predict(a,shape);

        System.out.println(result);
        result = (float)(Math.round(result*100))/100;
        System.out.println(result);
    }
}
