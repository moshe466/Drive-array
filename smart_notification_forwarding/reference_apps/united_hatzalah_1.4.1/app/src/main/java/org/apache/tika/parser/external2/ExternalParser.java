package org.apache.tika.parser.external2;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import n3.b;
import n3.d;
import org.apache.tika.config.Field;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.EmptyParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.pipes.PipesConfigBase;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.XHTMLContentHandler;
import org.apache.tika.utils.FileProcessResult;

/* loaded from: classes.dex */
public class ExternalParser implements Parser, Initializable {
    public static final long DEFAULT_TIMEOUT_MS = 60000;
    public static final String INPUT_FILE_TOKEN = "${INPUT_FILE}";
    public static final String OUTPUT_FILE_TOKEN = "${OUTPUT_FILE}";
    private static Pattern INPUT_TOKEN_MATCHER = Pattern.compile("\\$\\{INPUT_FILE}");
    private static Pattern OUTPUT_TOKEN_MATCHER = Pattern.compile("\\$\\{OUTPUT_FILE}");
    private static final b LOG = d.b(ExternalParser.class);
    private Set<MediaType> supportedTypes = new HashSet();
    private List<String> commandLine = new ArrayList();
    private Parser outputParser = EmptyParser.INSTANCE;
    private boolean returnStdout = false;
    private boolean returnStderr = true;
    private long timeoutMs = 60000;
    private int maxStdErr = PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS;
    private int maxStdOut = PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS;

    private void handleOutput(FileProcessResult fileProcessResult, Path path, XHTMLContentHandler xHTMLContentHandler, Metadata metadata, ParseContext parseContext) {
        BufferedReader newBufferedReader;
        if (this.outputParser == EmptyParser.INSTANCE) {
            if (path != null) {
                newBufferedReader = Files.newBufferedReader(path);
                try {
                    for (String readLine = newBufferedReader.readLine(); readLine != null; readLine = newBufferedReader.readLine()) {
                        xHTMLContentHandler.characters(readLine);
                        xHTMLContentHandler.newline();
                    }
                    newBufferedReader.close();
                    return;
                } catch (Throwable th) {
                    if (newBufferedReader != null) {
                        try {
                            newBufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            xHTMLContentHandler.characters(fileProcessResult.getStdout());
            return;
        }
        if (path != null) {
            TikaInputStream tikaInputStream = TikaInputStream.get(path);
            try {
                this.outputParser.parse(tikaInputStream, new BodyContentHandler(xHTMLContentHandler), metadata, parseContext);
                if (tikaInputStream != null) {
                    tikaInputStream.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                if (tikaInputStream != null) {
                    try {
                        tikaInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }
        TikaInputStream tikaInputStream2 = TikaInputStream.get(fileProcessResult.getStdout().getBytes(StandardCharsets.UTF_8));
        try {
            this.outputParser.parse(tikaInputStream2, new BodyContentHandler(xHTMLContentHandler), metadata, parseContext);
            if (tikaInputStream2 != null) {
                tikaInputStream2.close();
            }
        } catch (Throwable th5) {
            if (tikaInputStream2 != null) {
                try {
                    tikaInputStream2.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }

    @Override // org.apache.tika.config.Initializable
    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
        if (this.supportedTypes.size() != 0) {
            if (!this.commandLine.isEmpty()) {
                if (this.outputParser == EmptyParser.INSTANCE) {
                    LOG.j("no parser selected for the output; contents will be written to the content handler");
                    return;
                }
                return;
            }
            throw new TikaConfigException("commandLine is empty?!");
        }
        throw new TikaConfigException("supportedTypes size must be > 0");
    }

    public Parser getOutputParser() {
        return this.outputParser;
    }

    @Override // org.apache.tika.parser.Parser
    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.supportedTypes;
    }

    @Override // org.apache.tika.config.Initializable
    public void initialize(Map<String, Param> map) {
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    @Override // org.apache.tika.parser.Parser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parse(java.io.InputStream r12, org.xml.sax.ContentHandler r13, org.apache.tika.metadata.Metadata r14, org.apache.tika.parser.ParseContext r15) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.external2.ExternalParser.parse(java.io.InputStream, org.xml.sax.ContentHandler, org.apache.tika.metadata.Metadata, org.apache.tika.parser.ParseContext):void");
    }

    @Field
    public void setCommandLine(List<String> list) {
        this.commandLine = list;
    }

    @Field
    public void setMaxStdErr(int i) {
        this.maxStdErr = i;
    }

    @Field
    public void setMaxStdOut(int i) {
        this.maxStdOut = i;
    }

    @Field
    public void setOutputParser(Parser parser) {
        this.outputParser = parser;
    }

    @Field
    public void setReturnStderr(boolean z3) {
        this.returnStderr = z3;
    }

    @Field
    public void setReturnStdout(boolean z3) {
        this.returnStdout = z3;
    }

    @Field
    public void setSupportedTypes(List<String> list) {
        if (this.supportedTypes.size() <= 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.supportedTypes.add(MediaType.parse(it.next()));
            }
            return;
        }
        throw new IllegalStateException("can't set supportedTypes after initialization");
    }

    @Field
    public void setTimeoutMs(long j2) {
        this.timeoutMs = j2;
    }
}
