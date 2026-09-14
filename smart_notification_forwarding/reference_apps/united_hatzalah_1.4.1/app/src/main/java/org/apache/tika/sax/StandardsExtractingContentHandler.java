package org.apache.tika.sax;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class StandardsExtractingContentHandler extends ContentHandlerDecorator {
    public static final String STANDARD_REFERENCES = "standard_references";
    private int maxBufferLength;
    private final Metadata metadata;
    private final StringBuilder stringBuilder;
    private double threshold;

    public StandardsExtractingContentHandler(ContentHandler contentHandler, Metadata metadata) {
        super(contentHandler);
        this.maxBufferLength = 100000;
        this.threshold = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.metadata = metadata;
        this.stringBuilder = new StringBuilder();
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        int length;
        try {
            int i4 = this.maxBufferLength;
            if (i4 > -1 && (length = i4 - this.stringBuilder.length()) <= i3) {
                i3 = length;
            }
            this.stringBuilder.append(new String(Arrays.copyOfRange(cArr, i, i + i3)));
            super.characters(cArr, i, i3);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        super.endDocument();
        ArrayList<StandardReference> extractStandardReferences = StandardsText.extractStandardReferences(this.stringBuilder.toString(), this.threshold);
        int size = extractStandardReferences.size();
        int i = 0;
        while (i < size) {
            StandardReference standardReference = extractStandardReferences.get(i);
            i++;
            this.metadata.add(STANDARD_REFERENCES, standardReference.toString());
        }
    }

    public double getThreshold() {
        return this.threshold;
    }

    public void setMaxBufferLength(int i) {
        this.maxBufferLength = i;
    }

    public void setThreshold(double d2) {
        this.threshold = d2;
    }

    public StandardsExtractingContentHandler() {
        this(new DefaultHandler(), new Metadata());
    }
}
