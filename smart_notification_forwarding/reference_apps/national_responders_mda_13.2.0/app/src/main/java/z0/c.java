package z0;

import com.andrognito.patternlockview.PatternLockView;
import java.util.List;
import y7.d;

/* loaded from: classes.dex */
public class c extends z0.a<y0.c> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends z7.a implements v0.a {

        /* renamed from: g, reason: collision with root package name */
        private final PatternLockView f16061g;

        /* renamed from: h, reason: collision with root package name */
        private final d<? super y0.c> f16062h;

        a(PatternLockView patternLockView, d<? super y0.c> dVar) {
            this.f16061g = patternLockView;
            this.f16062h = dVar;
        }

        @Override // v0.a
        public void a(List<PatternLockView.f> list) {
            if (e()) {
                return;
            }
            this.f16062h.d(new y0.c(2, list));
        }

        @Override // v0.a
        public void b(List<PatternLockView.f> list) {
            if (e()) {
                return;
            }
            this.f16062h.d(new y0.c(1, list));
        }

        @Override // v0.a
        public void c() {
            if (e()) {
                return;
            }
            this.f16062h.d(new y0.c(3, null));
        }

        @Override // v0.a
        public void d() {
            if (e()) {
                return;
            }
            this.f16062h.d(new y0.c(0, null));
        }

        @Override // z7.a
        protected void f() {
            this.f16061g.G(this);
        }
    }

    public c(PatternLockView patternLockView, boolean z10) {
        super(patternLockView, z10);
    }

    @Override // y7.c
    protected void d(d<? super y0.c> dVar) {
        e(dVar);
        if (this.f16058b) {
            dVar.d(new y0.c(0, this.f16057a.getPattern()));
        }
    }

    protected void e(d<? super y0.c> dVar) {
        a aVar = new a(this.f16057a, dVar);
        dVar.c(aVar);
        this.f16057a.h(aVar);
    }
}
