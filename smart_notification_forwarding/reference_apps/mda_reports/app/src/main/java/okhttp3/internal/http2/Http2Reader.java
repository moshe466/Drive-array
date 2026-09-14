package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Http2Reader implements Closeable {
    static final Logger b = Logger.getLogger(Http2.class.getName());
    final Hpack.Reader a;
    private final boolean client;
    private final ContinuationSource continuation;
    private final BufferedSource source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ContinuationSource implements Source {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final BufferedSource source;

        ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private void readContinuationHeader() {
            int i = this.c;
            int a = Http2Reader.a(this.source);
            this.d = a;
            this.a = a;
            byte readByte = (byte) (this.source.readByte() & 255);
            this.b = (byte) (this.source.readByte() & 255);
            if (Http2Reader.b.isLoggable(Level.FINE)) {
                Http2Reader.b.fine(Http2.a(true, this.c, this.a, readByte, this.b));
            }
            this.c = this.source.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                Http2.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            }
            if (this.c == i) {
                return;
            }
            Http2.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) {
            while (true) {
                int i = this.d;
                if (i != 0) {
                    long read = this.source.read(buffer, Math.min(j, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.d = (int) (this.d - read);
                    return read;
                }
                this.source.skip(this.e);
                this.e = (short) 0;
                if ((this.b & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2);

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list);

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.client = z;
        this.continuation = new ContinuationSource(this.source);
        this.a = new Hpack.Reader(4096, this.continuation);
    }

    static int a(int i, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        Http2.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    static int a(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void readData(Handler handler, int i, byte b2, int i2) {
        if (i2 == 0) {
            Http2.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            Http2.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        short readByte = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.data(z, i2, this.source, a(i, b2, readByte));
        this.source.skip(readByte);
    }

    private void readGoAway(Handler handler, int i, byte b2, int i2) {
        if (i < 8) {
            Http2.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            Http2.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int readInt = this.source.readInt();
        int readInt2 = this.source.readInt();
        int i3 = i - 8;
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            Http2.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        }
        ByteString byteString = ByteString.EMPTY;
        if (i3 > 0) {
            byteString = this.source.readByteString(i3);
        }
        handler.goAway(readInt, fromHttp2, byteString);
    }

    private List<Header> readHeaderBlock(int i, short s, byte b2, int i2) {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.d = i;
        continuationSource.a = i;
        continuationSource.e = s;
        continuationSource.b = b2;
        continuationSource.c = i2;
        this.a.b();
        return this.a.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i, byte b2, int i2) {
        if (i2 == 0) {
            Http2.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        short readByte = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            readPriority(handler, i2);
            i -= 5;
        }
        handler.headers(z, i2, -1, readHeaderBlock(a(i, b2, readByte), readByte, b2, i2));
    }

    private void readPing(Handler handler, int i, byte b2, int i2) {
        if (i != 8) {
            Http2.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            Http2.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        handler.ping((b2 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private void readPriority(Handler handler, int i) {
        int readInt = this.source.readInt();
        handler.priority(i, readInt & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void readPriority(Handler handler, int i, byte b2, int i2) {
        if (i != 5) {
            Http2.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            readPriority(handler, i2);
        } else {
            Http2.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void readPushPromise(Handler handler, int i, byte b2, int i2) {
        if (i2 == 0) {
            Http2.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short readByte = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.pushPromise(i2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(a(i - 4, b2, readByte), readByte, b2, i2));
    }

    private void readRstStream(Handler handler, int i, byte b2, int i2) {
        if (i != 4) {
            Http2.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        }
        if (i2 == 0) {
            Http2.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
        int readInt = this.source.readInt();
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
        if (fromHttp2 != null) {
            handler.rstStream(i2, fromHttp2);
        } else {
            Http2.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        }
    }

    private void readSettings(Handler handler, int i, byte b2, int i2) {
        if (i2 != 0) {
            Http2.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b2 & 1) != 0) {
            if (i == 0) {
                handler.ackSettings();
                return;
            } else {
                Http2.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        }
        if (i % 6 != 0) {
            Http2.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
        Settings settings = new Settings();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int readShort = this.source.readShort() & UShort.MAX_VALUE;
            int readInt = this.source.readInt();
            switch (readShort) {
                case 2:
                    if (readInt != 0 && readInt != 1) {
                        Http2.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        throw null;
                    }
                    break;
                case 3:
                    readShort = 4;
                    break;
                case 4:
                    readShort = 7;
                    if (readInt < 0) {
                        Http2.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                    break;
                case 5:
                    if (readInt < 16384 || readInt > 16777215) {
                        Http2.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                    break;
                    break;
            }
            settings.a(readShort, readInt);
        }
        handler.settings(false, settings);
    }

    private void readWindowUpdate(Handler handler, int i, byte b2, int i2) {
        if (i != 4) {
            Http2.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            throw null;
        }
        long readInt = this.source.readInt() & 2147483647L;
        if (readInt != 0) {
            handler.windowUpdate(i2, readInt);
        } else {
            Http2.b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    public boolean nextFrame(boolean z, Handler handler) {
        try {
            this.source.require(9L);
            int a = a(this.source);
            if (a < 0 || a > 16384) {
                Http2.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
                throw null;
            }
            byte readByte = (byte) (this.source.readByte() & 255);
            if (z && readByte != 4) {
                Http2.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.source.readByte() & 255);
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            if (b.isLoggable(Level.FINE)) {
                b.fine(Http2.a(true, readInt, a, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    readData(handler, a, readByte2, readInt);
                    return true;
                case 1:
                    readHeaders(handler, a, readByte2, readInt);
                    return true;
                case 2:
                    readPriority(handler, a, readByte2, readInt);
                    return true;
                case 3:
                    readRstStream(handler, a, readByte2, readInt);
                    return true;
                case 4:
                    readSettings(handler, a, readByte2, readInt);
                    return true;
                case 5:
                    readPushPromise(handler, a, readByte2, readInt);
                    return true;
                case 6:
                    readPing(handler, a, readByte2, readInt);
                    return true;
                case 7:
                    readGoAway(handler, a, readByte2, readInt);
                    return true;
                case 8:
                    readWindowUpdate(handler, a, readByte2, readInt);
                    return true;
                default:
                    this.source.skip(a);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) {
        if (this.client) {
            if (nextFrame(true, handler)) {
                return;
            }
            Http2.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        ByteString readByteString = this.source.readByteString(Http2.a.size());
        if (b.isLoggable(Level.FINE)) {
            b.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
        }
        if (Http2.a.equals(readByteString)) {
            return;
        }
        Http2.b("Expected a connection header but was %s", readByteString.utf8());
        throw null;
    }
}
