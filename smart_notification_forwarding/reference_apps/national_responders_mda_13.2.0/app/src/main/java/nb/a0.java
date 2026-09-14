package nb;

import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p8.f;

@IgnoreJRERequirement
/* loaded from: classes.dex */
public final class a0 extends p8.a implements n1<String> {

    /* renamed from: g, reason: collision with root package name */
    public static final a f12359g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private final long f12360f;

    /* loaded from: classes.dex */
    public static final class a implements f.c<a0> {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    @Override // nb.n1
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void f(p8.f fVar, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // nb.n1
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public String M(p8.f fVar) {
        int P;
        String c10;
        b0 b0Var = (b0) fVar.get(b0.f12363g);
        String str = "coroutine";
        if (b0Var != null && (c10 = b0Var.c()) != null) {
            str = c10;
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        P = mb.s.P(name, " @", 0, false, 6, null);
        if (P < 0) {
            P = name.length();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + P + 10);
        String substring = name.substring(0, P);
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb2.append(substring);
        sb2.append(" @");
        sb2.append(str);
        sb2.append('#');
        sb2.append(c());
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb3);
        return name;
    }

    public final long c() {
        return this.f12360f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && this.f12360f == ((a0) obj).f12360f;
    }

    public int hashCode() {
        return z.a(this.f12360f);
    }

    public String toString() {
        return "CoroutineId(" + this.f12360f + ')';
    }
}
