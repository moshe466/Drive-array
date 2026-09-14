package org.apache.tika.detect;

import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;

@Deprecated
/* loaded from: classes.dex */
public class OverrideDetector implements Detector {
    @Override // org.apache.tika.detect.Detector
    public MediaType detect(InputStream inputStream, Metadata metadata) {
        String str = metadata.get(TikaCoreProperties.CONTENT_TYPE_PARSER_OVERRIDE);
        if (str != null) {
            return MediaType.parse(str);
        }
        String str2 = metadata.get(TikaCoreProperties.CONTENT_TYPE_USER_OVERRIDE);
        if (str2 != null) {
            return MediaType.parse(str2);
        }
        return MediaType.OCTET_STREAM;
    }
}
