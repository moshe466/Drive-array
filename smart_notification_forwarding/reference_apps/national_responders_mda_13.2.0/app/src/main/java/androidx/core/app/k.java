package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class k {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Bundle f2205a;

        /* renamed from: b, reason: collision with root package name */
        private IconCompat f2206b;

        /* renamed from: c, reason: collision with root package name */
        private final s[] f2207c;

        /* renamed from: d, reason: collision with root package name */
        private final s[] f2208d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f2209e;

        /* renamed from: f, reason: collision with root package name */
        boolean f2210f;

        /* renamed from: g, reason: collision with root package name */
        private final int f2211g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f2212h;

        /* renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f2213i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f2214j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f2215k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f2216l;

        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.h(null, "", i10) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, s[] sVarArr, s[] sVarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f2210f = true;
            this.f2206b = iconCompat;
            if (iconCompat != null && iconCompat.l() == 2) {
                this.f2213i = iconCompat.j();
            }
            this.f2214j = e.d(charSequence);
            this.f2215k = pendingIntent;
            this.f2205a = bundle == null ? new Bundle() : bundle;
            this.f2207c = sVarArr;
            this.f2208d = sVarArr2;
            this.f2209e = z10;
            this.f2211g = i10;
            this.f2210f = z11;
            this.f2212h = z12;
            this.f2216l = z13;
        }

        public PendingIntent a() {
            return this.f2215k;
        }

        public boolean b() {
            return this.f2209e;
        }

        public s[] c() {
            return this.f2208d;
        }

        public Bundle d() {
            return this.f2205a;
        }

        public IconCompat e() {
            int i10;
            if (this.f2206b == null && (i10 = this.f2213i) != 0) {
                this.f2206b = IconCompat.h(null, "", i10);
            }
            return this.f2206b;
        }

        public s[] f() {
            return this.f2207c;
        }

        public int g() {
            return this.f2211g;
        }

        public boolean h() {
            return this.f2210f;
        }

        public CharSequence i() {
            return this.f2214j;
        }

        public boolean j() {
            return this.f2216l;
        }

        public boolean k() {
            return this.f2212h;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f {

        /* renamed from: e, reason: collision with root package name */
        private IconCompat f2217e;

        /* renamed from: f, reason: collision with root package name */
        private IconCompat f2218f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f2219g;

        /* renamed from: h, reason: collision with root package name */
        private CharSequence f2220h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f2221i;

        /* loaded from: classes.dex */
        private static class a {
            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* renamed from: androidx.core.app.k$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0029b {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* loaded from: classes.dex */
        private static class c {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z10) {
                bigPictureStyle.showBigPictureWhenCollapsed(z10);
            }
        }

        @Override // androidx.core.app.k.f
        public void b(j jVar) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 16) {
                Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(jVar.a()).setBigContentTitle(this.f2250b);
                IconCompat iconCompat = this.f2217e;
                if (iconCompat != null) {
                    if (i10 >= 31) {
                        c.a(bigContentTitle, this.f2217e.r(jVar instanceof l ? ((l) jVar).f() : null));
                    } else if (iconCompat.l() == 1) {
                        bigContentTitle = bigContentTitle.bigPicture(this.f2217e.i());
                    }
                }
                if (this.f2219g) {
                    IconCompat iconCompat2 = this.f2218f;
                    if (iconCompat2 != null) {
                        if (i10 >= 23) {
                            C0029b.a(bigContentTitle, this.f2218f.r(jVar instanceof l ? ((l) jVar).f() : null));
                        } else if (iconCompat2.l() == 1) {
                            a.a(bigContentTitle, this.f2218f.i());
                        }
                    }
                    a.a(bigContentTitle, null);
                }
                if (this.f2252d) {
                    a.b(bigContentTitle, this.f2251c);
                }
                if (i10 >= 31) {
                    c.c(bigContentTitle, this.f2221i);
                    c.b(bigContentTitle, this.f2220h);
                }
            }
        }

        @Override // androidx.core.app.k.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public b h(Bitmap bitmap) {
            this.f2218f = bitmap == null ? null : IconCompat.e(bitmap);
            this.f2219g = true;
            return this;
        }

        public b i(Bitmap bitmap) {
            this.f2217e = bitmap == null ? null : IconCompat.e(bitmap);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private CharSequence f2222e;

        @Override // androidx.core.app.k.f
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f2222e);
            }
        }

        @Override // androidx.core.app.k.f
        public void b(j jVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(jVar.a()).setBigContentTitle(this.f2250b).bigText(this.f2222e);
                if (this.f2252d) {
                    bigText.setSummaryText(this.f2251c);
                }
            }
        }

        @Override // androidx.core.app.k.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public c h(CharSequence charSequence) {
            this.f2222e = e.d(charSequence);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        d R;
        Notification S;
        boolean T;
        Icon U;

        @Deprecated
        public ArrayList<String> V;

        /* renamed from: a, reason: collision with root package name */
        public Context f2223a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<a> f2224b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<q> f2225c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<a> f2226d;

        /* renamed from: e, reason: collision with root package name */
        CharSequence f2227e;

        /* renamed from: f, reason: collision with root package name */
        CharSequence f2228f;

        /* renamed from: g, reason: collision with root package name */
        PendingIntent f2229g;

        /* renamed from: h, reason: collision with root package name */
        PendingIntent f2230h;

        /* renamed from: i, reason: collision with root package name */
        RemoteViews f2231i;

        /* renamed from: j, reason: collision with root package name */
        Bitmap f2232j;

        /* renamed from: k, reason: collision with root package name */
        CharSequence f2233k;

        /* renamed from: l, reason: collision with root package name */
        int f2234l;

        /* renamed from: m, reason: collision with root package name */
        int f2235m;

        /* renamed from: n, reason: collision with root package name */
        boolean f2236n;

        /* renamed from: o, reason: collision with root package name */
        boolean f2237o;

        /* renamed from: p, reason: collision with root package name */
        f f2238p;

        /* renamed from: q, reason: collision with root package name */
        CharSequence f2239q;

        /* renamed from: r, reason: collision with root package name */
        CharSequence f2240r;

        /* renamed from: s, reason: collision with root package name */
        CharSequence[] f2241s;

        /* renamed from: t, reason: collision with root package name */
        int f2242t;

        /* renamed from: u, reason: collision with root package name */
        int f2243u;

        /* renamed from: v, reason: collision with root package name */
        boolean f2244v;

        /* renamed from: w, reason: collision with root package name */
        String f2245w;

        /* renamed from: x, reason: collision with root package name */
        boolean f2246x;

        /* renamed from: y, reason: collision with root package name */
        String f2247y;

        /* renamed from: z, reason: collision with root package name */
        boolean f2248z;

        @Deprecated
        public e(Context context) {
            this(context, null);
        }

        public e(Context context, String str) {
            this.f2224b = new ArrayList<>();
            this.f2225c = new ArrayList<>();
            this.f2226d = new ArrayList<>();
            this.f2236n = true;
            this.f2248z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.f2223a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.f2235m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private Bitmap e(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f2223a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(t.b.f14219b);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(t.b.f14218a);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
        }

        private void n(int i10, boolean z10) {
            Notification notification;
            int i11;
            if (z10) {
                notification = this.S;
                i11 = i10 | notification.flags;
            } else {
                notification = this.S;
                i11 = (~i10) & notification.flags;
            }
            notification.flags = i11;
        }

        public e A(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        public e B(int i10) {
            this.F = i10;
            return this;
        }

        public e C(long j10) {
            this.S.when = j10;
            return this;
        }

        public e a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2224b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new l(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public e f(boolean z10) {
            n(16, z10);
            return this;
        }

        public e g(String str) {
            this.K = str;
            return this;
        }

        public e h(int i10) {
            this.E = i10;
            return this;
        }

        public e i(PendingIntent pendingIntent) {
            this.f2229g = pendingIntent;
            return this;
        }

        public e j(CharSequence charSequence) {
            this.f2228f = d(charSequence);
            return this;
        }

        public e k(CharSequence charSequence) {
            this.f2227e = d(charSequence);
            return this;
        }

        public e l(int i10) {
            Notification notification = this.S;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e m(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public e o(Bitmap bitmap) {
            this.f2232j = e(bitmap);
            return this;
        }

        public e p(int i10, int i11, int i12) {
            Notification notification = this.S;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            notification.flags = ((i11 == 0 || i12 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e q(boolean z10) {
            this.f2248z = z10;
            return this;
        }

        public e r(int i10) {
            this.f2234l = i10;
            return this;
        }

        public e s(boolean z10) {
            n(2, z10);
            return this;
        }

        public e t(int i10) {
            this.f2235m = i10;
            return this;
        }

        public e u(int i10, int i11, boolean z10) {
            this.f2242t = i10;
            this.f2243u = i11;
            this.f2244v = z10;
            return this;
        }

        public e v(boolean z10) {
            this.f2236n = z10;
            return this;
        }

        public e w(int i10) {
            this.S.icon = i10;
            return this;
        }

        public e x(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public e y(f fVar) {
            if (this.f2238p != fVar) {
                this.f2238p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public e z(CharSequence charSequence) {
            this.S.tickerText = d(charSequence);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected e f2249a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f2250b;

        /* renamed from: c, reason: collision with root package name */
        CharSequence f2251c;

        /* renamed from: d, reason: collision with root package name */
        boolean f2252d = false;

        public void a(Bundle bundle) {
            if (this.f2252d) {
                bundle.putCharSequence("android.summaryText", this.f2251c);
            }
            CharSequence charSequence = this.f2250b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c10 = c();
            if (c10 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c10);
            }
        }

        public abstract void b(j jVar);

        protected abstract String c();

        public RemoteViews d(j jVar) {
            return null;
        }

        public RemoteViews e(j jVar) {
            return null;
        }

        public RemoteViews f(j jVar) {
            return null;
        }

        public void g(e eVar) {
            if (this.f2249a != eVar) {
                this.f2249a = eVar;
                if (eVar != null) {
                    eVar.y(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19) {
            return notification.extras;
        }
        if (i10 >= 16) {
            return m.c(notification);
        }
        return null;
    }
}
