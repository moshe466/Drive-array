package org.apache.tika.sax;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class TaggedContentHandler extends ContentHandlerDecorator {
    public TaggedContentHandler(ContentHandler contentHandler) {
        super(contentHandler);
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator
    public void handleException(SAXException sAXException) {
        throw new TaggedSAXException(sAXException, this);
    }

    public boolean isCauseOf(SAXException sAXException) {
        if (!(sAXException instanceof TaggedSAXException) || this != ((TaggedSAXException) sAXException).getTag()) {
            return false;
        }
        return true;
    }

    public void throwIfCauseOf(Exception exc) {
        if (exc instanceof TaggedSAXException) {
            TaggedSAXException taggedSAXException = (TaggedSAXException) exc;
            if (this == taggedSAXException.getTag()) {
                throw taggedSAXException.getCause();
            }
        }
    }
}
