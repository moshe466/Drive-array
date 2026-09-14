package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: classes3.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    static final ByteString j = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString k = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    RandomAccessFile a;
    Thread b;
    Source c;
    long e;
    boolean f;
    final long h;
    int i;
    private final ByteString metadata;
    final Buffer d = new Buffer();
    final Buffer g = new Buffer();

    /* loaded from: classes3.dex */
    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.a.getChannel());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                relay.i--;
                if (Relay.this.i == 0) {
                    RandomAccessFile randomAccessFile2 = Relay.this.a;
                    Relay.this.a = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        
            if (r5 != 2) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        
            r2 = java.lang.Math.min(r23, r7 - r21.sourcePos);
            r21.fileOperator.read(r21.sourcePos + 32, r22, r2);
            r21.sourcePos += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
        
            r5 = r21.a.c.read(r21.a.d, r21.a.h);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        
            if (r5 != (-1)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            r21.a.a(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
        
            r2 = r21.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
        
            r21.a.b = null;
            r21.a.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0090, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0094, code lost:
        
            r2 = java.lang.Math.min(r5, r23);
            r21.a.d.copyTo(r22, 0, r2);
            r21.sourcePos += r2;
            r21.fileOperator.write(r7 + 32, r21.a.d.clone(), r5);
            r7 = r21.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00bd, code lost:
        
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00be, code lost:
        
            r21.a.g.write(r21.a.d, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00d7, code lost:
        
            if (r21.a.g.size() <= r21.a.h) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d9, code lost:
        
            r21.a.g.skip(r21.a.g.size() - r21.a.h);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ed, code lost:
        
            r21.a.e += r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f4, code lost:
        
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00f5, code lost:
        
            r5 = r21.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00f7, code lost:
        
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f8, code lost:
        
            r21.a.b = null;
            r21.a.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0101, code lost:
        
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0102, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0109, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x010c, code lost:
        
            monitor-enter(r21.a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x010d, code lost:
        
            r21.a.b = null;
            r21.a.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0117, code lost:
        
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long read(okio.Buffer r22, long r23) {
            /*
                Method dump skipped, instructions count: 324
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j2, ByteString byteString, long j3) {
        this.a = randomAccessFile;
        this.c = source;
        this.f = source == null;
        this.e = j2;
        this.metadata = byteString;
        this.h = j3;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j2) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j2);
        randomAccessFile.setLength(0L);
        relay.writeHeader(k, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, 32L);
        if (!buffer.readByteString(j.size()).equals(j)) {
            throw new IOException("unreadable cache file");
        }
        long readLong = buffer.readLong();
        long readLong2 = buffer.readLong();
        Buffer buffer2 = new Buffer();
        fileOperator.read(readLong + 32, buffer2, readLong2);
        return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L);
    }

    private void writeHeader(ByteString byteString, long j2, long j3) {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j2);
        buffer.writeLong(j3);
        if (buffer.size() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.a.getChannel()).write(0L, buffer, 32L);
    }

    private void writeMetadata(long j2) {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        new FileOperator(this.a.getChannel()).write(32 + j2, buffer, this.metadata.size());
    }

    void a(long j2) {
        writeMetadata(j2);
        this.a.getChannel().force(false);
        writeHeader(j, j2, this.metadata.size());
        this.a.getChannel().force(false);
        synchronized (this) {
            this.f = true;
        }
        Util.closeQuietly(this.c);
        this.c = null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.a == null) {
                return null;
            }
            this.i++;
            return new RelaySource();
        }
    }
}
