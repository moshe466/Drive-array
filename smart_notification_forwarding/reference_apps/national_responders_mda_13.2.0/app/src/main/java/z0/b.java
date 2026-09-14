package z0;

import com.andrognito.patternlockview.PatternLockView;
import java.util.List;
import y7.d;

/* loaded from: classes.dex */
public class b extends z0.a<y0.b> {

    /* loaded from: classes.dex */
    private static final class a extends z7.a implements v0.a {

        /* renamed from: g, reason: collision with root package name */
        private final PatternLockView f16059g;

        /* renamed from: h, reason: collision with root package name */
        private final d<? super y0.b> f16060h;

        a(PatternLockView patternLockView, d<? super y0.b> dVar) {
            this.f16059g = patternLockView;
            this.f16060h = dVar;
        }

        @Override // v0.a
        public void a(List<PatternLockView.f> list) {
            if (e()) {
                return;
            }
            this.f16060h.d(new y0.b(list));
        }

        @Override // v0.a
        public void b(List<PatternLockView.f> list) {
        }

        @Override // v0.a
        public void c() {
        }

        @Override // v0.a
        public void d() {
        }

        @Override // z7.a
        protected void f() {
            this.f16059g.G(this);
        }
    }

    public b(PatternLockView patternLockView, boolean z10) {
        super(patternLockView, z10);
    }

    @Override // y7.c
    protected void d(d<? super y0.b> dVar) {
        a aVar = new a(this.f16057a, dVar);
        dVar.c(aVar);
        this.f16057a.h(aVar);
    }
}
