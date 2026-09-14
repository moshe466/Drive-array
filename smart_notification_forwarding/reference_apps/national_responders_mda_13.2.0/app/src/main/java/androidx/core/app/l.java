package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.k;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2253a;

    /* renamed from: b, reason: collision with root package name */
    private final Notification.Builder f2254b;

    /* renamed from: c, reason: collision with root package name */
    private final k.e f2255c;

    /* renamed from: d, reason: collision with root package name */
    private RemoteViews f2256d;

    /* renamed from: e, reason: collision with root package name */
    private RemoteViews f2257e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Bundle> f2258f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f2259g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    private int f2260h;

    /* renamed from: i, reason: collision with root package name */
    private RemoteViews f2261i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k.e eVar) {
        int i10;
        Icon icon;
        List<String> e10;
        Bundle bundle;
        String str;
        this.f2255c = eVar;
        this.f2253a = eVar.f2223a;
        int i11 = Build.VERSION.SDK_INT;
        Context context = eVar.f2223a;
        this.f2254b = i11 >= 26 ? new Notification.Builder(context, eVar.K) : new Notification.Builder(context);
        Notification notification = eVar.S;
        this.f2254b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f2231i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f2227e).setContentText(eVar.f2228f).setContentInfo(eVar.f2233k).setContentIntent(eVar.f2229g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f2230h, (notification.flags & 128) != 0).setLargeIcon(eVar.f2232j).setNumber(eVar.f2234l).setProgress(eVar.f2242t, eVar.f2243u, eVar.f2244v);
        if (i11 < 21) {
            this.f2254b.setSound(notification.sound, notification.audioStreamType);
        }
        if (i11 >= 16) {
            this.f2254b.setSubText(eVar.f2239q).setUsesChronometer(eVar.f2237o).setPriority(eVar.f2235m);
            Iterator<k.a> it = eVar.f2224b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle2 = eVar.D;
            if (bundle2 != null) {
                this.f2259g.putAll(bundle2);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.f2248z) {
                    this.f2259g.putBoolean("android.support.localOnly", true);
                }
                String str2 = eVar.f2245w;
                if (str2 != null) {
                    this.f2259g.putString("android.support.groupKey", str2);
                    if (eVar.f2246x) {
                        bundle = this.f2259g;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f2259g;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                String str3 = eVar.f2247y;
                if (str3 != null) {
                    this.f2259g.putString("android.support.sortKey", str3);
                }
            }
            this.f2256d = eVar.H;
            this.f2257e = eVar.I;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 17) {
            this.f2254b.setShowWhen(eVar.f2236n);
        }
        if (i12 >= 19 && i12 < 21 && (e10 = e(g(eVar.f2225c), eVar.V)) != null && !e10.isEmpty()) {
            this.f2259g.putStringArray("android.people", (String[]) e10.toArray(new String[e10.size()]));
        }
        if (i12 >= 20) {
            this.f2254b.setLocalOnly(eVar.f2248z).setGroup(eVar.f2245w).setGroupSummary(eVar.f2246x).setSortKey(eVar.f2247y);
            this.f2260h = eVar.O;
        }
        if (i12 >= 21) {
            this.f2254b.setCategory(eVar.C).setColor(eVar.E).setVisibility(eVar.F).setPublicVersion(eVar.G).setSound(notification.sound, notification.audioAttributes);
            List e11 = i12 < 28 ? e(g(eVar.f2225c), eVar.V) : eVar.V;
            if (e11 != null && !e11.isEmpty()) {
                Iterator it2 = e11.iterator();
                while (it2.hasNext()) {
                    this.f2254b.addPerson((String) it2.next());
                }
            }
            this.f2261i = eVar.J;
            if (eVar.f2226d.size() > 0) {
                Bundle bundle3 = eVar.c().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle(bundle3);
                Bundle bundle5 = new Bundle();
                for (int i13 = 0; i13 < eVar.f2226d.size(); i13++) {
                    bundle5.putBundle(Integer.toString(i13), m.b(eVar.f2226d.get(i13)));
                }
                bundle3.putBundle("invisible_actions", bundle5);
                bundle4.putBundle("invisible_actions", bundle5);
                eVar.c().putBundle("android.car.EXTENSIONS", bundle3);
                this.f2259g.putBundle("android.car.EXTENSIONS", bundle4);
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 23 && (icon = eVar.U) != null) {
            this.f2254b.setSmallIcon(icon);
        }
        if (i14 >= 24) {
            this.f2254b.setExtras(eVar.D).setRemoteInputHistory(eVar.f2241s);
            RemoteViews remoteViews = eVar.H;
            if (remoteViews != null) {
                this.f2254b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.I;
            if (remoteViews2 != null) {
                this.f2254b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.J;
            if (remoteViews3 != null) {
                this.f2254b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i14 >= 26) {
            this.f2254b.setBadgeIconType(eVar.L).setSettingsText(eVar.f2240r).setShortcutId(eVar.M).setTimeoutAfter(eVar.N).setGroupAlertBehavior(eVar.O);
            if (eVar.B) {
                this.f2254b.setColorized(eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.f2254b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i14 >= 28) {
            Iterator<q> it3 = eVar.f2225c.iterator();
            while (it3.hasNext()) {
                this.f2254b.addPerson(it3.next().h());
            }
        }
        int i15 = Build.VERSION.SDK_INT;
        if (i15 >= 29) {
            this.f2254b.setAllowSystemGeneratedContextualActions(eVar.Q);
            this.f2254b.setBubbleMetadata(k.d.a(eVar.R));
        }
        if (i15 >= 31 && (i10 = eVar.P) != 0) {
            this.f2254b.setForegroundServiceBehavior(i10);
        }
        if (eVar.T) {
            if (this.f2255c.f2246x) {
                this.f2260h = 2;
            } else {
                this.f2260h = 1;
            }
            this.f2254b.setVibrate(null);
            this.f2254b.setSound(null);
            int i16 = notification.defaults & (-2);
            notification.defaults = i16;
            int i17 = i16 & (-3);
            notification.defaults = i17;
            this.f2254b.setDefaults(i17);
            if (i15 >= 26) {
                if (TextUtils.isEmpty(this.f2255c.f2245w)) {
                    this.f2254b.setGroup("silent");
                }
                this.f2254b.setGroupAlertBehavior(this.f2260h);
            }
        }
    }

    private void b(k.a aVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 20) {
            if (i10 >= 16) {
                this.f2258f.add(m.f(this.f2254b, aVar));
                return;
            }
            return;
        }
        IconCompat e10 = aVar.e();
        Notification.Action.Builder builder = i10 >= 23 ? new Notification.Action.Builder(e10 != null ? e10.q() : null, aVar.i(), aVar.a()) : new Notification.Action.Builder(e10 != null ? e10.j() : 0, aVar.i(), aVar.a());
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : s.b(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (i11 >= 28) {
            builder.setSemanticAction(aVar.g());
        }
        if (i11 >= 29) {
            builder.setContextual(aVar.k());
        }
        if (i11 >= 31) {
            builder.setAuthenticationRequired(aVar.j());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        builder.addExtras(bundle);
        this.f2254b.addAction(builder.build());
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        l.b bVar = new l.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> g(List<q> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<q> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i10 = notification.defaults & (-2);
        notification.defaults = i10;
        notification.defaults = i10 & (-3);
    }

    @Override // androidx.core.app.j
    public Notification.Builder a() {
        return this.f2254b;
    }

    public Notification c() {
        Bundle a10;
        RemoteViews f10;
        RemoteViews d10;
        k.f fVar = this.f2255c.f2238p;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews e10 = fVar != null ? fVar.e(this) : null;
        Notification d11 = d();
        if (e10 != null || (e10 = this.f2255c.H) != null) {
            d11.contentView = e10;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 16 && fVar != null && (d10 = fVar.d(this)) != null) {
            d11.bigContentView = d10;
        }
        if (i10 >= 21 && fVar != null && (f10 = this.f2255c.f2238p.f(this)) != null) {
            d11.headsUpContentView = f10;
        }
        if (i10 >= 16 && fVar != null && (a10 = k.a(d11)) != null) {
            fVar.a(a10);
        }
        return d11;
    }

    protected Notification d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return this.f2254b.build();
        }
        if (i10 >= 24) {
            Notification build = this.f2254b.build();
            if (this.f2260h != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f2260h == 2) {
                    h(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f2260h == 1) {
                    h(build);
                }
            }
            return build;
        }
        if (i10 >= 21) {
            this.f2254b.setExtras(this.f2259g);
            Notification build2 = this.f2254b.build();
            RemoteViews remoteViews = this.f2256d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f2257e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f2261i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f2260h != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f2260h == 2) {
                    h(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f2260h == 1) {
                    h(build2);
                }
            }
            return build2;
        }
        if (i10 >= 20) {
            this.f2254b.setExtras(this.f2259g);
            Notification build3 = this.f2254b.build();
            RemoteViews remoteViews4 = this.f2256d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f2257e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f2260h != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.f2260h == 2) {
                    h(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f2260h == 1) {
                    h(build3);
                }
            }
            return build3;
        }
        if (i10 >= 19) {
            SparseArray<Bundle> a10 = m.a(this.f2258f);
            if (a10 != null) {
                this.f2259g.putSparseParcelableArray("android.support.actionExtras", a10);
            }
            this.f2254b.setExtras(this.f2259g);
            Notification build4 = this.f2254b.build();
            RemoteViews remoteViews6 = this.f2256d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f2257e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        }
        if (i10 < 16) {
            return this.f2254b.getNotification();
        }
        Notification build5 = this.f2254b.build();
        Bundle a11 = k.a(build5);
        Bundle bundle = new Bundle(this.f2259g);
        for (String str : this.f2259g.keySet()) {
            if (a11.containsKey(str)) {
                bundle.remove(str);
            }
        }
        a11.putAll(bundle);
        SparseArray<Bundle> a12 = m.a(this.f2258f);
        if (a12 != null) {
            k.a(build5).putSparseParcelableArray("android.support.actionExtras", a12);
        }
        RemoteViews remoteViews8 = this.f2256d;
        if (remoteViews8 != null) {
            build5.contentView = remoteViews8;
        }
        RemoteViews remoteViews9 = this.f2257e;
        if (remoteViews9 != null) {
            build5.bigContentView = remoteViews9;
        }
        return build5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f2253a;
    }
}
