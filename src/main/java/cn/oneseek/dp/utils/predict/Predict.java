package cn.oneseek.dp.utils.predict;

import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;

public class Predict {
    public static String PB_FILE_PATH = "D:\\IdeaProject\\dp_SpringBoot\\src\\main\\java\\cn\\oneseek\\dp\\utils\\predict\\test_model.pb";
    public static String INPUT_TENSOR_NAME = "dense_input";
    public static String OUTPUT_TENSOR_NAME = "dense_5/BiasAdd";

    public  static float predict(float[] a, long[] shape) throws IOException {

        try (Graph graph = new Graph()) {
            //导入图
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(PB_FILE_PATH));
            graph.importGraphDef(graphBytes);

            Tensor data = Tensor.create(shape, FloatBuffer.wrap(a));
            //根据图建立Session
            try (Session session = new Session(graph)) {
                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'x': 10.0})
                Tensor<?> out = session.runner()
                        .feed(INPUT_TENSOR_NAME, data)
                        .fetch(OUTPUT_TENSOR_NAME).run().get(0);

                // Tensor结果转换
                float[][] t = new float[1][1];
                out.copyTo(t);
                float max = 0f;
                float[] result = t[0];

                float fin_result = 0;
                for (int i = 0; i < result.length; i++) {
                    float score = result[i];
                    fin_result = score;
                    if (score > max) {
                        max = score;
                    }
                }
                return fin_result;
            }

        }
    }
}
