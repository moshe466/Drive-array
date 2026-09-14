package androidx.emoji2.text;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class e {

    /* renamed from: n, reason: collision with root package name */
    private static final Object f2745n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private static volatile e f2746o;

    /* renamed from: b, reason: collision with root package name */
    private final Set<AbstractC0047e> f2748b;

    /* renamed from: e, reason: collision with root package name */
    private final b f2751e;

    /* renamed from: f, reason: collision with root package name */
    final g f2752f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f2753g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f2754h;

    /* renamed from: i, reason: collision with root package name */
    final int[] f2755i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f2756j;

    /* renamed from: k, reason: collision with root package name */
    private final int f2757k;

    /* renamed from: l, reason: collision with root package name */
    private final int f2758l;

    /* renamed from: m, reason: collision with root package name */
    private final d f2759m;

    /* renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f2747a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private volatile int f2749c = 3;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f2750d = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    private static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.h f2760b;

        /* renamed from: c, reason: collision with root package name */
        private volatile m f2761c;

        /* renamed from: androidx.emoji2.text.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0046a extends h {
            C0046a() {
            }

            @Override // androidx.emoji2.text.e.h
            public void a(Throwable th) {
                a.this.f2763a.m(th);
            }

            @Override // androidx.emoji2.text.e.h
            public void b(m mVar) {
                a.this.d(mVar);
            }
        }

        a(e eVar) {
            super(eVar);
        }

        @Override // androidx.emoji2.text.e.b
        void a() {
            try {
                this.f2763a.f2752f.a(new C0046a());
            } catch (Throwable th) {
                this.f2763a.m(th);
            }
        }

        @Override // androidx.emoji2.text.e.b
        CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f2760b.h(charSequence, i10, i11, i12, z10);
        }

        @Override // androidx.emoji2.text.e.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f2761c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f2763a.f2753g);
        }

        void d(m mVar) {
            if (mVar == null) {
                this.f2763a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f2761c = mVar;
            m mVar2 = this.f2761c;
            i iVar = new i();
            d dVar = this.f2763a.f2759m;
            e eVar = this.f2763a;
            this.f2760b = new androidx.emoji2.text.h(mVar2, iVar, dVar, eVar.f2754h, eVar.f2755i);
            this.f2763a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final e f2763a;

        b(e eVar) {
            this.f2763a = eVar;
        }

        void a() {
            this.f2763a.n();
        }

        CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return charSequence;
        }

        void c(EditorInfo editorInfo) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final g f2764a;

        /* renamed from: b, reason: collision with root package name */
        boolean f2765b;

        /* renamed from: c, reason: collision with root package name */
        boolean f2766c;

        /* renamed from: d, reason: collision with root package name */
        int[] f2767d;

        /* renamed from: e, reason: collision with root package name */
        Set<AbstractC0047e> f2768e;

        /* renamed from: f, reason: collision with root package name */
        boolean f2769f;

        /* renamed from: g, reason: collision with root package name */
        int f2770g = -16711936;

        /* renamed from: h, reason: collision with root package name */
        int f2771h = 0;

        /* renamed from: i, reason: collision with root package name */
        d f2772i = new androidx.emoji2.text.d();

        /* JADX INFO: Access modifiers changed from: protected */
        public c(g gVar) {
            androidx.core.util.h.g(gVar, "metadataLoader cannot be null.");
            this.f2764a = gVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final g a() {
            return this.f2764a;
        }

        public c b(int i10) {
            this.f2771h = i10;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean a(CharSequence charSequence, int i10, int i11, int i12);
    }

    /* renamed from: androidx.emoji2.text.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0047e {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final List<AbstractC0047e> f2773f;

        /* renamed from: g, reason: collision with root package name */
        private final Throwable f2774g;

        /* renamed from: h, reason: collision with root package name */
        private final int f2775h;

        f(AbstractC0047e abstractC0047e, int i10) {
            this(Arrays.asList((AbstractC0047e) androidx.core.util.h.g(abstractC0047e, "initCallback cannot be null")), i10, null);
        }

        f(Collection<AbstractC0047e> collection, int i10) {
            this(collection, i10, null);
        }

        f(Collection<AbstractC0047e> collection, int i10, Throwable th) {
            androidx.core.util.h.g(collection, "initCallbacks cannot be null");
            this.f2773f = new ArrayList(collection);
            this.f2775h = i10;
            this.f2774g = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f2773f.size();
            int i10 = 0;
            if (this.f2775h != 1) {
                while (i10 < size) {
                    this.f2773f.get(i10).a(this.f2774g);
                    i10++;
                }
            } else {
                while (i10 < size) {
                    this.f2773f.get(i10).b();
                    i10++;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(h hVar);
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(m mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public androidx.emoji2.text.i a(androidx.emoji2.text.g gVar) {
            return new o(gVar);
        }
    }

    private e(c cVar) {
        this.f2753g = cVar.f2765b;
        this.f2754h = cVar.f2766c;
        this.f2755i = cVar.f2767d;
        this.f2756j = cVar.f2769f;
        this.f2757k = cVar.f2770g;
        this.f2752f = cVar.f2764a;
        this.f2758l = cVar.f2771h;
        this.f2759m = cVar.f2772i;
        l.b bVar = new l.b();
        this.f2748b = bVar;
        Set<AbstractC0047e> set = cVar.f2768e;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f2768e);
        }
        this.f2751e = Build.VERSION.SDK_INT < 19 ? new b(this) : new a(this);
        l();
    }

    public static e b() {
        e eVar;
        synchronized (f2745n) {
            eVar = f2746o;
            androidx.core.util.h.h(eVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return eVar;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        if (Build.VERSION.SDK_INT >= 19) {
            return androidx.emoji2.text.h.c(inputConnection, editable, i10, i11, z10);
        }
        return false;
    }

    public static boolean f(Editable editable, int i10, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return androidx.emoji2.text.h.d(editable, i10, keyEvent);
        }
        return false;
    }

    public static e g(c cVar) {
        e eVar = f2746o;
        if (eVar == null) {
            synchronized (f2745n) {
                eVar = f2746o;
                if (eVar == null) {
                    eVar = new e(cVar);
                    f2746o = eVar;
                }
            }
        }
        return eVar;
    }

    public static boolean h() {
        return f2746o != null;
    }

    private boolean j() {
        return d() == 1;
    }

    private void l() {
        this.f2747a.writeLock().lock();
        try {
            if (this.f2758l == 0) {
                this.f2749c = 0;
            }
            this.f2747a.writeLock().unlock();
            if (d() == 0) {
                this.f2751e.a();
            }
        } catch (Throwable th) {
            this.f2747a.writeLock().unlock();
            throw th;
        }
    }

    public int c() {
        return this.f2757k;
    }

    public int d() {
        this.f2747a.readLock().lock();
        try {
            return this.f2749c;
        } finally {
            this.f2747a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f2756j;
    }

    public void k() {
        androidx.core.util.h.h(this.f2758l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j()) {
            return;
        }
        this.f2747a.writeLock().lock();
        try {
            if (this.f2749c == 0) {
                return;
            }
            this.f2749c = 0;
            this.f2747a.writeLock().unlock();
            this.f2751e.a();
        } finally {
            this.f2747a.writeLock().unlock();
        }
    }

    void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f2747a.writeLock().lock();
        try {
            this.f2749c = 2;
            arrayList.addAll(this.f2748b);
            this.f2748b.clear();
            this.f2747a.writeLock().unlock();
            this.f2750d.post(new f(arrayList, this.f2749c, th));
        } catch (Throwable th2) {
            this.f2747a.writeLock().unlock();
            throw th2;
        }
    }

    void n() {
        ArrayList arrayList = new ArrayList();
        this.f2747a.writeLock().lock();
        try {
            this.f2749c = 1;
            arrayList.addAll(this.f2748b);
            this.f2748b.clear();
            this.f2747a.writeLock().unlock();
            this.f2750d.post(new f(arrayList, this.f2749c));
        } catch (Throwable th) {
            this.f2747a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i10, int i11) {
        return q(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    public CharSequence q(CharSequence charSequence, int i10, int i11, int i12) {
        return r(charSequence, i10, i11, i12, 0);
    }

    public CharSequence r(CharSequence charSequence, int i10, int i11, int i12, int i13) {
        androidx.core.util.h.h(j(), "Not initialized yet");
        androidx.core.util.h.d(i10, "start cannot be negative");
        androidx.core.util.h.d(i11, "end cannot be negative");
        androidx.core.util.h.d(i12, "maxEmojiCount cannot be negative");
        androidx.core.util.h.a(i10 <= i11, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        androidx.core.util.h.a(i10 <= charSequence.length(), "start should be < than charSequence length");
        androidx.core.util.h.a(i11 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i10 == i11) {
            return charSequence;
        }
        return this.f2751e.b(charSequence, i10, i11, i12, i13 != 1 ? i13 != 2 ? this.f2753g : false : true);
    }

    public void s(AbstractC0047e abstractC0047e) {
        androidx.core.util.h.g(abstractC0047e, "initCallback cannot be null");
        this.f2747a.writeLock().lock();
        try {
            if (this.f2749c != 1 && this.f2749c != 2) {
                this.f2748b.add(abstractC0047e);
            }
            this.f2750d.post(new f(abstractC0047e, this.f2749c));
        } finally {
            this.f2747a.writeLock().unlock();
        }
    }

    public void t(AbstractC0047e abstractC0047e) {
        androidx.core.util.h.g(abstractC0047e, "initCallback cannot be null");
        this.f2747a.writeLock().lock();
        try {
            this.f2748b.remove(abstractC0047e);
        } finally {
            this.f2747a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (!j() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f2751e.c(editorInfo);
    }
}
