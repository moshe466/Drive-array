package androidx.fragment.app;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import e.C0359a;
import f.AbstractC0365a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import s2.C0679d;
import t2.AbstractC0705g;
import t2.AbstractC0707i;
import t2.AbstractC0709k;
import t2.C0716r;
import x.AbstractC0773d;

/* renamed from: androidx.fragment.app.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0262b0 extends AbstractC0365a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3352a;

    public /* synthetic */ C0262b0(int i) {
        this.f3352a = i;
    }

    @Override // f.AbstractC0365a
    public final Intent a(L l3, Object obj) {
        Bundle bundleExtra;
        switch (this.f3352a) {
            case 0:
                e.j jVar = (e.j) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = jVar.f4437b;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        jVar = new e.j(jVar.f4436a, null, jVar.f4438c, jVar.f4439d);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", jVar);
                if (AbstractC0272g0.J(2)) {
                    intent.toString();
                }
                return intent;
            case 1:
                return d(l3, (e.k) obj);
            case 2:
                String[] input = (String[]) obj;
                kotlin.jvm.internal.j.e(input, "input");
                Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
                kotlin.jvm.internal.j.d(putExtra, "putExtra(...)");
                return putExtra;
            default:
                Intent input2 = (Intent) obj;
                kotlin.jvm.internal.j.e(input2, "input");
                return input2;
        }
    }

    @Override // f.AbstractC0365a
    public I1.h b(L l3, Object obj) {
        switch (this.f3352a) {
            case 1:
                kotlin.jvm.internal.j.e((e.k) obj, "input");
                return null;
            case 2:
                String[] input = (String[]) obj;
                kotlin.jvm.internal.j.e(input, "input");
                if (input.length == 0) {
                    return new I1.h(t2.s.f6477a);
                }
                for (String str : input) {
                    if (AbstractC0773d.a(l3, str) != 0) {
                        return null;
                    }
                }
                int F3 = t2.u.F(input.length);
                if (F3 < 16) {
                    F3 = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(F3);
                for (String str2 : input) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new I1.h(linkedHashMap);
            default:
                return super.b(l3, obj);
        }
    }

    @Override // f.AbstractC0365a
    public final Object c(int i, Intent intent) {
        List arrayList;
        boolean z3;
        switch (this.f3352a) {
            case 0:
                return new C0359a(i, intent);
            case 1:
                if (i != -1) {
                    intent = null;
                }
                if (intent == null) {
                    return null;
                }
                Uri data = intent.getData();
                if (data == null) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Uri data2 = intent.getData();
                    if (data2 != null) {
                        linkedHashSet.add(data2);
                    }
                    ClipData clipData = intent.getClipData();
                    if (clipData == null && linkedHashSet.isEmpty()) {
                        arrayList = C0716r.f6476a;
                    } else {
                        if (clipData != null) {
                            int itemCount = clipData.getItemCount();
                            for (int i3 = 0; i3 < itemCount; i3++) {
                                Uri uri = clipData.getItemAt(i3).getUri();
                                if (uri != null) {
                                    linkedHashSet.add(uri);
                                }
                            }
                        }
                        arrayList = new ArrayList(linkedHashSet);
                    }
                    return (Uri) AbstractC0707i.e0(arrayList);
                }
                return data;
            case 2:
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList2 = new ArrayList(intArrayExtra.length);
                        for (int i4 : intArrayExtra) {
                            if (i4 == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            arrayList2.add(Boolean.valueOf(z3));
                        }
                        ArrayList J3 = AbstractC0705g.J(stringArrayExtra);
                        Iterator it = J3.iterator();
                        Iterator it2 = arrayList2.iterator();
                        ArrayList arrayList3 = new ArrayList(Math.min(AbstractC0709k.Y(J3, 10), AbstractC0709k.Y(arrayList2, 10)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList3.add(new C0679d(it.next(), it2.next()));
                        }
                        return t2.u.I(arrayList3);
                    }
                }
                return t2.s.f6477a;
            default:
                return new C0359a(i, intent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 >= 2) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.Intent d(android.content.Context r4, e.k r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r4, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.j.e(r5, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 1
            if (r0 < r1) goto L12
            goto L1d
        L12:
            r1 = 30
            if (r0 < r1) goto L38
            int r0 = com.google.firebase.crashlytics.internal.common.i.a()
            r1 = 2
            if (r0 < r1) goto L38
        L1d:
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r0 = "android.provider.action.PICK_IMAGES"
            r4.<init>(r0)
            f.g r0 = r5.f4440a
            java.lang.String r0 = m3.b.x(r0)
            r4.setType(r0)
            f.c r5 = r5.f4442c
            r5.getClass()
            java.lang.String r5 = "android.provider.extra.PICK_IMAGES_LAUNCH_TAB"
            r4.putExtra(r5, r2)
            return r4
        L38:
            android.content.pm.ResolveInfo r0 = m3.b.u(r4)
            if (r0 == 0) goto L72
            android.content.pm.ResolveInfo r4 = m3.b.u(r4)
            if (r4 == 0) goto L6a
            android.content.pm.ActivityInfo r4 = r4.activityInfo
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "androidx.activity.result.contract.action.PICK_IMAGES"
            r0.<init>(r1)
            android.content.pm.ApplicationInfo r1 = r4.applicationInfo
            java.lang.String r1 = r1.packageName
            java.lang.String r4 = r4.name
            r0.setClassName(r1, r4)
            f.g r4 = r5.f4440a
            java.lang.String r4 = m3.b.x(r4)
            r0.setType(r4)
            f.c r4 = r5.f4442c
            r4.getClass()
            java.lang.String r4 = "androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB"
            r0.putExtra(r4, r2)
            return r0
        L6a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Required value was null."
            r4.<init>(r5)
            throw r4
        L72:
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.OPEN_DOCUMENT"
            r4.<init>(r0)
            f.g r5 = r5.f4440a
            java.lang.String r5 = m3.b.x(r5)
            r4.setType(r5)
            java.lang.String r5 = r4.getType()
            if (r5 != 0) goto L9a
        */
        //  java.lang.String r5 = "*/*"
        /*
            r4.setType(r5)
            java.lang.String r5 = "image/*"
            java.lang.String r0 = "video/*"
            java.lang.String[] r5 = new java.lang.String[]{r5, r0}
            java.lang.String r0 = "android.intent.extra.MIME_TYPES"
            r4.putExtra(r0, r5)
        L9a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0262b0.d(android.content.Context, e.k):android.content.Intent");
    }
}
