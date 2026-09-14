package io.grpc.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public class CompositeReadableBuffer extends AbstractReadableBuffer {
    private final Queue<ReadableBuffer> buffers = new ArrayDeque();
    private int readableBytes;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class ReadOperation {
        int a;
        IOException b;

        private ReadOperation() {
        }

        final void a(ReadableBuffer readableBuffer, int i) {
            try {
                this.a = readInternal(readableBuffer, i);
            } catch (IOException e) {
                this.b = e;
            }
        }

        final boolean a() {
            return this.b != null;
        }

        abstract int readInternal(ReadableBuffer readableBuffer, int i);
    }

    private void advanceBufferIfNecessary() {
        if (this.buffers.peek().readableBytes() == 0) {
            this.buffers.remove().close();
        }
    }

    private void execute(ReadOperation readOperation, int i) {
        a(i);
        if (this.buffers.isEmpty()) {
            advanceBufferIfNecessary();
            while (i > 0 && !this.buffers.isEmpty()) {
                ReadableBuffer peek = this.buffers.peek();
                int min = Math.min(i, peek.readableBytes());
                readOperation.a(peek, min);
                if (readOperation.a()) {
                    return;
                }
                i -= min;
                this.readableBytes -= min;
            }
            if (i > 0) {
                throw new AssertionError("Failed executing read operation");
            }
            return;
        }
        advanceBufferIfNecessary();
    }

    public void addBuffer(ReadableBuffer readableBuffer) {
        if (!(readableBuffer instanceof CompositeReadableBuffer)) {
            this.buffers.add(readableBuffer);
            this.readableBytes += readableBuffer.readableBytes();
            return;
        }
        CompositeReadableBuffer compositeReadableBuffer = (CompositeReadableBuffer) readableBuffer;
        while (!compositeReadableBuffer.buffers.isEmpty()) {
            this.buffers.add(compositeReadableBuffer.buffers.remove());
        }
        this.readableBytes += compositeReadableBuffer.readableBytes;
        compositeReadableBuffer.readableBytes = 0;
        compositeReadableBuffer.close();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.buffers.isEmpty()) {
            this.buffers.remove().close();
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public CompositeReadableBuffer readBytes(int i) {
        a(i);
        this.readableBytes -= i;
        CompositeReadableBuffer compositeReadableBuffer = new CompositeReadableBuffer();
        while (i > 0) {
            ReadableBuffer peek = this.buffers.peek();
            if (peek.readableBytes() > i) {
                compositeReadableBuffer.addBuffer(peek.readBytes(i));
                i = 0;
            } else {
                compositeReadableBuffer.addBuffer(this.buffers.poll());
                i -= peek.readableBytes();
            }
        }
        return compositeReadableBuffer;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(final OutputStream outputStream, int i) {
        ReadOperation readOperation = new ReadOperation(this) { // from class: io.grpc.internal.CompositeReadableBuffer.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            public int readInternal(ReadableBuffer readableBuffer, int i2) {
                readableBuffer.readBytes(outputStream, i2);
                return 0;
            }
        };
        execute(readOperation, i);
        if (readOperation.a()) {
            throw readOperation.b;
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(final ByteBuffer byteBuffer) {
        execute(new ReadOperation(this) { // from class: io.grpc.internal.CompositeReadableBuffer.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            public int readInternal(ReadableBuffer readableBuffer, int i) {
                int limit = byteBuffer.limit();
                ByteBuffer byteBuffer2 = byteBuffer;
                byteBuffer2.limit(byteBuffer2.position() + i);
                readableBuffer.readBytes(byteBuffer);
                byteBuffer.limit(limit);
                return 0;
            }
        }, byteBuffer.remaining());
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(final byte[] bArr, final int i, int i2) {
        execute(new ReadOperation(this) { // from class: io.grpc.internal.CompositeReadableBuffer.3
            int c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.c = i;
            }

            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            public int readInternal(ReadableBuffer readableBuffer, int i3) {
                readableBuffer.readBytes(bArr, this.c, i3);
                this.c += i3;
                return 0;
            }
        }, i2);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        ReadOperation readOperation = new ReadOperation(this) { // from class: io.grpc.internal.CompositeReadableBuffer.1
            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            int readInternal(ReadableBuffer readableBuffer, int i) {
                return readableBuffer.readUnsignedByte();
            }
        };
        execute(readOperation, 1);
        return readOperation.a;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.readableBytes;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i) {
        execute(new ReadOperation(this) { // from class: io.grpc.internal.CompositeReadableBuffer.2
            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            public int readInternal(ReadableBuffer readableBuffer, int i2) {
                readableBuffer.skipBytes(i2);
                return 0;
            }
        }, i);
    }
}
