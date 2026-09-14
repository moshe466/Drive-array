package com.google.android.play.core.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al implements ad {
    public static void a(ClassLoader classLoader, Set<File> set, aq aqVar) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getParentFile());
        }
        Object a = af.a(classLoader);
        List list = (List) ba.a(a, "nativeLibraryDirectories", List.class).a();
        hashSet.removeAll(list);
        list.addAll(hashSet);
        ArrayList arrayList = new ArrayList();
        Object[] a2 = aqVar.a(a, new ArrayList<>(hashSet), null, arrayList);
        if (arrayList.isEmpty()) {
            ba.b(a, "nativeLibraryPathElements", Object.class).b(a2);
            return;
        }
        aa aaVar = new aa("Error in makePathElements");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            bj.a(aaVar, (IOException) obj);
        }
        throw aaVar;
    }

    public static boolean a(ClassLoader classLoader, File file, File file2, boolean z, String str) {
        return af.a(classLoader, file, file2, z, new ao(), str, new ah());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object[] b(Object obj, List<File> list, File file, List<IOException> list2) {
        return (Object[]) ba.a(obj, "makePathElements", Object[].class, List.class, list, File.class, file, List.class, list2);
    }

    @Override // com.google.android.play.core.internal.ad
    public final void a(ClassLoader classLoader, Set<File> set) {
        a(classLoader, set, new an());
    }

    @Override // com.google.android.play.core.internal.ad
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, "zip");
    }
}
