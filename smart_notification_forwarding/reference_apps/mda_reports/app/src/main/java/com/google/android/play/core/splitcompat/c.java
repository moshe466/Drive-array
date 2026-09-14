package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.util.Log;
import com.google.android.play.core.internal.ag;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {
    private final File a;
    private final long b;

    public c(Context context) {
        this(context.getFilesDir(), context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
    }

    private c(File file, long j) {
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 82);
        sb.append("FileStorage: initializing (files directory = ");
        sb.append(absolutePath);
        sb.append(", versionCode = ");
        sb.append(j);
        sb.append(")");
        Log.d("SplitCompat", sb.toString());
        this.a = file;
        this.b = j;
    }

    private static File c(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return file;
            }
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
        file.mkdirs();
        if (file.isDirectory()) {
            return file;
        }
        String valueOf = String.valueOf(file.getAbsolutePath());
        throw new IOException(valueOf.length() != 0 ? "Unable to create directory: ".concat(valueOf) : new String("Unable to create directory: "));
    }

    private static void d(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                d(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", file.getAbsolutePath()));
        }
    }

    private final File f() {
        return c(new File(g(), "verified-splits"));
    }

    private final File g() {
        return c(new File(h(), Long.toString(this.b)));
    }

    private final File g(String str) {
        return c(new File(i(), str));
    }

    private final File h() {
        return c(new File(this.a, "splitcompat"));
    }

    private static String h(String str) {
        String valueOf = String.valueOf(str);
        return ".apk".length() != 0 ? valueOf.concat(".apk") : new String(valueOf);
    }

    private final File i() {
        return c(new File(g(), "native-libraries"));
    }

    public final File a(File file) {
        return new File(f(), file.getName());
    }

    public final File a(String str) {
        return new File(c(), h(str));
    }

    public final File a(String str, String str2) {
        return new File(g(str), str2);
    }

    public final void a() {
        File h = h();
        String[] list = h.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.b))) {
                    File file = new File(h, str);
                    String valueOf = String.valueOf(file);
                    long j = this.b;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    d(file);
                }
            }
        }
    }

    public final File b() {
        return new File(g(), "lock.tmp");
    }

    public final File b(String str) {
        return new File(f(), h(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(File file) {
        ag.a(file.getParentFile().getParentFile().equals(i()), "File to remove is not a native library");
        d(file);
    }

    public final File c() {
        return c(new File(g(), "unverified-splits"));
    }

    public final File c(String str) {
        return c(new File(c(new File(g(), "dex")), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<q> d() {
        File f = f();
        HashSet hashSet = new HashSet();
        File[] listFiles = f.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    hashSet.add(new b(file, file.getName().substring(0, r6.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str) {
        d(g(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> e() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = i().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<File> e(String str) {
        HashSet hashSet = new HashSet();
        File[] listFiles = g(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(String str) {
        d(b(str));
    }
}
