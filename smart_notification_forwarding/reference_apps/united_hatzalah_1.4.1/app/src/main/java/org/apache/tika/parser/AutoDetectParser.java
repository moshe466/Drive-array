package org.apache.tika.parser;

import java.io.InputStream;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.extractor.EmbeddedDocumentExtractor;
import org.apache.tika.extractor.EmbeddedDocumentExtractorFactory;
import org.apache.tika.extractor.ParsingEmbeddedDocumentExtractorFactory;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.parser.RecursiveParserWrapper;
import org.apache.tika.sax.SecureContentHandler;
import org.xml.sax.ContentHandler;

/* loaded from: classes.dex */
public class AutoDetectParser extends CompositeParser {
    private static final long serialVersionUID = 6110455808615143122L;
    private AutoDetectParserConfig autoDetectParserConfig;
    private Detector detector;

    public AutoDetectParser() {
        this(TikaConfig.getDefaultConfig());
    }

    private static Parser buildFallbackParser(TikaConfig tikaConfig) {
        Parser emptyParser;
        Parser parser = tikaConfig.getParser();
        if (parser instanceof DefaultParser) {
            emptyParser = ((DefaultParser) parser).getFallback();
        } else {
            emptyParser = new EmptyParser();
        }
        if (tikaConfig.getAutoDetectParserConfig().getDigesterFactory() == null) {
            return emptyParser;
        }
        return new DigestingParser(emptyParser, tikaConfig.getAutoDetectParserConfig().getDigesterFactory().build(), tikaConfig.getAutoDetectParserConfig().getDigesterFactory().isSkipContainerDocument());
    }

    private SecureContentHandler createSecureContentHandler(ContentHandler contentHandler, TikaInputStream tikaInputStream, AutoDetectParserConfig autoDetectParserConfig) {
        SecureContentHandler secureContentHandler = new SecureContentHandler(contentHandler, tikaInputStream);
        if (autoDetectParserConfig != null) {
            if (autoDetectParserConfig.getOutputThreshold() != null) {
                secureContentHandler.setOutputThreshold(autoDetectParserConfig.getOutputThreshold().longValue());
            }
            if (autoDetectParserConfig.getMaximumCompressionRatio() != null) {
                secureContentHandler.setMaximumCompressionRatio(autoDetectParserConfig.getMaximumCompressionRatio().longValue());
            }
            if (autoDetectParserConfig.getMaximumDepth() != null) {
                secureContentHandler.setMaximumDepth(autoDetectParserConfig.getMaximumDepth().intValue());
            }
            if (autoDetectParserConfig.getMaximumPackageEntryDepth() != null) {
                secureContentHandler.setMaximumPackageEntryDepth(autoDetectParserConfig.getMaximumPackageEntryDepth().intValue());
            }
        }
        return secureContentHandler;
    }

    private ContentHandler decorateHandler(ContentHandler contentHandler, Metadata metadata, ParseContext parseContext, AutoDetectParserConfig autoDetectParserConfig) {
        if (parseContext.get(RecursiveParserWrapper.RecursivelySecureContentHandler.class) != null) {
            return autoDetectParserConfig.getContentHandlerDecoratorFactory().decorate(contentHandler, metadata, parseContext);
        }
        ParseRecord parseRecord = (ParseRecord) parseContext.get(ParseRecord.class);
        if (parseRecord != null && parseRecord.getDepth() != 0) {
            return contentHandler;
        }
        return autoDetectParserConfig.getContentHandlerDecoratorFactory().decorate(contentHandler, metadata, parseContext);
    }

    private static Parser getParser(TikaConfig tikaConfig) {
        if (tikaConfig.getAutoDetectParserConfig().getDigesterFactory() == null) {
            return tikaConfig.getParser();
        }
        return new DigestingParser(tikaConfig.getParser(), tikaConfig.getAutoDetectParserConfig().getDigesterFactory().build(), tikaConfig.getAutoDetectParserConfig().getDigesterFactory().isSkipContainerDocument());
    }

    private void initializeEmbeddedDocumentExtractor(Metadata metadata, ParseContext parseContext) {
        if (parseContext.get(EmbeddedDocumentExtractor.class) != null) {
            return;
        }
        if (((Parser) parseContext.get(Parser.class)) == null) {
            parseContext.set(Parser.class, this);
        }
        EmbeddedDocumentExtractorFactory embeddedDocumentExtractorFactory = this.autoDetectParserConfig.getEmbeddedDocumentExtractorFactory();
        if (embeddedDocumentExtractorFactory == null) {
            embeddedDocumentExtractorFactory = new ParsingEmbeddedDocumentExtractorFactory();
        }
        parseContext.set(EmbeddedDocumentExtractor.class, embeddedDocumentExtractorFactory.newInstance(metadata, parseContext));
    }

    private void maybeSpool(TikaInputStream tikaInputStream, AutoDetectParserConfig autoDetectParserConfig, Metadata metadata) {
        if (!tikaInputStream.hasFile() && autoDetectParserConfig.getSpoolToDisk() != null) {
            if (autoDetectParserConfig.getSpoolToDisk().longValue() == 0) {
                tikaInputStream.getPath();
                metadata.set(HttpHeaders.CONTENT_LENGTH, Long.toString(tikaInputStream.getLength()));
            } else if (metadata.get(HttpHeaders.CONTENT_LENGTH) != null) {
                try {
                    if (Long.parseLong(metadata.get(HttpHeaders.CONTENT_LENGTH)) > autoDetectParserConfig.getSpoolToDisk().longValue()) {
                        tikaInputStream.getPath();
                        metadata.set(HttpHeaders.CONTENT_LENGTH, Long.toString(tikaInputStream.getLength()));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
    }

    public AutoDetectParserConfig getAutoDetectParserConfig() {
        return this.autoDetectParserConfig;
    }

    public Detector getDetector() {
        return this.detector;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x001a, B:8:0x0031, B:11:0x004b, B:13:0x0051, B:15:0x0059, B:17:0x0064, B:18:0x0068, B:19:0x006f, B:21:0x0070, B:23:0x0078, B:24:0x0080, B:26:0x0083, B:31:0x008b, B:32:0x008e, B:34:0x0042), top: B:5:0x001a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x001a, B:8:0x0031, B:11:0x004b, B:13:0x0051, B:15:0x0059, B:17:0x0064, B:18:0x0068, B:19:0x006f, B:21:0x0070, B:23:0x0078, B:24:0x0080, B:26:0x0083, B:31:0x008b, B:32:0x008e, B:34:0x0042), top: B:5:0x001a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x001a, B:8:0x0031, B:11:0x004b, B:13:0x0051, B:15:0x0059, B:17:0x0064, B:18:0x0068, B:19:0x006f, B:21:0x0070, B:23:0x0078, B:24:0x0080, B:26:0x0083, B:31:0x008b, B:32:0x008e, B:34:0x0042), top: B:5:0x001a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    @Override // org.apache.tika.parser.CompositeParser, org.apache.tika.parser.Parser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parse(java.io.InputStream r5, org.xml.sax.ContentHandler r6, org.apache.tika.metadata.Metadata r7, org.apache.tika.parser.ParseContext r8) {
        /*
            r4 = this;
            org.apache.tika.parser.AutoDetectParserConfig r0 = r4.autoDetectParserConfig
            org.apache.tika.metadata.writefilter.MetadataWriteFilterFactory r0 = r0.getMetadataWriteFilterFactory()
            if (r0 == 0) goto L15
            org.apache.tika.parser.AutoDetectParserConfig r0 = r4.autoDetectParserConfig
            org.apache.tika.metadata.writefilter.MetadataWriteFilterFactory r0 = r0.getMetadataWriteFilterFactory()
            org.apache.tika.metadata.writefilter.MetadataWriteFilter r0 = r0.newInstance()
            r7.setMetadataWriteFilter(r0)
        L15:
            org.apache.tika.io.TemporaryResources r0 = new org.apache.tika.io.TemporaryResources
            r0.<init>()
            org.apache.tika.io.TikaInputStream r5 = org.apache.tika.io.TikaInputStream.get(r5, r0, r7)     // Catch: java.lang.Throwable -> L40
            org.apache.tika.parser.AutoDetectParserConfig r1 = r4.autoDetectParserConfig     // Catch: java.lang.Throwable -> L40
            r4.maybeSpool(r5, r1, r7)     // Catch: java.lang.Throwable -> L40
            org.apache.tika.detect.Detector r1 = r4.detector     // Catch: java.lang.Throwable -> L40
            org.apache.tika.mime.MediaType r1 = r1.detect(r5, r7)     // Catch: java.lang.Throwable -> L40
            org.apache.tika.metadata.Property r2 = org.apache.tika.metadata.TikaCoreProperties.CONTENT_TYPE_PARSER_OVERRIDE     // Catch: java.lang.Throwable -> L40
            java.lang.String r3 = r7.get(r2)     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto L42
            java.lang.String r2 = r7.get(r2)     // Catch: java.lang.Throwable -> L40
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L40
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L40
            if (r2 != 0) goto L4b
            goto L42
        L40:
            r5 = move-exception
            goto L8f
        L42:
            java.lang.String r2 = "Content-Type"
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L40
            r7.set(r2, r1)     // Catch: java.lang.Throwable -> L40
        L4b:
            java.lang.Object r1 = r5.getOpenContainer()     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L70
            org.apache.tika.parser.AutoDetectParserConfig r1 = r4.autoDetectParserConfig     // Catch: java.lang.Throwable -> L40
            boolean r1 = r1.getThrowOnZeroBytes()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L70
            r1 = 1
            r5.mark(r1)     // Catch: java.lang.Throwable -> L40
            int r1 = r5.read()     // Catch: java.lang.Throwable -> L40
            r2 = -1
            if (r1 == r2) goto L68
            r5.reset()     // Catch: java.lang.Throwable -> L40
            goto L70
        L68:
            org.apache.tika.exception.ZeroByteFileException r5 = new org.apache.tika.exception.ZeroByteFileException     // Catch: java.lang.Throwable -> L40
            java.lang.String r6 = "InputStream must have > 0 bytes"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L40
            throw r5     // Catch: java.lang.Throwable -> L40
        L70:
            org.apache.tika.parser.AutoDetectParserConfig r1 = r4.autoDetectParserConfig     // Catch: java.lang.Throwable -> L40
            org.xml.sax.ContentHandler r6 = r4.decorateHandler(r6, r7, r8, r1)     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L7f
            org.apache.tika.parser.AutoDetectParserConfig r1 = r4.autoDetectParserConfig     // Catch: java.lang.Throwable -> L40
            org.apache.tika.sax.SecureContentHandler r6 = r4.createSecureContentHandler(r6, r5, r1)     // Catch: java.lang.Throwable -> L40
            goto L80
        L7f:
            r6 = 0
        L80:
            r4.initializeEmbeddedDocumentExtractor(r7, r8)     // Catch: java.lang.Throwable -> L40
            super.parse(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L40 org.xml.sax.SAXException -> L8a
            r0.dispose()
            return
        L8a:
            r5 = move-exception
            r6.throwIfCauseOf(r5)     // Catch: java.lang.Throwable -> L40
            throw r5     // Catch: java.lang.Throwable -> L40
        L8f:
            r0.dispose()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.AutoDetectParser.parse(java.io.InputStream, org.xml.sax.ContentHandler, org.apache.tika.metadata.Metadata, org.apache.tika.parser.ParseContext):void");
    }

    public void setAutoDetectParserConfig(AutoDetectParserConfig autoDetectParserConfig) {
        this.autoDetectParserConfig = autoDetectParserConfig;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    public AutoDetectParser(Detector detector) {
        this(TikaConfig.getDefaultConfig());
        setDetector(detector);
    }

    public AutoDetectParser(Parser... parserArr) {
        this(new DefaultDetector(), parserArr);
    }

    public AutoDetectParser(Detector detector, Parser... parserArr) {
        super(MediaTypeRegistry.getDefaultRegistry(), parserArr);
        setDetector(detector);
        setAutoDetectParserConfig(AutoDetectParserConfig.DEFAULT);
    }

    public AutoDetectParser(TikaConfig tikaConfig) {
        super(tikaConfig.getMediaTypeRegistry(), getParser(tikaConfig));
        setFallback(buildFallbackParser(tikaConfig));
        setDetector(tikaConfig.getDetector());
        setAutoDetectParserConfig(tikaConfig.getAutoDetectParserConfig());
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata) {
        ParseContext parseContext = new ParseContext();
        parseContext.set(Parser.class, this);
        parse(inputStream, contentHandler, metadata, parseContext);
    }
}
