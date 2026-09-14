package com.google.firebase.database.tubesock;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
class WebSocketWriter {
    private WritableByteChannel channel;
    private BlockingQueue<ByteBuffer> pendingBuffers;
    private WebSocket websocket;
    private final Random random = new Random();
    private volatile boolean stop = false;
    private boolean closeSent = false;
    private final Thread innerThread = WebSocket.e().newThread(new Runnable() { // from class: com.google.firebase.database.tubesock.WebSocketWriter.1
        @Override // java.lang.Runnable
        public void run() {
            WebSocketWriter.this.runWriter();
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketWriter(WebSocket webSocket, String str, int i) {
        WebSocket.d().setName(a(), str + "Writer-" + i);
        this.websocket = webSocket;
        this.pendingBuffers = new LinkedBlockingQueue();
    }

    private ByteBuffer frameInBuffer(byte b, boolean z, byte[] bArr) {
        int i = z ? 6 : 2;
        int length = bArr.length;
        if (length >= 126) {
            i = length <= 65535 ? i + 2 : i + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + i);
        allocate.put((byte) (b | Byte.MIN_VALUE));
        if (length < 126) {
            if (z) {
                length |= 128;
            }
            allocate.put((byte) length);
        } else if (length <= 65535) {
            allocate.put((byte) (z ? 254 : 126));
            allocate.putShort((short) length);
        } else {
            allocate.put((byte) (z ? 255 : 127));
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z) {
            byte[] generateMask = generateMask();
            allocate.put(generateMask);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                allocate.put((byte) (bArr[i2] ^ generateMask[i2 % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] generateMask() {
        byte[] bArr = new byte[4];
        this.random.nextBytes(bArr);
        return bArr;
    }

    private void handleError(WebSocketException webSocketException) {
        this.websocket.a(webSocketException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runWriter() {
        while (!this.stop && !Thread.interrupted()) {
            try {
                writeMessage();
            } catch (IOException e) {
                handleError(new WebSocketException("IO Exception", e));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i = 0; i < this.pendingBuffers.size(); i++) {
            writeMessage();
        }
    }

    private void writeMessage() {
        this.channel.write(this.pendingBuffers.take());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Thread a() {
        return this.innerThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        r1.closeSent = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(byte r2, boolean r3, byte[] r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.nio.ByteBuffer r3 = r1.frameInBuffer(r2, r3, r4)     // Catch: java.lang.Throwable -> L26
            boolean r4 = r1.stop     // Catch: java.lang.Throwable -> L26
            r0 = 8
            if (r4 == 0) goto L1a
            boolean r4 = r1.closeSent     // Catch: java.lang.Throwable -> L26
            if (r4 != 0) goto L12
            if (r2 != r0) goto L12
            goto L1a
        L12:
            com.google.firebase.database.tubesock.WebSocketException r2 = new com.google.firebase.database.tubesock.WebSocketException     // Catch: java.lang.Throwable -> L26
            java.lang.String r3 = "Shouldn't be sending"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L26
            throw r2     // Catch: java.lang.Throwable -> L26
        L1a:
            if (r2 != r0) goto L1f
            r2 = 1
            r1.closeSent = r2     // Catch: java.lang.Throwable -> L26
        L1f:
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r2 = r1.pendingBuffers     // Catch: java.lang.Throwable -> L26
            r2.add(r3)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r1)
            return
        L26:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.tubesock.WebSocketWriter.a(byte, boolean, byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OutputStream outputStream) {
        this.channel = Channels.newChannel(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.stop = true;
    }
}
