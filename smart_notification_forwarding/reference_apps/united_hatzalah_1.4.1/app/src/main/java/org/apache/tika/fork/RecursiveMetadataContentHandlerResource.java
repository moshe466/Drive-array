package org.apache.tika.fork;

import e0.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.sax.AbstractRecursiveParserWrapperHandler;
import org.apache.tika.sax.RecursiveParserWrapperHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
class RecursiveMetadataContentHandlerResource implements ForkResource {
    private static final ContentHandler DEFAULT_HANDLER = new DefaultHandler();
    private final AbstractRecursiveParserWrapperHandler handler;

    public RecursiveMetadataContentHandlerResource(RecursiveParserWrapperHandler recursiveParserWrapperHandler) {
        this.handler = recursiveParserWrapperHandler;
    }

    private void internalProcess(DataInputStream dataInputStream) {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        ContentHandler contentHandler = DEFAULT_HANDLER;
        if (readByte2 == 3) {
            contentHandler = (ContentHandler) readObject(dataInputStream);
        } else if (readByte2 != 4) {
            throw new IllegalArgumentException(a.c(readByte2, "Expected HANDLER_AND_METADATA or METADATA_ONLY, but got:"));
        }
        Metadata metadata = (Metadata) readObject(dataInputStream);
        if (readByte == 1) {
            this.handler.endEmbeddedDocument(contentHandler, metadata);
        } else if (readByte == 2) {
            this.handler.endDocument(contentHandler, metadata);
        } else {
            throw new IllegalArgumentException(a.c(readByte, "Expected either 0x01 or 0x02, but got: "));
        }
        byte readByte3 = dataInputStream.readByte();
        if (readByte3 == 5) {
        } else {
            throw new IOException(a.c(readByte3, "Expected the 'complete' signal, but got: "));
        }
    }

    private Object readObject(DataInputStream dataInputStream) {
        try {
            return ForkObjectInputStream.readObject(dataInputStream, getClass().getClassLoader());
        } catch (ClassNotFoundException e4) {
            throw new IOException(e4);
        }
    }

    @Override // org.apache.tika.fork.ForkResource
    public Throwable process(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        try {
            internalProcess(dataInputStream);
            return null;
        } catch (SAXException e4) {
            return e4;
        }
    }
}
