package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class aj {
    private final Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(Context context) {
        this.a = context;
    }

    private final SharedPreferences b() {
        return this.a.getSharedPreferences("playcore_split_install_internal", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized Set<String> a() {
        try {
            Set<String> stringSet = b().getStringSet("deferred_uninstall_module_list", new HashSet());
            if (stringSet != null) {
                return stringSet;
            }
            return new HashSet();
        } catch (Exception unused) {
            return new HashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(Collection<String> collection) {
        Set<String> a = a();
        boolean z = false;
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (a.add(it.next())) {
                z = true;
            }
        }
        if (z) {
            try {
                b().edit().putStringSet("deferred_uninstall_module_list", a).apply();
            } catch (Exception unused) {
            }
        }
    }
}
