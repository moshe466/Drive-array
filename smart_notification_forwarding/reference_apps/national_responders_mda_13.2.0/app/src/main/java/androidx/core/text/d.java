package androidx.core.text;

import java.util.Locale;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.core.text.c f2486a;

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.core.text.c f2487b;

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        static final a f2488b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        private final boolean f2489a;

        private a(boolean z10) {
            this.f2489a = z10;
        }

        @Override // androidx.core.text.d.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int a10 = d.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (a10 != 0) {
                    if (a10 != 1) {
                        continue;
                        i10++;
                    } else if (!this.f2489a) {
                        return 1;
                    }
                } else if (this.f2489a) {
                    return 0;
                }
                z10 = true;
                i10++;
            }
            if (z10) {
                return this.f2489a ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f2490a = new b();

        private b() {
        }

        @Override // androidx.core.text.d.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int i13 = 2;
            while (i10 < i12 && i13 == 2) {
                i13 = d.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    /* renamed from: androidx.core.text.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static abstract class AbstractC0037d implements androidx.core.text.c {

        /* renamed from: a, reason: collision with root package name */
        private final c f2491a;

        AbstractC0037d(c cVar) {
            this.f2491a = cVar;
        }

        private boolean c(CharSequence charSequence, int i10, int i11) {
            int a10 = this.f2491a.a(charSequence, i10, i11);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                return b();
            }
            return false;
        }

        @Override // androidx.core.text.c
        public boolean a(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            }
            return this.f2491a == null ? b() : c(charSequence, i10, i11);
        }

        protected abstract boolean b();
    }

    /* loaded from: classes.dex */
    private static class e extends AbstractC0037d {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f2492b;

        e(c cVar, boolean z10) {
            super(cVar);
            this.f2492b = z10;
        }

        @Override // androidx.core.text.d.AbstractC0037d
        protected boolean b() {
            return this.f2492b;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends AbstractC0037d {

        /* renamed from: b, reason: collision with root package name */
        static final f f2493b = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.text.d.AbstractC0037d
        protected boolean b() {
            return androidx.core.text.e.b(Locale.getDefault()) == 1;
        }
    }

    static {
        new e(null, false);
        new e(null, true);
        b bVar = b.f2490a;
        f2486a = new e(bVar, false);
        f2487b = new e(bVar, true);
        new e(a.f2488b, false);
        f fVar = f.f2493b;
    }

    static int a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
