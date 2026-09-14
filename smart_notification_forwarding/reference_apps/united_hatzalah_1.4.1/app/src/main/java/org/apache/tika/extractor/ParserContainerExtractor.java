package org.apache.tika.extractor;

import java.io.InputStream;
import java.util.Set;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.StatefulParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class ParserContainerExtractor implements ContainerExtractor {
    private static final long serialVersionUID = 2261131045580861514L;
    private final Detector detector;
    private final Parser parser;

    /* loaded from: classes.dex */
    public class RecursiveParser extends StatefulParser {
        private final ContainerExtractor extractor;
        private final EmbeddedResourceHandler handler;

        public /* synthetic */ RecursiveParser(ParserContainerExtractor parserContainerExtractor, Parser parser, ContainerExtractor containerExtractor, EmbeddedResourceHandler embeddedResourceHandler, int i) {
            this(parser, containerExtractor, embeddedResourceHandler);
        }

        @Override // org.apache.tika.parser.ParserDecorator, org.apache.tika.parser.Parser
        public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
            return ParserContainerExtractor.this.parser.getSupportedTypes(parseContext);
        }

        @Override // org.apache.tika.parser.ParserDecorator, org.apache.tika.parser.Parser
        public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) {
            TemporaryResources temporaryResources = new TemporaryResources();
            try {
                TikaInputStream tikaInputStream = TikaInputStream.get(inputStream, temporaryResources, metadata);
                String str = metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY);
                MediaType detect = ParserContainerExtractor.this.detector.detect(tikaInputStream, metadata);
                if (this.extractor == null) {
                    this.handler.handle(str, detect, tikaInputStream);
                } else {
                    TikaInputStream tikaInputStream2 = TikaInputStream.get(tikaInputStream.getFile());
                    try {
                        this.handler.handle(str, detect, tikaInputStream2);
                        if (tikaInputStream2 != null) {
                            tikaInputStream2.close();
                        }
                        ContainerExtractor containerExtractor = this.extractor;
                        containerExtractor.extract(tikaInputStream, containerExtractor, this.handler);
                    } finally {
                    }
                }
                temporaryResources.dispose();
            } catch (Throwable th) {
                temporaryResources.dispose();
                throw th;
            }
        }

        private RecursiveParser(Parser parser, ContainerExtractor containerExtractor, EmbeddedResourceHandler embeddedResourceHandler) {
            super(parser);
            this.extractor = containerExtractor;
            this.handler = embeddedResourceHandler;
        }
    }

    public ParserContainerExtractor() {
        this(TikaConfig.getDefaultConfig());
    }

    @Override // org.apache.tika.extractor.ContainerExtractor
    public void extract(TikaInputStream tikaInputStream, ContainerExtractor containerExtractor, EmbeddedResourceHandler embeddedResourceHandler) {
        ParseContext parseContext = new ParseContext();
        parseContext.set(Parser.class, new RecursiveParser(this, this.parser, containerExtractor, embeddedResourceHandler, 0));
        try {
            this.parser.parse(tikaInputStream, new DefaultHandler(), new Metadata(), parseContext);
        } catch (SAXException e4) {
            throw new TikaException("Unexpected SAX exception", e4);
        }
    }

    @Override // org.apache.tika.extractor.ContainerExtractor
    public boolean isSupported(TikaInputStream tikaInputStream) {
        return this.parser.getSupportedTypes(new ParseContext()).contains(this.detector.detect(tikaInputStream, new Metadata()));
    }

    public ParserContainerExtractor(TikaConfig tikaConfig) {
        this(new AutoDetectParser(tikaConfig), new DefaultDetector(tikaConfig.getMimeRepository()));
    }

    public ParserContainerExtractor(Parser parser, Detector detector) {
        this.parser = parser;
        this.detector = detector;
    }
}
