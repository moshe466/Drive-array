package xb;

import java.util.List;

/* loaded from: classes.dex */
public interface l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f15825a = new a();

    /* loaded from: classes.dex */
    class a implements l {
        a() {
        }

        @Override // xb.l
        public boolean a(int i10, List<c> list) {
            return true;
        }

        @Override // xb.l
        public boolean b(int i10, List<c> list, boolean z10) {
            return true;
        }

        @Override // xb.l
        public void c(int i10, b bVar) {
        }

        @Override // xb.l
        public boolean d(int i10, bc.e eVar, int i11, boolean z10) {
            eVar.q(i11);
            return true;
        }
    }

    boolean a(int i10, List<c> list);

    boolean b(int i10, List<c> list, boolean z10);

    void c(int i10, b bVar);

    boolean d(int i10, bc.e eVar, int i11, boolean z10);
}
