package n0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
final class b implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private final File f12166f;

    /* renamed from: g, reason: collision with root package name */
    private final long f12167g;

    /* renamed from: h, reason: collision with root package name */
    private final File f12168h;

    /* renamed from: i, reason: collision with root package name */
    private final RandomAccessFile f12169i;

    /* renamed from: j, reason: collision with root package name */
    private final FileChannel f12170j;

    /* renamed from: k, reason: collision with root package name */
    private final FileLock f12171k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements FileFilter {
        a(b bVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0255b extends File {

        /* renamed from: f, reason: collision with root package name */
        public long f12172f;

        public C0255b(File file, String str) {
            super(file, str);
            this.f12172f = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file, File file2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MultiDexExtractor(");
        sb2.append(file.getPath());
        sb2.append(", ");
        sb2.append(file2.getPath());
        sb2.append(")");
        this.f12166f = file;
        this.f12168h = file2;
        this.f12167g = v(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f12169i = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f12170j = channel;
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Blocking on lock ");
                sb3.append(file3.getPath());
                this.f12171k = channel.lock();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(file3.getPath());
                sb4.append(" locked");
            } catch (IOException e10) {
                e = e10;
                d(this.f12170j);
                throw e;
            } catch (Error e11) {
                e = e11;
                d(this.f12170j);
                throw e;
            } catch (RuntimeException e12) {
                e = e12;
                d(this.f12170j);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e13) {
            d(this.f12169i);
            throw e13;
        }
    }

    private static boolean D(Context context, File file, long j10, String str) {
        SharedPreferences g10 = g(context);
        if (g10.getLong(str + "timestamp", -1L) == j(file)) {
            if (g10.getLong(str + "crc", -1L) == j10) {
                return false;
            }
        }
        return true;
    }

    private List<C0255b> M(Context context, String str) {
        String str2 = this.f12166f.getName() + ".classes";
        SharedPreferences g10 = g(context);
        int i10 = g10.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i10 + (-1));
        int i11 = 2;
        while (i11 <= i10) {
            C0255b c0255b = new C0255b(this.f12168h, str2 + i11 + ".zip");
            if (!c0255b.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + c0255b.getPath() + "'");
            }
            c0255b.f12172f = v(c0255b);
            long j10 = g10.getLong(str + "dex.crc." + i11, -1L);
            long j11 = g10.getLong(str + "dex.time." + i11, -1L);
            long lastModified = c0255b.lastModified();
            if (j11 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = g10;
                if (j10 == c0255b.f12172f) {
                    arrayList.add(c0255b);
                    i11++;
                    g10 = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + c0255b + " (key \"" + str + "\"), expected modification time: " + j11 + ", modification time: " + lastModified + ", expected crc: " + j10 + ", file crc: " + c0255b.f12172f);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x012c, code lost:
    
        throw new java.io.IOException("Could not create zip file " + r8.getAbsolutePath() + " for secondary dex (" + r5 + ")");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<n0.b.C0255b> N() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.b.N():java.util.List");
    }

    private static void O(Context context, String str, long j10, long j11, List<C0255b> list) {
        SharedPreferences.Editor edit = g(context).edit();
        edit.putLong(str + "timestamp", j10);
        edit.putLong(str + "crc", j11);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i10 = 2;
        for (C0255b c0255b : list) {
            edit.putLong(str + "dex.crc." + i10, c0255b.f12172f);
            edit.putLong(str + "dex.time." + i10, c0255b.lastModified());
            i10++;
        }
        edit.commit();
    }

    private void c() {
        StringBuilder sb2;
        String str;
        File[] listFiles = this.f12168h.listFiles(new a(this));
        if (listFiles == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to list secondary dex dir content (");
            sb3.append(this.f12168h.getPath());
            sb3.append(").");
            return;
        }
        for (File file : listFiles) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Trying to delete old file ");
            sb4.append(file.getPath());
            sb4.append(" of size ");
            sb4.append(file.length());
            if (file.delete()) {
                sb2 = new StringBuilder();
                str = "Deleted old file ";
            } else {
                sb2 = new StringBuilder();
                str = "Failed to delete old file ";
            }
            sb2.append(str);
            sb2.append(file.getPath());
        }
    }

    private static void d(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private static void f(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Extracting ");
        sb2.append(createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        zipOutputStream.write(bArr, 0, read);
                    }
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!createTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Renaming to ");
                sb3.append(file.getPath());
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            d(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences g(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long j(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long v(File file) {
        long c10 = c.c(file);
        return c10 == -1 ? c10 - 1 : c10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends File> H(Context context, String str, boolean z10) {
        List<C0255b> list;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MultiDexExtractor.load(");
        sb2.append(this.f12166f.getPath());
        sb2.append(", ");
        sb2.append(z10);
        sb2.append(", ");
        sb2.append(str);
        sb2.append(")");
        if (!this.f12171k.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z10 && !D(context, this.f12166f, this.f12167g, str)) {
            try {
                list = M(context, str);
            } catch (IOException unused) {
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("load found ");
            sb3.append(list.size());
            sb3.append(" secondary dex files");
            return list;
        }
        List<C0255b> N = N();
        O(context, str, j(this.f12166f), this.f12167g, N);
        list = N;
        StringBuilder sb32 = new StringBuilder();
        sb32.append("load found ");
        sb32.append(list.size());
        sb32.append(" secondary dex files");
        return list;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12171k.release();
        this.f12170j.close();
        this.f12169i.close();
    }
}
