package org.apache.tika.sax;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.metadata.filter.MetadataFilter;
import org.apache.tika.metadata.filter.NoOpFilter;
import org.apache.tika.parser.RecursiveParserWrapper;
import org.apache.tika.utils.ParserUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class RecursiveParserWrapperHandler extends AbstractRecursiveParserWrapperHandler {
    private final MetadataFilter metadataFilter;
    protected final List<Metadata> metadataList;

    public RecursiveParserWrapperHandler(ContentHandlerFactory contentHandlerFactory) {
        this(contentHandlerFactory, -1, NoOpFilter.NOOP_FILTER);
    }

    private void writeFinalEmbeddedPaths() {
        HashMap hashMap = new HashMap();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (Metadata metadata : this.metadataList) {
            String str = metadata.get(TikaCoreProperties.EMBEDDED_ID);
            if (str != null) {
                hashMap.put(str, RecursiveParserWrapper.getResourceName(metadata, atomicInteger));
            }
        }
        for (Metadata metadata2 : this.metadataList) {
            String str2 = metadata2.get(TikaCoreProperties.EMBEDDED_ID_PATH);
            if (str2 != null) {
                if (str2.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    str2 = str2.substring(1);
                }
                String[] split = str2.split(RemoteSettings.FORWARD_SLASH_STRING);
                StringBuilder sb = new StringBuilder();
                for (String str3 : split) {
                    sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                    sb.append((String) hashMap.get(str3));
                }
                metadata2.set(TikaCoreProperties.FINAL_EMBEDDED_RESOURCE_PATH, sb.toString());
            }
        }
    }

    public void addContent(ContentHandler contentHandler, Metadata metadata) {
        String obj;
        if (!contentHandler.getClass().equals(DefaultHandler.class) && (obj = contentHandler.toString()) != null) {
            int length = obj.length();
            int i = 0;
            while (i < length) {
                int codePointAt = obj.codePointAt(i);
                if (!Character.isWhitespace(codePointAt)) {
                    metadata.add(TikaCoreProperties.TIKA_CONTENT, obj);
                    metadata.add(TikaCoreProperties.TIKA_CONTENT_HANDLER, contentHandler.getClass().getSimpleName());
                    return;
                }
                i += Character.charCount(codePointAt);
            }
        }
    }

    @Override // org.apache.tika.sax.AbstractRecursiveParserWrapperHandler
    public void endDocument(ContentHandler contentHandler, Metadata metadata) {
        super.endDocument(contentHandler, metadata);
        addContent(contentHandler, metadata);
        try {
            this.metadataFilter.filter(metadata);
            if (metadata.size() > 0) {
                this.metadataList.add(0, ParserUtils.cloneMetadata(metadata));
            }
            writeFinalEmbeddedPaths();
        } catch (TikaException e4) {
            throw new SAXException(e4);
        }
    }

    @Override // org.apache.tika.sax.AbstractRecursiveParserWrapperHandler
    public void endEmbeddedDocument(ContentHandler contentHandler, Metadata metadata) {
        super.endEmbeddedDocument(contentHandler, metadata);
        addContent(contentHandler, metadata);
        try {
            this.metadataFilter.filter(metadata);
            if (metadata.size() > 0) {
                this.metadataList.add(ParserUtils.cloneMetadata(metadata));
            }
        } catch (TikaException e4) {
            throw new SAXException(e4);
        }
    }

    public List<Metadata> getMetadataList() {
        return this.metadataList;
    }

    @Override // org.apache.tika.sax.AbstractRecursiveParserWrapperHandler
    public void startEmbeddedDocument(ContentHandler contentHandler, Metadata metadata) {
        super.startEmbeddedDocument(contentHandler, metadata);
    }

    public RecursiveParserWrapperHandler(ContentHandlerFactory contentHandlerFactory, int i) {
        this(contentHandlerFactory, i, NoOpFilter.NOOP_FILTER);
    }

    public RecursiveParserWrapperHandler(ContentHandlerFactory contentHandlerFactory, int i, MetadataFilter metadataFilter) {
        super(contentHandlerFactory, i);
        this.metadataList = new LinkedList();
        this.metadataFilter = metadataFilter;
    }
}
