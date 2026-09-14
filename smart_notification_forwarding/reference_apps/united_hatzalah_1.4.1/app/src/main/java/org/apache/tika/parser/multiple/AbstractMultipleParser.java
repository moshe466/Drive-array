package org.apache.tika.parser.multiple;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.tika.config.Param;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.ContentHandlerFactory;
import org.apache.tika.utils.ParserUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public abstract class AbstractMultipleParser implements Parser {
    protected static final String METADATA_POLICY_CONFIG_KEY = "metadataPolicy";
    private static final long serialVersionUID = 5383668090329836559L;
    private final Set<MediaType> offeredTypes;
    private final Collection<? extends Parser> parsers;
    private final MetadataPolicy policy;
    private MediaTypeRegistry registry;

    /* renamed from: org.apache.tika.parser.multiple.AbstractMultipleParser$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$tika$parser$multiple$AbstractMultipleParser$MetadataPolicy;

        static {
            int[] iArr = new int[MetadataPolicy.values().length];
            $SwitchMap$org$apache$tika$parser$multiple$AbstractMultipleParser$MetadataPolicy = iArr;
            try {
                iArr[MetadataPolicy.FIRST_WINS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$tika$parser$multiple$AbstractMultipleParser$MetadataPolicy[MetadataPolicy.LAST_WINS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$tika$parser$multiple$AbstractMultipleParser$MetadataPolicy[MetadataPolicy.KEEP_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum MetadataPolicy {
        DISCARD_ALL,
        FIRST_WINS,
        LAST_WINS,
        KEEP_ALL
    }

    public AbstractMultipleParser(MediaTypeRegistry mediaTypeRegistry, Collection<? extends Parser> collection, Map<String, Param> map) {
        this(mediaTypeRegistry, getMetadataPolicy(map), collection);
    }

    public static MetadataPolicy getMetadataPolicy(Map<String, Param> map) {
        if (map.containsKey(METADATA_POLICY_CONFIG_KEY)) {
            return (MetadataPolicy) map.get(METADATA_POLICY_CONFIG_KEY).getValue();
        }
        throw new IllegalArgumentException("Required parameter 'metadataPolicy' not supplied");
    }

    public static Metadata mergeMetadata(Metadata metadata, Metadata metadata2, MetadataPolicy metadataPolicy) {
        if (metadataPolicy != MetadataPolicy.DISCARD_ALL) {
            for (String str : metadata2.names()) {
                if (!str.equals(TikaCoreProperties.TIKA_PARSED_BY.getName()) && !str.equals(ParserUtils.EMBEDDED_PARSER.getName()) && !str.equals(TikaCoreProperties.EMBEDDED_EXCEPTION.getName())) {
                    String[] values = metadata.getValues(str);
                    String[] values2 = metadata2.getValues(str);
                    if (values != null && values.length != 0) {
                        if (!Arrays.deepEquals(values2, values)) {
                            int i = AnonymousClass1.$SwitchMap$org$apache$tika$parser$multiple$AbstractMultipleParser$MetadataPolicy[metadataPolicy.ordinal()];
                            if (i != 1) {
                                if (i == 3) {
                                    ArrayList arrayList = new ArrayList(Arrays.asList(values2));
                                    metadata.remove(str);
                                    for (String str2 : values2) {
                                        metadata.add(str, str2);
                                    }
                                    for (String str3 : values) {
                                        if (!arrayList.contains(str3)) {
                                            metadata.add(str, str3);
                                            arrayList.add(str3);
                                        }
                                    }
                                }
                            } else {
                                metadata.remove(str);
                                for (String str4 : values2) {
                                    metadata.add(str, str4);
                                }
                            }
                        }
                    } else {
                        for (String str5 : values2) {
                            metadata.add(str, str5);
                        }
                    }
                }
            }
        }
        return metadata;
    }

    public List<Parser> getAllParsers() {
        return Collections.unmodifiableList(new ArrayList(this.parsers));
    }

    public MediaTypeRegistry getMediaTypeRegistry() {
        return this.registry;
    }

    @Override // org.apache.tika.parser.Parser
    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.offeredTypes;
    }

    @Override // org.apache.tika.parser.Parser
    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) {
        parse(inputStream, contentHandler, null, metadata, parseContext);
    }

    public abstract boolean parserCompleted(Parser parser, Metadata metadata, ContentHandler contentHandler, ParseContext parseContext, Exception exc);

    public void parserPrepare(Parser parser, Metadata metadata, ParseContext parseContext) {
    }

    public void setMediaTypeRegistry(MediaTypeRegistry mediaTypeRegistry) {
        this.registry = mediaTypeRegistry;
    }

    public AbstractMultipleParser(MediaTypeRegistry mediaTypeRegistry, MetadataPolicy metadataPolicy, Parser... parserArr) {
        this(mediaTypeRegistry, metadataPolicy, Arrays.asList(parserArr));
    }

    @Deprecated
    public void parse(InputStream inputStream, ContentHandlerFactory contentHandlerFactory, Metadata metadata, ParseContext parseContext) {
        parse(inputStream, null, contentHandlerFactory, metadata, parseContext);
    }

    public AbstractMultipleParser(MediaTypeRegistry mediaTypeRegistry, MetadataPolicy metadataPolicy, Collection<? extends Parser> collection) {
        this.policy = metadataPolicy;
        this.parsers = collection;
        this.registry = mediaTypeRegistry;
        this.offeredTypes = new HashSet();
        Iterator<? extends Parser> it = collection.iterator();
        while (it.hasNext()) {
            this.offeredTypes.addAll(it.next().getSupportedTypes(new ParseContext()));
        }
    }

    private void parse(InputStream inputStream, ContentHandler contentHandler, ContentHandlerFactory contentHandlerFactory, Metadata metadata, ParseContext parseContext) {
        Throwable th;
        Exception exc;
        Metadata cloneMetadata = ParserUtils.cloneMetadata(metadata);
        TemporaryResources temporaryResources = new TemporaryResources();
        try {
            InputStream ensureStreamReReadable = ParserUtils.ensureStreamReReadable(inputStream, temporaryResources, metadata);
            Iterator<? extends Parser> it = this.parsers.iterator();
            Metadata metadata2 = cloneMetadata;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Parser next = it.next();
                if (contentHandlerFactory != null) {
                    try {
                        contentHandler = contentHandlerFactory.getNewContentHandler();
                    } catch (Throwable th2) {
                        th = th2;
                        temporaryResources.dispose();
                        throw th;
                    }
                }
                ContentHandler contentHandler2 = contentHandler;
                ParserUtils.recordParserDetails(next, metadata);
                Metadata cloneMetadata2 = ParserUtils.cloneMetadata(metadata);
                parserPrepare(next, cloneMetadata2, parseContext);
                try {
                    next.parse(ensureStreamReReadable, contentHandler2, cloneMetadata2, parseContext);
                    exc = null;
                } catch (Exception e4) {
                    exc = e4;
                    ParserUtils.recordParserFailure(next, exc, metadata);
                    ParserUtils.recordParserFailure(next, exc, cloneMetadata2);
                }
                Exception exc2 = exc;
                ParseContext parseContext2 = parseContext;
                try {
                    boolean parserCompleted = parserCompleted(next, cloneMetadata2, contentHandler2, parseContext2, exc2);
                    cloneMetadata = mergeMetadata(cloneMetadata2, metadata2, this.policy);
                    if (parserCompleted) {
                        metadata2 = ParserUtils.cloneMetadata(cloneMetadata);
                        ensureStreamReReadable = ParserUtils.streamResetForReRead(ensureStreamReReadable, temporaryResources);
                        contentHandler = contentHandler2;
                        parseContext = parseContext2;
                    } else if (exc2 != null) {
                        if (!(exc2 instanceof IOException)) {
                            if (!(exc2 instanceof SAXException)) {
                                if (exc2 instanceof TikaException) {
                                    throw ((TikaException) exc2);
                                }
                                throw new TikaException("Unexpected RuntimeException from " + next, exc2);
                            }
                            throw ((SAXException) exc2);
                        }
                        throw ((IOException) exc2);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    temporaryResources.dispose();
                    throw th;
                }
            }
            temporaryResources.dispose();
            for (String str : cloneMetadata.names()) {
                metadata.remove(str);
                for (String str2 : cloneMetadata.getValues(str)) {
                    metadata.add(str, str2);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            temporaryResources.dispose();
            throw th;
        }
    }

    public MetadataPolicy getMetadataPolicy() {
        return this.policy;
    }
}
