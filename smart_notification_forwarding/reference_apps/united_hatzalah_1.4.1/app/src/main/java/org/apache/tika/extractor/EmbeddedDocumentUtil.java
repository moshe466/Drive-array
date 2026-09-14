package org.apache.tika.extractor;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Iterator;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.CompositeParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParserDecorator;
import org.apache.tika.parser.PasswordProvider;
import org.apache.tika.parser.StatefulParser;
import org.apache.tika.utils.ExceptionUtils;
import org.xml.sax.ContentHandler;

/* loaded from: classes.dex */
public class EmbeddedDocumentUtil implements Serializable {
    private final ParseContext context;
    private Detector detector;
    private final EmbeddedDocumentExtractor embeddedDocumentExtractor;
    private MimeTypes mimeTypes;
    private TikaConfig tikaConfig;

    public EmbeddedDocumentUtil(ParseContext parseContext) {
        this.context = parseContext;
        this.embeddedDocumentExtractor = getEmbeddedDocumentExtractor(parseContext);
    }

    private static boolean equals(Parser parser, Class cls) {
        if (parser == null) {
            return false;
        }
        return parser.getClass().equals(cls);
    }

    private static Parser findInComposite(CompositeParser compositeParser, Class cls, ParseContext parseContext) {
        Iterator<Parser> it = compositeParser.getAllComponentParsers().iterator();
        while (it.hasNext()) {
            Parser next = it.next();
            if (equals(next, cls)) {
                return next;
            }
            if (next instanceof ParserDecorator) {
                next = findInDecorated((ParserDecorator) next, cls);
            }
            if (equals(next, cls)) {
                return next;
            }
            if (next instanceof CompositeParser) {
                next = findInComposite((CompositeParser) next, cls, parseContext);
            }
            if (equals(next, cls)) {
                return next;
            }
        }
        return null;
    }

    private static Parser findInDecorated(ParserDecorator parserDecorator, Class cls) {
        Parser wrappedParser = parserDecorator.getWrappedParser();
        if (!equals(wrappedParser, cls) && (wrappedParser instanceof ParserDecorator)) {
            return findInDecorated((ParserDecorator) wrappedParser, cls);
        }
        return wrappedParser;
    }

    public static EmbeddedDocumentExtractor getEmbeddedDocumentExtractor(ParseContext parseContext) {
        EmbeddedDocumentExtractor embeddedDocumentExtractor = (EmbeddedDocumentExtractor) parseContext.get(EmbeddedDocumentExtractor.class);
        if (embeddedDocumentExtractor != null) {
            return embeddedDocumentExtractor;
        }
        if (((Parser) parseContext.get(Parser.class)) == null) {
            TikaConfig tikaConfig = (TikaConfig) parseContext.get(TikaConfig.class);
            if (tikaConfig == null) {
                parseContext.set(Parser.class, new AutoDetectParser());
            } else {
                parseContext.set(Parser.class, new AutoDetectParser(tikaConfig));
            }
        }
        ParsingEmbeddedDocumentExtractor parsingEmbeddedDocumentExtractor = new ParsingEmbeddedDocumentExtractor(parseContext);
        parseContext.set(EmbeddedDocumentExtractor.class, parsingEmbeddedDocumentExtractor);
        return parsingEmbeddedDocumentExtractor;
    }

    public static Parser getStatelessParser(ParseContext parseContext) {
        Parser parser = (Parser) parseContext.get(Parser.class);
        if (parser == null) {
            return null;
        }
        if (parser instanceof StatefulParser) {
            return ((StatefulParser) parser).getWrappedParser();
        }
        return parser;
    }

    public static void recordEmbeddedStreamException(Throwable th, Metadata metadata) {
        metadata.add(TikaCoreProperties.TIKA_META_EXCEPTION_EMBEDDED_STREAM, ExceptionUtils.getFilteredStackTrace(th));
    }

    public static void recordException(Throwable th, Metadata metadata) {
        metadata.add(TikaCoreProperties.TIKA_META_EXCEPTION_WARNING, ExceptionUtils.getFilteredStackTrace(th));
    }

    public static Parser tryToFindExistingLeafParser(Class cls, ParseContext parseContext) {
        Parser parser;
        Parser parser2 = (Parser) parseContext.get(Parser.class);
        if (equals(parser2, cls)) {
            return parser2;
        }
        if (parser2 != null) {
            if (parser2 instanceof ParserDecorator) {
                parser2 = findInDecorated((ParserDecorator) parser2, cls);
            }
            if (equals(parser2, cls)) {
                return parser2;
            }
            if (parser2 instanceof CompositeParser) {
                parser = findInComposite((CompositeParser) parser2, cls, parseContext);
                if (parser != null || !equals(parser, cls)) {
                    return null;
                }
                return parser;
            }
        }
        parser = null;
        if (parser != null) {
        }
        return null;
    }

    public Detector getDetector() {
        Detector detector = (Detector) this.context.get(Detector.class);
        if (detector != null) {
            return detector;
        }
        Detector detector2 = this.detector;
        if (detector2 != null) {
            return detector2;
        }
        Detector detector3 = getTikaConfig().getDetector();
        this.detector = detector3;
        return detector3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0015 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getExtension(org.apache.tika.io.TikaInputStream r6, org.apache.tika.metadata.Metadata r7) {
        /*
            r5 = this;
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = r7.get(r0)
            org.apache.tika.mime.MimeTypes r2 = r5.getMimeTypes()
            if (r1 == 0) goto L11
            org.apache.tika.mime.MimeType r1 = r2.forName(r1)     // Catch: org.apache.tika.mime.MimeTypeException -> L11
            goto L12
        L11:
            r1 = 0
        L12:
            r3 = 0
            if (r1 != 0) goto L29
            org.apache.tika.detect.Detector r4 = r5.getDetector()     // Catch: java.lang.Throwable -> L29
            org.apache.tika.mime.MediaType r4 = r4.detect(r6, r7)     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L29
            org.apache.tika.mime.MimeType r1 = r2.forName(r4)     // Catch: java.lang.Throwable -> L29
            r3 = 1
            r6.reset()     // Catch: java.lang.Throwable -> L29
        L29:
            if (r1 == 0) goto L39
            if (r3 == 0) goto L34
            java.lang.String r6 = r1.toString()
            r7.set(r0, r6)
        L34:
            java.lang.String r6 = r1.getExtension()
            return r6
        L39:
            java.lang.String r6 = ".bin"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.extractor.EmbeddedDocumentUtil.getExtension(org.apache.tika.io.TikaInputStream, org.apache.tika.metadata.Metadata):java.lang.String");
    }

    public MimeTypes getMimeTypes() {
        MimeTypes mimeTypes = (MimeTypes) this.context.get(MimeTypes.class);
        if (mimeTypes != null) {
            return mimeTypes;
        }
        MimeTypes mimeTypes2 = this.mimeTypes;
        if (mimeTypes2 != null) {
            return mimeTypes2;
        }
        MimeTypes mimeRepository = getTikaConfig().getMimeRepository();
        this.mimeTypes = mimeRepository;
        return mimeRepository;
    }

    public PasswordProvider getPasswordProvider() {
        return (PasswordProvider) this.context.get(PasswordProvider.class);
    }

    public TikaConfig getTikaConfig() {
        if (this.tikaConfig == null) {
            TikaConfig tikaConfig = (TikaConfig) this.context.get(TikaConfig.class);
            this.tikaConfig = tikaConfig;
            if (tikaConfig == null) {
                this.tikaConfig = TikaConfig.getDefaultConfig();
            }
        }
        return this.tikaConfig;
    }

    public void parseEmbedded(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, boolean z3) {
        this.embeddedDocumentExtractor.parseEmbedded(inputStream, contentHandler, metadata, z3);
    }

    public boolean shouldParseEmbedded(Metadata metadata) {
        return getEmbeddedDocumentExtractor().shouldParseEmbedded(metadata);
    }

    private EmbeddedDocumentExtractor getEmbeddedDocumentExtractor() {
        return this.embeddedDocumentExtractor;
    }
}
