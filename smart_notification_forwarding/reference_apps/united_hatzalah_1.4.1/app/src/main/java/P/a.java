package P;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import m.f1;
import o1.j;

/* loaded from: classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1548a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1549b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f1 f1Var) {
        super(new Handler());
        this.f1549b = f1Var;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.f1548a) {
            case 0:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z3) {
        Cursor cursor;
        switch (this.f1548a) {
            case 0:
                f1 f1Var = (f1) this.f1549b;
                if (!f1Var.f1553b || (cursor = f1Var.f1554c) == null || cursor.isClosed()) {
                    return;
                }
                f1Var.f1552a = f1Var.f1554c.requery();
                return;
            default:
                super.onChange(z3);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(j jVar, Handler handler) {
        super(handler);
        this.f1549b = jVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
    
        if (r15 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096  */
    @Override // android.database.ContentObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onChange(boolean r14, android.net.Uri r15) {
        /*
            r13 = this;
            int r0 = r13.f1548a
            switch(r0) {
                case 1: goto L9;
                default: goto L5;
            }
        L5:
            super.onChange(r14, r15)
            return
        L9:
            java.lang.String r0 = "_display_name"
            java.lang.String r1 = "date_added"
            java.lang.String r2 = ""
            super.onChange(r14, r15)
            if (r15 == 0) goto Lac
            java.lang.Object r14 = r13.f1549b
            r4 = r14
            o1.j r4 = (o1.j) r4
            java.lang.String r14 = r15.toString()
            java.lang.String r3 = "toString(...)"
            kotlin.jvm.internal.j.d(r14, r3)
            android.net.Uri r5 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            java.lang.String r5 = r5.toString()
            kotlin.jvm.internal.j.d(r5, r3)
            r3 = 0
            boolean r14 = N2.f.N(r14, r5, r3)
            if (r14 == 0) goto Lac
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String[] r9 = new java.lang.String[]{r1, r0}     // Catch: java.lang.Exception -> L84
            android.content.Context r14 = r4.f5932b     // Catch: java.lang.Exception -> L84
            if (r14 == 0) goto L86
            android.content.ContentResolver r7 = r14.getContentResolver()     // Catch: java.lang.Exception -> L84
            r11 = 0
            r12 = 0
            r10 = 0
            r8 = r15
            android.database.Cursor r14 = r7.query(r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L82
            if (r14 == 0) goto L82
            boolean r15 = r14.moveToFirst()     // Catch: java.lang.Throwable -> L67
            if (r15 == 0) goto L76
            int r15 = r14.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L67
            if (r15 < 0) goto L6a
            long r9 = r14.getLong(r15)     // Catch: java.lang.Throwable -> L67
            r11 = 0
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 <= 0) goto L6a
            r15 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r15     // Catch: java.lang.Throwable -> L67
            long r5 = r5 * r9
            goto L6a
        L67:
            r0 = move-exception
            r15 = r0
            goto L7c
        L6a:
            int r15 = r14.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L67
            if (r15 < 0) goto L76
            java.lang.String r15 = r14.getString(r15)     // Catch: java.lang.Throwable -> L67
            if (r15 != 0) goto L77
        L76:
            r15 = r2
        L77:
            r14.close()     // Catch: java.lang.Exception -> L7a
        L7a:
            r6 = r5
            goto L8e
        L7c:
            throw r15     // Catch: java.lang.Throwable -> L7d
        L7d:
            r0 = move-exception
            p3.h.h(r14, r15)     // Catch: java.lang.Exception -> L82
            throw r0     // Catch: java.lang.Exception -> L82
        L82:
            r15 = r2
            goto L7a
        L84:
            r8 = r15
            goto L82
        L86:
            r8 = r15
            java.lang.String r14 = "context"
            kotlin.jvm.internal.j.i(r14)     // Catch: java.lang.Exception -> L82
            r14 = 0
            throw r14     // Catch: java.lang.Exception -> L82
        L8e:
            java.lang.String r14 = r8.getPath()
            if (r14 != 0) goto L96
            r5 = r2
            goto L97
        L96:
            r5 = r14
        L97:
            android.os.Handler r14 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r14.<init>(r0)
            io.flutter.embedding.android.c r3 = new io.flutter.embedding.android.c
            r9 = 2
            r8 = r15
            r3.<init>(r4, r5, r6, r8, r9)
            r0 = 100
            r14.postDelayed(r3, r0)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P.a.onChange(boolean, android.net.Uri):void");
    }
}
