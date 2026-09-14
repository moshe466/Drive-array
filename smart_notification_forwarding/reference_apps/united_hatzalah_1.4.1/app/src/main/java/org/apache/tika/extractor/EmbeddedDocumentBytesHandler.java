package org.apache.tika.extractor;

import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import org.apache.tika.metadata.Metadata;

/* loaded from: classes.dex */
public interface EmbeddedDocumentBytesHandler extends Closeable {
    void add(int i, Metadata metadata, InputStream inputStream);

    List<Integer> getIds();
}
