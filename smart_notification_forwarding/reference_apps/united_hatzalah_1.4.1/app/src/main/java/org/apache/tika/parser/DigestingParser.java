package org.apache.tika.parser;

import java.io.InputStream;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.xml.sax.ContentHandler;

/* loaded from: classes.dex */
public class DigestingParser extends ParserDecorator {
    private final Digester digester;
    private final boolean skipContainerDocument;

    /* loaded from: classes.dex */
    public interface Digester {
        void digest(InputStream inputStream, Metadata metadata, ParseContext parseContext);
    }

    /* loaded from: classes.dex */
    public interface DigesterFactory {
        Digester build();

        boolean isSkipContainerDocument();

        void setSkipContainerDocument(boolean z3);
    }

    /* loaded from: classes.dex */
    public interface Encoder {
        String encode(byte[] bArr);
    }

    public DigestingParser(Parser parser, Digester digester, boolean z3) {
        super(parser);
        this.digester = digester;
        this.skipContainerDocument = z3;
    }

    private boolean shouldDigest(Metadata metadata) {
        if (this.digester == null) {
            return false;
        }
        if (!this.skipContainerDocument) {
            return true;
        }
        Integer num = metadata.getInt(TikaCoreProperties.EMBEDDED_DEPTH);
        if (num == null || num.intValue() == 0) {
            return false;
        }
        return true;
    }

    @Override // org.apache.tika.parser.ParserDecorator, org.apache.tika.parser.Parser
    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) {
        TemporaryResources temporaryResources = new TemporaryResources();
        TikaInputStream tikaInputStream = TikaInputStream.get(inputStream, temporaryResources, metadata);
        try {
            if (shouldDigest(metadata)) {
                this.digester.digest(tikaInputStream, metadata, parseContext);
            }
            super.parse(tikaInputStream, contentHandler, metadata, parseContext);
            temporaryResources.dispose();
        } catch (Throwable th) {
            temporaryResources.dispose();
            throw th;
        }
    }
}
