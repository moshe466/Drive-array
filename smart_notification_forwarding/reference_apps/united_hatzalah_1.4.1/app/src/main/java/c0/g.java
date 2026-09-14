package C0;

import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t2.C0716r;
import w0.C0745a;
import w0.C0746b;
import w0.C0751g;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f89b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f90a;

    public g() {
        e0.a.j(3, "verificationMode");
        this.f90a = 3;
    }

    public static boolean a(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (kotlin.jvm.internal.j.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return kotlin.jvm.internal.j.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public static boolean b(List list, List list2) {
        if (list != list2) {
            if (list.size() == list2.size()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (a((SidecarDisplayFeature) list.get(i), (SidecarDisplayFeature) list2.get(i))) {
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final ArrayList c(List list, SidecarDeviceState sidecarDeviceState) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            z0.c e4 = e((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (e4 != null) {
                arrayList.add(e4);
            }
        }
        return arrayList;
    }

    public final z0.j d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        if (sidecarWindowLayoutInfo == null) {
            return new z0.j(C0716r.f6476a);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        b.d(sidecarDeviceState2, b.b(sidecarDeviceState));
        return new z0.j(c(b.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final z0.c e(SidecarDisplayFeature feature, SidecarDeviceState sidecarDeviceState) {
        z0.b bVar;
        z0.b bVar2 = z0.b.f6812f;
        kotlin.jvm.internal.j.e(feature, "feature");
        int i = this.f90a;
        e0.a.j(i, "verificationMode");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) new C0751g(feature, i, C0745a.f6681a).A("Type must be either TYPE_FOLD or TYPE_HINGE", c.f85a).A("Feature bounds must not be 0", d.f86a).A("TYPE_FOLD must have 0 area", e.f87a).A("Feature be pinned to either left or top", f.f88a).i();
        if (sidecarDisplayFeature != null) {
            int type = sidecarDisplayFeature.getType();
            if (type != 1) {
                if (type == 2) {
                    bVar = z0.b.i;
                } else {
                    return null;
                }
            } else {
                bVar = z0.b.f6814h;
            }
            int b4 = b.b(sidecarDeviceState);
            if (b4 != 0 && b4 != 1) {
                if (b4 != 2) {
                    if (b4 != 3 && b4 == 4) {
                        return null;
                    }
                } else {
                    bVar2 = z0.b.f6813g;
                }
                Rect rect = feature.getRect();
                kotlin.jvm.internal.j.d(rect, "feature.rect");
                return new z0.c(new C0746b(rect), bVar, bVar2);
            }
            return null;
        }
        return null;
    }
}
