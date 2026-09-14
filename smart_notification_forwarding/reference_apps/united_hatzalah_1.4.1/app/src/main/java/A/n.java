package A;

import F0.G1;
import J.InterfaceC0136y;
import P2.t0;
import P2.u0;
import P2.w0;
import R.InterfaceC0177b;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import androidx.datastore.core.CorruptionException;
import com.google.android.gms.common.ConnectionResult;
import io.flutter.Build;
import io.flutter.plugin.common.EventChannel;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public class n implements InterfaceC0136y, InterfaceC0177b, X2.a, X2.b {

    /* renamed from: b, reason: collision with root package name */
    public static n f25b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f26a;

    public /* synthetic */ n(int i) {
        this.f26a = i;
    }

    public static void A() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f876t);
    }

    public static void B() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f877u);
    }

    public static void C() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f878v);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0075, code lost:
    
        if (r11 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        if (r10 != (-1)) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e(X.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A.n.e(X.b, android.text.Editable, int, int, boolean):boolean");
    }

    public static void g() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f860b);
    }

    public static void h() {
        EventChannel.EventSink eventSink;
        LinkedHashSet linkedHashSet = I0.a.f888a;
        H0.c cVar = H0.c.f852a;
        if (I0.a.f889b && (eventSink = I0.a.f890c) != null) {
            eventSink.success(187429);
            return;
        }
        LinkedHashSet linkedHashSet2 = I0.a.f888a;
        synchronized (linkedHashSet2) {
            linkedHashSet2.add(cVar);
        }
    }

    public static void i() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f861c);
    }

    public static void j() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f862d);
    }

    public static void k() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f863e);
    }

    public static void l() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f864f);
    }

    public static void m() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f865g);
    }

    public static void n() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f866h);
    }

    public static void o() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.i);
    }

    public static void p() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f867j);
    }

    public static void q(ArrayList arrayList) {
        G1 g12;
        if (I0.b.f893c && (g12 = I0.b.f895e) != null) {
            g12.m(arrayList);
            return;
        }
        ArrayList arrayList2 = I0.b.f892b;
        synchronized (arrayList2) {
            arrayList2.addAll(arrayList);
        }
    }

    public static void r() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f868k);
    }

    public static void s() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f869l);
    }

    public static void t() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f870m);
    }

    public static void u() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f871n);
    }

    public static void v() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f872o);
    }

    public static void w() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.p);
    }

    public static void x() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f873q);
    }

    public static void y() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f874r);
    }

    public static void z() {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.a(H0.i.f875s);
    }

    public Object b(String str, Provider provider) {
        switch (this.f26a) {
            case 17:
                if (provider == null) {
                    return Cipher.getInstance(str);
                }
                return Cipher.getInstance(str, provider);
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                if (provider == null) {
                    return KeyAgreement.getInstance(str);
                }
                return KeyAgreement.getInstance(str, provider);
            case 19:
                if (provider == null) {
                    return KeyFactory.getInstance(str);
                }
                return KeyFactory.getInstance(str, provider);
            case 20:
                if (provider == null) {
                    return KeyPairGenerator.getInstance(str);
                }
                return KeyPairGenerator.getInstance(str, provider);
            case 21:
                if (provider == null) {
                    return Mac.getInstance(str);
                }
                return Mac.getInstance(str, provider);
            case 22:
                if (provider == null) {
                    return MessageDigest.getInstance(str);
                }
                return MessageDigest.getInstance(str, provider);
            default:
                if (provider == null) {
                    return Signature.getInstance(str);
                }
                return Signature.getInstance(str, provider);
        }
    }

    public android.content.pm.Signature[] c(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public long d() {
        switch (this.f26a) {
            case 1:
                return SystemClock.elapsedRealtime();
            default:
                return System.currentTimeMillis();
        }
    }

    public boolean f(CharSequence charSequence) {
        return charSequence instanceof H.b;
    }

    public n(w0 w0Var, int i) {
        this.f26a = i;
        switch (i) {
            case Build.API_LEVELS.API_25 /* 25 */:
                t0 t0Var = t0.f1699a;
                u0 u0Var = u0.f1705a;
                return;
            default:
                return;
        }
    }

    @Override // R.InterfaceC0177b
    public Object a(CorruptionException corruptionException) {
        throw corruptionException;
    }

    @Override // J.InterfaceC0136y
    public void onScrollLimit(int i, int i3, int i4, boolean z3) {
    }

    @Override // J.InterfaceC0136y
    public void onScrollProgress(int i, int i3, int i4, int i5) {
    }
}
