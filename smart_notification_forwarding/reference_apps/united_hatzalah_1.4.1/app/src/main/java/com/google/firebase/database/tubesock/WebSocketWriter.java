package com.google.firebase.database.tubesock;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
class WebSocketWriter {
    private WritableByteChannel channel;
    private BlockingQueue<ByteBuffer> pendingBuffers;
    private WebSocket websocket;
    private final Random random = new Random();
    private volatile boolean stop = false;
    private boolean closeSent = false;
    private final Thread innerThread = WebSocket.getThreadFactory().newThread(new Runnable() { // from class: com.google.firebase.database.tubesock.WebSocketWriter.1
        @Override // java.lang.Runnable
        public void run() {
            WebSocketWriter.this.runWriter();
        }
    });

    public WebSocketWriter(WebSocket webSocket, String str, int i) {
        WebSocket.getIntializer().setName(getInnerThread(), str + "Writer-" + i);
        this.websocket = webSocket;
        this.pendingBuffers = new LinkedBlockingQueue();
    }

    private ByteBuffer frameInBuffer(byte b4, boolean z3, byte[] bArr) {
        int i;
        int i3;
        if (z3) {
            i = 6;
        } else {
            i = 2;
        }
        int length = bArr.length;
        int i4 = 126;
        if (length >= 126) {
            if (length <= 65535) {
                i += 2;
            } else {
                i += 8;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + i);
        allocate.put((byte) (b4 | Byte.MIN_VALUE));
        if (length < 126) {
            if (z3) {
                length |= 128;
            }
            allocate.put((byte) length);
        } else if (length <= 65535) {
            if (z3) {
                i4 = 254;
            }
            allocate.put((byte) i4);
            allocate.putShort((short) length);
        } else {
            if (z3) {
                i3 = 255;
            } else {
                i3 = 127;
            }
            allocate.put((byte) i3);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z3) {
            byte[] generateMask = generateMask();
            allocate.put(generateMask);
            for (int i5 = 0; i5 < bArr.length; i5++) {
                allocate.put((byte) (bArr[i5] ^ generateMask[i5 % 4]));
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
        this.websocket.handleReceiverError(webSocketException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runWriter() {
        while (!this.stop && !Thread.interrupted()) {
            try {
                writeMessage();
            } catch (IOException e4) {
                handleError(new WebSocketException("IO Exception", e4));
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

    public Thread getInnerThread() {
        return this.innerThread;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        r1.closeSent = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void send(byte r2, boolean r3, byte[] r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.nio.ByteBuffer r3 = r1.frameInBuffer(r2, r3, r4)     // Catch: java.lang.Throwable -> L1a
            boolean r4 = r1.stop     // Catch: java.lang.Throwable -> L1a
            r0 = 8
            if (r4 == 0) goto L1c
            boolean r4 = r1.closeSent     // Catch: java.lang.Throwable -> L1a
            if (r4 != 0) goto L12
            if (r2 != r0) goto L12
            goto L1c
        L12:
            com.google.firebase.database.tubesock.WebSocketException r2 = new com.google.firebase.database.tubesock.WebSocketException     // Catch: java.lang.Throwable -> L1a
            java.lang.String r3 = "Shouldn't be sending"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1a
            throw r2     // Catch: java.lang.Throwable -> L1a
        L1a:
            r2 = move-exception
            goto L28
        L1c:
            if (r2 != r0) goto L21
            r2 = 1
            r1.closeSent = r2     // Catch: java.lang.Throwable -> L1a
        L21:
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r2 = r1.pendingBuffers     // Catch: java.lang.Throwable -> L1a
            r2.add(r3)     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r1)
            return
        L28:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1a
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.tubesock.WebSocketWriter.send(byte, boolean, byte[]):void");
    }

    public void setOutput(OutputStream outputStream) {
        this.channel = Channels.newChannel(outputStream);
    }

    public void stopIt() {
        this.stop = true;
    }
}
