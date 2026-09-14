package ha;

import d9.c;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import m8.g0;
import m8.r;
import m8.y;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class a extends ia.a {

    /* renamed from: f, reason: collision with root package name */
    public static final C0196a f10697f = new C0196a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final a f10698g = new a(1, 0, 7);

    /* renamed from: ha.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0196a {
        private C0196a() {
        }

        public /* synthetic */ C0196a(g gVar) {
            this();
        }

        public final a a(InputStream inputStream) {
            int n10;
            int[] m02;
            k.e(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            c cVar = new c(1, dataInputStream.readInt());
            n10 = r.n(cVar, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<Integer> it = cVar.iterator();
            while (it.hasNext()) {
                ((g0) it).b();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            m02 = y.m0(arrayList);
            int[] iArr = new int[m02.length];
            System.arraycopy(m02, 0, iArr, 0, m02.length);
            return new a(iArr);
        }
    }

    static {
        new a(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(int... r4) {
        /*
            r3 = this;
            java.lang.String r0 = "numbers"
            y8.k.e(r4, r0)
            int r0 = r4.length
            int[] r0 = new int[r0]
            int r1 = r4.length
            r2 = 0
            java.lang.System.arraycopy(r4, r2, r0, r2, r1)
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ha.a.<init>(int[]):void");
    }

    public boolean h() {
        return f(f10698g);
    }
}
