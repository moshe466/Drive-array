package org.apache.tika.parser;

import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.ContentHandler;

@Deprecated
/* loaded from: classes.dex */
public abstract class AbstractParser implements Parser {
    private static final long serialVersionUID = 7186985395903074255L;

    @Deprecated
    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata) {
        parse(inputStream, contentHandler, metadata, new ParseContext());
    }
}
