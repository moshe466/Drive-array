package K1;

import F0.G1;
import R1.q;
import R1.r;
import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.lifecycle.N;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentMap;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import k.AbstractC0458b;
import k.C0463g;
import k.InterfaceC0457a;
import l.MenuC0499C;
import l.t;
import t.C0691g;
import t.C0694j;

/* loaded from: classes.dex */
public final class m implements InterfaceC0457a {

    /* renamed from: a, reason: collision with root package name */
    public Object f1102a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1103b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1104c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1105d;

    public m(int i) {
        switch (i) {
            case 9:
                N n4 = new N(26);
                N n5 = new N(25);
                this.f1102a = new HashSet();
                this.f1103b = n4;
                this.f1104c = n5;
                return;
            case 10:
            default:
                this.f1102a = new HashMap();
                this.f1103b = new HashMap();
                this.f1104c = new HashMap();
                this.f1105d = new HashMap();
                return;
            case 11:
                this.f1102a = new C0694j(0);
                this.f1103b = new SparseArray();
                this.f1104c = new C0691g();
                this.f1105d = new C0694j(0);
                return;
        }
    }

    @Override // k.InterfaceC0457a
    public boolean a(AbstractC0458b abstractC0458b, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f1102a).onActionItemClicked(h(abstractC0458b), new t((Context) this.f1103b, (D.a) menuItem));
    }

    @Override // k.InterfaceC0457a
    public boolean b(AbstractC0458b abstractC0458b, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f1102a;
        C0463g h2 = h(abstractC0458b);
        C0694j c0694j = (C0694j) this.f1105d;
        Menu menu2 = (Menu) c0694j.get(menu);
        if (menu2 == null) {
            menu2 = new MenuC0499C((Context) this.f1103b, (l.m) menu);
            c0694j.put(menu, menu2);
        }
        return callback.onCreateActionMode(h2, menu2);
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object, L1.f] */
    public L1.f c() {
        G1 g12;
        L1.k kVar = (L1.k) this.f1102a;
        if (kVar != null) {
            G1 g13 = (G1) this.f1103b;
            if (g13 != null && (g12 = (G1) this.f1104c) != null) {
                if (kVar.f1315b == ((Y1.a) g13.f218b).f2706a.length) {
                    if (kVar.f1316c == ((Y1.a) g12.f218b).f2706a.length) {
                        L1.j jVar = kVar.f1318e;
                        L1.j jVar2 = L1.j.f1299j;
                        if (jVar != jVar2 && ((Integer) this.f1105d) == null) {
                            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                        }
                        if (jVar != jVar2 || ((Integer) this.f1105d) == null) {
                            if (jVar == jVar2) {
                                Y1.a.a(new byte[0]);
                            } else if (jVar == L1.j.i) {
                                Y1.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f1105d).intValue()).array());
                            } else if (jVar == L1.j.f1298h) {
                                Y1.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f1105d).intValue()).array());
                            } else {
                                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: " + ((L1.k) this.f1102a).f1318e);
                            }
                            return new Object();
                        }
                        throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                    }
                    throw new GeneralSecurityException("HMAC key size mismatch");
                }
                throw new GeneralSecurityException("AES key size mismatch");
            }
            throw new GeneralSecurityException("Cannot build without key material");
        }
        throw new GeneralSecurityException("Cannot build without parameters");
    }

    @Override // k.InterfaceC0457a
    public boolean d(AbstractC0458b abstractC0458b, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f1102a;
        C0463g h2 = h(abstractC0458b);
        C0694j c0694j = (C0694j) this.f1105d;
        Menu menu2 = (Menu) c0694j.get(menu);
        if (menu2 == null) {
            menu2 = new MenuC0499C((Context) this.f1103b, (l.m) menu);
            c0694j.put(menu, menu2);
        }
        return callback.onPrepareActionMode(h2, menu2);
    }

    @Override // k.InterfaceC0457a
    public void e(AbstractC0458b abstractC0458b) {
        ((ActionMode.Callback) this.f1102a).onDestroyActionMode(h(abstractC0458b));
    }

    public S1.j f() {
        Integer num = (Integer) this.f1102a;
        if (num != null) {
            if (((Integer) this.f1103b) != null) {
                if (((S1.c) this.f1104c) != null) {
                    if (((S1.c) this.f1105d) != null) {
                        if (num.intValue() >= 16) {
                            Integer num2 = (Integer) this.f1103b;
                            int intValue = num2.intValue();
                            S1.c cVar = (S1.c) this.f1104c;
                            if (intValue >= 10) {
                                if (cVar == S1.c.f2121g) {
                                    if (intValue > 20) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
                                    }
                                } else if (cVar == S1.c.f2122h) {
                                    if (intValue > 28) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
                                    }
                                } else if (cVar == S1.c.i) {
                                    if (intValue > 32) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
                                    }
                                } else if (cVar == S1.c.f2123j) {
                                    if (intValue > 48) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
                                    }
                                } else if (cVar == S1.c.f2124k) {
                                    if (intValue > 64) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
                                    }
                                } else {
                                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                                }
                                return new S1.j(((Integer) this.f1102a).intValue(), ((Integer) this.f1103b).intValue(), (S1.c) this.f1105d, (S1.c) this.f1104c);
                            }
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
                        }
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", (Integer) this.f1102a));
                    }
                    throw new GeneralSecurityException("variant is not set");
                }
                throw new GeneralSecurityException("hash type is not set");
            }
            throw new GeneralSecurityException("tag size is not set");
        }
        throw new GeneralSecurityException("key size is not set");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(y2.AbstractC0787c r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f1105d
            R.P r0 = (R.P) r0
            boolean r1 = r7 instanceof R.C0184i
            if (r1 == 0) goto L17
            r1 = r7
            R.i r1 = (R.C0184i) r1
            int r2 = r1.f1894d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.f1894d = r2
            goto L1c
        L17:
            R.i r1 = new R.i
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f1892b
            x2.a r2 = x2.EnumC0779a.f6740a
            int r3 = r1.f1894d
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L3e
            if (r3 == r5) goto L38
            if (r3 != r4) goto L30
            K1.m r0 = r1.f1891a
            a.AbstractC0228a.C(r7)
            goto L64
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            K1.m r0 = r1.f1891a
            a.AbstractC0228a.C(r7)
            goto L74
        L3e:
            a.AbstractC0228a.C(r7)
            java.lang.Object r7 = r6.f1103b
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L67
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4e
            goto L67
        L4e:
            R.j0 r7 = r0.g()
            R.l r3 = new R.l
            r5 = 0
            r3.<init>(r0, r6, r5)
            r1.f1891a = r6
            r1.f1894d = r4
            java.lang.Object r7 = r7.b(r3, r1)
            if (r7 != r2) goto L63
            goto L72
        L63:
            r0 = r6
        L64:
            R.c r7 = (R.C0178c) r7
            goto L76
        L67:
            r1.f1891a = r6
            r1.f1894d = r5
            r7 = 0
            java.lang.Object r7 = R.P.f(r0, r7, r1)
            if (r7 != r2) goto L73
        L72:
            return r2
        L73:
            r0 = r6
        L74:
            R.c r7 = (R.C0178c) r7
        L76:
            java.lang.Object r0 = r0.f1105d
            R.P r0 = (R.P) r0
            F0.G1 r0 = r0.f1810h
            r0.n(r7)
            s2.i r7 = s2.C0684i.f6340a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: K1.m.g(y2.c):java.lang.Object");
    }

    public C0463g h(AbstractC0458b abstractC0458b) {
        ArrayList arrayList = (ArrayList) this.f1104c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0463g c0463g = (C0463g) arrayList.get(i);
            if (c0463g != null && c0463g.f5115b == abstractC0458b) {
                return c0463g;
            }
        }
        C0463g c0463g2 = new C0463g((Context) this.f1103b, abstractC0458b);
        arrayList.add(c0463g2);
        return c0463g2;
    }

    public List i(byte[] bArr) {
        List list = (List) ((ConcurrentMap) this.f1102a).get(new l(bArr));
        if (list != null) {
            return list;
        }
        return Collections.EMPTY_LIST;
    }

    public File j(Context context) {
        ((N) this.f1103b).getClass();
        return new File(context.getDir("lib", 0), System.mapLibraryName("flutter"));
    }

    public void k(String str, Object... objArr) {
        String format = String.format(Locale.US, str, objArr);
        if (((e3.c) this.f1105d) != null) {
            FlutterJNI.a(format);
        }
    }

    public void l(R1.a aVar) {
        aVar.getClass();
        R1.p pVar = new R1.p(R1.n.class, aVar.f1979a);
        HashMap hashMap = (HashMap) this.f1103b;
        if (hashMap.containsKey(pVar)) {
            R1.a aVar2 = (R1.a) hashMap.get(pVar);
            if (aVar2.equals(aVar) && aVar.equals(aVar2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + pVar);
        }
        hashMap.put(pVar, aVar);
    }

    public void m(R1.b bVar) {
        q qVar = new q(bVar.f1981a, R1.n.class);
        HashMap hashMap = (HashMap) this.f1102a;
        if (hashMap.containsKey(qVar)) {
            R1.b bVar2 = (R1.b) hashMap.get(qVar);
            if (bVar2.equals(bVar) && bVar.equals(bVar2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + qVar);
        }
        hashMap.put(qVar, bVar);
    }

    public void n(R1.i iVar) {
        iVar.getClass();
        R1.p pVar = new R1.p(R1.o.class, iVar.f1994a);
        HashMap hashMap = (HashMap) this.f1105d;
        if (hashMap.containsKey(pVar)) {
            R1.i iVar2 = (R1.i) hashMap.get(pVar);
            if (iVar2.equals(iVar) && iVar.equals(iVar2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + pVar);
        }
        hashMap.put(pVar, iVar);
    }

    public void o(R1.j jVar) {
        q qVar = new q(jVar.f1995a, R1.o.class);
        HashMap hashMap = (HashMap) this.f1104c;
        if (hashMap.containsKey(qVar)) {
            R1.j jVar2 = (R1.j) hashMap.get(qVar);
            if (jVar2.equals(jVar) && jVar.equals(jVar2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + qVar);
        }
        hashMap.put(qVar, jVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: all -> 0x0094, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0094, blocks: (B:25:0x0066, B:29:0x0078), top: B:24:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r2v6, types: [Y2.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object p(y2.AbstractC0787c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof R.e0
            if (r0 == 0) goto L13
            r0 = r8
            R.e0 r0 = (R.e0) r0
            int r1 = r0.f1870e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1870e = r1
            goto L18
        L13:
            R.e0 r0 = new R.e0
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f1868c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1870e
            r3 = 2
            r4 = 1
            s2.i r5 = s2.C0684i.f6340a
            r6 = 0
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            Y2.a r1 = r0.f1867b
            K1.m r0 = r0.f1866a
            a.AbstractC0228a.C(r8)     // Catch: java.lang.Throwable -> L31
            goto L87
        L31:
            r8 = move-exception
            goto L97
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3b:
            Y2.a r2 = r0.f1867b
            K1.m r4 = r0.f1866a
            a.AbstractC0228a.C(r8)
            r8 = r2
            goto L66
        L44:
            a.AbstractC0228a.C(r8)
            java.lang.Object r8 = r7.f1104c
            P2.t r8 = (P2.C0169t) r8
            java.lang.Object r8 = r8.x()
            boolean r8 = r8 instanceof P2.InterfaceC0147d0
            if (r8 != 0) goto L54
            return r5
        L54:
            java.lang.Object r8 = r7.f1102a
            Y2.d r8 = (Y2.d) r8
            r0.f1866a = r7
            r0.f1867b = r8
            r0.f1870e = r4
            java.lang.Object r2 = r8.d(r0)
            if (r2 != r1) goto L65
            goto L84
        L65:
            r4 = r7
        L66:
            java.lang.Object r2 = r4.f1104c     // Catch: java.lang.Throwable -> L94
            P2.t r2 = (P2.C0169t) r2     // Catch: java.lang.Throwable -> L94
            java.lang.Object r2 = r2.x()     // Catch: java.lang.Throwable -> L94
            boolean r2 = r2 instanceof P2.InterfaceC0147d0     // Catch: java.lang.Throwable -> L94
            if (r2 != 0) goto L78
            Y2.d r8 = (Y2.d) r8
            r8.f(r6)
            return r5
        L78:
            r0.f1866a = r4     // Catch: java.lang.Throwable -> L94
            r0.f1867b = r8     // Catch: java.lang.Throwable -> L94
            r0.f1870e = r3     // Catch: java.lang.Throwable -> L94
            java.lang.Object r0 = r4.g(r0)     // Catch: java.lang.Throwable -> L94
            if (r0 != r1) goto L85
        L84:
            return r1
        L85:
            r1 = r8
            r0 = r4
        L87:
            java.lang.Object r8 = r0.f1104c     // Catch: java.lang.Throwable -> L31
            P2.t r8 = (P2.C0169t) r8     // Catch: java.lang.Throwable -> L31
            r8.D(r5)     // Catch: java.lang.Throwable -> L31
            Y2.d r1 = (Y2.d) r1
            r1.f(r6)
            return r5
        L94:
            r0 = move-exception
            r1 = r8
            r8 = r0
        L97:
            Y2.d r1 = (Y2.d) r1
            r1.f(r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: K1.m.p(y2.c):java.lang.Object");
    }

    public m(r rVar) {
        this.f1102a = new HashMap(rVar.f2013a);
        this.f1103b = new HashMap(rVar.f2014b);
        this.f1104c = new HashMap(rVar.f2015c);
        this.f1105d = new HashMap(rVar.f2016d);
    }

    public m(Typeface typeface, W.b bVar) {
        int i;
        int i3;
        int i4;
        int i5;
        this.f1105d = typeface;
        this.f1102a = bVar;
        this.f1104c = new V.t(1024);
        int a2 = bVar.a(6);
        if (a2 != 0) {
            int i6 = a2 + bVar.f943a;
            i = ((ByteBuffer) bVar.f946d).getInt(((ByteBuffer) bVar.f946d).getInt(i6) + i6);
        } else {
            i = 0;
        }
        this.f1103b = new char[i * 2];
        int a4 = bVar.a(6);
        if (a4 != 0) {
            int i7 = a4 + bVar.f943a;
            i3 = ((ByteBuffer) bVar.f946d).getInt(((ByteBuffer) bVar.f946d).getInt(i7) + i7);
        } else {
            i3 = 0;
        }
        for (int i8 = 0; i8 < i3; i8++) {
            V.p pVar = new V.p(this, i8);
            W.a b4 = pVar.b();
            int a5 = b4.a(4);
            Character.toChars(a5 != 0 ? ((ByteBuffer) b4.f946d).getInt(a5 + b4.f943a) : 0, (char[]) this.f1103b, i8 * 2);
            W.a b5 = pVar.b();
            int a6 = b5.a(16);
            if (a6 != 0) {
                int i9 = a6 + b5.f943a;
                i4 = ((ByteBuffer) b5.f946d).getInt(((ByteBuffer) b5.f946d).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                V.t tVar = (V.t) this.f1104c;
                W.a b6 = pVar.b();
                int a7 = b6.a(16);
                if (a7 != 0) {
                    int i10 = a7 + b6.f943a;
                    i5 = ((ByteBuffer) b6.f946d).getInt(((ByteBuffer) b6.f946d).getInt(i10) + i10);
                } else {
                    i5 = 0;
                }
                tVar.a(pVar, 0, i5 - 1);
            } else {
                throw new IllegalArgumentException("invalid metadata codepoint length");
            }
        }
    }

    public m(Signature signature) {
        this.f1102a = signature;
        this.f1103b = null;
        this.f1104c = null;
        this.f1105d = null;
    }

    public m(Cipher cipher) {
        this.f1102a = null;
        this.f1103b = cipher;
        this.f1104c = null;
        this.f1105d = null;
    }

    public m(Mac mac) {
        this.f1102a = null;
        this.f1103b = null;
        this.f1104c = mac;
        this.f1105d = null;
    }
}
