package io.fabric.sdk.android.services.common;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class QueueFile implements Closeable {
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    int a;
    private final byte[] buffer = new byte[16];
    private int elementCount;
    private Element first;
    private Element last;
    private final RandomAccessFile raf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Element {
        static final Element c = new Element(0, 0);
        final int a;
        final int b;

        Element(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public String toString() {
            return Element.class.getSimpleName() + "[position = " + this.a + ", length = " + this.b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ElementInputStream extends InputStream {
        private int position;
        private int remaining;

        private ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.a + 4);
            this.remaining = element.b;
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

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            QueueFile.nonNull(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.remaining;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            QueueFile.this.ringRead(this.position, bArr, i, i2);
            this.position = QueueFile.this.wrapPosition(this.position + i2);
            this.remaining -= i2;
            return i2;
        }
    }

    /* loaded from: classes2.dex */
    public interface ElementReader {
        void read(InputStream inputStream, int i);
    }

    public QueueFile(File file) {
        if (!file.exists()) {
            initialize(file);
        }
        this.raf = open(file);
        readHeader();
    }

    private void expandIfNecessary(int i) {
        int i2 = i + 4;
        int remainingBytes = remainingBytes();
        if (remainingBytes >= i2) {
            return;
        }
        int i3 = this.a;
        do {
            remainingBytes += i3;
            i3 <<= 1;
        } while (remainingBytes < i2);
        setLength(i3);
        Element element = this.last;
        int wrapPosition = wrapPosition(element.a + 4 + element.b);
        if (wrapPosition < this.first.a) {
            FileChannel channel = this.raf.getChannel();
            channel.position(this.a);
            long j = wrapPosition - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i4 = this.last.a;
        int i5 = this.first.a;
        if (i4 < i5) {
            int i6 = (this.a + i4) - 16;
            writeHeader(i3, this.elementCount, i5, i6);
            this.last = new Element(i6, this.last.b);
        } else {
            writeHeader(i3, this.elementCount, i5, i4);
        }
        this.a = i3;
    }

    private static void initialize(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile open = open(file2);
        try {
            open.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            open.seek(0L);
            byte[] bArr = new byte[16];
            writeInts(bArr, 4096, 0, 0, 0);
            open.write(bArr);
            open.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            open.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T nonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile open(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private Element readElement(int i) {
        if (i == 0) {
            return Element.c;
        }
        this.raf.seek(i);
        return new Element(i, this.raf.readInt());
    }

    private void readHeader() {
        this.raf.seek(0L);
        this.raf.readFully(this.buffer);
        this.a = readInt(this.buffer, 0);
        if (this.a <= this.raf.length()) {
            this.elementCount = readInt(this.buffer, 4);
            int readInt = readInt(this.buffer, 8);
            int readInt2 = readInt(this.buffer, 12);
            this.first = readElement(readInt);
            this.last = readElement(readInt2);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.raf.length());
    }

    private static int readInt(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    private int remainingBytes() {
        return this.a - usedBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ringRead(int i, byte[] bArr, int i2, int i3) {
        RandomAccessFile randomAccessFile;
        int wrapPosition = wrapPosition(i);
        int i4 = wrapPosition + i3;
        int i5 = this.a;
        if (i4 <= i5) {
            this.raf.seek(wrapPosition);
            randomAccessFile = this.raf;
        } else {
            int i6 = i5 - wrapPosition;
            this.raf.seek(wrapPosition);
            this.raf.readFully(bArr, i2, i6);
            this.raf.seek(16L);
            randomAccessFile = this.raf;
            i2 += i6;
            i3 -= i6;
        }
        randomAccessFile.readFully(bArr, i2, i3);
    }

    private void ringWrite(int i, byte[] bArr, int i2, int i3) {
        RandomAccessFile randomAccessFile;
        int wrapPosition = wrapPosition(i);
        int i4 = wrapPosition + i3;
        int i5 = this.a;
        if (i4 <= i5) {
            this.raf.seek(wrapPosition);
            randomAccessFile = this.raf;
        } else {
            int i6 = i5 - wrapPosition;
            this.raf.seek(wrapPosition);
            this.raf.write(bArr, i2, i6);
            this.raf.seek(16L);
            randomAccessFile = this.raf;
            i2 += i6;
            i3 -= i6;
        }
        randomAccessFile.write(bArr, i2, i3);
    }

    private void setLength(int i) {
        this.raf.setLength(i);
        this.raf.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wrapPosition(int i) {
        int i2 = this.a;
        return i < i2 ? i : (i + 16) - i2;
    }

    private void writeHeader(int i, int i2, int i3, int i4) {
        writeInts(this.buffer, i, i2, i3, i4);
        this.raf.seek(0L);
        this.raf.write(this.buffer);
    }

    private static void writeInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void writeInts(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            writeInt(bArr, i, i2);
            i += 4;
        }
    }

    public void add(byte[] bArr) {
        add(bArr, 0, bArr.length);
    }

    public synchronized void add(byte[] bArr, int i, int i2) {
        nonNull(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        expandIfNecessary(i2);
        boolean isEmpty = isEmpty();
        Element element = new Element(isEmpty ? 16 : wrapPosition(this.last.a + 4 + this.last.b), i2);
        writeInt(this.buffer, 0, i2);
        ringWrite(element.a, this.buffer, 0, 4);
        ringWrite(element.a + 4, bArr, i, i2);
        writeHeader(this.a, this.elementCount + 1, isEmpty ? element.a : this.first.a, element.a);
        this.last = element;
        this.elementCount++;
        if (isEmpty) {
            this.first = this.last;
        }
    }

    public synchronized void clear() {
        writeHeader(4096, 0, 0, 0);
        this.elementCount = 0;
        this.first = Element.c;
        this.last = Element.c;
        if (this.a > 4096) {
            setLength(4096);
        }
        this.a = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.raf.close();
    }

    public synchronized void forEach(ElementReader elementReader) {
        int i = this.first.a;
        for (int i2 = 0; i2 < this.elementCount; i2++) {
            Element readElement = readElement(i);
            elementReader.read(new ElementInputStream(readElement), readElement.b);
            i = wrapPosition(readElement.a + 4 + readElement.b);
        }
    }

    public boolean hasSpaceFor(int i, int i2) {
        return (usedBytes() + 4) + i <= i2;
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    public synchronized void peek(ElementReader elementReader) {
        if (this.elementCount > 0) {
            elementReader.read(new ElementInputStream(this.first), this.first.b);
        }
    }

    public synchronized byte[] peek() {
        if (isEmpty()) {
            return null;
        }
        int i = this.first.b;
        byte[] bArr = new byte[i];
        ringRead(this.first.a + 4, bArr, 0, i);
        return bArr;
    }

    public synchronized void remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (this.elementCount == 1) {
            clear();
        } else {
            int wrapPosition = wrapPosition(this.first.a + 4 + this.first.b);
            ringRead(wrapPosition, this.buffer, 0, 4);
            int readInt = readInt(this.buffer, 0);
            writeHeader(this.a, this.elementCount - 1, wrapPosition, this.last.a);
            this.elementCount--;
            this.first = new Element(wrapPosition, readInt);
        }
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(QueueFile.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.a);
        sb.append(", size=");
        sb.append(this.elementCount);
        sb.append(", first=");
        sb.append(this.first);
        sb.append(", last=");
        sb.append(this.last);
        sb.append(", element lengths=[");
        try {
            forEach(new ElementReader(this) { // from class: io.fabric.sdk.android.services.common.QueueFile.1
                boolean a = true;

                @Override // io.fabric.sdk.android.services.common.QueueFile.ElementReader
                public void read(InputStream inputStream, int i) {
                    if (this.a) {
                        this.a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    public int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        Element element = this.last;
        int i = element.a;
        int i2 = this.first.a;
        return i >= i2 ? (i - i2) + 4 + element.b + 16 : (((i + 4) + element.b) + this.a) - i2;
    }
}
