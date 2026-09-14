package org.apache.tika.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class TextContentHandler extends DefaultHandler {
    private static final char[] SPACE = {' '};
    private final boolean addSpaceBetweenElements;
    private final ContentHandler delegate;

    public TextContentHandler(ContentHandler contentHandler) {
        this(contentHandler, false);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        this.delegate.characters(cArr, i, i3);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        this.delegate.endDocument();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i3) {
        this.delegate.ignorableWhitespace(cArr, i, i3);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.delegate.setDocumentLocator(locator);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        this.delegate.startDocument();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (this.addSpaceBetweenElements) {
            ContentHandler contentHandler = this.delegate;
            char[] cArr = SPACE;
            contentHandler.characters(cArr, 0, cArr.length);
        }
    }

    public String toString() {
        return this.delegate.toString();
    }

    public TextContentHandler(ContentHandler contentHandler, boolean z3) {
        this.delegate = contentHandler;
        this.addSpaceBetweenElements = z3;
    }
}
