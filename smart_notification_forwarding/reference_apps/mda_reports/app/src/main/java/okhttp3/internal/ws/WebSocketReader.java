package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes3.dex */
final class WebSocketReader {
    final boolean a;
    final BufferedSource b;
    final FrameCallback c;
    boolean d;
    int e;
    long f;
    boolean g;
    boolean h;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer controlFrameBuffer = new Buffer();
    private final Buffer messageFrameBuffer = new Buffer();

    /* loaded from: classes3.dex */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str);

        void onReadMessage(ByteString byteString);

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.a = z;
        this.b = bufferedSource;
        this.c = frameCallback;
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new Buffer.UnsafeCursor();
    }

    private void readControlFrame() {
        String str;
        long j = this.f;
        if (j > 0) {
            this.b.readFully(this.controlFrameBuffer, j);
            if (!this.a) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol.a(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.e) {
            case 8:
                short s = 1005;
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = this.controlFrameBuffer.readShort();
                    str = this.controlFrameBuffer.readUtf8();
                    String a = WebSocketProtocol.a(s);
                    if (a != null) {
                        throw new ProtocolException(a);
                    }
                } else {
                    str = "";
                }
                this.c.onReadClose(s, str);
                this.d = true;
                return;
            case 9:
                this.c.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.c.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.e));
        }
    }

    /* JADX WARN: Finally extract failed */
    private void readHeader() {
        if (this.d) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.b.timeout().timeoutNanos();
        this.b.timeout().clearTimeout();
        try {
            int readByte = this.b.readByte() & 255;
            this.b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            this.e = readByte & 15;
            this.g = (readByte & 128) != 0;
            this.h = (readByte & 8) != 0;
            if (this.h && !this.g) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z = (readByte & 64) != 0;
            boolean z2 = (readByte & 32) != 0;
            boolean z3 = (readByte & 16) != 0;
            if (z || z2 || z3) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            boolean z4 = ((this.b.readByte() & 255) & 128) != 0;
            boolean z5 = this.a;
            if (z4 == z5) {
                throw new ProtocolException(z5 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            this.f = r0 & 127;
            long j = this.f;
            if (j == 126) {
                this.f = this.b.readShort() & 65535;
            } else if (j == 127) {
                this.f = this.b.readLong();
                if (this.f < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.h && this.f > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z4) {
                this.b.readFully(this.maskKey);
            }
        } catch (Throwable th) {
            this.b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void readMessage() {
        while (!this.d) {
            long j = this.f;
            if (j > 0) {
                this.b.readFully(this.messageFrameBuffer, j);
                if (!this.a) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.f);
                    WebSocketProtocol.a(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.g) {
                return;
            }
            readUntilNonControlFrame();
            if (this.e != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.e));
            }
        }
        throw new IOException("closed");
    }

    private void readMessageFrame() {
        int i = this.e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
        readMessage();
        if (i == 1) {
            this.c.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.c.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private void readUntilNonControlFrame() {
        while (!this.d) {
            readHeader();
            if (!this.h) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        readHeader();
        if (this.h) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
