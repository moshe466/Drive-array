package O2;

import java.util.concurrent.TimeUnit;
import p3.h;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f1540b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f1541c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f1542d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f1543e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f1544f;

    /* renamed from: j, reason: collision with root package name */
    public static final c f1545j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ c[] f1546k;

    /* renamed from: a, reason: collision with root package name */
    public final TimeUnit f1547a;

    static {
        c cVar = new c("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f1540b = cVar;
        c cVar2 = new c("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        c cVar3 = new c("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f1541c = cVar3;
        c cVar4 = new c("SECONDS", 3, TimeUnit.SECONDS);
        f1542d = cVar4;
        c cVar5 = new c("MINUTES", 4, TimeUnit.MINUTES);
        f1543e = cVar5;
        c cVar6 = new c("HOURS", 5, TimeUnit.HOURS);
        f1544f = cVar6;
        c cVar7 = new c("DAYS", 6, TimeUnit.DAYS);
        f1545j = cVar7;
        c[] cVarArr = {cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
        f1546k = cVarArr;
        h.p(cVarArr);
    }

    public c(String str, int i, TimeUnit timeUnit) {
        this.f1547a = timeUnit;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f1546k.clone();
    }
}
