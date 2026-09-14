package org.apache.tika.parser;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Set;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.xml.sax.ContentHandler;

/* loaded from: classes.dex */
public interface Parser extends Serializable {
    Set<MediaType> getSupportedTypes(ParseContext parseContext);

    void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext);
}
