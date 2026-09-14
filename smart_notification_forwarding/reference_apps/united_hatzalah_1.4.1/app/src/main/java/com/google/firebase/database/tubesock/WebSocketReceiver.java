package com.google.firebase.database.tubesock;

import com.google.firebase.database.tubesock.MessageBuilderFactory;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
class WebSocketReceiver {
    private MessageBuilderFactory.Builder pendingBuilder;
    private WebSocket websocket;
    private DataInputStream input = null;
    private WebSocketEventHandler eventHandler = null;
    private byte[] inputHeader = new byte[112];
    private volatile boolean stop = false;

    public WebSocketReceiver(WebSocket webSocket) {
        this.websocket = null;
        this.websocket = webSocket;
    }

    private void appendBytes(boolean z3, byte b4, byte[] bArr) {
        if (b4 == 9) {
            if (z3) {
                handlePing(bArr);
                return;
            }
            throw new WebSocketException("PING must not fragment across frames");
        }
        MessageBuilderFactory.Builder builder = this.pendingBuilder;
        if (builder != null && b4 != 0) {
            throw new WebSocketException("Failed to continue outstanding frame");
        }
        if (builder == null && b4 == 0) {
            throw new WebSocketException("Received continuing frame, but there's nothing to continue");
        }
        if (builder == null) {
            this.pendingBuilder = MessageBuilderFactory.builder(b4);
        }
        if (this.pendingBuilder.appendBytes(bArr)) {
            if (z3) {
                WebSocketMessage message = this.pendingBuilder.toMessage();
                this.pendingBuilder = null;
                if (message != null) {
                    this.eventHandler.onMessage(message);
                    return;
                }
                throw new WebSocketException("Failed to decode whole message");
            }
            return;
        }
        throw new WebSocketException("Failed to decode frame");
    }

    private void handleError(WebSocketException webSocketException) {
        stopit();
        this.websocket.handleReceiverError(webSocketException);
    }

    private void handlePing(byte[] bArr) {
        if (bArr.length <= 125) {
            this.websocket.pong(bArr);
            return;
        }
        throw new WebSocketException("PING frame too long");
    }

    private long parseLong(byte[] bArr, int i) {
        return (bArr[i] << 56) + ((bArr[i + 1] & ForkServer.ERROR) << 48) + ((bArr[i + 2] & ForkServer.ERROR) << 40) + ((bArr[i + 3] & ForkServer.ERROR) << 32) + ((bArr[i + 4] & ForkServer.ERROR) << 24) + ((bArr[i + 5] & ForkServer.ERROR) << 16) + ((bArr[i + 6] & ForkServer.ERROR) << 8) + (bArr[i + 7] & ForkServer.ERROR);
    }

    private int read(byte[] bArr, int i, int i3) {
        this.input.readFully(bArr, i, i3);
        return i3;
    }

    public boolean isRunning() {
        return !this.stop;
    }

    public void run() {
        int read;
        byte[] bArr;
        byte b4;
        boolean z3;
        long j2;
        this.eventHandler = this.websocket.getEventHandler();
        while (!this.stop) {
            try {
                read = read(this.inputHeader, 0, 1);
                bArr = this.inputHeader;
                b4 = bArr[0];
                if ((b4 & 128) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } catch (WebSocketException e4) {
                handleError(e4);
            } catch (SocketTimeoutException unused) {
            } catch (IOException e5) {
                handleError(new WebSocketException("IO Error", e5));
            }
            if ((b4 & 112) == 0) {
                byte b5 = (byte) (b4 & 15);
                int read2 = read + read(bArr, read, 1);
                byte[] bArr2 = this.inputHeader;
                byte b6 = bArr2[1];
                if (b6 < 126) {
                    j2 = b6;
                } else if (b6 == 126) {
                    read(bArr2, read2, 2);
                    byte[] bArr3 = this.inputHeader;
                    j2 = ((bArr3[2] & ForkServer.ERROR) << 8) | (bArr3[3] & ForkServer.ERROR);
                } else if (b6 == Byte.MAX_VALUE) {
                    j2 = parseLong(this.inputHeader, (read2 + read(bArr2, read2, 8)) - 8);
                } else {
                    j2 = 0;
                }
                int i = (int) j2;
                byte[] bArr4 = new byte[i];
                read(bArr4, 0, i);
                if (b5 == 8) {
                    this.websocket.onCloseOpReceived();
                } else if (b5 != 10) {
                    if (b5 != 1 && b5 != 2 && b5 != 9 && b5 != 0) {
                        throw new WebSocketException("Unsupported opcode: " + ((int) b5));
                    }
                    appendBytes(z3, b5, bArr4);
                }
            } else {
                throw new WebSocketException("Invalid frame received");
            }
        }
    }

    public void setInput(DataInputStream dataInputStream) {
        this.input = dataInputStream;
    }

    public void stopit() {
        this.stop = true;
    }
}
