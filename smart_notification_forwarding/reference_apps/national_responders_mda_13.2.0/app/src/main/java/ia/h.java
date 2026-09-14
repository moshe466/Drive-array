package ia;

import ga.n;
import ga.r;
import ga.v;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import l8.l;
import y8.k;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final a f10828f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b f10829a;

    /* renamed from: b, reason: collision with root package name */
    private final v.d f10830b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.a f10831c;

    /* renamed from: d, reason: collision with root package name */
    private final Integer f10832d;

    /* renamed from: e, reason: collision with root package name */
    private final String f10833e;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: ia.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public /* synthetic */ class C0208a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10834a;

            static {
                int[] iArr = new int[v.c.values().length];
                iArr[v.c.WARNING.ordinal()] = 1;
                iArr[v.c.ERROR.ordinal()] = 2;
                iArr[v.c.HIDDEN.ordinal()] = 3;
                f10834a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final h a(int i10, c cVar, i iVar) {
            kotlin.a aVar;
            k.e(cVar, "nameResolver");
            k.e(iVar, "table");
            v b10 = iVar.b(i10);
            if (b10 == null) {
                return null;
            }
            b a10 = b.f10835d.a(b10.L() ? Integer.valueOf(b10.F()) : null, b10.M() ? Integer.valueOf(b10.G()) : null);
            v.c C = b10.C();
            k.b(C);
            int i11 = C0208a.f10834a[C.ordinal()];
            if (i11 == 1) {
                aVar = kotlin.a.WARNING;
            } else if (i11 == 2) {
                aVar = kotlin.a.ERROR;
            } else {
                if (i11 != 3) {
                    throw new l();
                }
                aVar = kotlin.a.HIDDEN;
            }
            kotlin.a aVar2 = aVar;
            Integer valueOf = b10.I() ? Integer.valueOf(b10.B()) : null;
            String a11 = b10.K() ? cVar.a(b10.E()) : null;
            v.d H = b10.H();
            k.d(H, "info.versionKind");
            return new h(a10, H, aVar2, valueOf, a11);
        }

        public final List<h> b(q qVar, c cVar, i iVar) {
            List<Integer> e02;
            k.e(qVar, "proto");
            k.e(cVar, "nameResolver");
            k.e(iVar, "table");
            if (qVar instanceof ga.c) {
                e02 = ((ga.c) qVar).J0();
            } else if (qVar instanceof ga.d) {
                e02 = ((ga.d) qVar).P();
            } else if (qVar instanceof ga.i) {
                e02 = ((ga.i) qVar).k0();
            } else if (qVar instanceof n) {
                e02 = ((n) qVar).h0();
            } else {
                if (!(qVar instanceof r)) {
                    throw new IllegalStateException(k.j("Unexpected declaration: ", qVar.getClass()));
                }
                e02 = ((r) qVar).e0();
            }
            k.d(e02, "ids");
            ArrayList arrayList = new ArrayList();
            for (Integer num : e02) {
                k.d(num, "id");
                h a10 = a(num.intValue(), cVar, iVar);
                if (a10 != null) {
                    arrayList.add(a10);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        public static final a f10835d = new a(null);

        /* renamed from: e, reason: collision with root package name */
        public static final b f10836e = new b(256, 256, 256);

        /* renamed from: a, reason: collision with root package name */
        private final int f10837a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10838b;

        /* renamed from: c, reason: collision with root package name */
        private final int f10839c;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(y8.g gVar) {
                this();
            }

            public final b a(Integer num, Integer num2) {
                return num2 != null ? new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255) : num != null ? new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127) : b.f10836e;
            }
        }

        public b(int i10, int i11, int i12) {
            this.f10837a = i10;
            this.f10838b = i11;
            this.f10839c = i12;
        }

        public /* synthetic */ b(int i10, int i11, int i12, int i13, y8.g gVar) {
            this(i10, i11, (i13 & 4) != 0 ? 0 : i12);
        }

        public final String a() {
            StringBuilder sb2;
            int i10;
            if (this.f10839c == 0) {
                sb2 = new StringBuilder();
                sb2.append(this.f10837a);
                sb2.append('.');
                i10 = this.f10838b;
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.f10837a);
                sb2.append('.');
                sb2.append(this.f10838b);
                sb2.append('.');
                i10 = this.f10839c;
            }
            sb2.append(i10);
            return sb2.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f10837a == bVar.f10837a && this.f10838b == bVar.f10838b && this.f10839c == bVar.f10839c;
        }

        public int hashCode() {
            return (((this.f10837a * 31) + this.f10838b) * 31) + this.f10839c;
        }

        public String toString() {
            return a();
        }
    }

    public h(b bVar, v.d dVar, kotlin.a aVar, Integer num, String str) {
        k.e(bVar, "version");
        k.e(dVar, "kind");
        k.e(aVar, "level");
        this.f10829a = bVar;
        this.f10830b = dVar;
        this.f10831c = aVar;
        this.f10832d = num;
        this.f10833e = str;
    }

    public final v.d a() {
        return this.f10830b;
    }

    public final b b() {
        return this.f10829a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("since ");
        sb2.append(this.f10829a);
        sb2.append(' ');
        sb2.append(this.f10831c);
        Integer num = this.f10832d;
        sb2.append(num != null ? k.j(" error ", num) : "");
        String str = this.f10833e;
        sb2.append(str != null ? k.j(": ", str) : "");
        return sb2.toString();
    }
}
