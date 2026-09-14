package org.apache.tika.detect;

import F0.AbstractC0008a;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Objects;
import n3.b;
import n3.d;
import org.apache.tika.mime.MediaType;

/* loaded from: classes.dex */
public class NNExampleModelDetector extends TrainedModelDetector {
    private static final String EXAMPLE_NNMODEL_FILE = "tika-example.nnmodel";
    private static final b LOG = d.b(NNExampleModelDetector.class);
    private static final long serialVersionUID = 1;

    public NNExampleModelDetector() {
    }

    private void readDescription(NNTrainedModelBuilder nNTrainedModelBuilder, String str) {
        String[] split = str.split("\t");
        try {
            MediaType parse = MediaType.parse(split[1]);
            int parseInt = Integer.parseInt(split[2]);
            int parseInt2 = Integer.parseInt(split[3]);
            int parseInt3 = Integer.parseInt(split[4]);
            nNTrainedModelBuilder.setNumOfInputs(parseInt);
            nNTrainedModelBuilder.setNumOfHidden(parseInt2);
            nNTrainedModelBuilder.setNumOfOutputs(parseInt3);
            nNTrainedModelBuilder.setType(parse);
        } catch (Exception e4) {
            LOG.p("Unable to parse the model configuration", e4);
            throw new RuntimeException("Unable to parse the model configuration", e4);
        }
    }

    private void readNNParams(NNTrainedModelBuilder nNTrainedModelBuilder, String str) {
        String[] split = str.split("\t");
        float[] fArr = new float[split.length];
        try {
            int i = 0;
            for (String str2 : split) {
                fArr[i] = Float.parseFloat(str2);
                i++;
            }
            nNTrainedModelBuilder.setParams(fArr);
        } catch (Exception e4) {
            LOG.p("Unable to parse the model configuration", e4);
            throw new RuntimeException("Unable to parse the model configuration", e4);
        }
    }

    @Override // org.apache.tika.detect.TrainedModelDetector
    public void loadDefaultModels(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        NNTrainedModelBuilder nNTrainedModelBuilder = new NNTrainedModelBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                String trim = readLine.trim();
                if (trim.startsWith("#")) {
                    readDescription(nNTrainedModelBuilder, trim);
                } else {
                    readNNParams(nNTrainedModelBuilder, trim);
                    super.registerModels(nNTrainedModelBuilder.getType(), nNTrainedModelBuilder.build());
                }
            } catch (IOException e4) {
                throw new RuntimeException("Unable to read the default media type registry", e4);
            }
        }
    }

    public NNExampleModelDetector(Path path) {
        loadDefaultModels(path);
    }

    public NNExampleModelDetector(File file) {
        loadDefaultModels(file);
    }

    @Override // org.apache.tika.detect.TrainedModelDetector
    public void loadDefaultModels(ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = TrainedModelDetector.class.getClassLoader();
        }
        String n4 = AbstractC0008a.n(TrainedModelDetector.class.getPackage().getName().replace('.', '/'), RemoteSettings.FORWARD_SLASH_STRING);
        URL resource = classLoader.getResource(n4 + EXAMPLE_NNMODEL_FILE);
        Objects.requireNonNull(resource, "required resource " + n4 + "tika-example.nnmodel not found");
        try {
            InputStream openStream = resource.openStream();
            try {
                loadDefaultModels(openStream);
                if (openStream != null) {
                    openStream.close();
                }
            } finally {
            }
        } catch (IOException e4) {
            throw new RuntimeException("Unable to read the default media type registry", e4);
        }
    }
}
