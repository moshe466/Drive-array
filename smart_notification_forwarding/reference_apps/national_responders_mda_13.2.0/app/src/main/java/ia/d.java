package ia;

import ga.o;
import ga.p;
import java.util.LinkedList;
import java.util.List;
import l8.s;
import m8.y;
import y8.k;

/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private final p f10824a;

    /* renamed from: b, reason: collision with root package name */
    private final o f10825b;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10826a;

        static {
            int[] iArr = new int[o.c.EnumC0181c.values().length];
            iArr[o.c.EnumC0181c.CLASS.ordinal()] = 1;
            iArr[o.c.EnumC0181c.PACKAGE.ordinal()] = 2;
            iArr[o.c.EnumC0181c.LOCAL.ordinal()] = 3;
            f10826a = iArr;
        }
    }

    public d(p pVar, o oVar) {
        k.e(pVar, "strings");
        k.e(oVar, "qualifiedNames");
        this.f10824a = pVar;
        this.f10825b = oVar;
    }

    private final s<List<String>, List<String>, Boolean> d(int i10) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z10 = false;
        while (i10 != -1) {
            o.c w10 = this.f10825b.w(i10);
            String w11 = this.f10824a.w(w10.A());
            o.c.EnumC0181c y10 = w10.y();
            k.b(y10);
            int i11 = a.f10826a[y10.ordinal()];
            if (i11 == 1) {
                linkedList2.addFirst(w11);
            } else if (i11 == 2) {
                linkedList.addFirst(w11);
            } else if (i11 == 3) {
                linkedList2.addFirst(w11);
                z10 = true;
            }
            i10 = w10.z();
        }
        return new s<>(linkedList, linkedList2, Boolean.valueOf(z10));
    }

    @Override // ia.c
    public String a(int i10) {
        String w10 = this.f10824a.w(i10);
        k.d(w10, "strings.getString(index)");
        return w10;
    }

    @Override // ia.c
    public boolean b(int i10) {
        return d(i10).d().booleanValue();
    }

    @Override // ia.c
    public String c(int i10) {
        String Q;
        String Q2;
        s<List<String>, List<String>, Boolean> d10 = d(i10);
        List<String> a10 = d10.a();
        Q = y.Q(d10.b(), ".", null, null, 0, null, null, 62, null);
        if (a10.isEmpty()) {
            return Q;
        }
        StringBuilder sb2 = new StringBuilder();
        Q2 = y.Q(a10, "/", null, null, 0, null, null, 62, null);
        sb2.append(Q2);
        sb2.append('/');
        sb2.append(Q);
        return sb2.toString();
    }
}
