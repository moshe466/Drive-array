package org.apache.tika.parser;

import org.apache.tika.detect.DefaultEncodingDetector;
import org.apache.tika.detect.EncodingDetector;

/* loaded from: classes.dex */
public abstract class AbstractEncodingDetectorParser implements Parser {
    private EncodingDetector encodingDetector;

    public AbstractEncodingDetectorParser() {
        this.encodingDetector = new DefaultEncodingDetector();
    }

    public EncodingDetector getEncodingDetector(ParseContext parseContext) {
        EncodingDetector encodingDetector = (EncodingDetector) parseContext.get(EncodingDetector.class);
        return encodingDetector != null ? encodingDetector : getEncodingDetector();
    }

    public void setEncodingDetector(EncodingDetector encodingDetector) {
        this.encodingDetector = encodingDetector;
    }

    public AbstractEncodingDetectorParser(EncodingDetector encodingDetector) {
        this.encodingDetector = encodingDetector;
    }

    public EncodingDetector getEncodingDetector() {
        return this.encodingDetector;
    }
}
