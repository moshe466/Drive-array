package org.apache.tika.sax;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class PhoneExtractingContentHandler extends ContentHandlerDecorator {
    private static final String PHONE_NUMBERS = "phonenumbers";
    private final Metadata metadata;
    private final StringBuilder stringBuilder;

    public PhoneExtractingContentHandler(ContentHandler contentHandler, Metadata metadata) {
        super(contentHandler);
        this.metadata = metadata;
        this.stringBuilder = new StringBuilder();
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        try {
            this.stringBuilder.append(new String(Arrays.copyOfRange(cArr, i, i + i3)));
            super.characters(cArr, i, i3);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        super.endDocument();
        ArrayList<String> extractPhoneNumbers = CleanPhoneText.extractPhoneNumbers(this.stringBuilder.toString());
        int size = extractPhoneNumbers.size();
        int i = 0;
        while (i < size) {
            String str = extractPhoneNumbers.get(i);
            i++;
            this.metadata.add(PHONE_NUMBERS, str);
        }
    }

    public PhoneExtractingContentHandler() {
        this(new DefaultHandler(), new Metadata());
    }
}
