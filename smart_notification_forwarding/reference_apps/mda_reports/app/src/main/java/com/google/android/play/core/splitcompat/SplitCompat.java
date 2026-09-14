package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ac;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ba;
import com.google.android.play.core.internal.bj;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class SplitCompat {
    private static final AtomicReference<SplitCompat> a = new AtomicReference<>(null);
    private final c b;
    private final Set<String> c = new HashSet();

    private SplitCompat(Context context) {
        try {
            this.b = new c(context);
        } catch (PackageManager.NameNotFoundException | IOException e) {
            throw new aa("Failed to initialize FileStorage", e);
        }
    }

    private static void a(Context context, Set<File> set) {
        AssetManager assets = context.getAssets();
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) ba.a(assets, "addAssetPath", Integer.class, (Class<String>) String.class, it.next().getPath())).intValue();
            StringBuilder sb = new StringBuilder(39);
            sb.append("addAssetPath completed with ");
            sb.append(intValue);
            Log.d("SplitCompat", sb.toString());
        }
    }

    public static boolean a() {
        return a.get() != null;
    }

    public static boolean a(Context context) {
        return a(context, true);
    }

    private static boolean a(Context context, boolean z) {
        if (b()) {
            return false;
        }
        boolean compareAndSet = a.compareAndSet(null, new SplitCompat(context));
        SplitCompat splitCompat = a.get();
        if (compareAndSet) {
            com.google.android.play.core.splitinstall.g.a(new ac(context, a.a(), new ba(context, splitCompat.b, new ag()), splitCompat.b, new com.google.android.play.core.splitinstall.j()));
            com.google.android.play.core.splitinstall.i.a(new m(splitCompat));
            a.a().execute(new o(context));
        }
        try {
            splitCompat.b(context, z);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }

    private static boolean a(q qVar) {
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(qVar.a());
            try {
                boolean z = zipFile2.getEntry("classes.dex") != null;
                zipFile2.close();
                return z;
            } catch (IOException e) {
                e = e;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        bj.a(e, e2);
                    }
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    private final synchronized void b(Context context) {
        HashSet hashSet = new HashSet();
        SplitCompat splitCompat = a.get();
        Iterator<String> it = (splitCompat == null ? Collections.emptySet() : splitCompat.c()).iterator();
        while (it.hasNext()) {
            hashSet.add(this.b.b(it.next()));
        }
        a(context, hashSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final synchronized void b(android.content.Context r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.b(android.content.Context, boolean):void");
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT < 21;
    }

    private static List<String> c(Context context) {
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            return packageInfo.splitNames == null ? new ArrayList() : Arrays.asList(packageInfo.splitNames);
        } catch (PackageManager.NameNotFoundException e) {
            throw new IOException(String.format("Cannot load data for application '%s'", packageName), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized Set<String> c() {
        return new HashSet(this.c);
    }

    public static boolean install(Context context) {
        return a(context, false);
    }

    public static boolean installActivity(Context context) {
        if (b()) {
            return false;
        }
        SplitCompat splitCompat = a.get();
        if (splitCompat == null) {
            throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
        }
        try {
            splitCompat.b(context);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }
}
