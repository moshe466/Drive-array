package androidx.fragment.app;

import e.C0359a;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class W implements e.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3329a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0272g0 f3330b;

    public /* synthetic */ W(AbstractC0272g0 abstractC0272g0, int i) {
        this.f3329a = i;
        this.f3330b = abstractC0272g0;
    }

    @Override // e.b
    public final void a(Object obj) {
        int i;
        switch (this.f3329a) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (((Boolean) arrayList.get(i3)).booleanValue()) {
                        i = 0;
                    } else {
                        i = -1;
                    }
                    iArr[i3] = i;
                }
                AbstractC0272g0 abstractC0272g0 = this.f3330b;
                C0264c0 c0264c0 = (C0264c0) abstractC0272g0.f3378F.pollFirst();
                if (c0264c0 != null) {
                    String str = c0264c0.f3355a;
                    int i4 = c0264c0.f3356b;
                    G c4 = abstractC0272g0.f3391c.c(str);
                    if (c4 != null) {
                        c4.onRequestPermissionsResult(i4, strArr, iArr);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                C0359a c0359a = (C0359a) obj;
                AbstractC0272g0 abstractC0272g02 = this.f3330b;
                C0264c0 c0264c02 = (C0264c0) abstractC0272g02.f3378F.pollLast();
                if (c0264c02 != null) {
                    String str2 = c0264c02.f3355a;
                    int i5 = c0264c02.f3356b;
                    G c5 = abstractC0272g02.f3391c.c(str2);
                    if (c5 != null) {
                        c5.onActivityResult(i5, c0359a.f4415a, c0359a.f4416b);
                        return;
                    }
                    return;
                }
                return;
            default:
                C0359a c0359a2 = (C0359a) obj;
                AbstractC0272g0 abstractC0272g03 = this.f3330b;
                C0264c0 c0264c03 = (C0264c0) abstractC0272g03.f3378F.pollFirst();
                if (c0264c03 != null) {
                    String str3 = c0264c03.f3355a;
                    int i6 = c0264c03.f3356b;
                    G c6 = abstractC0272g03.f3391c.c(str3);
                    if (c6 != null) {
                        c6.onActivityResult(i6, c0359a2.f4415a, c0359a2.f4416b);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
