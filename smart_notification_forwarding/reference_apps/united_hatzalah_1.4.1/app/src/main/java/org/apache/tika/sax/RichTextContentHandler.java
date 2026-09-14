package org.apache.tika.sax;

import java.io.Writer;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public class RichTextContentHandler extends WriteOutContentHandler {
    public RichTextContentHandler(Writer writer) {
        super(writer);
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        super.startElement(str, str2, str3, attributes);
        if ("img".equals(str2) && attributes.getValue("alt") != null) {
            String e4 = e0.a.e("[image: ", attributes.getValue("alt"), "]");
            characters(e4.toCharArray(), 0, e4.length());
        }
        if ("a".equals(str2) && attributes.getValue("name") != null) {
            String e5 = e0.a.e("[bookmark: ", attributes.getValue("name"), "]");
            characters(e5.toCharArray(), 0, e5.length());
        }
    }
}
