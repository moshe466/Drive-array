package g;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.core.content.res.k;
import g.b;
import g.d;
import l.h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class a extends g.d implements androidx.core.graphics.drawable.b {

    /* renamed from: t, reason: collision with root package name */
    private c f9692t;

    /* renamed from: u, reason: collision with root package name */
    private g f9693u;

    /* renamed from: v, reason: collision with root package name */
    private int f9694v;

    /* renamed from: w, reason: collision with root package name */
    private int f9695w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f9696x;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        private final Animatable f9697a;

        b(Animatable animatable) {
            super();
            this.f9697a = animatable;
        }

        @Override // g.a.g
        public void c() {
            this.f9697a.start();
        }

        @Override // g.a.g
        public void d() {
            this.f9697a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends d.a {
        l.d<Long> K;
        h<Integer> L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            h<Integer> hVar;
            if (cVar != null) {
                this.K = cVar.K;
                hVar = cVar.L;
            } else {
                this.K = new l.d<>();
                hVar = new h<>();
            }
            this.L = hVar;
        }

        private static long D(int i10, int i11) {
            return i11 | (i10 << 32);
        }

        int B(int[] iArr, Drawable drawable, int i10) {
            int z10 = super.z(iArr, drawable);
            this.L.l(z10, Integer.valueOf(i10));
            return z10;
        }

        int C(int i10, int i11, Drawable drawable, boolean z10) {
            int a10 = super.a(drawable);
            long D = D(i10, i11);
            long j10 = z10 ? 8589934592L : 0L;
            long j11 = a10;
            this.K.a(D, Long.valueOf(j11 | j10));
            if (z10) {
                this.K.a(D(i11, i10), Long.valueOf(4294967296L | j11 | j10));
            }
            return a10;
        }

        int E(int i10) {
            if (i10 < 0) {
                return 0;
            }
            return this.L.i(i10, 0).intValue();
        }

        int F(int[] iArr) {
            int A = super.A(iArr);
            return A >= 0 ? A : super.A(StateSet.WILD_CARD);
        }

        int G(int i10, int i11) {
            return (int) this.K.i(D(i10, i11), -1L).longValue();
        }

        boolean H(int i10, int i11) {
            return (this.K.i(D(i10, i11), -1L).longValue() & 4294967296L) != 0;
        }

        boolean I(int i10, int i11) {
            return (this.K.i(D(i10, i11), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // g.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // g.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        @Override // g.d.a, g.b.d
        void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.b f9698a;

        d(androidx.vectordrawable.graphics.drawable.b bVar) {
            super();
            this.f9698a = bVar;
        }

        @Override // g.a.g
        public void c() {
            this.f9698a.start();
        }

        @Override // g.a.g
        public void d() {
            this.f9698a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends g {

        /* renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f9699a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f9700b;

        e(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i10 = z10 ? numberOfFrames - 1 : 0;
            int i11 = z10 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z10);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i10, i11);
            if (Build.VERSION.SDK_INT >= 18) {
                h.b.a(ofInt, true);
            }
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.f9700b = z11;
            this.f9699a = ofInt;
        }

        @Override // g.a.g
        public boolean a() {
            return this.f9700b;
        }

        @Override // g.a.g
        public void b() {
            this.f9699a.reverse();
        }

        @Override // g.a.g
        public void c() {
            this.f9699a.start();
        }

        @Override // g.a.g
        public void d() {
            this.f9699a.cancel();
        }
    }

    /* loaded from: classes.dex */
    private static class f implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        private int[] f9701a;

        /* renamed from: b, reason: collision with root package name */
        private int f9702b;

        /* renamed from: c, reason: collision with root package name */
        private int f9703c;

        f(AnimationDrawable animationDrawable, boolean z10) {
            b(animationDrawable, z10);
        }

        int a() {
            return this.f9703c;
        }

        int b(AnimationDrawable animationDrawable, boolean z10) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f9702b = numberOfFrames;
            int[] iArr = this.f9701a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f9701a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f9701a;
            int i10 = 0;
            for (int i11 = 0; i11 < numberOfFrames; i11++) {
                int duration = animationDrawable.getDuration(z10 ? (numberOfFrames - i11) - 1 : i11);
                iArr2[i11] = duration;
                i10 += duration;
            }
            this.f9703c = i10;
            return i10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            int i10 = (int) ((f10 * this.f9703c) + 0.5f);
            int i11 = this.f9702b;
            int[] iArr = this.f9701a;
            int i12 = 0;
            while (i12 < i11 && i10 >= iArr[i12]) {
                i10 -= iArr[i12];
                i12++;
            }
            return (i12 / i11) + (i12 < i11 ? i10 / this.f9703c : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    a(c cVar, Resources resources) {
        super(null);
        this.f9694v = -1;
        this.f9695w = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    r(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        if (r5 != 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        if (r7.getName().equals("vector") == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r5 = androidx.vectordrawable.graphics.drawable.h.c(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        r5 = h.c.a(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r7.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (r5 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        return r4.f9692t.B(r0, r5, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r7.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
    
        if (r5 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        r5 = r7.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        if (r5 != 4) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int q(android.content.Context r5, android.content.res.Resources r6, org.xmlpull.v1.XmlPullParser r7, android.util.AttributeSet r8, android.content.res.Resources.Theme r9) {
        /*
            r4 = this;
            int[] r0 = h.e.f10413h
            android.content.res.TypedArray r0 = androidx.core.content.res.k.k(r6, r9, r8, r0)
            int r1 = h.e.f10414i
            r2 = 0
            int r1 = r0.getResourceId(r1, r2)
            int r2 = h.e.f10415j
            r3 = -1
            int r2 = r0.getResourceId(r2, r3)
            if (r2 <= 0) goto L1f
            androidx.appcompat.widget.o0 r3 = androidx.appcompat.widget.o0.h()
            android.graphics.drawable.Drawable r5 = r3.j(r5, r2)
            goto L20
        L1f:
            r5 = 0
        L20:
            r0.recycle()
            int[] r0 = r4.k(r8)
            java.lang.String r2 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r5 != 0) goto L70
        L2b:
            int r5 = r7.next()
            r3 = 4
            if (r5 != r3) goto L33
            goto L2b
        L33:
            r3 = 2
            if (r5 != r3) goto L57
            java.lang.String r5 = r7.getName()
            java.lang.String r3 = "vector"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L47
            androidx.vectordrawable.graphics.drawable.h r5 = androidx.vectordrawable.graphics.drawable.h.c(r6, r7, r8, r9)
            goto L70
        L47:
            int r5 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r5 < r3) goto L52
            android.graphics.drawable.Drawable r5 = h.c.a(r6, r7, r8, r9)
            goto L70
        L52:
            android.graphics.drawable.Drawable r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8)
            goto L70
        L57:
            org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r7.getPositionDescription()
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L70:
            if (r5 == 0) goto L79
            g.a$c r6 = r4.f9692t
            int r5 = r6.B(r0, r5, r1)
            return r5
        L79:
            org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r7.getPositionDescription()
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.q(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        if (r4 != 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        if (r10.getName().equals("animated-vector") == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
    
        r4 = androidx.vectordrawable.graphics.drawable.b.a(r8, r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        r4 = h.c.a(r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        if (r4 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
    
        if (r1 == (-1)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
    
        if (r3 == (-1)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
    
        return r7.f9692t.C(r1, r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009f, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b8, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0031, code lost:
    
        if (r4 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0033, code lost:
    
        r4 = r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0038, code lost:
    
        if (r4 != 4) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int r(android.content.Context r8, android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            int[] r0 = h.e.f10416k
            android.content.res.TypedArray r0 = androidx.core.content.res.k.k(r9, r12, r11, r0)
            int r1 = h.e.f10419n
            r2 = -1
            int r1 = r0.getResourceId(r1, r2)
            int r3 = h.e.f10418m
            int r3 = r0.getResourceId(r3, r2)
            int r4 = h.e.f10417l
            int r4 = r0.getResourceId(r4, r2)
            if (r4 <= 0) goto L24
            androidx.appcompat.widget.o0 r5 = androidx.appcompat.widget.o0.h()
            android.graphics.drawable.Drawable r4 = r5.j(r8, r4)
            goto L25
        L24:
            r4 = 0
        L25:
            int r5 = h.e.f10420o
            r6 = 0
            boolean r5 = r0.getBoolean(r5, r6)
            r0.recycle()
            java.lang.String r0 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r4 != 0) goto L78
        L33:
            int r4 = r10.next()
            r6 = 4
            if (r4 != r6) goto L3b
            goto L33
        L3b:
            r6 = 2
            if (r4 != r6) goto L5f
            java.lang.String r4 = r10.getName()
            java.lang.String r6 = "animated-vector"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L4f
            androidx.vectordrawable.graphics.drawable.b r4 = androidx.vectordrawable.graphics.drawable.b.a(r8, r9, r10, r11, r12)
            goto L78
        L4f:
            int r8 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r8 < r4) goto L5a
            android.graphics.drawable.Drawable r4 = h.c.a(r9, r10, r11, r12)
            goto L78
        L5a:
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11)
            goto L78
        L5f:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r9.append(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L78:
            if (r4 == 0) goto La0
            if (r1 == r2) goto L85
            if (r3 == r2) goto L85
            g.a$c r8 = r7.f9692t
            int r8 = r8.C(r1, r3, r4, r5)
            return r8
        L85:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r9.append(r10)
            java.lang.String r10 = ": <transition> tag requires 'fromId' & 'toId' attributes"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        La0:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r9.append(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.r(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):int");
    }

    private boolean s(int i10) {
        int c10;
        int G;
        g bVar;
        g gVar = this.f9693u;
        if (gVar == null) {
            c10 = c();
        } else {
            if (i10 == this.f9694v) {
                return true;
            }
            if (i10 == this.f9695w && gVar.a()) {
                gVar.b();
                this.f9694v = this.f9695w;
                this.f9695w = i10;
                return true;
            }
            c10 = this.f9694v;
            gVar.d();
        }
        this.f9693u = null;
        this.f9695w = -1;
        this.f9694v = -1;
        c cVar = this.f9692t;
        int E = cVar.E(c10);
        int E2 = cVar.E(i10);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else {
            if (!(current instanceof androidx.vectordrawable.graphics.drawable.b)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((androidx.vectordrawable.graphics.drawable.b) current);
        }
        bVar.c();
        this.f9693u = bVar;
        this.f9695w = c10;
        this.f9694v = i10;
        return true;
    }

    private void t(TypedArray typedArray) {
        c cVar = this.f9692t;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f9721d |= h.c.b(typedArray);
        }
        cVar.x(typedArray.getBoolean(h.e.f10409d, cVar.f9726i));
        cVar.t(typedArray.getBoolean(h.e.f10410e, cVar.f9729l));
        cVar.u(typedArray.getInt(h.e.f10411f, cVar.A));
        cVar.v(typedArray.getInt(h.e.f10412g, cVar.B));
        setDither(typedArray.getBoolean(h.e.f10407b, cVar.f9741x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.d, g.b
    public void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof c) {
            this.f9692t = (c) dVar;
        }
    }

    @Override // g.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // g.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f9693u;
        if (gVar != null) {
            gVar.d();
            this.f9693u = null;
            g(this.f9694v);
            this.f9694v = -1;
            this.f9695w = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.f9692t, this, null);
    }

    @Override // g.d, g.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9696x && super.mutate() == this) {
            this.f9692t.r();
            this.f9696x = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray k10 = k.k(resources, theme, attributeSet, h.e.f10406a);
        setVisible(k10.getBoolean(h.e.f10408c, true), true);
        t(k10);
        i(resources);
        k10.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.d, g.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int F = this.f9692t.F(iArr);
        boolean z10 = F != c() && (s(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z10 | current.setState(iArr) : z10;
    }

    @Override // g.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        g gVar = this.f9693u;
        if (gVar != null && (visible || z11)) {
            if (z10) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }
}
