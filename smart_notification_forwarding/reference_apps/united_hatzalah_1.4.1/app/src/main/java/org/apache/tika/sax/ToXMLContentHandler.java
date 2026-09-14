package org.apache.tika.sax;

import F0.AbstractC0008a;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.tika.metadata.TikaCoreProperties;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class ToXMLContentHandler extends ToTextContentHandler {
    private ElementInfo currentElement;
    private final String encoding;
    protected boolean inStartElement;
    protected final Map<String, String> namespaces;

    /* loaded from: classes.dex */
    public static class ElementInfo {
        private final Map<String, String> namespaces;
        private final ElementInfo parent;

        public ElementInfo(ElementInfo elementInfo, Map<String, String> map) {
            this.parent = elementInfo;
            if (map.isEmpty()) {
                this.namespaces = Collections.EMPTY_MAP;
            } else {
                this.namespaces = new HashMap(map);
            }
        }

        public String getPrefix(String str) {
            String str2 = this.namespaces.get(str);
            if (str2 != null) {
                return str2;
            }
            ElementInfo elementInfo = this.parent;
            if (elementInfo != null) {
                return elementInfo.getPrefix(str);
            }
            if (str != null && !str.isEmpty()) {
                throw new SAXException(e0.a.e("Namespace ", str, " not declared"));
            }
            return "";
        }

        public String getQName(String str, String str2) {
            String prefix = getPrefix(str);
            if (prefix.length() > 0) {
                return AbstractC0008a.o(prefix, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, str2);
            }
            return str2;
        }
    }

    public ToXMLContentHandler(OutputStream outputStream, String str) {
        super(outputStream, str);
        this.namespaces = new HashMap();
        this.inStartElement = false;
        this.encoding = str;
    }

    private void lazyCloseStartElement() {
        if (this.inStartElement) {
            write('>');
            this.inStartElement = false;
        }
    }

    private int writeCharsAndEntity(char[] cArr, int i, int i3, String str) {
        super.characters(cArr, i, i3 - i);
        write('&');
        write(str);
        write(';');
        return i3 + 1;
    }

    private void writeEscaped(char[] cArr, int i, int i3, boolean z3) {
        int i4 = i;
        while (i < i3) {
            char c4 = cArr[i];
            if (c4 == '<') {
                i4 = writeCharsAndEntity(cArr, i4, i, "lt");
            } else if (c4 == '>') {
                i4 = writeCharsAndEntity(cArr, i4, i, "gt");
            } else if (c4 == '&') {
                i4 = writeCharsAndEntity(cArr, i4, i, "amp");
            } else if (z3 && c4 == '\"') {
                i4 = writeCharsAndEntity(cArr, i4, i, "quot");
            } else {
                i++;
            }
            i = i4;
        }
        super.characters(cArr, i4, i3 - i4);
    }

    @Override // org.apache.tika.sax.ToTextContentHandler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        lazyCloseStartElement();
        writeEscaped(cArr, i, i3 + i, false);
    }

    @Override // org.apache.tika.sax.ToTextContentHandler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (this.inStartElement) {
            write(" />");
            this.inStartElement = false;
        } else {
            write("</");
            write(str3);
            write('>');
        }
        this.namespaces.clear();
        this.currentElement = this.currentElement.parent;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        if (this.encoding != null) {
            write("<?xml version=\"1.0\" encoding=\"");
            write(this.encoding);
            write("\"?>\n");
        }
        this.currentElement = null;
        this.namespaces.clear();
    }

    @Override // org.apache.tika.sax.ToTextContentHandler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        lazyCloseStartElement();
        this.currentElement = new ElementInfo(this.currentElement, this.namespaces);
        write('<');
        write(this.currentElement.getQName(str, str2));
        for (int i = 0; i < attributes.getLength(); i++) {
            write(' ');
            write(this.currentElement.getQName(attributes.getURI(i), attributes.getLocalName(i)));
            write('=');
            write('\"');
            char[] charArray = attributes.getValue(i).toCharArray();
            writeEscaped(charArray, 0, charArray.length, true);
            write('\"');
        }
        for (Map.Entry<String, String> entry : this.namespaces.entrySet()) {
            write(' ');
            write("xmlns");
            String value = entry.getValue();
            if (value.length() > 0) {
                write(':');
                write(value);
            }
            write('=');
            write('\"');
            char[] charArray2 = entry.getKey().toCharArray();
            writeEscaped(charArray2, 0, charArray2.length, true);
            write('\"');
        }
        this.namespaces.clear();
        this.inStartElement = true;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
        try {
            ElementInfo elementInfo = this.currentElement;
            if (elementInfo != null) {
                if (str.equals(elementInfo.getPrefix(str2))) {
                    return;
                }
            }
        } catch (SAXException unused) {
        }
        this.namespaces.put(str2, str);
    }

    public void write(char c4) {
        super.characters(new char[]{c4}, 0, 1);
    }

    public void write(String str) {
        super.characters(str.toCharArray(), 0, str.length());
    }

    public ToXMLContentHandler(String str) {
        this.namespaces = new HashMap();
        this.inStartElement = false;
        this.encoding = str;
    }

    public ToXMLContentHandler() {
        this.namespaces = new HashMap();
        this.inStartElement = false;
        this.encoding = null;
    }
}
