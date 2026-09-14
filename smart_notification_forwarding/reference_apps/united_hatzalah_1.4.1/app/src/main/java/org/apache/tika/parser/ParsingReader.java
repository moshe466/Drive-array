package org.apache.tika.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.concurrent.Executor;
import org.apache.tika.exception.ZeroByteFileException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.sax.BodyContentHandler;

/* loaded from: classes.dex */
public class ParsingReader extends Reader {
    private final ParseContext context;
    private final Metadata metadata;
    private final Parser parser;
    private final Reader reader;
    private final InputStream stream;
    private transient Throwable throwable;
    private final Writer writer;

    /* loaded from: classes.dex */
    public class ParsingTask implements Runnable {
        public /* synthetic */ ParsingTask(ParsingReader parsingReader, int i) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ParsingReader.this.parser.parse(ParsingReader.this.stream, new BodyContentHandler(ParsingReader.this.writer), ParsingReader.this.metadata, ParsingReader.this.context);
            } catch (Throwable th) {
                ParsingReader.this.throwable = th;
            }
            try {
                ParsingReader.this.stream.close();
            } catch (Throwable th2) {
                if (ParsingReader.this.throwable == null) {
                    ParsingReader.this.throwable = th2;
                }
            }
            try {
                ParsingReader.this.writer.close();
            } catch (Throwable th3) {
                if (ParsingReader.this.throwable == null) {
                    ParsingReader.this.throwable = th3;
                }
            }
        }

        private ParsingTask() {
        }
    }

    public ParsingReader(InputStream inputStream) {
        this(new AutoDetectParser(), inputStream, new Metadata(), new ParseContext());
        this.context.set(Parser.class, this.parser);
    }

    private static Metadata getMetadata(String str) {
        Metadata metadata = new Metadata();
        if (str != null && str.length() > 0) {
            metadata.set(TikaCoreProperties.RESOURCE_NAME_KEY, str);
        }
        return metadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Metadata metadata, Runnable runnable) {
        String str;
        String str2 = metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY);
        if (str2 != null) {
            str = "Apache Tika: ".concat(str2);
        } else {
            str = "Apache Tika";
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        thread.start();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.reader.close();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i3) {
        Throwable th = this.throwable;
        if (th instanceof ZeroByteFileException) {
            return -1;
        }
        if (!(th instanceof IOException)) {
            if (th == null) {
                return this.reader.read(cArr, i, i3);
            }
            throw new IOException("", this.throwable);
        }
        throw ((IOException) th);
    }

    public ParsingReader(InputStream inputStream, String str) {
        this(new AutoDetectParser(), inputStream, getMetadata(str), new ParseContext());
        this.context.set(Parser.class, this.parser);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ParsingReader(java.nio.file.Path r2) {
        /*
            r1 = this;
            r0 = 0
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            java.io.InputStream r0 = k3.a.f(r2, r0)
            java.nio.file.Path r2 = k3.a.A(r2)
            java.lang.String r2 = k3.a.i(r2)
            r1.<init>(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.ParsingReader.<init>(java.nio.file.Path):void");
    }

    public ParsingReader(File file) {
        this(new FileInputStream(file), file.getName());
    }

    public ParsingReader(Parser parser, InputStream inputStream, final Metadata metadata, ParseContext parseContext) {
        this(parser, inputStream, metadata, parseContext, new Executor() { // from class: org.apache.tika.parser.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                ParsingReader.lambda$new$0(Metadata.this, runnable);
            }
        });
    }

    public ParsingReader(Parser parser, InputStream inputStream, Metadata metadata, ParseContext parseContext, Executor executor) {
        this.parser = parser;
        PipedReader pipedReader = new PipedReader();
        BufferedReader bufferedReader = new BufferedReader(pipedReader);
        this.reader = bufferedReader;
        try {
            this.writer = new PipedWriter(pipedReader);
            this.stream = inputStream;
            this.metadata = metadata;
            this.context = parseContext;
            executor.execute(new ParsingTask(this, 0));
            bufferedReader.mark(1);
            bufferedReader.read();
            bufferedReader.reset();
        } catch (IOException e4) {
            throw new IllegalStateException(e4);
        }
    }
}
