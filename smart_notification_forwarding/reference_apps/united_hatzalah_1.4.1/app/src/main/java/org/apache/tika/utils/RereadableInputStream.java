package org.apache.tika.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

/* loaded from: classes.dex */
public class RereadableInputStream extends InputStream {
    private static final int DEFAULT_MAX_BYTES_IN_MEMORY = 536870912;
    private int bufferHighWaterMark;
    private int bufferPointer;
    private byte[] byteBuffer;
    private final boolean closeOriginalStreamOnClose;
    private boolean closed;
    private InputStream inputStream;
    private final int maxBytesInMemory;
    private final InputStream originalInputStream;
    private boolean readingFromBuffer;
    private File storeFile;
    private OutputStream storeOutputStream;

    public RereadableInputStream(InputStream inputStream) {
        this(inputStream, DEFAULT_MAX_BYTES_IN_MEMORY, true);
    }

    private void closeStream() {
        InputStream inputStream = this.originalInputStream;
        InputStream inputStream2 = this.inputStream;
        if (inputStream != inputStream2) {
            inputStream2.close();
        }
        if (this.closeOriginalStreamOnClose) {
            this.originalInputStream.close();
        }
    }

    private void saveByte(int i) {
        Path createTempFile;
        File file;
        byte[] bArr = this.byteBuffer;
        if (bArr != null) {
            int i3 = this.bufferPointer;
            if (i3 == this.maxBytesInMemory) {
                createTempFile = Files.createTempFile("TIKA_streamstore_", ".tmp", new FileAttribute[0]);
                file = createTempFile.toFile();
                this.storeFile = file;
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.storeFile));
                this.storeOutputStream = bufferedOutputStream;
                bufferedOutputStream.write(this.byteBuffer, 0, this.bufferPointer);
                this.storeOutputStream.write(i);
                this.byteBuffer = null;
                return;
            }
            this.bufferPointer = i3 + 1;
            bArr[i3] = (byte) i;
            return;
        }
        this.storeOutputStream.write(i);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeStream();
        OutputStream outputStream = this.storeOutputStream;
        if (outputStream != null) {
            outputStream.close();
            this.storeOutputStream = null;
        }
        super.close();
        File file = this.storeFile;
        if (file != null) {
            file.delete();
        }
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream inputStream;
        if (!this.closed) {
            int read = this.inputStream.read();
            if (read == -1 && (inputStream = this.inputStream) != this.originalInputStream) {
                if (this.readingFromBuffer) {
                    this.readingFromBuffer = false;
                    inputStream.close();
                } else {
                    inputStream.close();
                    this.storeOutputStream = new BufferedOutputStream(new FileOutputStream(this.storeFile, true));
                }
                InputStream inputStream2 = this.originalInputStream;
                this.inputStream = inputStream2;
                read = inputStream2.read();
            }
            if (read != -1 && this.inputStream == this.originalInputStream) {
                saveByte(read);
            }
            return read;
        }
        throw new IOException("Stream is already closed");
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [e3.h, b3.d] */
    public void rewind() {
        if (!this.closed) {
            OutputStream outputStream = this.storeOutputStream;
            if (outputStream != null) {
                outputStream.close();
                this.storeOutputStream = null;
            }
            InputStream inputStream = this.inputStream;
            if (inputStream != this.originalInputStream) {
                inputStream.close();
            }
            int max = Math.max(this.bufferPointer, this.bufferHighWaterMark);
            this.bufferHighWaterMark = max;
            this.bufferPointer = max;
            if (max > 0) {
                if (this.byteBuffer != null) {
                    this.readingFromBuffer = true;
                    ?? dVar = new b3.d();
                    dVar.M(this.byteBuffer);
                    int i = this.bufferHighWaterMark;
                    if (i >= 0) {
                        dVar.f4468d = i;
                        this.inputStream = dVar.L();
                        return;
                    }
                    throw new IllegalArgumentException("length cannot be negative");
                }
                this.inputStream = new BufferedInputStream(new FileInputStream(this.storeFile));
                return;
            }
            this.inputStream = this.originalInputStream;
            return;
        }
        throw new IOException("Stream is already closed");
    }

    public RereadableInputStream(InputStream inputStream, boolean z3) {
        this(inputStream, DEFAULT_MAX_BYTES_IN_MEMORY, z3);
    }

    public RereadableInputStream(InputStream inputStream, int i) {
        this(inputStream, i, true);
    }

    public RereadableInputStream(InputStream inputStream, int i, boolean z3) {
        this.inputStream = inputStream;
        this.originalInputStream = inputStream;
        this.maxBytesInMemory = i;
        this.byteBuffer = new byte[i];
        this.closeOriginalStreamOnClose = z3;
    }
}
