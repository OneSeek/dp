package cn.oneseek.dp.utils.other;

import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.FloatBuffer;

public class Test {
    public static String PB_FILE_PATH = "D:\\IdeaProject\\dp_SpringBoot\\src\\main\\java\\cn\\oneseek\\dp\\utils\\predict\\test_model.pb";
    public static String INPUT_TENSOR_NAME = "conv2d_1_input";
    public static String OUTPUT_TENSOR_NAME = "dense_2/Softmax";

    public static void main(String[] args) throws IOException {
        try (Graph graph = new Graph()) {

            //导入图
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(PB_FILE_PATH));
            graph.importGraphDef(graphBytes);

            float[] a = new float[]{
                    0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.2f, 0.517647f, 0.839216f, 0.992157f, 0.996078f, 0.992157f, 0.796079f, 0.635294f, 0.160784f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.4f, 0.556863f, 0.796079f, 0.796079f, 0.992157f, 0.988235f, 0.992157f, 0.988235f, 0.592157f, 0.27451f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.996078f, 0.992157f, 0.956863f, 0.796079f, 0.556863f, 0.4f, 0.321569f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.67451f, 0.988235f, 0.796079f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.0823529f, 0.87451f, 0.917647f, 0.117647f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.478431f, 0.992157f, 0.196078f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.482353f, 0.996078f, 0.356863f, 0.2f, 0.2f, 0.2f, 0.0392157f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.0823529f, 0.87451f, 0.992157f, 0.988235f, 0.992157f, 0.988235f, 0.992157f, 0.67451f, 0.321569f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.0823529f, 0.839216f, 0.992157f, 0.796079f, 0.635294f, 0.4f, 0.4f, 0.796079f, 0.87451f, 0.996078f, 0.992157f, 0.2f, 0.0392157f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.239216f, 0.992157f, 0.670588f, 0f, 0f, 0f, 0f, 0f, 0.0784314f, 0.439216f, 0.752941f, 0.992157f, 0.831373f, 0.160784f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.4f, 0.796079f, 0.917647f, 0.2f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.0784314f, 0.835294f, 0.909804f, 0.321569f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.243137f, 0.796079f, 0.917647f, 0.439216f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.0784314f, 0.835294f, 0.988235f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.6f, 0.992157f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.160784f, 0.913726f, 0.831373f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.443137f, 0.360784f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.121569f, 0.678431f, 0.956863f, 0.156863f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.321569f, 0.992157f, 0.592157f, 0f, 0f, 0f, 0f, 0f, 0f, 0.0823529f, 0.4f, 0.4f, 0.717647f, 0.913726f, 0.831373f, 0.317647f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.321569f, 1.0f, 0.992157f, 0.917647f, 0.596078f, 0.6f, 0.756863f, 0.678431f, 0.992157f, 0.996078f, 0.992157f, 0.996078f, 0.835294f, 0.556863f, 0.0784314f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.278431f, 0.592157f, 0.592157f, 0.909804f, 0.992157f, 0.831373f, 0.752941f, 0.592157f, 0.513726f, 0.196078f, 0.196078f, 0.0392157f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0.0f};
            long[] shape = new long[]{1, 28, 28, 1};

            Tensor data = Tensor.create(shape, FloatBuffer.wrap(a));

            //根据图建立Session
            try (Session session = new Session(graph)) {
                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'x': 10.0})
                Tensor<?> out = session.runner()
                        .feed(INPUT_TENSOR_NAME, data)
                        .fetch(OUTPUT_TENSOR_NAME).run().get(0);

                // Tensor结果转换
                float[][] t = new float[1][10];
                out.copyTo(t);
                float max = 0f;
                float[] result = t[0];

                int label = 0;
                for (int i = 0; i < result.length; i++) {
                    float score = result[i];
                    System.out.println(score);
                    if (score > max) {
                        max = score;
                        label = i;
                    }
                }
                System.out.println(label);
            }

        }
    }
}
