package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes3.dex */
public final class Okio {
    static final Logger a = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink appendingSink(File file) {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() { // from class: okio.Okio.3
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
            }

            @Override // okio.Sink
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override // okio.Sink
            public void write(Buffer buffer, long j) {
                buffer.skip(j);
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static Sink sink(File file) {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new Sink() { // from class: okio.Okio.1
                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    outputStream.close();
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    outputStream.flush();
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                @Override // okio.Sink
                public void write(Buffer buffer, long j) {
                    Util.checkOffsetAndCount(buffer.b, 0L, j);
                    while (j > 0) {
                        Timeout.this.throwIfReached();
                        Segment segment = buffer.a;
                        int min = (int) Math.min(j, segment.c - segment.b);
                        outputStream.write(segment.a, segment.b, min);
                        segment.b += min;
                        long j2 = min;
                        j -= j2;
                        buffer.b -= j2;
                        if (segment.b == segment.c) {
                            buffer.a = segment.pop();
                            SegmentPool.a(segment);
                        }
                    }
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static Sink sink(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        AsyncTimeout timeout = timeout(socket);
        return timeout.sink(sink(socket.getOutputStream(), timeout));
    }

    @IgnoreJRERequirement
    public static Sink sink(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(File file) {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new Source() { // from class: okio.Okio.2
                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    inputStream.close();
                }

                @Override // okio.Source
                public long read(Buffer buffer, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    }
                    if (j == 0) {
                        return 0L;
                    }
                    try {
                        Timeout.this.throwIfReached();
                        Segment a2 = buffer.a(1);
                        int read = inputStream.read(a2.a, a2.c, (int) Math.min(j, 8192 - a2.c));
                        if (read == -1) {
                            return -1L;
                        }
                        a2.c += read;
                        long j2 = read;
                        buffer.b += j2;
                        return j2;
                    } catch (AssertionError e) {
                        if (Okio.a(e)) {
                            throw new IOException(e);
                        }
                        throw e;
                    }
                }

                @Override // okio.Source
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static Source source(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        AsyncTimeout timeout = timeout(socket);
        return timeout.source(source(socket.getInputStream(), timeout));
    }

    @IgnoreJRERequirement
    public static Source source(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    private static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() { // from class: okio.Okio.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // okio.AsyncTimeout
            protected void a() {
                Level level;
                StringBuilder sb;
                Logger logger;
                Exception exc;
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (!Okio.a(e)) {
                        throw e;
                    }
                    Logger logger2 = Okio.a;
                    level = Level.WARNING;
                    sb = new StringBuilder();
                    exc = e;
                    logger = logger2;
                    sb.append("Failed to close timed out socket ");
                    sb.append(socket);
                    logger.log(level, sb.toString(), (Throwable) exc);
                } catch (Exception e2) {
                    Logger logger3 = Okio.a;
                    level = Level.WARNING;
                    sb = new StringBuilder();
                    exc = e2;
                    logger = logger3;
                    sb.append("Failed to close timed out socket ");
                    sb.append(socket);
                    logger.log(level, sb.toString(), (Throwable) exc);
                }
            }

            @Override // okio.AsyncTimeout
            protected IOException b(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
        };
    }
}
