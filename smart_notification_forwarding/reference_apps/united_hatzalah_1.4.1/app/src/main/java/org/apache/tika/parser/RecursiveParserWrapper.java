package org.apache.tika.parser;

import F0.AbstractC0008a;
import com.google.firebase.sessions.settings.RemoteSettings;
import e3.d;
import java.io.InputStream;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.tika.exception.CorruptedFileException;
import org.apache.tika.exception.EncryptedDocumentException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.exception.WriteLimitReachedException;
import org.apache.tika.exception.ZeroByteFileException;
import org.apache.tika.extractor.ParentContentHandler;
import org.apache.tika.io.FilenameUtils;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.sax.AbstractRecursiveParserWrapperHandler;
import org.apache.tika.sax.SecureContentHandler;
import org.apache.tika.utils.ParserUtils;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class RecursiveParserWrapper extends ParserDecorator {
    private static final long serialVersionUID = 9086536568120690938L;
    private final boolean catchEmbeddedExceptions;
    private final boolean inlineContent;

    /* loaded from: classes.dex */
    public class EmbeddedParserDecorator extends StatefulParser {
        private static final long serialVersionUID = 207648200464263337L;
        private String embeddedIdPath;
        private String location;
        private final ParserState parserState;

        public /* synthetic */ EmbeddedParserDecorator(RecursiveParserWrapper recursiveParserWrapper, Parser parser, ParserState parserState) {
            this(parser, RemoteSettings.FORWARD_SLASH_STRING, RemoteSettings.FORWARD_SLASH_STRING, parserState);
        }

        @Override // org.apache.tika.parser.ParserDecorator, org.apache.tika.parser.Parser
        public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) {
            String str;
            TemporaryResources temporaryResources;
            if (!this.parserState.recursiveParserWrapperHandler.hasHitMaximumEmbeddedResources()) {
                String n4 = AbstractC0008a.n(this.location, RecursiveParserWrapper.getResourceName(metadata, this.parserState.unknownCount));
                metadata.add(TikaCoreProperties.EMBEDDED_RESOURCE_PATH, n4);
                if (this.embeddedIdPath.equals(RemoteSettings.FORWARD_SLASH_STRING)) {
                    String str2 = this.embeddedIdPath;
                    ParserState parserState = this.parserState;
                    int i = parserState.embeddedCount + 1;
                    parserState.embeddedCount = i;
                    str = str2 + i;
                } else {
                    String str3 = this.embeddedIdPath;
                    ParserState parserState2 = this.parserState;
                    int i3 = parserState2.embeddedCount + 1;
                    parserState2.embeddedCount = i3;
                    str = str3 + RemoteSettings.FORWARD_SLASH_STRING + i3;
                }
                String str4 = str;
                metadata.add(TikaCoreProperties.EMBEDDED_ID_PATH, str4);
                metadata.set(TikaCoreProperties.EMBEDDED_ID, this.parserState.embeddedCount);
                ContentHandler newContentHandler = this.parserState.recursiveParserWrapperHandler.getNewContentHandler();
                this.parserState.recursiveParserWrapperHandler.startEmbeddedDocument(newContentHandler, metadata);
                Parser parser = (Parser) parseContext.get(Parser.class);
                parseContext.set(Parser.class, new EmbeddedParserDecorator(getWrappedParser(), n4, str4, this.parserState));
                long currentTimeMillis = System.currentTimeMillis();
                RecursivelySecureContentHandler recursivelySecureContentHandler = (RecursivelySecureContentHandler) parseContext.get(RecursivelySecureContentHandler.class);
                ParentContentHandler parentContentHandler = (ParentContentHandler) parseContext.get(ParentContentHandler.class);
                parseContext.set(ParentContentHandler.class, new ParentContentHandler(recursivelySecureContentHandler));
                TikaInputStream cast = TikaInputStream.cast(inputStream);
                if (cast == null) {
                    TemporaryResources temporaryResources2 = new TemporaryResources();
                    temporaryResources = temporaryResources2;
                    cast = TikaInputStream.get(new d(inputStream), temporaryResources2, metadata);
                } else {
                    temporaryResources = null;
                }
                TikaInputStream tikaInputStream = cast;
                try {
                    try {
                        try {
                            super.parse(inputStream, new RecursivelySecureContentHandler(newContentHandler, tikaInputStream, recursivelySecureContentHandler.handlerCounter, recursivelySecureContentHandler.throwOnWriteLimitReached, parseContext), metadata, parseContext);
                            parseContext.set(Parser.class, parser);
                            parseContext.set(RecursivelySecureContentHandler.class, recursivelySecureContentHandler);
                            parseContext.set(ParentContentHandler.class, parentContentHandler);
                            metadata.set(TikaCoreProperties.PARSE_TIME_MILLIS, Long.toString(System.currentTimeMillis() - currentTimeMillis));
                            this.parserState.recursiveParserWrapperHandler.endEmbeddedDocument(newContentHandler, metadata);
                            if (temporaryResources != null) {
                                tikaInputStream.close();
                            }
                        } catch (SAXException e4) {
                            if (!WriteLimitReachedException.isWriteLimitReached(e4)) {
                                if (RecursiveParserWrapper.this.catchEmbeddedExceptions) {
                                    ParserUtils.recordParserFailure(this, e4, metadata);
                                    parseContext.set(Parser.class, parser);
                                    parseContext.set(RecursivelySecureContentHandler.class, recursivelySecureContentHandler);
                                    parseContext.set(ParentContentHandler.class, parentContentHandler);
                                    metadata.set(TikaCoreProperties.PARSE_TIME_MILLIS, Long.toString(System.currentTimeMillis() - currentTimeMillis));
                                    this.parserState.recursiveParserWrapperHandler.endEmbeddedDocument(newContentHandler, metadata);
                                    if (temporaryResources == null) {
                                        return;
                                    }
                                    tikaInputStream.close();
                                }
                                throw e4;
                            }
                            metadata.add(TikaCoreProperties.WRITE_LIMIT_REACHED, "true");
                            throw e4;
                        }
                    } catch (CorruptedFileException e5) {
                        throw e5;
                    } catch (TikaException e6) {
                        if (e6 instanceof EncryptedDocumentException) {
                            metadata.set(TikaCoreProperties.IS_ENCRYPTED, true);
                        }
                        if (parseContext.get(ZeroByteFileException.IgnoreZeroByteFileException.class) == null || !(e6 instanceof ZeroByteFileException)) {
                            if (RecursiveParserWrapper.this.catchEmbeddedExceptions) {
                                ParserUtils.recordParserFailure(this, e6, metadata);
                            } else {
                                throw e6;
                            }
                        }
                        parseContext.set(Parser.class, parser);
                        parseContext.set(RecursivelySecureContentHandler.class, recursivelySecureContentHandler);
                        parseContext.set(ParentContentHandler.class, parentContentHandler);
                        metadata.set(TikaCoreProperties.PARSE_TIME_MILLIS, Long.toString(System.currentTimeMillis() - currentTimeMillis));
                        this.parserState.recursiveParserWrapperHandler.endEmbeddedDocument(newContentHandler, metadata);
                        if (temporaryResources == null) {
                            return;
                        }
                        tikaInputStream.close();
                    }
                } catch (Throwable th) {
                    parseContext.set(Parser.class, parser);
                    parseContext.set(RecursivelySecureContentHandler.class, recursivelySecureContentHandler);
                    parseContext.set(ParentContentHandler.class, parentContentHandler);
                    metadata.set(TikaCoreProperties.PARSE_TIME_MILLIS, Long.toString(System.currentTimeMillis() - currentTimeMillis));
                    this.parserState.recursiveParserWrapperHandler.endEmbeddedDocument(newContentHandler, metadata);
                    if (temporaryResources != null) {
                        tikaInputStream.close();
                    }
                    throw th;
                }
            }
        }

        private EmbeddedParserDecorator(Parser parser, String str, String str2, ParserState parserState) {
            super(parser);
            this.embeddedIdPath = null;
            this.location = str;
            if (!str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                this.location = AbstractC0008a.n(this.location, RemoteSettings.FORWARD_SLASH_STRING);
            }
            this.embeddedIdPath = str2;
            this.parserState = parserState;
        }
    }

    /* loaded from: classes.dex */
    public static class ParserState {
        private int embeddedCount;
        private final AbstractRecursiveParserWrapperHandler recursiveParserWrapperHandler;
        private AtomicInteger unknownCount;

        public /* synthetic */ ParserState(AbstractRecursiveParserWrapperHandler abstractRecursiveParserWrapperHandler, int i) {
            this(abstractRecursiveParserWrapperHandler);
        }

        private ParserState(AbstractRecursiveParserWrapperHandler abstractRecursiveParserWrapperHandler) {
            this.unknownCount = new AtomicInteger(0);
            this.embeddedCount = 0;
            this.recursiveParserWrapperHandler = abstractRecursiveParserWrapperHandler;
        }
    }

    /* loaded from: classes.dex */
    public static class RecursivelySecureContentHandler extends SecureContentHandler {
        private static AtomicInteger COUNTER = new AtomicInteger();
        private final ContentHandler handler;
        private final SecureHandlerCounter handlerCounter;
        private final int id;
        private final ParseContext parseContext;
        private final boolean throwOnWriteLimitReached;

        public RecursivelySecureContentHandler(ContentHandler contentHandler, TikaInputStream tikaInputStream, SecureHandlerCounter secureHandlerCounter, boolean z3, ParseContext parseContext) {
            super(contentHandler, tikaInputStream);
            this.id = COUNTER.getAndIncrement();
            this.handler = contentHandler;
            this.handlerCounter = secureHandlerCounter;
            this.throwOnWriteLimitReached = z3;
            this.parseContext = parseContext;
        }

        private void handleWriteLimitReached() {
            this.handlerCounter.writeLimitReached = true;
            if (!this.throwOnWriteLimitReached) {
                ParseRecord parseRecord = (ParseRecord) this.parseContext.get(ParseRecord.class);
                if (parseRecord != null) {
                    parseRecord.setWriteLimitReached(true);
                    return;
                }
                return;
            }
            throw new WriteLimitReachedException(this.handlerCounter.totalWriteLimit);
        }

        @Override // org.apache.tika.sax.SecureContentHandler, org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i3) {
            if (!this.handlerCounter.writeLimitReached) {
                if (this.handlerCounter.totalWriteLimit < 0) {
                    super.characters(cArr, i, i3);
                    return;
                }
                int available = this.handlerCounter.getAvailable(i3);
                super.characters(cArr, i, available);
                this.handlerCounter.addChars(available);
                if (available < i3) {
                    handleWriteLimitReached();
                }
            }
        }

        @Override // org.apache.tika.sax.SecureContentHandler, org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            this.handler.endElement(str, str2, str3);
        }

        @Override // org.apache.tika.sax.SecureContentHandler, org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i3) {
            if (!this.handlerCounter.writeLimitReached) {
                if (this.handlerCounter.totalWriteLimit < 0) {
                    super.ignorableWhitespace(cArr, i, i3);
                    return;
                }
                int available = this.handlerCounter.getAvailable(i3);
                super.ignorableWhitespace(cArr, i, available);
                this.handlerCounter.addChars(available);
                if (available < i3) {
                    handleWriteLimitReached();
                }
            }
        }

        @Override // org.apache.tika.sax.SecureContentHandler, org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            this.handler.startElement(str, str2, str3, attributes);
        }
    }

    /* loaded from: classes.dex */
    public static class SecureHandlerCounter {
        private int totalChars;
        private final int totalWriteLimit;
        private boolean writeLimitReached;

        public /* synthetic */ SecureHandlerCounter(int i, int i3) {
            this(i);
        }

        public void addChars(int i) {
            this.totalChars += i;
        }

        public int getAvailable(int i) {
            return Math.min(this.totalWriteLimit - this.totalChars, i);
        }

        private SecureHandlerCounter(int i) {
            this.writeLimitReached = false;
            this.totalChars = 0;
            this.totalWriteLimit = i;
        }
    }

    public RecursiveParserWrapper(Parser parser) {
        this(parser, true);
    }

    public static String getResourceName(Metadata metadata, AtomicInteger atomicInteger) {
        String c4;
        if (metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY) != null) {
            c4 = metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY);
        } else if (metadata.get(TikaCoreProperties.EMBEDDED_RELATIONSHIP_ID) != null) {
            c4 = metadata.get(TikaCoreProperties.EMBEDDED_RELATIONSHIP_ID);
        } else {
            Property property = TikaCoreProperties.VERSION_NUMBER;
            if (metadata.get(property) != null) {
                c4 = e0.a.d("version-number-", metadata.get(property));
            } else {
                c4 = e0.a.c(atomicInteger.incrementAndGet(), "embedded-");
            }
        }
        return FilenameUtils.getName(c4);
    }

    @Override // org.apache.tika.parser.ParserDecorator, org.apache.tika.parser.Parser
    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return getWrappedParser().getSupportedTypes(parseContext);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|(2:5|(10:7|8|9|10|11|12|13|14|15|16))|37|8|9|10|11|12|13|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0099, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a1, code lost:
    
        if ((r0 instanceof org.apache.tika.exception.EncryptedDocumentException) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a3, code lost:
    
        r19.set(org.apache.tika.metadata.TikaCoreProperties.IS_ENCRYPTED, "true");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
    
        if (org.apache.tika.exception.WriteLimitReachedException.isWriteLimitReached(r0) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b1, code lost:
    
        r19.set(org.apache.tika.metadata.TikaCoreProperties.WRITE_LIMIT_REACHED, "true");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b7, code lost:
    
        r19.add(org.apache.tika.metadata.TikaCoreProperties.CONTAINER_EXCEPTION, org.apache.tika.utils.ExceptionUtils.getFilteredStackTrace(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c0, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c1, code lost:
    
        r13.dispose();
        r19.set(org.apache.tika.metadata.TikaCoreProperties.PARSE_TIME_MILLIS, java.lang.Long.toString(java.lang.System.currentTimeMillis() - r11));
        r9.recursiveParserWrapperHandler.endDocument(r3, r19);
        r9.recursiveParserWrapperHandler.endDocument();
        r20.set(org.apache.tika.parser.RecursiveParserWrapper.RecursivelySecureContentHandler.class, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e3, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
    
        r3 = r4;
     */
    @Override // org.apache.tika.parser.ParserDecorator, org.apache.tika.parser.Parser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parse(java.io.InputStream r17, org.xml.sax.ContentHandler r18, org.apache.tika.metadata.Metadata r19, org.apache.tika.parser.ParseContext r20) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.RecursiveParserWrapper.parse(java.io.InputStream, org.xml.sax.ContentHandler, org.apache.tika.metadata.Metadata, org.apache.tika.parser.ParseContext):void");
    }

    public RecursiveParserWrapper(Parser parser, boolean z3) {
        super(parser);
        this.inlineContent = false;
        this.catchEmbeddedExceptions = z3;
    }
}
