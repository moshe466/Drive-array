package org.apache.tika.sax;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.tika.metadata.Office;

/* loaded from: classes.dex */
public class ToHTMLContentHandler extends ToXMLContentHandler {
    private static final Set<String> EMPTY_ELEMENTS = new HashSet(Arrays.asList("area", "base", "basefont", "br", "col", "frame", "hr", "img", "input", "isindex", "link", Office.PREFIX_DOC_META, "param"));

    public ToHTMLContentHandler(OutputStream outputStream, String str) {
        super(outputStream, str);
    }

    @Override // org.apache.tika.sax.ToXMLContentHandler, org.apache.tika.sax.ToTextContentHandler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (this.inStartElement) {
            write('>');
            this.inStartElement = false;
            if (EMPTY_ELEMENTS.contains(str2)) {
                this.namespaces.clear();
                return;
            }
        }
        super.endElement(str, str2, str3);
    }

    @Override // org.apache.tika.sax.ToXMLContentHandler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
    }

    public ToHTMLContentHandler() {
    }
}
