package org.apache.tika.detect;

import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

/* loaded from: classes.dex */
public class EmptyDetector implements Detector {
    public static final EmptyDetector INSTANCE = new EmptyDetector();

    @Override // org.apache.tika.detect.Detector
    public MediaType detect(InputStream inputStream, Metadata metadata) {
        return MediaType.OCTET_STREAM;
    }
}
