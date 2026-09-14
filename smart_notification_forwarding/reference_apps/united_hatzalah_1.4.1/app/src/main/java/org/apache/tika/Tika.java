package org.apache.tika;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Path;
import java.util.Properties;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.exception.WriteLimitReachedException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.language.translate.Translator;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParsingReader;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.WriteOutContentHandler;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class Tika {
    private final Detector detector;
    private int maxStringLength;
    private final Parser parser;
    private final Translator translator;

    public Tika(Detector detector, Parser parser) {
        this.maxStringLength = 100000;
        this.detector = detector;
        this.parser = parser;
        this.translator = TikaConfig.getDefaultConfig().getTranslator();
    }

    public static String getString() {
        String str = null;
        try {
            InputStream resourceAsStream = Tika.class.getResourceAsStream("/META-INF/maven/org.apache.tika/tika-core/pom.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    str = properties.getProperty("version");
                } finally {
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (Exception unused) {
        }
        if (str != null) {
            return "Apache Tika ".concat(str);
        }
        return "Apache Tika";
    }

    public String detect(InputStream inputStream, Metadata metadata) {
        if (inputStream != null && !inputStream.markSupported()) {
            return this.detector.detect(new BufferedInputStream(inputStream), metadata).toString();
        }
        return this.detector.detect(inputStream, metadata).toString();
    }

    public Detector getDetector() {
        return this.detector;
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public Parser getParser() {
        return this.parser;
    }

    public Translator getTranslator() {
        return this.translator;
    }

    public Reader parse(InputStream inputStream, Metadata metadata) {
        ParseContext parseContext = new ParseContext();
        parseContext.set(Parser.class, this.parser);
        return new ParsingReader(this.parser, inputStream, metadata, parseContext);
    }

    public String parseToString(InputStream inputStream, Metadata metadata) {
        return parseToString(inputStream, metadata, this.maxStringLength);
    }

    public void setMaxStringLength(int i) {
        this.maxStringLength = i;
    }

    public String toString() {
        return getString();
    }

    public String translate(String str, String str2, String str3) {
        try {
            return this.translator.translate(str, str2, str3);
        } catch (Exception e4) {
            throw new IllegalStateException("Error translating data.", e4);
        }
    }

    public String parseToString(InputStream inputStream, Metadata metadata, int i) {
        WriteOutContentHandler writeOutContentHandler = new WriteOutContentHandler(i);
        ParseContext parseContext = new ParseContext();
        parseContext.set(Parser.class, this.parser);
        try {
            try {
                this.parser.parse(inputStream, new BodyContentHandler(writeOutContentHandler), metadata, parseContext);
                if (inputStream != null) {
                    inputStream.close();
                }
            } finally {
            }
        } catch (SAXException e4) {
            if (!WriteLimitReachedException.isWriteLimitReached(e4)) {
                throw new TikaException("Unexpected SAX processing failure", e4);
            }
        }
        return writeOutContentHandler.toString();
    }

    public String translate(String str, String str2) {
        try {
            return this.translator.translate(str, str2);
        } catch (Exception e4) {
            throw new IllegalStateException("Error translating data.", e4);
        }
    }

    public String detect(InputStream inputStream, String str) {
        Metadata metadata = new Metadata();
        metadata.set(TikaCoreProperties.RESOURCE_NAME_KEY, str);
        return detect(inputStream, metadata);
    }

    public Reader parse(InputStream inputStream) {
        return parse(inputStream, new Metadata());
    }

    public Reader parse(Path path, Metadata metadata) {
        return parse(TikaInputStream.get(path, metadata), metadata);
    }

    public Tika(Detector detector, Parser parser, Translator translator) {
        this.maxStringLength = 100000;
        this.detector = detector;
        this.parser = parser;
        this.translator = translator;
    }

    public String detect(InputStream inputStream) {
        return detect(inputStream, new Metadata());
    }

    public Reader parse(Path path) {
        return parse(path, new Metadata());
    }

    public String detect(byte[] bArr, String str) {
        try {
            TikaInputStream tikaInputStream = TikaInputStream.get(bArr);
            try {
                String detect = detect(tikaInputStream, str);
                if (tikaInputStream == null) {
                    return detect;
                }
                tikaInputStream.close();
                return detect;
            } finally {
            }
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected IOException", e4);
        }
    }

    public Reader parse(File file, Metadata metadata) {
        return parse(TikaInputStream.get(file, metadata), metadata);
    }

    public Reader parse(File file) {
        return parse(file, new Metadata());
    }

    public Tika(TikaConfig tikaConfig) {
        this(tikaConfig.getDetector(), new AutoDetectParser(tikaConfig), tikaConfig.getTranslator());
    }

    public Reader parse(URL url) {
        Metadata metadata = new Metadata();
        return parse(TikaInputStream.get(url, metadata), metadata);
    }

    public String parseToString(InputStream inputStream) {
        return parseToString(inputStream, new Metadata());
    }

    public Tika() {
        this(TikaConfig.getDefaultConfig());
    }

    public String parseToString(Path path) {
        Metadata metadata = new Metadata();
        return parseToString(TikaInputStream.get(path, metadata), metadata);
    }

    public Tika(Detector detector) {
        this(detector, new AutoDetectParser(detector));
    }

    public String detect(byte[] bArr) {
        try {
            TikaInputStream tikaInputStream = TikaInputStream.get(bArr);
            try {
                String detect = detect(tikaInputStream);
                if (tikaInputStream == null) {
                    return detect;
                }
                tikaInputStream.close();
                return detect;
            } finally {
            }
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected IOException", e4);
        }
    }

    public String parseToString(File file) {
        Metadata metadata = new Metadata();
        return parseToString(TikaInputStream.get(file, metadata), metadata);
    }

    public String detect(Path path) {
        Metadata metadata = new Metadata();
        TikaInputStream tikaInputStream = TikaInputStream.get(path, metadata);
        try {
            String detect = detect(tikaInputStream, metadata);
            if (tikaInputStream != null) {
                tikaInputStream.close();
            }
            return detect;
        } catch (Throwable th) {
            if (tikaInputStream != null) {
                try {
                    tikaInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String parseToString(URL url) {
        Metadata metadata = new Metadata();
        return parseToString(TikaInputStream.get(url, metadata), metadata);
    }

    public String detect(File file) {
        Metadata metadata = new Metadata();
        TikaInputStream tikaInputStream = TikaInputStream.get(file, metadata);
        try {
            String detect = detect(tikaInputStream, metadata);
            if (tikaInputStream != null) {
                tikaInputStream.close();
            }
            return detect;
        } catch (Throwable th) {
            if (tikaInputStream != null) {
                try {
                    tikaInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String detect(URL url) {
        Metadata metadata = new Metadata();
        TikaInputStream tikaInputStream = TikaInputStream.get(url, metadata);
        try {
            String detect = detect(tikaInputStream, metadata);
            if (tikaInputStream != null) {
                tikaInputStream.close();
            }
            return detect;
        } catch (Throwable th) {
            if (tikaInputStream != null) {
                try {
                    tikaInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String detect(String str) {
        try {
            return detect((InputStream) null, str);
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected IOException", e4);
        }
    }
}
