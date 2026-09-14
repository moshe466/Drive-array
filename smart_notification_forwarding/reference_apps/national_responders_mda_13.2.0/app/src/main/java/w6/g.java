package w6;

import android.content.Context;
import android.media.AudioManager;

/* loaded from: classes.dex */
public class g {

    /* renamed from: i, reason: collision with root package name */
    static g f15144i;

    /* renamed from: a, reason: collision with root package name */
    AudioManager f15145a;

    /* renamed from: b, reason: collision with root package name */
    public int f15146b;

    /* renamed from: c, reason: collision with root package name */
    public int f15147c;

    /* renamed from: d, reason: collision with root package name */
    public int f15148d;

    /* renamed from: e, reason: collision with root package name */
    public int f15149e;

    /* renamed from: f, reason: collision with root package name */
    public c f15150f;

    /* renamed from: g, reason: collision with root package name */
    public d f15151g;

    /* renamed from: h, reason: collision with root package name */
    boolean f15152h;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f15153f;

        a(int i10) {
            this.f15153f = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.a(this.f15153f);
            g gVar = g.this;
            if (gVar.f15152h) {
                return;
            }
            try {
                gVar.f15145a.setStreamVolume(gVar.f15150f.getStreamIntValue(), g.this.f15146b, 4);
                if (g.f15144i == g.this) {
                    g.f15144i = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15155a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f15156b;

        static {
            int[] iArr = new int[c.values().length];
            f15156b = iArr;
            try {
                iArr[c.Ring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15156b[c.Call.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15156b[c.Notification.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.values().length];
            f15155a = iArr2;
            try {
                iArr2[d.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15155a[d.Silence.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15155a[d.Low.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15155a[d.Medium.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15155a[d.High.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        Ring,
        Call,
        Notification;

        public int getStreamIntValue() {
            int i10 = b.f15156b[ordinal()];
            if (i10 == 1) {
                return 2;
            }
            if (i10 == 2) {
                return 0;
            }
            if (i10 != 3) {
                return Ring.getStreamIntValue();
            }
            return 5;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        NONE,
        Silence,
        Low,
        Medium,
        High;

        public static d getByInt(int i10) {
            return i10 != -1 ? i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? NONE : High : Medium : Low : Silence : NONE;
        }

        public int getLevelValue() {
            int i10 = b.f15155a[ordinal()];
            if (i10 == 1) {
                return -1;
            }
            if (i10 == 2) {
                return 0;
            }
            if (i10 == 3) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 != 5) {
                return Silence.getLevelValue();
            }
            return 3;
        }
    }

    public g(Context context, c cVar, d dVar) {
        this.f15145a = null;
        this.f15145a = (AudioManager) context.getSystemService("audio");
        this.f15150f = cVar;
        this.f15151g = dVar;
        this.f15146b = this.f15145a.getStreamVolume(cVar.getStreamIntValue());
        int streamMaxVolume = this.f15145a.getStreamMaxVolume(cVar.getStreamIntValue());
        this.f15147c = streamMaxVolume;
        int i10 = streamMaxVolume / 3;
        this.f15148d = i10;
        this.f15149e = i10 * dVar.getLevelValue();
    }

    public void a() {
        this.f15152h = true;
    }

    public void b() {
        try {
            this.f15145a.setStreamVolume(this.f15150f.getStreamIntValue(), this.f15146b, 4);
            if (f15144i == this) {
                f15144i = null;
            }
        } catch (Exception unused) {
        }
    }

    public void c(int i10) {
        g gVar = f15144i;
        if (gVar != null) {
            gVar.a();
        }
        f15144i = this;
        if (d()) {
            this.f15152h = false;
            new Thread(new a(i10)).start();
        }
    }

    public boolean d() {
        if (this.f15151g == d.NONE || this.f15149e == this.f15146b) {
            return false;
        }
        try {
            this.f15145a.setStreamVolume(this.f15150f.getStreamIntValue(), this.f15149e, 4);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
