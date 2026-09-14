package u9;

import y8.k;

/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f14494a = new a();

        private a() {
        }

        @Override // u9.c
        public boolean a() {
            return false;
        }

        @Override // u9.c
        public void b(String str, e eVar, String str2, f fVar, String str3) {
            k.e(str, "filePath");
            k.e(eVar, "position");
            k.e(str2, "scopeFqName");
            k.e(fVar, "scopeKind");
            k.e(str3, "name");
        }
    }

    boolean a();

    void b(String str, e eVar, String str2, f fVar, String str3);
}
