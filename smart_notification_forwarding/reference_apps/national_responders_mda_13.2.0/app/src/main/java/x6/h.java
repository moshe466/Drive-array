package x6;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.groboot.mdaemergency.ptt.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import w6.m;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final AudioManager f15490a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15491b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Integer, Set<b>> f15492c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final a f15493d = new a(new Handler());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        private Map<Integer, Integer> f15494a;

        public a(Handler handler) {
            super(handler);
            this.f15494a = new HashMap();
        }

        private void b(Integer num, int i10) {
            int c10 = h.this.c(num.intValue());
            Iterator it = ((Set) h.this.f15492c.get(num)).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(num.intValue(), i10, c10);
            }
            this.f15494a.put(num, Integer.valueOf(i10));
        }

        public Integer c(Uri uri) {
            return null;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            for (Map.Entry entry : h.this.f15492c.entrySet()) {
                Integer valueOf = Integer.valueOf(h.this.b(((Integer) entry.getKey()).intValue()));
                Integer num = this.f15494a.get(entry.getKey());
                if (num == null || num.intValue() != valueOf.intValue()) {
                    b((Integer) entry.getKey(), valueOf.intValue());
                }
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            Integer c10 = c(uri);
            if (c10 != null) {
                Integer num = this.f15494a.get(c10);
                Integer valueOf = Integer.valueOf(h.this.b(c10.intValue()));
                if (num == null || num.intValue() != valueOf.intValue()) {
                    b(c10, valueOf.intValue());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i10, int i11, int i12);
    }

    public h(Context context) {
        this.f15491b = context;
        this.f15490a = (AudioManager) context.getSystemService("audio");
    }

    public int b(int i10) {
        return this.f15490a.getStreamVolume(i10);
    }

    public int c(int i10) {
        return this.f15490a.getStreamMaxVolume(i10);
    }

    public void d(int i10, b bVar, boolean z10) {
        boolean isEmpty = this.f15492c.isEmpty();
        if (!this.f15492c.containsKey(Integer.valueOf(i10))) {
            HashSet hashSet = new HashSet();
            hashSet.add(bVar);
            this.f15492c.put(Integer.valueOf(i10), hashSet);
        } else {
            this.f15492c.get(Integer.valueOf(i10)).add(bVar);
        }
        if (isEmpty) {
            this.f15491b.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f15493d);
        }
        if (z10) {
            bVar.a(i10, b(i10), c(i10));
        }
    }

    public void e(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("change to: ");
        sb2.append(i11);
        m.x0(i11);
        p.c0().Z0();
    }

    public void f(int i10, b bVar) {
        this.f15492c.get(Integer.valueOf(i10)).remove(bVar);
        if (this.f15492c.get(Integer.valueOf(i10)).size() == 0) {
            this.f15492c.remove(Integer.valueOf(i10));
            this.f15493d.f15494a.remove(Integer.valueOf(i10));
        }
        if (this.f15492c.isEmpty()) {
            this.f15491b.getApplicationContext().getContentResolver().unregisterContentObserver(this.f15493d);
        }
    }
}
