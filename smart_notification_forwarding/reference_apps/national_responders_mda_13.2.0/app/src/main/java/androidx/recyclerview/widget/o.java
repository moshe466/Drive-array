package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    final b f3649a;

    /* renamed from: b, reason: collision with root package name */
    a f3650b = new a();

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f3651a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f3652b;

        /* renamed from: c, reason: collision with root package name */
        int f3653c;

        /* renamed from: d, reason: collision with root package name */
        int f3654d;

        /* renamed from: e, reason: collision with root package name */
        int f3655e;

        a() {
        }

        void a(int i10) {
            this.f3651a = i10 | this.f3651a;
        }

        boolean b() {
            int i10 = this.f3651a;
            if ((i10 & 7) != 0 && (i10 & (c(this.f3654d, this.f3652b) << 0)) == 0) {
                return false;
            }
            int i11 = this.f3651a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f3654d, this.f3653c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f3651a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f3655e, this.f3652b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f3651a;
            return (i13 & 28672) == 0 || (i13 & (c(this.f3655e, this.f3653c) << 12)) != 0;
        }

        int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        void d() {
            this.f3651a = 0;
        }

        void e(int i10, int i11, int i12, int i13) {
            this.f3652b = i10;
            this.f3653c = i11;
            this.f3654d = i12;
            this.f3655e = i13;
        }
    }

    /* loaded from: classes.dex */
    interface b {
        View a(int i10);

        int b();

        int c(View view);

        int d();

        int e(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.f3649a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i10, int i11, int i12, int i13) {
        int d10 = this.f3649a.d();
        int b10 = this.f3649a.b();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View a10 = this.f3649a.a(i10);
            this.f3650b.e(d10, b10, this.f3649a.c(a10), this.f3649a.e(a10));
            if (i12 != 0) {
                this.f3650b.d();
                this.f3650b.a(i12);
                if (this.f3650b.b()) {
                    return a10;
                }
            }
            if (i13 != 0) {
                this.f3650b.d();
                this.f3650b.a(i13);
                if (this.f3650b.b()) {
                    view = a10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view, int i10) {
        this.f3650b.e(this.f3649a.d(), this.f3649a.b(), this.f3649a.c(view), this.f3649a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f3650b.d();
        this.f3650b.a(i10);
        return this.f3650b.b();
    }
}
