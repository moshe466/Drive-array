package com.lt.plugin.lt_plugin.services;

import android.content.Context;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4381a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f4382b;

    public /* synthetic */ c(Context context, int i) {
        this.f4381a = i;
        this.f4382b = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.f4381a
            switch(r0) {
                case 0: goto Lb8;
                case 1: goto L2f;
                case 2: goto L13;
                default: goto L5;
            }
        L5:
            i0.c r0 = new i0.c
            r0.<init>()
            androidx.lifecycle.N r1 = i0.e.f4951a
            r2 = 0
            android.content.Context r3 = r11.f4382b
            i0.e.t(r3, r0, r1, r2)
            return
        L13:
            java.util.concurrent.ThreadPoolExecutor r4 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r5 = 0
            r6 = 1
            r7 = 0
            r4.<init>(r5, r6, r7, r9, r10)
            com.lt.plugin.lt_plugin.services.c r0 = new com.lt.plugin.lt_plugin.services.c
            r1 = 3
            android.content.Context r2 = r11.f4382b
            r0.<init>(r2, r1)
            r4.execute(r0)
            return
        L2f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 1
            if (r0 < r1) goto Lb5
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.String r1 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            android.content.Context r3 = r11.f4382b
            r0.<init>(r3, r1)
            android.content.pm.PackageManager r1 = r3.getPackageManager()
            int r1 = r1.getComponentEnabledSetting(r0)
            if (r1 == r2) goto Lb5
            boolean r1 = F.a.b()
            java.lang.String r4 = "locale"
            if (r1 == 0) goto L8c
            t.f r1 = h.o.f4839j
            r1.getClass()
            t.a r5 = new t.a
            r5.<init>(r1)
        L5b:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L7a
            java.lang.Object r1 = r5.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r1 = r1.get()
            h.o r1 = (h.o) r1
            if (r1 == 0) goto L5b
            h.y r1 = (h.y) r1
            android.content.Context r1 = r1.f4912n
            if (r1 == 0) goto L5b
            java.lang.Object r1 = r1.getSystemService(r4)
            goto L7b
        L7a:
            r1 = 0
        L7b:
            if (r1 == 0) goto L91
            android.os.LocaleList r1 = h.AbstractC0444n.a(r1)
            F.f r5 = new F.f
            F.g r6 = new F.g
            r6.<init>(r1)
            r5.<init>(r6)
            goto L93
        L8c:
            F.f r5 = h.o.f4835c
            if (r5 == 0) goto L91
            goto L93
        L91:
            F.f r5 = F.f.f161b
        L93:
            F.g r1 = r5.f162a
            android.os.LocaleList r1 = r1.f163a
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto Lae
            java.lang.String r1 = E1.b.x(r3)
            java.lang.Object r4 = r3.getSystemService(r4)
            if (r4 == 0) goto Lae
            android.os.LocaleList r1 = h.AbstractC0443m.a(r1)
            h.AbstractC0444n.b(r4, r1)
        Lae:
            android.content.pm.PackageManager r1 = r3.getPackageManager()
            r1.setComponentEnabledSetting(r0, r2, r2)
        Lb5:
            h.o.f4838f = r2
            return
        Lb8:
            android.content.Context r0 = r11.f4382b
            com.lt.plugin.lt_plugin.services.ActiveDispatchRefresh.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lt.plugin.lt_plugin.services.c.run():void");
    }
}
