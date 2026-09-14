package i2;

import P2.G;
import P2.O;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.j;

/* renamed from: i2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0451b implements PluginRegistry.ActivityResultListener {

    /* renamed from: m, reason: collision with root package name */
    public static final int f4977m = (C0454e.class.hashCode() + 43) & 65535;

    /* renamed from: n, reason: collision with root package name */
    public static final int f4978n = (C0454e.class.hashCode() + 83) & 65535;

    /* renamed from: a, reason: collision with root package name */
    public final Activity f4979a;

    /* renamed from: b, reason: collision with root package name */
    public i f4980b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4981c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4982d;

    /* renamed from: e, reason: collision with root package name */
    public String f4983e;

    /* renamed from: f, reason: collision with root package name */
    public int f4984f;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f4985j;

    /* renamed from: k, reason: collision with root package name */
    public EventChannel.EventSink f4986k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f4987l;

    public C0451b(Activity activity) {
        this.f4979a = activity;
    }

    public final void a(boolean z3) {
        if (this.f4986k != null && !j.a(this.f4983e, "dir")) {
            new Handler(Looper.getMainLooper()).post(new com.google.firebase.installations.a(this, z3, 2));
        }
    }

    public final void b(String str, String str2) {
        a(false);
        i iVar = this.f4980b;
        if (iVar != null) {
            iVar.error(str, str2, null);
        }
        this.f4980b = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        if (r3 == 0) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [i2.i] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.io.Serializable r13) {
        /*
            r12 = this;
            r0 = 0
            r12.a(r0)
            i2.i r1 = r12.f4980b
            if (r1 == 0) goto L8d
            r2 = 0
            if (r13 == 0) goto L14
            boolean r3 = r13 instanceof java.lang.String
            if (r3 == 0) goto L11
            r3 = r13
            goto L12
        L11:
            r3 = r2
        L12:
            if (r3 != 0) goto L88
        L14:
            boolean r3 = r13 instanceof java.util.ArrayList
            if (r3 == 0) goto L1b
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            goto L1c
        L1b:
            r13 = r2
        L1c:
            if (r13 == 0) goto L87
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r13.size()
        L27:
            if (r0 >= r4) goto L88
            java.lang.Object r5 = r13.get(r0)
            int r0 = r0 + 1
            boolean r6 = r5 instanceof i2.C0450a
            if (r6 == 0) goto L36
            i2.a r5 = (i2.C0450a) r5
            goto L37
        L36:
            r5 = r2
        L37:
            if (r5 == 0) goto L80
            s2.d r6 = new s2.d
            java.lang.String r7 = "path"
            java.lang.String r8 = r5.f4972a
            r6.<init>(r7, r8)
            s2.d r7 = new s2.d
            java.lang.String r8 = "name"
            java.lang.String r9 = r5.f4973b
            r7.<init>(r8, r9)
            s2.d r8 = new s2.d
            long r9 = r5.f4975d
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.lang.String r10 = "size"
            r8.<init>(r10, r9)
            s2.d r9 = new s2.d
            java.lang.String r10 = "bytes"
            byte[] r11 = r5.f4976e
            r9.<init>(r10, r11)
            s2.d r10 = new s2.d
            android.net.Uri r5 = r5.f4974c
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r11 = "identifier"
            r10.<init>(r11, r5)
            s2.d[] r5 = new s2.C0679d[]{r6, r7, r8, r9, r10}
            java.util.HashMap r6 = new java.util.HashMap
            r7 = 5
            int r7 = t2.u.F(r7)
            r6.<init>(r7)
            t2.u.H(r6, r5)
            goto L81
        L80:
            r6 = r2
        L81:
            if (r6 == 0) goto L27
            r3.add(r6)
            goto L27
        L87:
            r3 = r2
        L88:
            r1.success(r3)
            r12.f4980b = r2
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C0451b.c(java.io.Serializable):void");
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public final boolean onActivityResult(int i, int i3, Intent intent) {
        int i4 = f4978n;
        Activity activity = this.f4979a;
        Uri uri = null;
        if (i == i4) {
            if (i3 != -1) {
                if (i3 == 0) {
                    c(null);
                    return false;
                }
            } else {
                if (intent != null) {
                    uri = intent.getData();
                }
                if (uri != null) {
                    a(true);
                    try {
                        byte[] bArr = this.f4987l;
                        OutputStream openOutputStream = activity.getContentResolver().openOutputStream(uri);
                        if (openOutputStream != null) {
                            if (bArr != null) {
                                try {
                                    openOutputStream.write(bArr);
                                } finally {
                                }
                            }
                            openOutputStream.close();
                        }
                        c(uri.getPath());
                        return true;
                    } catch (IOException e4) {
                        Log.e("FilePickerDelegate", "Error while saving file", e4);
                        b("Error while saving file", e4.getMessage());
                    }
                }
                return false;
            }
        } else if (i == f4977m) {
            if (i3 != -1) {
                if (i3 == 0) {
                    c(null);
                    return true;
                }
            } else {
                a(true);
                int i5 = this.f4984f;
                boolean z3 = this.f4982d;
                String str = this.f4983e;
                if (str == null) {
                    str = "";
                }
                G.r(G.b(O.f1623b), null, new g(intent, this, activity, i5, z3, str, null), 3);
                return true;
            }
        } else {
            b("unknown_activity", "Unknown activity error, please file an issue.");
            return false;
        }
        return false;
    }
}
