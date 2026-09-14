package org.apache.tika.sax;

import org.xml.sax.ContentHandler;

/* loaded from: classes.dex */
public class EndDocumentShieldingContentHandler extends ContentHandlerDecorator {
    private boolean endDocumentCalled;

    public EndDocumentShieldingContentHandler(ContentHandler contentHandler) {
        super(contentHandler);
        this.endDocumentCalled = false;
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        this.endDocumentCalled = true;
    }

    public boolean isEndDocumentWasCalled() {
        return this.endDocumentCalled;
    }

    public void reallyEndDocument() {
        super.endDocument();
    }
}
