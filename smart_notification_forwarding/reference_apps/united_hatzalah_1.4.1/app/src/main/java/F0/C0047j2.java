package F0;

import J.InterfaceC0128p;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.security.ProviderInstaller;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import m.C0548i;
import m.InterfaceC0554l;
import r2.InterfaceC0645a;
import v1.C0742a;

/* renamed from: F0.j2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0047j2 implements F1.c, Y0.a, X1.h, k0.M, l.k, androidx.lifecycle.C {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f545a;

    /* renamed from: b, reason: collision with root package name */
    public Object f546b;

    public /* synthetic */ C0047j2(Object obj, int i) {
        this.f545a = i;
        this.f546b = obj;
    }

    public static int q(int i, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            i4++;
            if (i4 == i3) {
                i5++;
                i4 = 0;
            } else if (i4 > i3) {
                i5++;
                i4 = 1;
            }
        }
        if (i4 + 1 > i3) {
            return i5 + 1;
        }
        return i5;
    }

    public C0021d0 a() {
        return (C0021d0) this.f546b;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [v1.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, t1.l] */
    public t1.l b() {
        Context context = (Context) this.f546b;
        if (context != null) {
            ?? obj = new Object();
            obj.f6434a = C0742a.a(t1.o.f6443a);
            u1.e eVar = new u1.e(context, 1);
            obj.f6435b = eVar;
            obj.f6436c = C0742a.a(new A1.m(eVar, new u1.e(eVar, 0), 1));
            u1.e eVar2 = obj.f6435b;
            obj.f6437d = new A1.e(eVar2, 1);
            InterfaceC0645a a2 = C0742a.a(new A1.e(eVar2, 0));
            obj.f6438e = a2;
            int i = 0;
            InterfaceC0645a a4 = C0742a.a(new A1.m(obj.f6437d, a2, i));
            obj.f6439f = a4;
            ?? obj2 = new Object();
            u1.e eVar3 = obj.f6435b;
            t1.u uVar = new t1.u(eVar3, a4, obj2, 1);
            InterfaceC0645a interfaceC0645a = obj.f6434a;
            InterfaceC0645a interfaceC0645a2 = obj.f6436c;
            obj.f6440j = C0742a.a(new t1.u(new y1.b(interfaceC0645a, interfaceC0645a2, uVar, a4, a4), new z1.h(eVar3, interfaceC0645a2, a4, uVar, interfaceC0645a, a4, a4), new z1.j(interfaceC0645a, a4, uVar, a4), i));
            return obj;
        }
        throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
    }

    @Override // k0.M
    public int c(View view) {
        return (view.getTop() - ((k0.u) view.getLayoutParams()).f5275a.top) - ((ViewGroup.MarginLayoutParams) ((k0.u) view.getLayoutParams())).topMargin;
    }

    @Override // Y0.a
    public void d(byte[] bArr, int i, int i3) {
        try {
            ((ByteBuffer) this.f546b).put(bArr, 0, i3);
        } catch (BufferOverflowException e4) {
            throw new IOException(AbstractC0008a.j(i3, "Insufficient space in output buffer for ", " bytes"), e4);
        }
    }

    @Override // Y0.a
    public void e(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        try {
            ((ByteBuffer) this.f546b).put(byteBuffer);
        } catch (BufferOverflowException e4) {
            throw new IOException(AbstractC0008a.j(remaining, "Insufficient space in output buffer for ", " bytes"), e4);
        }
    }

    @Override // l.k
    public void f(l.m mVar) {
        switch (this.f545a) {
            case 19:
                l.k kVar = ((ActionMenuView) this.f546b).y;
                if (kVar != null) {
                    kVar.f(mVar);
                    return;
                }
                return;
            default:
                Toolbar toolbar = (Toolbar) this.f546b;
                C0548i c0548i = toolbar.f2986a.f2861w;
                if (c0548i == null || !c0548i.k()) {
                    Iterator it = toolbar.f2972J.f1019b.iterator();
                    while (it.hasNext()) {
                        ((androidx.fragment.app.Y) ((InterfaceC0128p) it.next())).f3332a.t(mVar);
                    }
                }
                C0035g2 c0035g2 = toolbar.f2980R;
                if (c0035g2 != null) {
                    c0035g2.f(mVar);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r3 == 1) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (r3 == 3) goto L21;
     */
    @Override // androidx.lifecycle.C
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Object r0 = r11.f546b
            q.I r0 = (q.I) r0
            android.os.Handler r1 = r0.f6011a
            G.a r2 = r0.f6012b
            r1.removeCallbacks(r2)
            int r3 = r12.intValue()
            android.widget.ImageView r4 = r0.f6016f
            r5 = 2
            if (r4 != 0) goto L17
            goto L5f
        L17:
            q.A r4 = r0.f6013c
            int r4 = r4.f6009w
            android.content.Context r6 = r0.getContext()
            r7 = 1
            r8 = 0
            if (r6 != 0) goto L24
            goto L42
        L24:
            r9 = 2131230835(0x7f080073, float:1.8077734E38)
            if (r4 != 0) goto L2c
            if (r3 != r7) goto L2c
            goto L3e
        L2c:
            if (r4 != r7) goto L34
            if (r3 != r5) goto L34
            r9 = 2131230834(0x7f080072, float:1.8077732E38)
            goto L3e
        L34:
            if (r4 != r5) goto L39
            if (r3 != r7) goto L39
            goto L3e
        L39:
            if (r4 != r7) goto L42
            r10 = 3
            if (r3 != r10) goto L42
        L3e:
            android.graphics.drawable.Drawable r8 = r6.getDrawable(r9)
        L42:
            if (r8 != 0) goto L45
            goto L5f
        L45:
            android.widget.ImageView r6 = r0.f6016f
            r6.setImageDrawable(r8)
            if (r4 != 0) goto L4f
            if (r3 != r7) goto L4f
            goto L5b
        L4f:
            if (r4 != r7) goto L54
            if (r3 != r5) goto L54
            goto L58
        L54:
            if (r4 != r5) goto L5b
            if (r3 != r7) goto L5b
        L58:
            q.G.a(r8)
        L5b:
            q.A r4 = r0.f6013c
            r4.f6009w = r3
        L5f:
            int r12 = r12.intValue()
            android.widget.TextView r3 = r0.f6017j
            if (r3 == 0) goto L71
            if (r12 != r5) goto L6c
            int r12 = r0.f6014d
            goto L6e
        L6c:
            int r12 = r0.f6015e
        L6e:
            r3.setTextColor(r12)
        L71:
            r3 = 2000(0x7d0, double:9.88E-321)
            r1.postDelayed(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0047j2.g(java.lang.Object):void");
    }

    @Override // k0.M
    public int h() {
        return ((k0.t) this.f546b).u();
    }

    @Override // l.k
    public boolean i(l.m mVar, MenuItem menuItem) {
        boolean z3;
        switch (this.f545a) {
            case 19:
                InterfaceC0554l interfaceC0554l = ((ActionMenuView) this.f546b).f2856D;
                if (interfaceC0554l == null) {
                    return false;
                }
                Toolbar toolbar = (Toolbar) ((C0035g2) interfaceC0554l).f526b;
                if (toolbar.f2972J.a(menuItem)) {
                    z3 = true;
                } else {
                    m.p1 p1Var = toolbar.f2974L;
                    if (p1Var != null) {
                        z3 = ((h.I) ((G1) p1Var).f218b).f4735b.onMenuItemSelected(0, menuItem);
                    } else {
                        z3 = false;
                    }
                }
                if (!z3) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    @Override // k0.M
    public int j() {
        k0.t tVar = (k0.t) this.f546b;
        return tVar.f5274g - tVar.r();
    }

    @Override // X1.h
    public Object k(String str) {
        String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt"};
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            Provider provider = Security.getProvider(strArr[i3]);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        int size = arrayList.size();
        Exception exc = null;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                return ((A.n) this.f546b).b(str, (Provider) obj);
            } catch (Exception e4) {
                if (exc == null) {
                    exc = e4;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }

    public Integer l() {
        int i;
        Integer num = null;
        char c4 = 34327;
        while (true) {
            if (c4 != 34327) {
                if (c4 != 296) {
                    if (c4 != 63412) {
                        if (c4 == 33409) {
                            return num;
                        }
                        c4 = 63412;
                    } else {
                        i = 1;
                    }
                } else {
                    i = 0;
                }
                num = Integer.valueOf(i);
                c4 = 33409;
            } else if (((C0051k2) this.f546b).f557a.f832f) {
                c4 = 63412;
            } else {
                c4 = 296;
            }
        }
    }

    public Integer m() {
        Integer num = null;
        char c4 = 46270;
        while (true) {
            if (c4 != 40769) {
                if (c4 != 6943) {
                    if (c4 != 46270) {
                        if (c4 == 64148) {
                            return num;
                        }
                    } else if (((C0051k2) this.f546b).f557a.f832f) {
                        c4 = 40769;
                    }
                    c4 = 6943;
                } else {
                    num = 0;
                }
            } else {
                int i = AbstractC0041i0.f535a;
                num = null;
            }
            c4 = 64148;
        }
    }

    public Integer n() {
        Integer num = null;
        char c4 = 20823;
        while (true) {
            if (c4 != 42515) {
                if (c4 != 20823) {
                    if (c4 != 21717) {
                        if (c4 == 54651) {
                            return num;
                        }
                    } else {
                        num = 0;
                    }
                } else if (!((C0051k2) this.f546b).f557a.f832f) {
                    c4 = 21717;
                }
                c4 = 42515;
            } else {
                int i = AbstractC0041i0.f535a;
                num = null;
            }
            c4 = 54651;
        }
    }

    @Override // k0.M
    public View o(int i) {
        return ((k0.t) this.f546b).o(i);
    }

    @Override // k0.M
    public int p(View view) {
        return view.getBottom() + ((k0.u) view.getLayoutParams()).f5275a.bottom + ((ViewGroup.MarginLayoutParams) ((k0.u) view.getLayoutParams())).bottomMargin;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0009. Please report as an issue. */
    public Integer r() {
        int i;
        C0047j2 c0047j2 = null;
        char c4 = 55882;
        Integer num = null;
        while (true) {
            switch (c4) {
                case 28504:
                    if (((C0051k2) c0047j2.f546b).f557a.f832f) {
                        c4 = 25985;
                    } else {
                        c4 = 33841;
                    }
                case 33841:
                    i = 0;
                    num = Integer.valueOf(i);
                    c4 = 8090;
                case 8090:
                    break;
                case 25985:
                    i = 1;
                    num = Integer.valueOf(i);
                    c4 = 8090;
                case 55882:
                    c4 = 28504;
                    c0047j2 = this;
                default:
                    c4 = 25985;
            }
            return num;
        }
    }

    public Integer s() {
        Integer num = null;
        while (true) {
            char c4 = 4742;
            while (true) {
                if (c4 != 61703) {
                    if (c4 != 40140) {
                        if (c4 != 4742) {
                            if (c4 != 1620) {
                                break;
                            }
                            num = 0;
                        } else if (((C0051k2) this.f546b).f557a.f832f) {
                            c4 = 61703;
                        } else {
                            c4 = 1620;
                        }
                    } else {
                        return num;
                    }
                } else {
                    int i = AbstractC0041i0.f535a;
                    num = null;
                }
                c4 = 40140;
            }
        }
    }

    public Integer t() {
        Integer num = null;
        char c4 = 32570;
        while (true) {
            if (c4 != 47426) {
                if (c4 != 32570) {
                    if (c4 != 3967) {
                        if (c4 == 5281) {
                            int i = AbstractC0041i0.f535a;
                            num = null;
                        }
                    } else {
                        return num;
                    }
                } else if (!((C0051k2) this.f546b).f557a.f832f) {
                    c4 = 47426;
                }
                c4 = 5281;
            } else {
                num = 0;
            }
            c4 = 3967;
        }
    }

    public Integer u() {
        Integer num = null;
        char c4 = 10277;
        while (c4 != 5431) {
            if (c4 != 1867) {
                if (c4 != 41361) {
                    if (c4 != 10277 || ((C0051k2) this.f546b).f557a.f832f) {
                        c4 = 41361;
                    } else {
                        c4 = 1867;
                    }
                } else {
                    int i = AbstractC0041i0.f535a;
                    num = null;
                }
            } else {
                int i3 = ((~C0047j2.class.getName().length()) | (-1796810777)) & 311705986;
                int length = C0047j2.class.getName().length() & 51380256;
                num = Integer.valueOf((-1684714590) ^ (i3 + (~(((C0047j2.class.getName().length() | 1996420575) | length) - ((C0047j2.class.getName().length() & (-1996420576)) | length)))));
            }
            c4 = 5431;
        }
        return num;
    }

    @Override // F1.c
    public Object zza() {
        switch (this.f545a) {
            case 1:
                return new E1.c(((E1.e) ((C0047j2) this.f546b).f546b).f134a);
            default:
                return ((E1.e) this.f546b).f134a;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public C0047j2(F0.C0026e1 r67) {
        /*
            Method dump skipped, instructions count: 2678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0047j2.<init>(F0.e1):void");
    }

    public C0047j2(int i) {
        this.f545a = i;
        switch (i) {
            case 16:
                this.f546b = new SparseIntArray();
                return;
            case 22:
                return;
            default:
                this.f546b = new AtomicInteger(0);
                return;
        }
    }

    public C0047j2(boolean z3) {
        this.f545a = 7;
        this.f546b = new AtomicBoolean(z3);
    }

    public C0047j2(TextView textView) {
        this.f545a = 9;
        this.f546b = new X.g(textView);
    }

    public C0047j2(N0.e eVar) {
        this.f545a = 5;
        ArrayList arrayList = eVar.f1446b;
        ArrayList a2 = L0.c.a(eVar.d());
        this.f546b = a2;
        ArrayList a4 = L0.c.a(eVar.e());
        L0.c.a(eVar.f1448d);
        if (a2.isEmpty()) {
            a4.isEmpty();
        }
    }
}
