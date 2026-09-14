package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private Random f502a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f503b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map<String, Integer> f504c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, c> f505d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<String> f506e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    final transient Map<String, b<?>> f507f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    final Map<String, Object> f508g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    final Bundle f509h = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [I] */
    /* loaded from: classes.dex */
    public class a<I> extends androidx.activity.result.c<I> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.a f511b;

        a(String str, d.a aVar) {
            this.f510a = str;
            this.f511b = aVar;
        }

        @Override // androidx.activity.result.c
        public void b(I i10, androidx.core.app.c cVar) {
            Integer num = d.this.f504c.get(this.f510a);
            if (num != null) {
                d.this.f506e.add(this.f510a);
                try {
                    d.this.f(num.intValue(), this.f511b, i10, cVar);
                    return;
                } catch (Exception e10) {
                    d.this.f506e.remove(this.f510a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f511b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void c() {
            d.this.k(this.f510a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b<O> {

        /* renamed from: a, reason: collision with root package name */
        final androidx.activity.result.b<O> f513a;

        /* renamed from: b, reason: collision with root package name */
        final d.a<?, O> f514b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(androidx.activity.result.b<O> bVar, d.a<?, O> aVar) {
            this.f513a = bVar;
            this.f514b = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final h f515a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<j> f516b;

        void a() {
            Iterator<j> it = this.f516b.iterator();
            while (it.hasNext()) {
                this.f515a.c(it.next());
            }
            this.f516b.clear();
        }
    }

    private void a(int i10, String str) {
        this.f503b.put(Integer.valueOf(i10), str);
        this.f504c.put(str, Integer.valueOf(i10));
    }

    private <O> void d(String str, int i10, Intent intent, b<O> bVar) {
        if (bVar == null || bVar.f513a == null || !this.f506e.contains(str)) {
            this.f508g.remove(str);
            this.f509h.putParcelable(str, new androidx.activity.result.a(i10, intent));
        } else {
            bVar.f513a.a(bVar.f514b.c(i10, intent));
            this.f506e.remove(str);
        }
    }

    private int e() {
        int nextInt = this.f502a.nextInt(2147418112);
        while (true) {
            int i10 = nextInt + 65536;
            if (!this.f503b.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            nextInt = this.f502a.nextInt(2147418112);
        }
    }

    private void j(String str) {
        if (this.f504c.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = this.f503b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, this.f507f.get(str));
        return true;
    }

    public final <O> boolean c(int i10, @SuppressLint({"UnknownNullness"}) O o10) {
        androidx.activity.result.b<?> bVar;
        String str = this.f503b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        b<?> bVar2 = this.f507f.get(str);
        if (bVar2 == null || (bVar = bVar2.f513a) == null) {
            this.f509h.remove(str);
            this.f508g.put(str, o10);
            return true;
        }
        if (!this.f506e.remove(str)) {
            return true;
        }
        bVar.a(o10);
        return true;
    }

    public abstract <I, O> void f(int i10, d.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i11, androidx.core.app.c cVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f506e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f502a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f509h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            if (this.f504c.containsKey(str)) {
                Integer remove = this.f504c.remove(str);
                if (!this.f509h.containsKey(str)) {
                    this.f503b.remove(remove);
                }
            }
            a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f504c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f504c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f506e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f509h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f502a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.c<I> i(String str, d.a<I, O> aVar, androidx.activity.result.b<O> bVar) {
        j(str);
        this.f507f.put(str, new b<>(bVar, aVar));
        if (this.f508g.containsKey(str)) {
            Object obj = this.f508g.get(str);
            this.f508g.remove(str);
            bVar.a(obj);
        }
        androidx.activity.result.a aVar2 = (androidx.activity.result.a) this.f509h.getParcelable(str);
        if (aVar2 != null) {
            this.f509h.remove(str);
            bVar.a(aVar.c(aVar2.b(), aVar2.a()));
        }
        return new a(str, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(String str) {
        Integer remove;
        if (!this.f506e.contains(str) && (remove = this.f504c.remove(str)) != null) {
            this.f503b.remove(remove);
        }
        this.f507f.remove(str);
        if (this.f508g.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(this.f508g.get(str));
            this.f508g.remove(str);
        }
        if (this.f509h.containsKey(str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Dropping pending result for request ");
            sb3.append(str);
            sb3.append(": ");
            sb3.append(this.f509h.getParcelable(str));
            this.f509h.remove(str);
        }
        c cVar = this.f505d.get(str);
        if (cVar != null) {
            cVar.a();
            this.f505d.remove(str);
        }
    }
}
