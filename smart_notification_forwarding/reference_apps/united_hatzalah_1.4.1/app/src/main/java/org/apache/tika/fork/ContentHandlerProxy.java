package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
class ContentHandlerProxy implements ContentHandler, ForkProxy {
    public static final int CHARACTERS = 7;
    public static final int END_DOCUMENT = 2;
    public static final int END_ELEMENT = 6;
    public static final int END_PREFIX_MAPPING = 4;
    public static final int IGNORABLE_WHITESPACE = 8;
    public static final int PROCESSING_INSTRUCTION = 9;
    public static final int SKIPPED_ENTITY = 10;
    public static final int START_DOCUMENT = 1;
    public static final int START_ELEMENT = 5;
    public static final int START_PREFIX_MAPPING = 3;
    private static final long serialVersionUID = 737511106054617524L;
    private transient DataOutputStream output;
    private final int resource;

    public ContentHandlerProxy(int i) {
        this.resource = i;
    }

    private void doneSending() {
        try {
            this.output.flush();
        } catch (IOException e4) {
            throw new SAXException("Unexpected fork proxy problem", e4);
        }
    }

    private void sendCharacters(char[] cArr, int i, int i3) {
        try {
            writeString(new String(cArr, i, i3));
        } catch (IOException e4) {
            throw new SAXException("Unexpected fork proxy problem", e4);
        }
    }

    private void sendRequest(int i) {
        try {
            this.output.writeByte(3);
            this.output.writeByte(this.resource);
            this.output.writeByte(i);
        } catch (IOException e4) {
            throw new SAXException("Unexpected fork proxy problem", e4);
        }
    }

    private void sendString(String str) {
        try {
            if (str != null) {
                this.output.writeBoolean(true);
                writeString(str);
            } else {
                this.output.writeBoolean(false);
            }
        } catch (IOException e4) {
            throw new SAXException("Unexpected fork proxy problem", e4);
        }
    }

    private void writeString(String str) {
        int length;
        int ceil = (int) Math.ceil(str.length() / 21845);
        this.output.writeInt(ceil);
        for (int i = 0; i < ceil; i++) {
            if (i < ceil - 1) {
                length = (i + 1) * 21845;
            } else {
                length = str.length();
            }
            this.output.writeUTF(str.substring(i * 21845, length));
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        sendRequest(7);
        sendCharacters(cArr, i, i3);
        doneSending();
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() {
        sendRequest(2);
        doneSending();
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        sendRequest(6);
        sendString(str);
        sendString(str2);
        sendString(str3);
        doneSending();
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) {
        sendRequest(4);
        sendString(str);
        doneSending();
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i3) {
        sendRequest(8);
        sendCharacters(cArr, i, i3);
        doneSending();
    }

    @Override // org.apache.tika.fork.ForkProxy
    public void init(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.output = dataOutputStream;
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) {
        sendRequest(9);
        sendString(str);
        sendString(str2);
        doneSending();
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) {
        sendRequest(10);
        sendString(str);
        doneSending();
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() {
        sendRequest(1);
        doneSending();
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        int i;
        sendRequest(5);
        sendString(str);
        sendString(str2);
        sendString(str3);
        if (attributes != null) {
            i = attributes.getLength();
        } else {
            i = -1;
        }
        try {
            this.output.writeInt(i);
            for (int i3 = 0; i3 < i; i3++) {
                sendString(attributes.getURI(i3));
                sendString(attributes.getLocalName(i3));
                sendString(attributes.getQName(i3));
                sendString(attributes.getType(i3));
                sendString(attributes.getValue(i3));
            }
            doneSending();
        } catch (IOException e4) {
            throw new SAXException("Unexpected fork proxy problem", e4);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
        sendRequest(3);
        sendString(str);
        sendString(str2);
        doneSending();
    }
}
