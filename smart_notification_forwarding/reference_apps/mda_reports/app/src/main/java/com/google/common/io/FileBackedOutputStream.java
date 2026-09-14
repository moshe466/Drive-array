package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class FileBackedOutputStream extends OutputStream {

    @NullableDecl
    private File file;
    private final int fileThreshold;
    private MemoryOutput memory;
    private OutputStream out;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    public FileBackedOutputStream(int i, boolean z) {
        this.fileThreshold = i;
        this.resetOnFinalize = z;
        this.memory = new MemoryOutput();
        this.out = this.memory;
        this.source = z ? new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.1
            protected void finalize() {
                try {
                    FileBackedOutputStream.this.reset();
                } catch (Throwable th) {
                    th.printStackTrace(System.err);
                }
            }

            @Override // com.google.common.io.ByteSource
            public InputStream openStream() {
                return FileBackedOutputStream.this.openInputStream();
            }
        } : new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.2
            @Override // com.google.common.io.ByteSource
            public InputStream openStream() {
                return FileBackedOutputStream.this.openInputStream();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized InputStream openInputStream() {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        return new ByteArrayInputStream(this.memory.a(), 0, this.memory.getCount());
    }

    private void update(int i) {
        if (this.file != null || this.memory.getCount() + i <= this.fileThreshold) {
            return;
        }
        File createTempFile = File.createTempFile("FileBackedOutputStream", null);
        if (this.resetOnFinalize) {
            createTempFile.deleteOnExit();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        fileOutputStream.write(this.memory.a(), 0, this.memory.getCount());
        fileOutputStream.flush();
        this.out = fileOutputStream;
        this.file = createTempFile;
        this.memory = null;
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        this.out.flush();
    }

    public synchronized void reset() {
        try {
            close();
            if (this.memory == null) {
                this.memory = new MemoryOutput();
            } else {
                this.memory.reset();
            }
            this.out = this.memory;
            if (this.file != null) {
                File file = this.file;
                this.file = null;
                if (!file.delete()) {
                    throw new IOException("Could not delete: " + file);
                }
            }
        } catch (Throwable th) {
            if (this.memory == null) {
                this.memory = new MemoryOutput();
            } else {
                this.memory.reset();
            }
            this.out = this.memory;
            if (this.file != null) {
                File file2 = this.file;
                this.file = null;
                if (!file2.delete()) {
                    throw new IOException("Could not delete: " + file2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        update(1);
        this.out.write(i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        update(i2);
        this.out.write(bArr, i, i2);
    }
}
