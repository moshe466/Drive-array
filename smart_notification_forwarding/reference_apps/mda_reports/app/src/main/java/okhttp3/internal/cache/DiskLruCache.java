package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: classes3.dex */
public final class DiskLruCache implements Closeable, Flushable {
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final Pattern l = Pattern.compile("[a-z0-9_-]{1,120}");
    final FileSystem a;
    private final int appVersion;
    final File b;
    final int c;
    BufferedSink d;
    private final Executor executor;
    int f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    boolean k;
    private long maxSize;
    private long size = 0;
    final LinkedHashMap<String, Entry> e = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final Runnable cleanupRunnable = new Runnable() { // from class: okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.this.h) || DiskLruCache.this.i) {
                    return;
                }
                try {
                    DiskLruCache.this.c();
                } catch (IOException unused) {
                    DiskLruCache.this.j = true;
                }
                try {
                    if (DiskLruCache.this.a()) {
                        DiskLruCache.this.b();
                        DiskLruCache.this.f = 0;
                    }
                } catch (IOException unused2) {
                    DiskLruCache.this.k = true;
                    DiskLruCache.this.d = Okio.buffer(Okio.blackhole());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public final class Editor {
        final Entry a;
        final boolean[] b;
        private boolean done;

        Editor(Entry entry) {
            this.a = entry;
            this.b = entry.e ? null : new boolean[DiskLruCache.this.c];
        }

        void a() {
            if (this.a.f != this) {
                return;
            }
            int i = 0;
            while (true) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (i >= diskLruCache.c) {
                    this.a.f = null;
                    return;
                } else {
                    try {
                        diskLruCache.a.delete(this.a.d[i]);
                    } catch (IOException unused) {
                    }
                    i++;
                }
            }
        }

        public void abort() {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.a.f == this) {
                    DiskLruCache.this.a(this, false);
                }
                this.done = true;
            }
        }

        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.done && this.a.f == this) {
                    try {
                        DiskLruCache.this.a(this, false);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public void commit() {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.a.f == this) {
                    DiskLruCache.this.a(this, true);
                }
                this.done = true;
            }
        }

        public Sink newSink(int i) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.a.f != this) {
                    return Okio.blackhole();
                }
                if (!this.a.e) {
                    this.b[i] = true;
                }
                try {
                    return new FaultHidingSink(DiskLruCache.this.a.sink(this.a.d[i])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                        @Override // okhttp3.internal.cache.FaultHidingSink
                        protected void a(IOException iOException) {
                            synchronized (DiskLruCache.this) {
                                Editor.this.a();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                }
            }
        }

        public Source newSource(int i) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (!this.a.e || this.a.f != this) {
                    return null;
                }
                try {
                    return DiskLruCache.this.a.source(this.a.c[i]);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class Entry {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        Editor f;
        long g;

        Entry(String str) {
            this.a = str;
            int i = DiskLruCache.this.c;
            this.b = new long[i];
            this.c = new File[i];
            this.d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.c; i2++) {
                sb.append(i2);
                this.c[i2] = new File(DiskLruCache.this.b, sb.toString());
                sb.append(".tmp");
                this.d[i2] = new File(DiskLruCache.this.b, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException invalidLengths(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        Snapshot a() {
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.c];
            long[] jArr = (long[]) this.b.clone();
            for (int i = 0; i < DiskLruCache.this.c; i++) {
                try {
                    sourceArr[i] = DiskLruCache.this.a.source(this.c[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < DiskLruCache.this.c && sourceArr[i2] != null; i2++) {
                        Util.closeQuietly(sourceArr[i2]);
                    }
                    try {
                        DiskLruCache.this.a(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return new Snapshot(this.a, this.g, sourceArr, jArr);
        }

        void a(BufferedSink bufferedSink) {
            for (long j : this.b) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }

        void a(String[] strArr) {
            if (strArr.length != DiskLruCache.this.c) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.sources) {
                Util.closeQuietly(source);
            }
        }

        @Nullable
        public Editor edit() {
            return DiskLruCache.this.a(this.key, this.sequenceNumber);
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public Source getSource(int i) {
            return this.sources[i];
        }

        public String key() {
            return this.key;
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.a = fileSystem;
        this.b = file;
        this.appVersion = i;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.c = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private BufferedSink newJournalWriter() {
        return Okio.buffer(new FaultHidingSink(this.a.appendingSink(this.journalFile)) { // from class: okhttp3.internal.cache.DiskLruCache.2
            @Override // okhttp3.internal.cache.FaultHidingSink
            protected void a(IOException iOException) {
                DiskLruCache.this.g = true;
            }
        });
    }

    private void processJournal() {
        this.a.delete(this.journalFileTmp);
        Iterator<Entry> it = this.e.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.c) {
                    this.size += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.c) {
                    this.a.delete(next.c[i]);
                    this.a.delete(next.d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void readJournal() {
        BufferedSource buffer = Okio.buffer(this.a.source(this.journalFile));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.appVersion).equals(readUtf8LineStrict3) || !Integer.toString(this.c).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(buffer.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.f = i - this.e.size();
                    if (buffer.exhausted()) {
                        this.d = newJournalWriter();
                    } else {
                        b();
                    }
                    Util.closeQuietly(buffer);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(buffer);
            throw th;
        }
    }

    private void readJournalLine(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith(REMOVE)) {
                this.e.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = this.e.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.e.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.e = true;
            entry.f = null;
            entry.a(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
            entry.f = new Editor(entry);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith(READ)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void validateKey(String str) {
        if (l.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    synchronized Editor a(String str, long j) {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.e.get(str);
        if (j != -1 && (entry == null || entry.g != j)) {
            return null;
        }
        if (entry != null && entry.f != null) {
            return null;
        }
        if (!this.j && !this.k) {
            this.d.writeUtf8(DIRTY).writeByte(32).writeUtf8(str).writeByte(10);
            this.d.flush();
            if (this.g) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(str);
                this.e.put(str, entry);
            }
            Editor editor = new Editor(entry);
            entry.f = editor;
            return editor;
        }
        this.executor.execute(this.cleanupRunnable);
        return null;
    }

    synchronized void a(Editor editor, boolean z) {
        Entry entry = editor.a;
        if (entry.f != editor) {
            throw new IllegalStateException();
        }
        if (z && !entry.e) {
            for (int i = 0; i < this.c; i++) {
                if (!editor.b[i]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.a.exists(entry.d[i])) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            File file = entry.d[i2];
            if (!z) {
                this.a.delete(file);
            } else if (this.a.exists(file)) {
                File file2 = entry.c[i2];
                this.a.rename(file, file2);
                long j = entry.b[i2];
                long size = this.a.size(file2);
                entry.b[i2] = size;
                this.size = (this.size - j) + size;
            }
        }
        this.f++;
        entry.f = null;
        if (entry.e || z) {
            entry.e = true;
            this.d.writeUtf8(CLEAN).writeByte(32);
            this.d.writeUtf8(entry.a);
            entry.a(this.d);
            this.d.writeByte(10);
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.g = j2;
            }
        } else {
            this.e.remove(entry.a);
            this.d.writeUtf8(REMOVE).writeByte(32);
            this.d.writeUtf8(entry.a);
            this.d.writeByte(10);
        }
        this.d.flush();
        if (this.size > this.maxSize || a()) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    boolean a() {
        int i = this.f;
        return i >= 2000 && i >= this.e.size();
    }

    boolean a(Entry entry) {
        Editor editor = entry.f;
        if (editor != null) {
            editor.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.a.delete(entry.c[i]);
            long j = this.size;
            long[] jArr = entry.b;
            this.size = j - jArr[i];
            jArr[i] = 0;
        }
        this.f++;
        this.d.writeUtf8(REMOVE).writeByte(32).writeUtf8(entry.a).writeByte(10);
        this.e.remove(entry.a);
        if (a()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    synchronized void b() {
        if (this.d != null) {
            this.d.close();
        }
        BufferedSink buffer = Okio.buffer(this.a.sink(this.journalFileTmp));
        try {
            buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong(this.appVersion).writeByte(10);
            buffer.writeDecimalLong(this.c).writeByte(10);
            buffer.writeByte(10);
            for (Entry entry : this.e.values()) {
                if (entry.f != null) {
                    buffer.writeUtf8(DIRTY).writeByte(32);
                    buffer.writeUtf8(entry.a);
                } else {
                    buffer.writeUtf8(CLEAN).writeByte(32);
                    buffer.writeUtf8(entry.a);
                    entry.a(buffer);
                }
                buffer.writeByte(10);
            }
            buffer.close();
            if (this.a.exists(this.journalFile)) {
                this.a.rename(this.journalFile, this.journalFileBackup);
            }
            this.a.rename(this.journalFileTmp, this.journalFile);
            this.a.delete(this.journalFileBackup);
            this.d = newJournalWriter();
            this.g = false;
            this.k = false;
        } catch (Throwable th) {
            buffer.close();
            throw th;
        }
    }

    void c() {
        while (this.size > this.maxSize) {
            a(this.e.values().iterator().next());
        }
        this.j = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.h && !this.i) {
            for (Entry entry : (Entry[]) this.e.values().toArray(new Entry[this.e.size()])) {
                if (entry.f != null) {
                    entry.f.abort();
                }
            }
            c();
            this.d.close();
            this.d = null;
            this.i = true;
            return;
        }
        this.i = true;
    }

    public void delete() {
        close();
        this.a.deleteContents(this.b);
    }

    @Nullable
    public Editor edit(String str) {
        return a(str, -1L);
    }

    public synchronized void evictAll() {
        initialize();
        for (Entry entry : (Entry[]) this.e.values().toArray(new Entry[this.e.size()])) {
            a(entry);
        }
        this.j = false;
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.h) {
            checkNotClosed();
            c();
            this.d.flush();
        }
    }

    public synchronized Snapshot get(String str) {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.e.get(str);
        if (entry != null && entry.e) {
            Snapshot a = entry.a();
            if (a == null) {
                return null;
            }
            this.f++;
            this.d.writeUtf8(READ).writeByte(32).writeUtf8(str).writeByte(10);
            if (a()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return a;
        }
        return null;
    }

    public File getDirectory() {
        return this.b;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void initialize() {
        if (this.h) {
            return;
        }
        if (this.a.exists(this.journalFileBackup)) {
            if (this.a.exists(this.journalFile)) {
                this.a.delete(this.journalFileBackup);
            } else {
                this.a.rename(this.journalFileBackup, this.journalFile);
            }
        }
        if (this.a.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.h = true;
                return;
            } catch (IOException e) {
                Platform.get().log(5, "DiskLruCache " + this.b + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.i = false;
                } catch (Throwable th) {
                    this.i = false;
                    throw th;
                }
            }
        }
        b();
        this.h = true;
    }

    public synchronized boolean isClosed() {
        return this.i;
    }

    public synchronized boolean remove(String str) {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.e.get(str);
        if (entry == null) {
            return false;
        }
        boolean a = a(entry);
        if (a && this.size <= this.maxSize) {
            this.j = false;
        }
        return a;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.h) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() {
        initialize();
        return this.size;
    }

    public synchronized Iterator<Snapshot> snapshots() {
        initialize();
        return new Iterator<Snapshot>() { // from class: okhttp3.internal.cache.DiskLruCache.3
            final Iterator<Entry> a;
            Snapshot b;
            Snapshot c;

            {
                this.a = new ArrayList(DiskLruCache.this.e.values()).iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.b != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.i) {
                        return false;
                    }
                    while (this.a.hasNext()) {
                        Snapshot a = this.a.next().a();
                        if (a != null) {
                            this.b = a;
                            return true;
                        }
                    }
                    return false;
                }
            }

            @Override // java.util.Iterator
            public Snapshot next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.c = this.b;
                this.b = null;
                return this.c;
            }

            @Override // java.util.Iterator
            public void remove() {
                Snapshot snapshot = this.c;
                if (snapshot == null) {
                    throw new IllegalStateException("remove() before next()");
                }
                try {
                    DiskLruCache.this.remove(snapshot.key);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.c = null;
                    throw th;
                }
                this.c = null;
            }
        };
    }
}
