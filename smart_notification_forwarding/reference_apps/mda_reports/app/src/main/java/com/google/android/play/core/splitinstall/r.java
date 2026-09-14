package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.bc;
import com.google.android.play.core.tasks.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r {
    private static final com.google.android.play.core.splitcompat.a b = new com.google.android.play.core.splitcompat.a("SplitInstallService");
    private static final Intent c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");
    final com.google.android.play.core.internal.t<bc> a;
    private final String d;

    public r(Context context) {
        this(context, context.getPackageName());
    }

    private r(Context context, String str) {
        this.d = str;
        this.a = new com.google.android.play.core.internal.t<>(com.google.android.play.core.internal.ag.a(context), b, "SplitInstallService", c, q.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<Bundle> c(Collection<String> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (String str : collection) {
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10604);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<Bundle> d(Collection<String> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (String str : collection) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final Task<List<SplitInstallSessionState>> a() {
        b.a("getSessionStates", new Object[0]);
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new z(this, hVar, hVar));
        return hVar.a();
    }

    public final Task<SplitInstallSessionState> a(int i) {
        b.a("getSessionState(%d)", Integer.valueOf(i));
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new w(this, hVar, i, hVar));
        return hVar.a();
    }

    public final Task<Integer> a(Collection<String> collection, Collection<String> collection2) {
        b.a("startInstall(%s,%s)", collection, collection2);
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new t(this, hVar, collection, collection2, hVar));
        return hVar.a();
    }

    public final Task<Void> a(List<String> list) {
        b.a("deferredUninstall(%s)", list);
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new s(this, hVar, list, hVar));
        return hVar.a();
    }

    public final Task<Void> b(int i) {
        b.a("cancelInstall(%d)", Integer.valueOf(i));
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new y(this, hVar, i, hVar));
        return hVar.a();
    }

    public final Task<Void> b(List<String> list) {
        b.a("deferredInstall(%s)", list);
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new v(this, hVar, list, hVar));
        return hVar.a();
    }

    public final Task<Void> c(List<String> list) {
        b.a("deferredLanguageInstall(%s)", list);
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new u(this, hVar, list, hVar));
        return hVar.a();
    }

    public final Task<Void> d(List<String> list) {
        b.a("deferredLanguageUninstall(%s)", list);
        com.google.android.play.core.tasks.h hVar = new com.google.android.play.core.tasks.h();
        this.a.a(new x(this, hVar, list, hVar));
        return hVar.a();
    }
}
