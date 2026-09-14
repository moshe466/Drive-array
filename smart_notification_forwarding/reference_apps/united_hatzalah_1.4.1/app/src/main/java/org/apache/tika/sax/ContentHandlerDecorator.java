package org.apache.tika.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class ContentHandlerDecorator extends DefaultHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ContentHandler handler;

    public ContentHandlerDecorator(ContentHandler contentHandler) {
        this.handler = contentHandler;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        try {
            this.handler.characters(cArr, i, i3);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        try {
            this.handler.endDocument();
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        try {
            this.handler.endElement(str, str2, str3);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) {
        try {
            this.handler.endPrefixMapping(str);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) {
        ContentHandler contentHandler = this.handler;
        if (contentHandler instanceof ErrorHandler) {
            ((ErrorHandler) contentHandler).error(sAXParseException);
        } else {
            super.error(sAXParseException);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) {
        ContentHandler contentHandler = this.handler;
        if (contentHandler instanceof ErrorHandler) {
            ((ErrorHandler) contentHandler).fatalError(sAXParseException);
        } else {
            super.fatalError(sAXParseException);
        }
    }

    public void handleException(SAXException sAXException) {
        ContentHandler contentHandler = this.handler;
        if (contentHandler instanceof ContentHandlerDecorator) {
            ((ContentHandlerDecorator) contentHandler).handleException(sAXException);
            return;
        }
        throw sAXException;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i3) {
        try {
            this.handler.ignorableWhitespace(cArr, i, i3);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) {
        try {
            this.handler.processingInstruction(str, str2);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.handler = contentHandler;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.handler.setDocumentLocator(locator);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void skippedEntity(String str) {
        try {
            this.handler.skippedEntity(str);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        try {
            this.handler.startDocument();
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        try {
            this.handler.startElement(str, str2, str3, attributes);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
        try {
            this.handler.startPrefixMapping(str, str2);
        } catch (SAXException e4) {
            handleException(e4);
        }
    }

    public String toString() {
        return this.handler.toString();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        ContentHandler contentHandler = this.handler;
        if (contentHandler instanceof ErrorHandler) {
            ((ErrorHandler) contentHandler).warning(sAXParseException);
        } else {
            super.warning(sAXParseException);
        }
    }

    public ContentHandlerDecorator() {
        this(new DefaultHandler());
    }
}
