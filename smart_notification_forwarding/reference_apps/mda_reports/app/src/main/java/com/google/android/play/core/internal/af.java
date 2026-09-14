package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af implements ad {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(ClassLoader classLoader) {
        return ba.a(classLoader, "pathList", Object.class).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ClassLoader classLoader, File file, File file2, boolean z, aj ajVar, String str, ak akVar) {
        ArrayList<IOException> arrayList = new ArrayList<>();
        Object a = a(classLoader);
        ax b = ba.b(a, "dexElements", Object.class);
        List asList = Arrays.asList((Object[]) b.a());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            arrayList2.add((File) ba.a(it.next(), str, File.class).a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        int i = 0;
        if (!z && !akVar.a(a, file2, file)) {
            String valueOf = String.valueOf(file2.getPath());
            Log.w("SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "));
            return false;
        }
        b.a(ajVar.a(a, new ArrayList<>(Collections.singleton(file2)), file, arrayList));
        if (arrayList.isEmpty()) {
            return true;
        }
        aa aaVar = new aa("DexPathList.makeDexElement failed");
        int size = arrayList.size();
        while (i < size) {
            IOException iOException = arrayList.get(i);
            i++;
            IOException iOException2 = iOException;
            Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException2);
            bj.a(aaVar, iOException2);
        }
        ba.b(a, "dexElementsSuppressedExceptions", IOException.class).a((Collection) arrayList);
        throw aaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ClassLoader classLoader, Set<File> set) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (File file : set) {
            String valueOf = String.valueOf(file.getParentFile().getAbsolutePath());
            Log.d("Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "));
            hashSet.add(file.getParentFile());
        }
        ax b = ba.b(a(classLoader), "nativeLibraryDirectories", File.class);
        hashSet.removeAll(Arrays.asList((File[]) b.a()));
        int size = hashSet.size();
        StringBuilder sb = new StringBuilder(30);
        sb.append("Adding directories ");
        sb.append(size);
        Log.d("Splitcompat", sb.toString());
        b.b(hashSet);
    }

    @Override // com.google.android.play.core.internal.ad
    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.ad
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, new ai(), "zip", new ah());
    }
}
