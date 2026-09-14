package com.opentok.android;

import android.os.Build;
import com.opentok.android.Session;
import com.opentok.android.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {

    /* loaded from: classes.dex */
    static class a extends Session.d {
        a() {
        }
    }

    static {
        new j.a();
        a aVar = new a();
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.a();
        }
    }

    public static void a(boolean z10) {
    }
}
