package org.apache.tika.extractor;

import java.io.Serializable;
import org.apache.tika.io.TikaInputStream;

/* loaded from: classes.dex */
public interface ContainerExtractor extends Serializable {
    void extract(TikaInputStream tikaInputStream, ContainerExtractor containerExtractor, EmbeddedResourceHandler embeddedResourceHandler);

    boolean isSupported(TikaInputStream tikaInputStream);
}
