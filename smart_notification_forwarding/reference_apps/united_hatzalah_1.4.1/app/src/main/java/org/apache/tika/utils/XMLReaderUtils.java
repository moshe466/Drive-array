package org.apache.tika.utils;

import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLResolver;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.OfflineContentHandler;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class XMLReaderUtils implements Serializable {
    public static final int DEFAULT_MAX_ENTITY_EXPANSIONS = 20;
    public static final int DEFAULT_POOL_SIZE = 10;
    private static final String JAXP_ENTITY_EXPANSION_LIMIT_KEY = "jdk.xml.entityExpansionLimit";
    private static final String XERCES_SECURITY_MANAGER = "org.apache.xerces.util.SecurityManager";
    private static final String XERCES_SECURITY_MANAGER_PROPERTY = "http://apache.org/xml/properties/security-manager";
    private static final long serialVersionUID = 6110455808615143122L;
    private static final n3.b LOG = n3.d.b(XMLReaderUtils.class);
    private static final AtomicBoolean HAS_WARNED_STAX = new AtomicBoolean(false);
    private static final ContentHandler IGNORING_CONTENT_HANDLER = new DefaultHandler();
    private static final DTDHandler IGNORING_DTD_HANDLER = new DTDHandler() { // from class: org.apache.tika.utils.XMLReaderUtils.1
        @Override // org.xml.sax.DTDHandler
        public void notationDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.DTDHandler
        public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        }
    };
    private static final ErrorHandler IGNORING_ERROR_HANDLER = new ErrorHandler() { // from class: org.apache.tika.utils.XMLReaderUtils.2
        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) {
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) {
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) {
        }
    };
    private static final ReentrantReadWriteLock SAX_POOL_LOCK = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock DOM_POOL_LOCK = new ReentrantReadWriteLock();
    private static final AtomicInteger POOL_GENERATION = new AtomicInteger();
    private static final EntityResolver IGNORING_SAX_ENTITY_RESOLVER = new Object();
    private static final XMLResolver IGNORING_STAX_ENTITY_RESOLVER = new Object();
    private static int POOL_SIZE = 10;
    private static long LAST_LOG = -1;
    private static volatile int MAX_ENTITY_EXPANSIONS = determineMaxEntityExpansions();
    private static ArrayBlockingQueue<PoolSAXParser> SAX_PARSERS = new ArrayBlockingQueue<>(POOL_SIZE);
    private static ArrayBlockingQueue<PoolDOMBuilder> DOM_BUILDERS = new ArrayBlockingQueue<>(POOL_SIZE);

    /* loaded from: classes.dex */
    public static class BuiltInPoolSAXParser extends PoolSAXParser {
        public BuiltInPoolSAXParser(int i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        @Override // org.apache.tika.utils.XMLReaderUtils.PoolSAXParser
        public void reset() {
            this.saxParser.reset();
            try {
                XMLReaderUtils.clearReader(this.saxParser.getXMLReader());
            } catch (SAXException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PoolDOMBuilder {
        private final DocumentBuilder documentBuilder;
        private final int poolGeneration;

        public PoolDOMBuilder(int i, DocumentBuilder documentBuilder) {
            this.poolGeneration = i;
            this.documentBuilder = documentBuilder;
        }

        public DocumentBuilder getDocumentBuilder() {
            return this.documentBuilder;
        }

        public int getPoolGeneration() {
            return this.poolGeneration;
        }

        public void reset() {
            this.documentBuilder.reset();
            this.documentBuilder.setEntityResolver(XMLReaderUtils.IGNORING_SAX_ENTITY_RESOLVER);
            this.documentBuilder.setErrorHandler(null);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PoolSAXParser {
        final int poolGeneration;
        final SAXParser saxParser;

        public PoolSAXParser(int i, SAXParser sAXParser) {
            this.poolGeneration = i;
            this.saxParser = sAXParser;
        }

        public int getGeneration() {
            return this.poolGeneration;
        }

        public SAXParser getSAXParser() {
            return this.saxParser;
        }

        public abstract void reset();
    }

    /* loaded from: classes.dex */
    public static class UnrecognizedPoolSAXParser extends PoolSAXParser {
        public UnrecognizedPoolSAXParser(int i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        @Override // org.apache.tika.utils.XMLReaderUtils.PoolSAXParser
        public void reset() {
            try {
                this.saxParser.reset();
            } catch (UnsupportedOperationException unused) {
            }
            try {
                XMLReaderUtils.clearReader(this.saxParser.getXMLReader());
            } catch (SAXException unused2) {
            }
            XMLReaderUtils.trySetXercesSecurityManager(this.saxParser);
        }
    }

    /* loaded from: classes.dex */
    public static class Xerces2PoolSAXParser extends PoolSAXParser {
        public Xerces2PoolSAXParser(int i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        @Override // org.apache.tika.utils.XMLReaderUtils.PoolSAXParser
        public void reset() {
            try {
                Object property = this.saxParser.getProperty(XMLReaderUtils.XERCES_SECURITY_MANAGER_PROPERTY);
                this.saxParser.reset();
                this.saxParser.setProperty(XMLReaderUtils.XERCES_SECURITY_MANAGER_PROPERTY, property);
            } catch (SAXException e4) {
                XMLReaderUtils.LOG.p("problem resetting sax parser", e4);
            }
            try {
                XMLReaderUtils.clearReader(this.saxParser.getXMLReader());
            } catch (SAXException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class XercesPoolSAXParser extends PoolSAXParser {
        public XercesPoolSAXParser(int i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        @Override // org.apache.tika.utils.XMLReaderUtils.PoolSAXParser
        public void reset() {
            try {
                XMLReaderUtils.clearReader(this.saxParser.getXMLReader());
            } catch (SAXException unused) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object, javax.xml.stream.XMLResolver] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object, org.xml.sax.EntityResolver] */
    static {
        try {
            setPoolSize(POOL_SIZE);
        } catch (TikaException e4) {
            throw new RuntimeException("problem initializing SAXParser and DOMBuilder pools", e4);
        }
    }

    private static PoolDOMBuilder acquireDOMBuilder() {
        ReentrantReadWriteLock reentrantReadWriteLock = DOM_POOL_LOCK;
        reentrantReadWriteLock.readLock().lock();
        try {
            PoolDOMBuilder poll = DOM_BUILDERS.poll();
            reentrantReadWriteLock.readLock().unlock();
            if (poll == null) {
                LOG.u("Contention waiting for a DOMBuilder. Consider increasing the XMLReaderUtils.POOL_SIZE");
            }
            return poll;
        } catch (Throwable th) {
            DOM_POOL_LOCK.readLock().unlock();
            throw th;
        }
    }

    private static PoolSAXParser acquireSAXParser() {
        ReentrantReadWriteLock reentrantReadWriteLock = SAX_POOL_LOCK;
        reentrantReadWriteLock.readLock().lock();
        try {
            PoolSAXParser poll = SAX_PARSERS.poll();
            reentrantReadWriteLock.readLock().unlock();
            if (poll == null) {
                LOG.u("Contention waiting for a SAXParser. Consider increasing the XMLReaderUtils.POOL_SIZE");
            }
            return poll;
        } catch (Throwable th) {
            SAX_POOL_LOCK.readLock().unlock();
            throw th;
        }
    }

    public static Document buildDOM(InputStream inputStream, ParseContext parseContext) {
        PoolDOMBuilder poolDOMBuilder;
        DocumentBuilder documentBuilder;
        DocumentBuilder documentBuilder2 = (DocumentBuilder) parseContext.get(DocumentBuilder.class);
        if (documentBuilder2 == null) {
            PoolDOMBuilder acquireDOMBuilder = acquireDOMBuilder();
            if (acquireDOMBuilder != null) {
                documentBuilder = acquireDOMBuilder.getDocumentBuilder();
            } else {
                documentBuilder = getDocumentBuilder();
            }
            DocumentBuilder documentBuilder3 = documentBuilder;
            poolDOMBuilder = acquireDOMBuilder;
            documentBuilder2 = documentBuilder3;
        } else {
            poolDOMBuilder = null;
        }
        try {
            return documentBuilder2.parse(inputStream);
        } finally {
            if (poolDOMBuilder != null) {
                releaseDOMBuilder(poolDOMBuilder);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.apache.tika.utils.XMLReaderUtils.PoolSAXParser buildPoolParser(int r13, javax.xml.parsers.SAXParser r14) {
        /*
            java.lang.String r0 = "SAX Security Manager could not be setup [log suppressed for 5 minutes]"
            r1 = 0
            r2 = 1
            r14.reset()     // Catch: java.lang.UnsupportedOperationException -> L9
            r3 = r2
            goto La
        L9:
            r3 = r1
        La:
            r4 = 5
            java.lang.String r6 = "org.apache.xerces.util.SecurityManager"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            r7 = 0
            java.lang.reflect.Constructor r6 = r6.getDeclaredConstructor(r7)     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            java.lang.Object r6 = r6.newInstance(r7)     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            java.lang.Class r7 = r6.getClass()     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            java.lang.String r8 = "setEntityExpansionLimit"
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            java.lang.Class[] r9 = new java.lang.Class[]{r9}     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            int r8 = org.apache.tika.utils.XMLReaderUtils.MAX_ENTITY_EXPANSIONS     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            r7.invoke(r6, r8)     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            java.lang.String r7 = "http://apache.org/xml/properties/security-manager"
            r14.setProperty(r7, r6)     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L5c java.lang.SecurityException -> Laf
            r6 = r2
            goto L5d
        L3f:
            r6 = move-exception
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = org.apache.tika.utils.XMLReaderUtils.LAST_LOG
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MINUTES
            long r11 = r11.toMillis(r4)
            long r11 = r11 + r9
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 <= 0) goto L5c
            n3.b r7 = org.apache.tika.utils.XMLReaderUtils.LOG
            r7.p(r0, r6)
            long r6 = java.lang.System.currentTimeMillis()
            org.apache.tika.utils.XMLReaderUtils.LAST_LOG = r6
        L5c:
            r6 = r1
        L5d:
            if (r6 != 0) goto L89
            java.lang.String r7 = "http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit"
            int r8 = org.apache.tika.utils.XMLReaderUtils.MAX_ENTITY_EXPANSIONS     // Catch: org.xml.sax.SAXException -> L6c
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: org.xml.sax.SAXException -> L6c
            r14.setProperty(r7, r8)     // Catch: org.xml.sax.SAXException -> L6c
            r1 = r2
            goto L89
        L6c:
            r2 = move-exception
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = org.apache.tika.utils.XMLReaderUtils.LAST_LOG
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MINUTES
            long r4 = r11.toMillis(r4)
            long r4 = r4 + r9
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 <= 0) goto L89
            n3.b r4 = org.apache.tika.utils.XMLReaderUtils.LOG
            r4.p(r0, r2)
            long r4 = java.lang.System.currentTimeMillis()
            org.apache.tika.utils.XMLReaderUtils.LAST_LOG = r4
        L89:
            if (r3 != 0) goto L93
            if (r6 == 0) goto L93
            org.apache.tika.utils.XMLReaderUtils$XercesPoolSAXParser r0 = new org.apache.tika.utils.XMLReaderUtils$XercesPoolSAXParser
            r0.<init>(r13, r14)
            return r0
        L93:
            if (r3 == 0) goto L9d
            if (r6 == 0) goto L9d
            org.apache.tika.utils.XMLReaderUtils$Xerces2PoolSAXParser r0 = new org.apache.tika.utils.XMLReaderUtils$Xerces2PoolSAXParser
            r0.<init>(r13, r14)
            return r0
        L9d:
            if (r3 == 0) goto La9
            if (r6 != 0) goto La9
            if (r1 == 0) goto La9
            org.apache.tika.utils.XMLReaderUtils$BuiltInPoolSAXParser r0 = new org.apache.tika.utils.XMLReaderUtils$BuiltInPoolSAXParser
            r0.<init>(r13, r14)
            return r0
        La9:
            org.apache.tika.utils.XMLReaderUtils$UnrecognizedPoolSAXParser r0 = new org.apache.tika.utils.XMLReaderUtils$UnrecognizedPoolSAXParser
            r0.<init>(r13, r14)
            return r0
        Laf:
            r13 = move-exception
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.utils.XMLReaderUtils.buildPoolParser(int, javax.xml.parsers.SAXParser):org.apache.tika.utils.XMLReaderUtils$PoolSAXParser");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearReader(XMLReader xMLReader) {
        if (xMLReader == null) {
            return;
        }
        xMLReader.setContentHandler(IGNORING_CONTENT_HANDLER);
        xMLReader.setDTDHandler(IGNORING_DTD_HANDLER);
        xMLReader.setEntityResolver(IGNORING_SAX_ENTITY_RESOLVER);
        xMLReader.setErrorHandler(IGNORING_ERROR_HANDLER);
    }

    private static int determineMaxEntityExpansions() {
        String property = System.getProperty(JAXP_ENTITY_EXPANSION_LIMIT_KEY);
        if (property != null) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                LOG.r(property, "Couldn't parse an integer for the entity expansion limit: {}; backing off to default: {}", 20);
            }
        }
        return 20;
    }

    public static String getAttrValue(String str, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (str.equals(attributes.getLocalName(i))) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    public static DocumentBuilder getDocumentBuilder() {
        try {
            DocumentBuilder newDocumentBuilder = getDocumentBuilderFactory().newDocumentBuilder();
            newDocumentBuilder.setEntityResolver(IGNORING_SAX_ENTITY_RESOLVER);
            newDocumentBuilder.setErrorHandler(null);
            return newDocumentBuilder;
        } catch (ParserConfigurationException e4) {
            throw new TikaException("XML parser not available", e4);
        }
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        n3.b bVar = LOG;
        if (bVar.b()) {
            bVar.x(newInstance.getClass(), "DocumentBuilderFactory class {}");
        }
        newInstance.setExpandEntityReferences(false);
        newInstance.setNamespaceAware(true);
        newInstance.setValidating(false);
        trySetSAXFeature(newInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-general-entities", false);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-parameter-entities", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        trySetXercesSecurityManager(newInstance);
        return newInstance;
    }

    public static int getMaxEntityExpansions() {
        return MAX_ENTITY_EXPANSIONS;
    }

    public static int getPoolSize() {
        return POOL_SIZE;
    }

    public static SAXParser getSAXParser() {
        try {
            SAXParser newSAXParser = getSAXParserFactory().newSAXParser();
            trySetXercesSecurityManager(newSAXParser);
            return newSAXParser;
        } catch (ParserConfigurationException e4) {
            throw new TikaException("Unable to configure a SAX parser", e4);
        } catch (SAXException e5) {
            throw new TikaException("Unable to create a SAX parser", e5);
        }
    }

    public static SAXParserFactory getSAXParserFactory() {
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        n3.b bVar = LOG;
        if (bVar.b()) {
            bVar.x(newInstance.getClass(), "SAXParserFactory class {}");
        }
        newInstance.setNamespaceAware(true);
        newInstance.setValidating(false);
        trySetSAXFeature(newInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-general-entities", false);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-parameter-entities", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        return newInstance;
    }

    public static Transformer getTransformer() {
        try {
            TransformerFactory newInstance = TransformerFactory.newInstance();
            newInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            trySetTransformerAttribute(newInstance, "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
            trySetTransformerAttribute(newInstance, "http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
            return newInstance.newTransformer();
        } catch (TransformerConfigurationException | TransformerFactoryConfigurationError e4) {
            throw new TikaException("Transformer not available", e4);
        }
    }

    public static XMLInputFactory getXMLInputFactory() {
        XMLInputFactory newFactory = XMLInputFactory.newFactory();
        n3.b bVar = LOG;
        if (bVar.b()) {
            bVar.x(newFactory.getClass(), "XMLInputFactory class {}");
        }
        tryToSetStaxProperty(newFactory, "javax.xml.stream.isNamespaceAware", true);
        tryToSetStaxProperty(newFactory, "javax.xml.stream.isValidating", false);
        newFactory.setXMLResolver(IGNORING_STAX_ENTITY_RESOLVER);
        trySetStaxSecurityManager(newFactory);
        return newFactory;
    }

    public static XMLReader getXMLReader() {
        try {
            XMLReader xMLReader = getSAXParser().getXMLReader();
            xMLReader.setEntityResolver(IGNORING_SAX_ENTITY_RESOLVER);
            return xMLReader;
        } catch (SAXException e4) {
            throw new TikaException("Unable to create an XMLReader", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InputSource lambda$static$0(String str, String str2) {
        return new InputSource(new StringReader(""));
    }

    private static /* synthetic */ Object lambda$static$1(String str, String str2, String str3, String str4) {
        return "";
    }

    public static void parseSAX(InputStream inputStream, ContentHandler contentHandler, ParseContext parseContext) {
        PoolSAXParser poolSAXParser;
        SAXParser sAXParser;
        SAXParser sAXParser2 = (SAXParser) parseContext.get(SAXParser.class);
        if (sAXParser2 == null) {
            PoolSAXParser acquireSAXParser = acquireSAXParser();
            if (acquireSAXParser != null) {
                sAXParser = acquireSAXParser.getSAXParser();
            } else {
                sAXParser = getSAXParser();
            }
            SAXParser sAXParser3 = sAXParser;
            poolSAXParser = acquireSAXParser;
            sAXParser2 = sAXParser3;
        } else {
            poolSAXParser = null;
        }
        try {
            sAXParser2.parse(inputStream, new OfflineContentHandler(contentHandler));
        } finally {
            if (poolSAXParser != null) {
                releaseParser(poolSAXParser);
            }
        }
    }

    private static void releaseDOMBuilder(PoolDOMBuilder poolDOMBuilder) {
        if (poolDOMBuilder.getPoolGeneration() != POOL_GENERATION.get()) {
            return;
        }
        try {
            poolDOMBuilder.reset();
        } catch (UnsupportedOperationException unused) {
        }
        ReentrantReadWriteLock reentrantReadWriteLock = DOM_POOL_LOCK;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (!DOM_BUILDERS.offer(poolDOMBuilder)) {
                LOG.u("DocumentBuilder not taken back into pool.  If you haven't resized the pool, this could be a sign that there are more calls to 'acquire' than to 'release'");
            }
            reentrantReadWriteLock.readLock().unlock();
        } catch (Throwable th) {
            DOM_POOL_LOCK.readLock().unlock();
            throw th;
        }
    }

    private static void releaseParser(PoolSAXParser poolSAXParser) {
        try {
            poolSAXParser.reset();
        } catch (UnsupportedOperationException unused) {
        }
        if (poolSAXParser.getGeneration() != POOL_GENERATION.get()) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = SAX_POOL_LOCK;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (!SAX_PARSERS.offer(poolSAXParser)) {
                LOG.u("SAXParser not taken back into pool.  If you haven't resized the pool this could be a sign that there are more calls to 'acquire' than to 'release'");
            }
            reentrantReadWriteLock.readLock().unlock();
        } catch (Throwable th) {
            SAX_POOL_LOCK.readLock().unlock();
            throw th;
        }
    }

    public static void setMaxEntityExpansions(int i) {
        MAX_ENTITY_EXPANSIONS = i;
    }

    public static void setPoolSize(int i) {
        SAX_POOL_LOCK.writeLock().lock();
        try {
            Iterator<PoolSAXParser> it = SAX_PARSERS.iterator();
            while (it.hasNext()) {
                it.next().reset();
            }
            SAX_PARSERS.clear();
            SAX_PARSERS = new ArrayBlockingQueue<>(i);
            int incrementAndGet = POOL_GENERATION.incrementAndGet();
            for (int i3 = 0; i3 < i; i3++) {
                try {
                    SAX_PARSERS.offer(buildPoolParser(incrementAndGet, getSAXParserFactory().newSAXParser()));
                } catch (ParserConfigurationException | SAXException e4) {
                    throw new TikaException("problem creating sax parser", e4);
                }
            }
            SAX_POOL_LOCK.writeLock().unlock();
            DOM_POOL_LOCK.writeLock().lock();
            try {
                DOM_BUILDERS.clear();
                DOM_BUILDERS = new ArrayBlockingQueue<>(i);
                for (int i4 = 0; i4 < i; i4++) {
                    DOM_BUILDERS.offer(new PoolDOMBuilder(POOL_GENERATION.get(), getDocumentBuilder()));
                }
                DOM_POOL_LOCK.writeLock().unlock();
                POOL_SIZE = i;
            } catch (Throwable th) {
                DOM_POOL_LOCK.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            SAX_POOL_LOCK.writeLock().unlock();
            throw th2;
        }
    }

    private static void trySetSAXFeature(SAXParserFactory sAXParserFactory, String str, boolean z3) {
        try {
            sAXParserFactory.setFeature(str, z3);
        } catch (AbstractMethodError e4) {
            LOG.r(str, "Cannot set SAX feature because outdated XML parser in classpath: {}", e4);
        } catch (SecurityException e5) {
            throw e5;
        } catch (Exception e6) {
            LOG.r(str, "SAX Feature unsupported: {}", e6);
        }
    }

    private static void trySetStaxSecurityManager(XMLInputFactory xMLInputFactory) {
        try {
            try {
                xMLInputFactory.setProperty("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            } catch (IllegalArgumentException unused) {
                xMLInputFactory.setProperty("com.ctc.wstx.maxEntityCount", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            }
        } catch (IllegalArgumentException unused2) {
            if (!HAS_WARNED_STAX.getAndSet(true)) {
                LOG.u("Could not set limit on maximum entity expansions for: " + xMLInputFactory.getClass());
            }
        }
    }

    private static void trySetTransformerAttribute(TransformerFactory transformerFactory, String str, String str2) {
        try {
            transformerFactory.setAttribute(str, str2);
        } catch (AbstractMethodError e4) {
            LOG.r(str, "Cannot set Transformer attribute because outdated XML parser in classpath: {}", e4);
        } catch (SecurityException e5) {
            throw e5;
        } catch (Exception e6) {
            LOG.r(str, "Transformer Attribute unsupported: {}", e6);
        }
    }

    private static void trySetXercesSecurityManager(DocumentBuilderFactory documentBuilderFactory) {
        try {
            Object newInstance = Class.forName(new String[]{XERCES_SECURITY_MANAGER}[0]).getDeclaredConstructor(null).newInstance(null);
            newInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(newInstance, Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            documentBuilderFactory.setAttribute(XERCES_SECURITY_MANAGER_PROPERTY, newInstance);
        } catch (ClassNotFoundException unused) {
            try {
                documentBuilderFactory.setAttribute("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            } catch (IllegalArgumentException e4) {
                if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + LAST_LOG) {
                    LOG.p("SAX Security Manager could not be setup [log suppressed for 5 minutes]", e4);
                    LAST_LOG = System.currentTimeMillis();
                }
            }
        } catch (Throwable th) {
            if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + LAST_LOG) {
                LOG.p("SAX Security Manager could not be setup [log suppressed for 5 minutes]", th);
                LAST_LOG = System.currentTimeMillis();
            }
            documentBuilderFactory.setAttribute("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
        }
    }

    private static void tryToSetStaxProperty(XMLInputFactory xMLInputFactory, String str, boolean z3) {
        try {
            xMLInputFactory.setProperty(str, Boolean.valueOf(z3));
        } catch (IllegalArgumentException e4) {
            LOG.r(str, "StAX Feature unsupported: {}", e4);
        }
    }

    private static void trySetSAXFeature(DocumentBuilderFactory documentBuilderFactory, String str, boolean z3) {
        try {
            documentBuilderFactory.setFeature(str, z3);
        } catch (AbstractMethodError e4) {
            LOG.r(str, "Cannot set SAX feature because outdated XML parser in classpath: {}", e4);
        } catch (Exception e5) {
            LOG.r(str, "SAX Feature unsupported: {}", e5);
        }
    }

    public static DocumentBuilder getDocumentBuilder(ParseContext parseContext) {
        DocumentBuilder documentBuilder = (DocumentBuilder) parseContext.get(DocumentBuilder.class);
        return documentBuilder != null ? documentBuilder : getDocumentBuilder();
    }

    public static Transformer getTransformer(ParseContext parseContext) {
        Transformer transformer = (Transformer) parseContext.get(Transformer.class);
        return transformer != null ? transformer : getTransformer();
    }

    public static Document buildDOM(Reader reader, ParseContext parseContext) {
        PoolDOMBuilder poolDOMBuilder;
        DocumentBuilder documentBuilder = (DocumentBuilder) parseContext.get(DocumentBuilder.class);
        if (documentBuilder == null) {
            PoolDOMBuilder acquireDOMBuilder = acquireDOMBuilder();
            poolDOMBuilder = acquireDOMBuilder;
            documentBuilder = acquireDOMBuilder.getDocumentBuilder();
        } else {
            poolDOMBuilder = null;
        }
        try {
            return documentBuilder.parse(new InputSource(reader));
        } finally {
            if (poolDOMBuilder != null) {
                releaseDOMBuilder(poolDOMBuilder);
            }
        }
    }

    public static XMLInputFactory getXMLInputFactory(ParseContext parseContext) {
        XMLInputFactory xMLInputFactory = (XMLInputFactory) parseContext.get(XMLInputFactory.class);
        return xMLInputFactory != null ? xMLInputFactory : getXMLInputFactory();
    }

    public static void parseSAX(Reader reader, ContentHandler contentHandler, ParseContext parseContext) {
        PoolSAXParser poolSAXParser;
        SAXParser sAXParser;
        SAXParser sAXParser2 = (SAXParser) parseContext.get(SAXParser.class);
        if (sAXParser2 == null) {
            PoolSAXParser acquireSAXParser = acquireSAXParser();
            if (acquireSAXParser != null) {
                sAXParser = acquireSAXParser.getSAXParser();
            } else {
                sAXParser = getSAXParser();
            }
            SAXParser sAXParser3 = sAXParser;
            poolSAXParser = acquireSAXParser;
            sAXParser2 = sAXParser3;
        } else {
            poolSAXParser = null;
        }
        try {
            sAXParser2.parse(new InputSource(reader), new OfflineContentHandler(contentHandler));
        } finally {
            if (poolSAXParser != null) {
                releaseParser(poolSAXParser);
            }
        }
    }

    public static Document buildDOM(Path path) {
        InputStream newInputStream;
        newInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            Document buildDOM = buildDOM(newInputStream);
            if (newInputStream != null) {
                newInputStream.close();
            }
            return buildDOM;
        } catch (Throwable th) {
            if (newInputStream != null) {
                try {
                    newInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void trySetXercesSecurityManager(SAXParser sAXParser) {
        try {
            Object newInstance = Class.forName(new String[]{XERCES_SECURITY_MANAGER}[0]).getDeclaredConstructor(null).newInstance(null);
            newInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(newInstance, Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            sAXParser.setProperty(XERCES_SECURITY_MANAGER_PROPERTY, newInstance);
        } catch (ClassNotFoundException unused) {
            try {
                sAXParser.setProperty("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            } catch (SAXException e4) {
                if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + LAST_LOG) {
                    LOG.p("SAX Security Manager could not be setup [log suppressed for 5 minutes]", e4);
                    LAST_LOG = System.currentTimeMillis();
                }
            }
        } catch (Throwable th) {
            if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + LAST_LOG) {
                LOG.p("SAX Security Manager could not be setup [log suppressed for 5 minutes]", th);
                LAST_LOG = System.currentTimeMillis();
            }
            sAXParser.setProperty("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
        }
    }

    public static Document buildDOM(String str) {
        PoolDOMBuilder acquireDOMBuilder = acquireDOMBuilder();
        try {
            return acquireDOMBuilder.getDocumentBuilder().parse(str);
        } finally {
            releaseDOMBuilder(acquireDOMBuilder);
        }
    }

    public static Document buildDOM(InputStream inputStream) {
        PoolDOMBuilder acquireDOMBuilder = acquireDOMBuilder();
        try {
            return acquireDOMBuilder.getDocumentBuilder().parse(inputStream);
        } finally {
            releaseDOMBuilder(acquireDOMBuilder);
        }
    }
}
