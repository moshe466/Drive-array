package com.google.firebase.crashlytics.internal.metadata;

import F0.AbstractC0008a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class QueueFile implements Closeable {
    static final int HEADER_LENGTH = 16;
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    private final byte[] buffer;
    private int elementCount;
    int fileLength;
    private Element first;
    private Element last;
    private final RandomAccessFile raf;

    /* loaded from: classes.dex */
    public static class Element {
        static final int HEADER_LENGTH = 4;
        static final Element NULL = new Element(0, 0);
        final int length;
        final int position;

        public Element(int i, int i3) {
            this.position = i;
            this.length = i3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("[position = ");
            sb.append(this.position);
            sb.append(", length = ");
            return AbstractC0008a.r(sb, this.length, "]");
        }
    }

    /* loaded from: classes.dex */
    public final class ElementInputStream extends InputStream {
        private int position;
        private int remaining;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i3) {
            QueueFile.nonNull(bArr, "buffer");
            if ((i | i3) >= 0 && i3 <= bArr.length - i) {
                int i4 = this.remaining;
                if (i4 <= 0) {
                    return -1;
                }
                if (i3 > i4) {
                    i3 = i4;
                }
                QueueFile.this.ringRead(this.position, bArr, i, i3);
                this.position = QueueFile.this.wrapPosition(this.position + i3);
                this.remaining -= i3;
                return i3;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        private ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.position + 4);
            this.remaining = element.length;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile.this.raf.seek(this.position);
            int read = QueueFile.this.raf.read();
            this.position = QueueFile.this.wrapPosition(this.position + 1);
            this.remaining--;
            return read;
        }
    }

    /* loaded from: classes.dex */
    public interface ElementReader {
        void read(InputStream inputStream, int i);
    }

    public QueueFile(File file) {
        this.buffer = new byte[16];
        if (!file.exists()) {
            initialize(file);
        }
        this.raf = open(file);
        readHeader();
    }

    private void expandIfNecessary(int i) {
        int i3 = i + 4;
        int remainingBytes = remainingBytes();
        if (remainingBytes >= i3) {
            return;
        }
        int i4 = this.fileLength;
        do {
            remainingBytes += i4;
            i4 <<= 1;
        } while (remainingBytes < i3);
        setLength(i4);
        Element element = this.last;
        int wrapPosition = wrapPosition(element.position + 4 + element.length);
        if (wrapPosition < this.first.position) {
            FileChannel channel = this.raf.getChannel();
            channel.position(this.fileLength);
            long j2 = wrapPosition - 4;
            if (channel.transferTo(16L, j2, channel) != j2) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i5 = this.last.position;
        int i6 = this.first.position;
        if (i5 < i6) {
            int i7 = (this.fileLength + i5) - 16;
            writeHeader(i4, this.elementCount, i6, i7);
            this.last = new Element(i7, this.last.length);
        } else {
            writeHeader(i4, this.elementCount, i6, i5);
        }
        this.fileLength = i4;
    }

    private static void initialize(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile open = open(file2);
        try {
            open.setLength(4096L);
            open.seek(0L);
            byte[] bArr = new byte[16];
            writeInts(bArr, INITIAL_LENGTH, 0, 0, 0);
            open.write(bArr);
            open.close();
            if (file2.renameTo(file)) {
            } else {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            open.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T nonNull(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile open(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private Element readElement(int i) {
        if (i == 0) {
            return Element.NULL;
        }
        this.raf.seek(i);
        return new Element(i, this.raf.readInt());
    }

    private void readHeader() {
        this.raf.seek(0L);
        this.raf.readFully(this.buffer);
        int readInt = readInt(this.buffer, 0);
        this.fileLength = readInt;
        if (readInt <= this.raf.length()) {
            this.elementCount = readInt(this.buffer, 4);
            int readInt2 = readInt(this.buffer, 8);
            int readInt3 = readInt(this.buffer, 12);
            this.first = readElement(readInt2);
            this.last = readElement(readInt3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
    }

    private static int readInt(byte[] bArr, int i) {
        return ((bArr[i] & ForkServer.ERROR) << 24) + ((bArr[i + 1] & ForkServer.ERROR) << 16) + ((bArr[i + 2] & ForkServer.ERROR) << 8) + (bArr[i + 3] & ForkServer.ERROR);
    }

    private int remainingBytes() {
        return this.fileLength - usedBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ringRead(int i, byte[] bArr, int i3, int i4) {
        int wrapPosition = wrapPosition(i);
        int i5 = wrapPosition + i4;
        int i6 = this.fileLength;
        if (i5 <= i6) {
            this.raf.seek(wrapPosition);
            this.raf.readFully(bArr, i3, i4);
            return;
        }
        int i7 = i6 - wrapPosition;
        this.raf.seek(wrapPosition);
        this.raf.readFully(bArr, i3, i7);
        this.raf.seek(16L);
        this.raf.readFully(bArr, i3 + i7, i4 - i7);
    }

    private void ringWrite(int i, byte[] bArr, int i3, int i4) {
        int wrapPosition = wrapPosition(i);
        int i5 = wrapPosition + i4;
        int i6 = this.fileLength;
        if (i5 <= i6) {
            this.raf.seek(wrapPosition);
            this.raf.write(bArr, i3, i4);
            return;
        }
        int i7 = i6 - wrapPosition;
        this.raf.seek(wrapPosition);
        this.raf.write(bArr, i3, i7);
        this.raf.seek(16L);
        this.raf.write(bArr, i3 + i7, i4 - i7);
    }

    private void setLength(int i) {
        this.raf.setLength(i);
        this.raf.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wrapPosition(int i) {
        int i3 = this.fileLength;
        if (i < i3) {
            return i;
        }
        return (i + 16) - i3;
    }

    private void writeHeader(int i, int i3, int i4, int i5) {
        writeInts(this.buffer, i, i3, i4, i5);
        this.raf.seek(0L);
        this.raf.write(this.buffer);
    }

    private static void writeInt(byte[] bArr, int i, int i3) {
        bArr[i] = (byte) (i3 >> 24);
        bArr[i + 1] = (byte) (i3 >> 16);
        bArr[i + 2] = (byte) (i3 >> 8);
        bArr[i + 3] = (byte) i3;
    }

    private static void writeInts(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i3 : iArr) {
            writeInt(bArr, i, i3);
            i += 4;
        }
    }

    public void add(byte[] bArr) {
        add(bArr, 0, bArr.length);
    }

    public synchronized void clear() {
        try {
            writeHeader(INITIAL_LENGTH, 0, 0, 0);
            this.elementCount = 0;
            Element element = Element.NULL;
            this.first = element;
            this.last = element;
            if (this.fileLength > INITIAL_LENGTH) {
                setLength(INITIAL_LENGTH);
            }
            this.fileLength = INITIAL_LENGTH;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.raf.close();
    }

    public synchronized void forEach(ElementReader elementReader) {
        int i = this.first.position;
        for (int i3 = 0; i3 < this.elementCount; i3++) {
            Element readElement = readElement(i);
            elementReader.read(new ElementInputStream(readElement), readElement.length);
            i = wrapPosition(readElement.position + 4 + readElement.length);
        }
    }

    public boolean hasSpaceFor(int i, int i3) {
        if (usedBytes() + 4 + i <= i3) {
            return true;
        }
        return false;
    }

    public synchronized boolean isEmpty() {
        boolean z3;
        if (this.elementCount == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        return z3;
    }

    public synchronized byte[] peek() {
        if (isEmpty()) {
            return null;
        }
        Element element = this.first;
        int i = element.length;
        byte[] bArr = new byte[i];
        ringRead(element.position + 4, bArr, 0, i);
        return bArr;
    }

    public synchronized void remove() {
        try {
            if (!isEmpty()) {
                if (this.elementCount == 1) {
                    clear();
                } else {
                    Element element = this.first;
                    int wrapPosition = wrapPosition(element.position + 4 + element.length);
                    ringRead(wrapPosition, this.buffer, 0, 4);
                    int readInt = readInt(this.buffer, 0);
                    writeHeader(this.fileLength, this.elementCount - 1, wrapPosition, this.last.position);
                    this.elementCount--;
                    this.first = new Element(wrapPosition, readInt);
                }
            } else {
                throw new NoSuchElementException();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[fileLength=");
        sb.append(this.fileLength);
        sb.append(", size=");
        sb.append(this.elementCount);
        sb.append(", first=");
        sb.append(this.first);
        sb.append(", last=");
        sb.append(this.last);
        sb.append(", element lengths=[");
        try {
            forEach(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1
                boolean first = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void read(InputStream inputStream, int i) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e4) {
            LOGGER.log(Level.WARNING, "read error", (Throwable) e4);
        }
        sb.append("]]");
        return sb.toString();
    }

    public int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        Element element = this.last;
        int i = element.position;
        int i3 = this.first.position;
        if (i >= i3) {
            return (i - i3) + 4 + element.length + 16;
        }
        return (((i + 4) + element.length) + this.fileLength) - i3;
    }

    public synchronized void add(byte[] bArr, int i, int i3) {
        int wrapPosition;
        try {
            nonNull(bArr, "buffer");
            if ((i | i3) >= 0 && i3 <= bArr.length - i) {
                expandIfNecessary(i3);
                boolean isEmpty = isEmpty();
                if (isEmpty) {
                    wrapPosition = 16;
                } else {
                    Element element = this.last;
                    wrapPosition = wrapPosition(element.position + 4 + element.length);
                }
                Element element2 = new Element(wrapPosition, i3);
                writeInt(this.buffer, 0, i3);
                ringWrite(element2.position, this.buffer, 0, 4);
                ringWrite(element2.position + 4, bArr, i, i3);
                writeHeader(this.fileLength, this.elementCount + 1, isEmpty ? element2.position : this.first.position, element2.position);
                this.last = element2;
                this.elementCount++;
                if (isEmpty) {
                    this.first = element2;
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public QueueFile(RandomAccessFile randomAccessFile) {
        this.buffer = new byte[16];
        this.raf = randomAccessFile;
        readHeader();
    }

    public synchronized void peek(ElementReader elementReader) {
        if (this.elementCount > 0) {
            elementReader.read(new ElementInputStream(this.first), this.first.length);
        }
    }
}
