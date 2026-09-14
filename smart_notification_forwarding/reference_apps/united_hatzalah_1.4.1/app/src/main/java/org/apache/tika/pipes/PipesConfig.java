package org.apache.tika.pipes;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import n3.b;
import n3.d;

/* loaded from: classes.dex */
public class PipesConfig extends PipesConfigBase {
    private static final b LOG = d.b(PipesClient.class);
    private long maxWaitForClientMillis = 60000;

    private PipesConfig() {
    }

    public static PipesConfig load(Path path) {
        InputStream newInputStream;
        PipesConfig pipesConfig = new PipesConfig();
        newInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            pipesConfig.configure("pipes", newInputStream);
            if (newInputStream != null) {
                newInputStream.close();
            }
            if (pipesConfig.getTikaConfig() == null) {
                LOG.x(path, "A separate tikaConfig was not specified in the <pipes/> element in the  config file; will use {} for pipes");
                pipesConfig.setTikaConfig(path);
            }
            return pipesConfig;
        } catch (Throwable th) {
            if (newInputStream != null) {
                try {
                    newInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public long getMaxWaitForClientMillis() {
        return this.maxWaitForClientMillis;
    }

    public void setMaxWaitForClientMillis(long j2) {
        this.maxWaitForClientMillis = j2;
    }

    public static PipesConfig load(InputStream inputStream) {
        PipesConfig pipesConfig = new PipesConfig();
        pipesConfig.configure("pipes", inputStream);
        return pipesConfig;
    }
}
