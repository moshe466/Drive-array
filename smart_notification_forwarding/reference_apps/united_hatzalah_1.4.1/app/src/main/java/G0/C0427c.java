package g0;

import F0.C0018c1;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* renamed from: g0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0427c {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f4656f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static C0427c f4657g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4658a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f4659b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f4660c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f4661d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HandlerC0425a f4662e;

    public C0427c(Context context) {
        this.f4658a = context;
        this.f4662e = new HandlerC0425a(this, context.getMainLooper());
    }

    public static C0427c a(Context context) {
        C0427c c0427c;
        synchronized (f4656f) {
            try {
                if (f4657g == null) {
                    f4657g = new C0427c(context.getApplicationContext());
                }
                c0427c = f4657g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0427c;
    }

    public final void b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f4659b) {
            try {
                C0426b c0426b = new C0426b(broadcastReceiver, intentFilter);
                ArrayList arrayList = (ArrayList) this.f4659b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f4659b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(c0426b);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.f4660c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f4660c.put(action, arrayList2);
                    }
                    arrayList2.add(c0426b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(Intent intent) {
        boolean z3;
        int match;
        synchronized (this.f4659b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f4658a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                if ((intent.getFlags() & 8) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    intent.toString();
                }
                ArrayList arrayList = (ArrayList) this.f4660c.get(intent.getAction());
                if (arrayList != null) {
                    if (z3) {
                        arrayList.toString();
                    }
                    ArrayList arrayList2 = null;
                    for (int i = 0; i < arrayList.size(); i++) {
                        C0426b c0426b = (C0426b) arrayList.get(i);
                        if (z3) {
                            Objects.toString(c0426b.f4652a);
                        }
                        if (!c0426b.f4654c && (match = c0426b.f4652a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager")) >= 0) {
                            if (z3) {
                                Integer.toHexString(match);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(c0426b);
                            c0426b.f4654c = true;
                        }
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            ((C0426b) arrayList2.get(i3)).f4654c = false;
                        }
                        this.f4661d.add(new C0018c1(intent, arrayList2));
                        if (!this.f4662e.hasMessages(1)) {
                            this.f4662e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f4659b) {
            try {
                ArrayList arrayList = (ArrayList) this.f4659b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    C0426b c0426b = (C0426b) arrayList.get(size);
                    c0426b.f4655d = true;
                    for (int i = 0; i < c0426b.f4652a.countActions(); i++) {
                        String action = c0426b.f4652a.getAction(i);
                        ArrayList arrayList2 = (ArrayList) this.f4660c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                C0426b c0426b2 = (C0426b) arrayList2.get(size2);
                                if (c0426b2.f4653b == broadcastReceiver) {
                                    c0426b2.f4655d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f4660c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
