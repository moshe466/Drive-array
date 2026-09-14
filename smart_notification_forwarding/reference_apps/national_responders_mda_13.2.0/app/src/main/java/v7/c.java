package v7;

import java.util.ArrayList;
import u7.b0;

/* loaded from: classes.dex */
public class c implements Comparable<c> {

    /* renamed from: f, reason: collision with root package name */
    private String f14712f;

    /* renamed from: g, reason: collision with root package name */
    private String f14713g;

    /* renamed from: h, reason: collision with root package name */
    private String f14714h;

    /* renamed from: i, reason: collision with root package name */
    private long f14715i;

    /* renamed from: j, reason: collision with root package name */
    private String f14716j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14717a;

        static {
            int[] iArr = new int[j7.a.values().length];
            f14717a = iArr;
            try {
                iArr[j7.a.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14717a[j7.a.SPEAKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14717a[j7.a.DND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14717a[j7.a.MUTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14717a[j7.a.OFFLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements b0.a<j7.a, f> {
        b() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<j7.a, f> b0Var, j7.a aVar) {
            b0.a<j7.a, f> dVar;
            int i10 = a.f14717a[aVar.ordinal()];
            if (i10 == 3) {
                dVar = new d();
            } else if (i10 == 4) {
                dVar = new e();
            } else if (i10 != 5) {
                return;
            } else {
                dVar = new C0304c(System.currentTimeMillis());
            }
            b0Var.b(dVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public f a() {
            return f.ONLINE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v7.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0304c implements b0.a<j7.a, f> {
        C0304c(long j10) {
            c.this.f14715i = j10;
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<j7.a, f> b0Var, j7.a aVar) {
            b0.a<j7.a, f> bVar;
            int i10 = a.f14717a[aVar.ordinal()];
            if (i10 == 1 || i10 == 2) {
                bVar = new b();
            } else if (i10 == 3) {
                bVar = new d();
            } else if (i10 != 4) {
                return;
            } else {
                bVar = new e();
            }
            b0Var.b(bVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public f a() {
            return c.this.f14715i == 0 ? f.UNKNOWN : f.OFFLINE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements b0.a<j7.a, f> {
        d() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<j7.a, f> b0Var, j7.a aVar) {
            b0.a<j7.a, f> bVar;
            int i10 = a.f14717a[aVar.ordinal()];
            if (i10 == 1 || i10 == 2) {
                bVar = new b();
            } else if (i10 == 4) {
                bVar = new e();
            } else if (i10 != 5) {
                return;
            } else {
                bVar = new C0304c(System.currentTimeMillis());
            }
            b0Var.b(bVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public f a() {
            return f.DND;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b0.a<j7.a, f> {
        e() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<j7.a, f> b0Var, j7.a aVar) {
            b0.a<j7.a, f> bVar;
            int i10 = a.f14717a[aVar.ordinal()];
            if (i10 == 1 || i10 == 2) {
                bVar = new b();
            } else if (i10 == 3) {
                bVar = new d();
            } else if (i10 != 5) {
                return;
            } else {
                bVar = new C0304c(System.currentTimeMillis());
            }
            b0Var.b(bVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public f a() {
            return f.MUTE;
        }
    }

    public c(String str, String str2, String str3, String str4, int i10) {
        new b0(new C0304c(0L));
        this.f14712f = str;
        this.f14714h = str2;
        this.f14713g = str3;
        this.f14716j = str4;
        new ArrayList();
    }

    @Override // java.lang.Comparable
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return this.f14713g.compareToIgnoreCase(cVar.r());
    }

    public String n() {
        return this.f14716j;
    }

    public String o() {
        return this.f14712f;
    }

    public String r() {
        return this.f14713g;
    }

    public String s() {
        return this.f14714h;
    }
}
