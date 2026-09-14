package P1;

import J.C0119g;
import R1.i;
import R1.j;
import R1.s;
import W1.r0;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final j f1583a;

    /* renamed from: b, reason: collision with root package name */
    public static final i f1584b;

    /* renamed from: c, reason: collision with root package name */
    public static final R1.b f1585c;

    /* renamed from: d, reason: collision with root package name */
    public static final R1.a f1586d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map f1587e;

    static {
        Y1.a b4 = s.b("type.googleapis.com/google.crypto.tink.AesSivKey");
        f1583a = new j(c.class);
        f1584b = new i(b4);
        f1585c = new R1.b(a.class);
        f1586d = new R1.a(b4, new C0119g(8));
        HashMap hashMap = new HashMap();
        b bVar = b.f1579d;
        r0 r0Var = r0.RAW;
        hashMap.put(bVar, r0Var);
        b bVar2 = b.f1577b;
        r0 r0Var2 = r0.TINK;
        hashMap.put(bVar2, r0Var2);
        b bVar3 = b.f1578c;
        r0 r0Var3 = r0.CRUNCHY;
        hashMap.put(bVar3, r0Var3);
        Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(r0.class);
        enumMap.put((EnumMap) r0Var, (r0) bVar);
        enumMap.put((EnumMap) r0Var2, (r0) bVar2);
        enumMap.put((EnumMap) r0Var3, (r0) bVar3);
        enumMap.put((EnumMap) r0.LEGACY, (r0) bVar3);
        f1587e = Collections.unmodifiableMap(enumMap);
    }
}
