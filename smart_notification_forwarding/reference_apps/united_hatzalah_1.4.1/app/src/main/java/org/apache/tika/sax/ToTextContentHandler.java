package org.apache.tika.sax;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class ToTextContentHandler extends DefaultHandler {
    private static final String SCRIPT = "SCRIPT";
    private static final String STYLE = "STYLE";
    private int scriptDepth;
    private int styleDepth;
    private final Writer writer;

    public ToTextContentHandler(Writer writer) {
        this.styleDepth = 0;
        this.scriptDepth = 0;
        this.writer = writer;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        if (this.styleDepth + this.scriptDepth != 0) {
            return;
        }
        try {
            this.writer.write(cArr, i, i3);
        } catch (IOException e4) {
            throw new SAXException("Error writing: ".concat(new String(cArr, i, i3)), e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        try {
            this.writer.flush();
        } catch (IOException e4) {
            throw new SAXException("Error flushing character output", e4);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        String upperCase;
        if (str3 == null) {
            upperCase = "";
        } else {
            upperCase = str3.toUpperCase(Locale.ENGLISH);
        }
        if (upperCase.equals(STYLE)) {
            this.styleDepth--;
        }
        if (upperCase.equals(SCRIPT)) {
            this.scriptDepth--;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i3) {
        characters(cArr, i, i3);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        String upperCase;
        if (str3 == null) {
            upperCase = "";
        } else {
            upperCase = str3.toUpperCase(Locale.ENGLISH);
        }
        if (upperCase.equals(STYLE)) {
            this.styleDepth++;
        }
        if (upperCase.equals(SCRIPT)) {
            this.scriptDepth++;
        }
    }

    public String toString() {
        return this.writer.toString();
    }

    public ToTextContentHandler(OutputStream outputStream, String str) {
        this(new OutputStreamWriter(outputStream, str));
    }

    public ToTextContentHandler() {
        this(new StringWriter());
    }
}
