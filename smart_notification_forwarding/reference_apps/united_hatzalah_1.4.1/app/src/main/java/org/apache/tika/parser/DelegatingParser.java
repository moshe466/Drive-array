package org.apache.tika.parser;

import java.io.InputStream;
import java.util.Set;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.xml.sax.ContentHandler;

/* loaded from: classes.dex */
public class DelegatingParser implements Parser {
    public Parser getDelegateParser(ParseContext parseContext) {
        return (Parser) parseContext.get(Parser.class, EmptyParser.INSTANCE);
    }

    @Override // org.apache.tika.parser.Parser
    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return getDelegateParser(parseContext).getSupportedTypes(parseContext);
    }

    @Override // org.apache.tika.parser.Parser
    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) {
        getDelegateParser(parseContext).parse(inputStream, contentHandler, metadata, parseContext);
    }
}
