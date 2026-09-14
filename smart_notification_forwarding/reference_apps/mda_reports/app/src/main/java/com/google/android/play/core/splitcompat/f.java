package com.google.android.play.core.splitcompat;

import android.os.Build;
import android.util.Log;
import com.google.android.play.core.internal.bj;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class f {
    private static final Pattern a = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    private final c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<File> a(Set<k> set, q qVar, ZipFile zipFile) {
        HashSet hashSet = new HashSet();
        a(qVar, set, new j(hashSet, qVar, zipFile));
        return hashSet;
    }

    private static void a(q qVar, i iVar) {
        ZipFile zipFile;
        String format;
        try {
            zipFile = new ZipFile(qVar.a());
        } catch (IOException e) {
            e = e;
            zipFile = null;
        }
        try {
            String b = qVar.b();
            HashMap hashMap = new HashMap();
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                Matcher matcher = a.matcher(nextElement.getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", b, group2, group));
                    Set set = (Set) hashMap.get(group);
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(group, set);
                    }
                    set.add(new k(nextElement, group2));
                }
            }
            HashMap hashMap2 = new HashMap();
            for (String str : Build.SUPPORTED_ABIS) {
                if (hashMap.containsKey(str)) {
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI", str));
                    for (k kVar : (Set) hashMap.get(str)) {
                        if (hashMap2.containsKey(kVar.a)) {
                            format = String.format("NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI", kVar.a, str);
                        } else {
                            hashMap2.put(kVar.a, kVar);
                            format = String.format("NativeLibraryExtractor: using library %s for ABI %s", kVar.a, str);
                        }
                        Log.d("SplitCompat", format);
                    }
                } else {
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are no native libraries for supported ABI %s", str));
                }
            }
            iVar.a(zipFile, new HashSet(hashMap2.values()));
            zipFile.close();
        } catch (IOException e2) {
            e = e2;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    bj.a(e, e3);
                }
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(q qVar, Set<k> set, l lVar) {
        for (k kVar : set) {
            File a2 = this.b.a(qVar.b(), kVar.a);
            lVar.a(kVar, a2, a2.exists() && a2.length() == kVar.b.getSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ZipFile zipFile, ZipEntry zipEntry, File file) {
        byte[] bArr = new byte[4096];
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                } finally {
                }
            }
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    bj.a(th, th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<File> a() {
        boolean z;
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<q> d = this.b.d();
        for (String str : this.b.e()) {
            Iterator<q> it = d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next().b().equals(str)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", str));
                this.b.d(str);
            }
        }
        HashSet hashSet = new HashSet();
        for (q qVar : d) {
            HashSet hashSet2 = new HashSet();
            a(qVar, new g(this, hashSet2, qVar));
            for (File file : this.b.e(qVar.b())) {
                if (!hashSet2.contains(file)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", file.getAbsolutePath(), qVar.b(), qVar.a().getAbsolutePath()));
                    this.b.b(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<File> a(q qVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        a(qVar, new e(this, qVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }
}
