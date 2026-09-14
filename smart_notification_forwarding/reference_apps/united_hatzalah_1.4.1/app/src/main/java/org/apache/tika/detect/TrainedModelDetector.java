package org.apache.tika.detect;

import com.google.android.gms.common.api.Api;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

/* loaded from: classes.dex */
public abstract class TrainedModelDetector implements Detector {
    private static final long serialVersionUID = 1;
    private final Map<MediaType, TrainedModel> MODEL_MAP = new HashMap();

    public TrainedModelDetector() {
        loadDefaultModels(getClass().getClassLoader());
    }

    private void writeHisto(float[] fArr) {
        BufferedWriter newBufferedWriter;
        Path createTempFile = new TemporaryResources().createTempFile();
        Charset charset = StandardCharsets.UTF_8;
        newBufferedWriter = Files.newBufferedWriter(createTempFile, StandardCharsets.UTF_8, new OpenOption[0]);
        try {
            for (float f4 : fArr) {
                newBufferedWriter.write(f4 + "\t");
            }
            newBufferedWriter.write("\r\n");
            newBufferedWriter.close();
        } catch (Throwable th) {
            if (newBufferedWriter != null) {
                try {
                    newBufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.apache.tika.detect.Detector
    public MediaType detect(InputStream inputStream, Metadata metadata) {
        if (inputStream != null) {
            inputStream.mark(getMinLength());
            float[] readByteFrequencies = readByteFrequencies(inputStream);
            MediaType mediaType = MediaType.OCTET_STREAM;
            float f4 = 0.5f;
            for (Map.Entry<MediaType, TrainedModel> entry : this.MODEL_MAP.entrySet()) {
                MediaType key = entry.getKey();
                float predict = entry.getValue().predict(readByteFrequencies);
                if (f4 < predict) {
                    f4 = predict;
                    mediaType = key;
                }
            }
            inputStream.reset();
            return mediaType;
        }
        return null;
    }

    public int getMinLength() {
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public abstract void loadDefaultModels(InputStream inputStream);

    public abstract void loadDefaultModels(ClassLoader classLoader);

    public void loadDefaultModels(Path path) {
        InputStream newInputStream;
        try {
            newInputStream = Files.newInputStream(path, new OpenOption[0]);
            try {
                loadDefaultModels(newInputStream);
                if (newInputStream != null) {
                    newInputStream.close();
                }
            } finally {
            }
        } catch (IOException e4) {
            throw new RuntimeException("Unable to read the default media type registry", e4);
        }
    }

    public float[] readByteFrequencies(InputStream inputStream) {
        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
        float[] fArr = new float[257];
        fArr[0] = 1.0f;
        ByteBuffer allocate = ByteBuffer.allocate(5120);
        float f4 = -1.0f;
        for (int read = newChannel.read(allocate); read != -1; read = newChannel.read(allocate)) {
            allocate.flip();
            while (allocate.hasRemaining()) {
                byte b4 = allocate.get();
                int i = b4 + 1;
                if (b4 < 0) {
                    i = b4 + 257;
                    fArr[i] = fArr[i] + 1.0f;
                } else {
                    fArr[i] = fArr[i] + 1.0f;
                }
                f4 = Math.max(f4, fArr[i]);
            }
        }
        for (int i3 = 1; i3 < 257; i3++) {
            float f5 = fArr[i3] / f4;
            fArr[i3] = f5;
            fArr[i3] = (float) Math.sqrt(f5);
        }
        return fArr;
    }

    public void registerModels(MediaType mediaType, TrainedModel trainedModel) {
        this.MODEL_MAP.put(mediaType, trainedModel);
    }

    public void loadDefaultModels(File file) {
        Path path;
        path = file.toPath();
        loadDefaultModels(path);
    }
}
