package okio;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class Pipe {
    final long a;
    boolean c;
    boolean d;
    final Buffer b = new Buffer();
    private final Sink sink = new PipeSink();
    private final Source source = new PipeSource();

    /* loaded from: classes3.dex */
    final class PipeSink implements Sink {
        final Timeout a = new Timeout();

        PipeSink() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Pipe.this.b) {
                if (Pipe.this.c) {
                    return;
                }
                if (Pipe.this.d && Pipe.this.b.size() > 0) {
                    throw new IOException("source is closed");
                }
                Pipe.this.c = true;
                Pipe.this.b.notifyAll();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            synchronized (Pipe.this.b) {
                if (Pipe.this.c) {
                    throw new IllegalStateException("closed");
                }
                if (Pipe.this.d && Pipe.this.b.size() > 0) {
                    throw new IOException("source is closed");
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) {
            synchronized (Pipe.this.b) {
                if (Pipe.this.c) {
                    throw new IllegalStateException("closed");
                }
                while (j > 0) {
                    if (Pipe.this.d) {
                        throw new IOException("source is closed");
                    }
                    long size = Pipe.this.a - Pipe.this.b.size();
                    if (size == 0) {
                        this.a.waitUntilNotified(Pipe.this.b);
                    } else {
                        long min = Math.min(size, j);
                        Pipe.this.b.write(buffer, min);
                        j -= min;
                        Pipe.this.b.notifyAll();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    final class PipeSource implements Source {
        final Timeout a = new Timeout();

        PipeSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Pipe.this.b) {
                Pipe.this.d = true;
                Pipe.this.b.notifyAll();
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) {
            synchronized (Pipe.this.b) {
                if (Pipe.this.d) {
                    throw new IllegalStateException("closed");
                }
                while (Pipe.this.b.size() == 0) {
                    if (Pipe.this.c) {
                        return -1L;
                    }
                    this.a.waitUntilNotified(Pipe.this.b);
                }
                long read = Pipe.this.b.read(buffer, j);
                Pipe.this.b.notifyAll();
                return read;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.a;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.a = j;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
