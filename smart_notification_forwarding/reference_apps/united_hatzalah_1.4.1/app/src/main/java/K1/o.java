package K1;

import F0.AbstractC0008a;
import F0.C0084t0;
import W1.Y;
import W1.a0;
import W1.b0;
import W1.r0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.C0336h;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f1106a;

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f1107b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f1108c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f1109d;

    static {
        Logger.getLogger(o.class.getName());
        f1106a = new AtomicReference(new e());
        f1107b = new ConcurrentHashMap();
        f1108c = new ConcurrentHashMap();
        new ConcurrentHashMap();
        f1109d = new ConcurrentHashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0051, code lost:
    
        r6 = (java.util.Map.Entry) r5.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
    
        if (K1.o.f1109d.containsKey(r6.getKey()) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0088, code lost:
    
        throw new java.security.GeneralSecurityException("Attempted to register a new key template " + ((java.lang.String) r6.getKey()) + " from an existing key manager of type " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0089, code lost:
    
        r4 = r5.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0095, code lost:
    
        if (r4.hasNext() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
    
        r5 = (java.util.Map.Entry) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a7, code lost:
    
        if (K1.o.f1109d.containsKey(r5.getKey()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c6, code lost:
    
        throw new java.security.GeneralSecurityException("Attempted overwrite of a registered key template " + ((java.lang.String) r5.getKey()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0041, code lost:
    
        if (((K1.e) K1.o.f1106a.get()).f1084a.containsKey(r4) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0043, code lost:
    
        r5 = r5.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004f, code lost:
    
        if (r5.hasNext() == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void a(java.lang.String r4, java.util.Map r5, boolean r6) {
        /*
            java.lang.String r0 = "New keys are already disallowed for key type "
            java.lang.Class<K1.o> r1 = K1.o.class
            monitor-enter(r1)
            if (r6 == 0) goto L31
            java.util.concurrent.ConcurrentHashMap r2 = K1.o.f1108c     // Catch: java.lang.Throwable -> L2e
            boolean r3 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L31
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L2e
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L1c
            goto L31
        L1c:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L2e
            r6.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L2e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            throw r5     // Catch: java.lang.Throwable -> L2e
        L2e:
            r4 = move-exception
            goto Lc7
        L31:
            if (r6 == 0) goto Lc9
            java.util.concurrent.atomic.AtomicReference r6 = K1.o.f1106a     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L2e
            K1.e r6 = (K1.e) r6     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentHashMap r6 = r6.f1084a     // Catch: java.lang.Throwable -> L2e
            boolean r6 = r6.containsKey(r4)     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L89
            java.util.Set r5 = r5.entrySet()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L2e
        L4b:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto Lc9
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L2e
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentHashMap r0 = K1.o.f1109d     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r2 = r6.getKey()     // Catch: java.lang.Throwable -> L2e
            boolean r0 = r0.containsKey(r2)     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L64
            goto L4b
        L64:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r0.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "Attempted to register a new key template "
            r0.append(r2)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r6.getKey()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L2e
            r0.append(r6)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = " from an existing key manager of type "
            r0.append(r6)     // Catch: java.lang.Throwable -> L2e
            r0.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L2e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            throw r5     // Catch: java.lang.Throwable -> L2e
        L89:
            java.util.Set r4 = r5.entrySet()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L2e
        L91:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r5 == 0) goto Lc9
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L2e
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentHashMap r6 = K1.o.f1109d     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r0 = r5.getKey()     // Catch: java.lang.Throwable -> L2e
            boolean r6 = r6.containsKey(r0)     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto Laa
            goto L91
        Laa:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r6.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r0 = "Attempted overwrite of a registered key template "
            r6.append(r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r5 = r5.getKey()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L2e
            r6.append(r5)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L2e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2e
            throw r4     // Catch: java.lang.Throwable -> L2e
        Lc7:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            throw r4
        Lc9:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: K1.o.a(java.lang.String, java.util.Map, boolean):void");
    }

    public static Object b(b bVar, Class cls) {
        Object obj;
        R1.m mVar = (R1.m) R1.g.f1990b.f1991a.get();
        mVar.getClass();
        R1.l lVar = new R1.l(bVar.getClass(), cls);
        HashMap hashMap = mVar.f2000a;
        if (hashMap.containsKey(lVar)) {
            switch (((R1.k) hashMap.get(lVar)).f1997b.f993a) {
                case 9:
                    obj = new Object();
                    if (!AbstractC0008a.b(1)) {
                        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
                    }
                    return obj;
                default:
                    obj = new Object();
                    if (!AbstractC0008a.c(2)) {
                        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
                    }
                    return obj;
            }
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + lVar + " available");
    }

    public static Object c(String str, AbstractC0337i abstractC0337i, Class cls) {
        e eVar = (e) f1106a.get();
        eVar.getClass();
        d a2 = eVar.a(str);
        Set keySet = a2.f1082a.f1985b.keySet();
        R1.d dVar = a2.f1082a;
        if (keySet.contains(cls)) {
            try {
                if (!dVar.f1985b.keySet().contains(cls) && !Void.class.equals(cls)) {
                    throw new IllegalArgumentException("Given internalKeyMananger " + dVar.toString() + " does not support primitive class " + cls.getName());
                }
                try {
                    AbstractC0329a f4 = dVar.f(abstractC0337i);
                    if (!Void.class.equals(cls)) {
                        dVar.g(f4);
                        return dVar.c(f4, cls);
                    }
                    throw new GeneralSecurityException("Cannot create a primitive for Void");
                } catch (InvalidProtocolBufferException e4) {
                    throw new GeneralSecurityException("Failures parsing proto of type ".concat(dVar.f1984a.getName()), e4);
                }
            } catch (IllegalArgumentException e5) {
                throw new GeneralSecurityException("Primitive type not supported", e5);
            }
        }
        StringBuilder sb = new StringBuilder("Primitive type ");
        sb.append(cls.getName());
        sb.append(" not supported by key manager of type ");
        sb.append(dVar.getClass());
        sb.append(", supported primitives: ");
        Set<Class> keySet2 = dVar.f1985b.keySet();
        StringBuilder sb2 = new StringBuilder();
        boolean z3 = true;
        for (Class cls2 : keySet2) {
            if (!z3) {
                sb2.append(", ");
            }
            sb2.append(cls2.getCanonicalName());
            z3 = false;
        }
        sb.append(sb2.toString());
        throw new GeneralSecurityException(sb.toString());
    }

    public static Object d(String str, byte[] bArr) {
        C0336h c0336h = AbstractC0337i.f4107b;
        return c(str, AbstractC0337i.i(bArr, 0, bArr.length), a.class);
    }

    public static synchronized Y e(b0 b0Var) {
        Y e4;
        synchronized (o.class) {
            R1.d dVar = ((e) f1106a.get()).a(b0Var.B()).f1082a;
            f fVar = new f(dVar, dVar.f1986c);
            if (((Boolean) f1108c.get(b0Var.B())).booleanValue()) {
                e4 = fVar.e(b0Var.C());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + b0Var.B());
            }
        }
        return e4;
    }

    public static synchronized void f(R1.d dVar, boolean z3) {
        Map map;
        synchronized (o.class) {
            try {
                AtomicReference atomicReference = f1106a;
                e eVar = new e((e) atomicReference.get());
                eVar.b(dVar);
                String b4 = dVar.b();
                if (z3) {
                    map = dVar.d().m();
                } else {
                    map = Collections.EMPTY_MAP;
                }
                a(b4, map, z3);
                if (!((e) atomicReference.get()).f1084a.containsKey(b4)) {
                    f1107b.put(b4, new A.n(7));
                    if (z3) {
                        g(b4, dVar.d().m());
                    }
                }
                f1108c.put(b4, Boolean.valueOf(z3));
                atomicReference.set(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void g(String str, Map map) {
        r0 r0Var;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            byte[] e4 = ((AbstractC0329a) ((R1.c) entry.getValue()).f1982a).e();
            int i = ((R1.c) entry.getValue()).f1983b;
            a0 D3 = b0.D();
            D3.e();
            b0.w((b0) D3.f4158b, str);
            C0336h i3 = AbstractC0337i.i(e4, 0, e4.length);
            D3.e();
            b0.x((b0) D3.f4158b, i3);
            int b4 = T.k.b(i);
            if (b4 != 0) {
                if (b4 != 1) {
                    if (b4 != 2) {
                        if (b4 == 3) {
                            r0Var = r0.CRUNCHY;
                        } else {
                            throw new IllegalArgumentException("Unknown output prefix type");
                        }
                    } else {
                        r0Var = r0.RAW;
                    }
                } else {
                    r0Var = r0.LEGACY;
                }
            } else {
                r0Var = r0.TINK;
            }
            D3.e();
            b0.y((b0) D3.f4158b, r0Var);
            f1109d.put(str2, new g((b0) D3.b()));
        }
    }

    public static synchronized void h(n nVar) {
        synchronized (o.class) {
            R1.g gVar = R1.g.f1990b;
            synchronized (gVar) {
                C0084t0 c0084t0 = new C0084t0((R1.m) gVar.f1991a.get());
                c0084t0.m(nVar);
                gVar.f1991a.set(new R1.m(c0084t0));
            }
        }
    }
}
