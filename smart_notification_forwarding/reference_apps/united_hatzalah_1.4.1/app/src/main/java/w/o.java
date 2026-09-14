package w;

import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import t.C0690f;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6669a;

    /* renamed from: b, reason: collision with root package name */
    public final Notification.Builder f6670b;

    /* renamed from: c, reason: collision with root package name */
    public final n f6671c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f6672d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6673e;

    /* JADX WARN: Multi-variable type inference failed */
    public o(n nVar) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Icon f4;
        int i;
        Bundle bundle;
        int i3;
        ArrayList arrayList;
        Icon icon;
        Bundle bundle2;
        int i4;
        new ArrayList();
        this.f6672d = new Bundle();
        this.f6671c = nVar;
        Context context = nVar.f6647a;
        ArrayList arrayList2 = nVar.f6668x;
        ArrayList arrayList3 = nVar.f6649c;
        ArrayList arrayList4 = nVar.f6650d;
        this.f6669a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6670b = B.a.a(context, nVar.f6664t);
        } else {
            this.f6670b = new Notification.Builder(nVar.f6647a);
        }
        Notification notification = nVar.f6666v;
        Context context2 = null;
        Notification.Builder lights = this.f6670b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z3);
        if ((notification.flags & 8) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z4);
        if ((notification.flags & 16) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(nVar.f6651e).setContentText(nVar.f6652f).setContentInfo(null).setContentIntent(nVar.f6653g).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        deleteIntent.setFullScreenIntent(null, z6).setNumber(nVar.i).setProgress(0, 0, false);
        Notification.Builder builder = this.f6670b;
        IconCompat iconCompat = nVar.f6654h;
        if (iconCompat == null) {
            f4 = null;
        } else {
            f4 = iconCompat.f(context);
        }
        builder.setLargeIcon(f4);
        this.f6670b.setSubText(null).setUsesChronometer(false).setPriority(nVar.f6655j);
        ArrayList arrayList5 = nVar.f6648b;
        int size = arrayList5.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList5.get(i5);
            i5++;
            h hVar = (h) obj;
            int i6 = Build.VERSION.SDK_INT;
            if (hVar.f6637b == null && (i4 = hVar.f6640e) != 0) {
                hVar.f6637b = IconCompat.b(i4);
            }
            IconCompat iconCompat2 = hVar.f6637b;
            boolean z7 = hVar.f6638c;
            Bundle bundle3 = hVar.f6636a;
            if (iconCompat2 != null) {
                icon = iconCompat2.f(context2);
            } else {
                icon = context2;
            }
            ArrayList arrayList6 = arrayList5;
            ArrayList arrayList7 = arrayList3;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(icon, hVar.f6641f, hVar.f6642g);
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android.support.allowGeneratedReplies", z7);
            builder2.setAllowGeneratedReplies(z7);
            bundle2.putInt("android.support.action.semanticAction", 0);
            if (i6 >= 28) {
                B.b.o(builder2);
            }
            if (i6 >= 29) {
                A.b.e(builder2);
            }
            if (i6 >= 31) {
                E.a.b(builder2);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", hVar.f6639d);
            builder2.addExtras(bundle2);
            this.f6670b.addAction(builder2.build());
            arrayList5 = arrayList6;
            arrayList3 = arrayList7;
            context2 = null;
        }
        ArrayList arrayList8 = arrayList3;
        Bundle bundle4 = nVar.f6661q;
        if (bundle4 != null) {
            this.f6672d.putAll(bundle4);
        }
        int i7 = Build.VERSION.SDK_INT;
        this.f6670b.setShowWhen(nVar.f6656k);
        this.f6670b.setLocalOnly(nVar.f6660o);
        this.f6670b.setGroup(nVar.f6658m);
        this.f6670b.setSortKey(null);
        this.f6670b.setGroupSummary(nVar.f6659n);
        this.f6673e = 0;
        this.f6670b.setCategory(nVar.p);
        this.f6670b.setColor(nVar.f6662r);
        this.f6670b.setVisibility(nVar.f6663s);
        this.f6670b.setPublicVersion(null);
        this.f6670b.setSound(notification.sound, notification.audioAttributes);
        if (i7 < 28) {
            if (arrayList8 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList8.size());
                Iterator it = arrayList8.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
            }
            if (arrayList != null) {
                if (arrayList2 == null) {
                    arrayList2 = arrayList;
                } else {
                    C0690f c0690f = new C0690f(arrayList2.size() + arrayList.size());
                    c0690f.addAll(arrayList);
                    c0690f.addAll(arrayList2);
                    arrayList2 = new ArrayList(c0690f);
                }
            }
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int size2 = arrayList2.size();
            int i8 = 0;
            while (i8 < size2) {
                Object obj2 = arrayList2.get(i8);
                i8++;
                this.f6670b.addPerson((String) obj2);
            }
        }
        if (arrayList4.size() > 0) {
            if (nVar.f6661q == null) {
                nVar.f6661q = new Bundle();
            }
            Bundle bundle5 = nVar.f6661q.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            for (int i9 = 0; i9 < arrayList4.size(); i9++) {
                String num = Integer.toString(i9);
                h hVar2 = (h) arrayList4.get(i9);
                Bundle bundle8 = new Bundle();
                if (hVar2.f6637b == null && (i3 = hVar2.f6640e) != 0) {
                    hVar2.f6637b = IconCompat.b(i3);
                }
                IconCompat iconCompat3 = hVar2.f6637b;
                Bundle bundle9 = hVar2.f6636a;
                if (iconCompat3 != null) {
                    i = iconCompat3.c();
                } else {
                    i = 0;
                }
                bundle8.putInt("icon", i);
                bundle8.putCharSequence("title", hVar2.f6641f);
                bundle8.putParcelable("actionIntent", hVar2.f6642g);
                if (bundle9 != null) {
                    bundle = new Bundle(bundle9);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", hVar2.f6638c);
                bundle8.putBundle("extras", bundle);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", hVar2.f6639d);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(num, bundle8);
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (nVar.f6661q == null) {
                nVar.f6661q = new Bundle();
            }
            nVar.f6661q.putBundle("android.car.EXTENSIONS", bundle5);
            this.f6672d.putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i10 = Build.VERSION.SDK_INT;
        this.f6670b.setExtras(nVar.f6661q);
        this.f6670b.setRemoteInputHistory(null);
        if (i10 >= 26) {
            B.a.m(this.f6670b);
            B.a.s(this.f6670b);
            B.a.t(this.f6670b);
            B.a.u(this.f6670b);
            B.a.o(this.f6670b, 0);
            if (!TextUtils.isEmpty(nVar.f6664t)) {
                this.f6670b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i10 >= 28) {
            Iterator it2 = arrayList8.iterator();
            if (it2.hasNext()) {
                it2.next().getClass();
                throw new ClassCastException();
            }
        }
        if (i10 >= 29) {
            A.b.c(this.f6670b, nVar.f6665u);
            A.b.d(this.f6670b);
        }
        if (i10 >= 36) {
            K.e.g(this.f6670b);
        }
        if (nVar.f6667w) {
            if (this.f6671c.f6659n) {
                this.f6673e = 2;
            } else {
                this.f6673e = 1;
            }
            this.f6670b.setVibrate(null);
            this.f6670b.setSound(null);
            int i11 = notification.defaults & (-4);
            notification.defaults = i11;
            this.f6670b.setDefaults(i11);
            if (i10 >= 26) {
                if (TextUtils.isEmpty(this.f6671c.f6658m)) {
                    this.f6670b.setGroup("silent");
                }
                B.a.o(this.f6670b, this.f6673e);
            }
        }
    }
}
