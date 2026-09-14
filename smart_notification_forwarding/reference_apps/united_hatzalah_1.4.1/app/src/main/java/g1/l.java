package g1;

import F0.C0047j2;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t2.AbstractC0709k;

/* loaded from: classes.dex */
public final class l extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4700a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0047j2 f4701b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(C0047j2 c0047j2, int i) {
        super(0);
        this.f4700a = i;
        this.f4701b = c0047j2;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f4700a) {
            case 0:
                PackageManager packageManager = (PackageManager) this.f4701b.f546b;
                kotlin.jvm.internal.j.b(packageManager);
                List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(128);
                kotlin.jvm.internal.j.d(installedApplications, "getInstalledApplications(...)");
                ArrayList arrayList = new ArrayList(AbstractC0709k.Y(installedApplications, 10));
                for (ApplicationInfo applicationInfo : installedApplications) {
                    kotlin.jvm.internal.j.b(applicationInfo);
                    String str = applicationInfo.packageName;
                    kotlin.jvm.internal.j.b(str);
                    arrayList.add(new k(str));
                }
                return arrayList;
            default:
                PackageManager packageManager2 = (PackageManager) this.f4701b.f546b;
                kotlin.jvm.internal.j.b(packageManager2);
                List<ApplicationInfo> installedApplications2 = packageManager2.getInstalledApplications(128);
                kotlin.jvm.internal.j.d(installedApplications2, "getInstalledApplications(...)");
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = installedApplications2.iterator();
                while (true) {
                    int i = 0;
                    if (it.hasNext()) {
                        Object next = it.next();
                        ApplicationInfo applicationInfo2 = (ApplicationInfo) next;
                        kotlin.jvm.internal.j.b(applicationInfo2);
                        String str2 = applicationInfo2.sourceDir;
                        kotlin.jvm.internal.j.b(str2);
                        if (N2.f.N(str2, "/system/", false)) {
                            arrayList2.add(next);
                        }
                    } else {
                        ArrayList arrayList3 = new ArrayList(AbstractC0709k.Y(arrayList2, 10));
                        int size = arrayList2.size();
                        while (i < size) {
                            Object obj = arrayList2.get(i);
                            i++;
                            ApplicationInfo applicationInfo3 = (ApplicationInfo) obj;
                            kotlin.jvm.internal.j.b(applicationInfo3);
                            String str3 = applicationInfo3.packageName;
                            kotlin.jvm.internal.j.b(str3);
                            arrayList3.add(new k(str3));
                        }
                        return arrayList3;
                    }
                }
        }
    }
}
