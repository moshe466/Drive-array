package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    /* loaded from: classes2.dex */
    private static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = new NullWriter();

        private NullWriter() {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c) {
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, charSequence.length());
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i) {
        }

        @Override // java.io.Writer
        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2 + i, str.length());
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2 + i, cArr.length);
        }
    }

    private CharStreams() {
    }

    @CanIgnoreReturnValue
    static long a(Reader reader, Writer writer) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(writer);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += read;
        }
    }

    @CanIgnoreReturnValue
    static long a(Reader reader, StringBuilder sb) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sb);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            sb.append(cArr, 0, read);
            j += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharBuffer a() {
        return CharBuffer.allocate(2048);
    }

    public static Writer asWriter(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    @CanIgnoreReturnValue
    public static long copy(Readable readable, Appendable appendable) {
        if (readable instanceof Reader) {
            Reader reader = (Reader) readable;
            return appendable instanceof StringBuilder ? a(reader, (StringBuilder) appendable) : a(reader, asWriter(appendable));
        }
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        long j = 0;
        CharBuffer a = a();
        while (readable.read(a) != -1) {
            a.flip();
            appendable.append(a);
            j += a.remaining();
            a.clear();
        }
        return j;
    }

    @CanIgnoreReturnValue
    public static long exhaust(Readable readable) {
        CharBuffer a = a();
        long j = 0;
        while (true) {
            long read = readable.read(a);
            if (read == -1) {
                return j;
            }
            j += read;
            a.clear();
        }
    }

    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    @CanIgnoreReturnValue
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }

    public static List<String> readLines(Readable readable) {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public static void skipFully(Reader reader, long j) {
        Preconditions.checkNotNull(reader);
        while (j > 0) {
            long skip = reader.skip(j);
            if (skip == 0) {
                throw new EOFException();
            }
            j -= skip;
        }
    }

    public static String toString(Readable readable) {
        return toStringBuilder(readable).toString();
    }

    private static StringBuilder toStringBuilder(Readable readable) {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            a((Reader) readable, sb);
        } else {
            copy(readable, sb);
        }
        return sb;
    }
}
