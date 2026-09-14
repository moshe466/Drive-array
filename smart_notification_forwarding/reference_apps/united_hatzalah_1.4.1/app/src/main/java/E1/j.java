package E1;

import F0.C0035g2;
import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: d, reason: collision with root package name */
    public final String f143d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ k f144e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, TaskCompletionSource taskCompletionSource, String str) {
        super(kVar, new C0035g2("OnRequestInstallCallback"), taskCompletionSource);
        this.f144e = kVar;
        this.f143d = str;
    }

    @Override // E1.h, F1.i
    public final void f(Bundle bundle) {
        Integer valueOf;
        super.f(bundle);
        int i = bundle.getInt("error.code", -2);
        TaskCompletionSource taskCompletionSource = this.f141b;
        if (i != 0) {
            taskCompletionSource.trySetException(new InstallException(bundle.getInt("error.code", -2)));
            return;
        }
        int i3 = bundle.getInt("version.code", -1);
        int i4 = bundle.getInt("update.availability");
        int i5 = bundle.getInt("install.status", 0);
        if (bundle.getInt("client.version.staleness", -1) == -1) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(bundle.getInt("client.version.staleness"));
        }
        Integer num = valueOf;
        int i6 = bundle.getInt("in.app.update.priority", 0);
        bundle.getLong("bytes.downloaded");
        bundle.getLong("total.bytes.to.download");
        long j2 = bundle.getLong("additional.size.required");
        l lVar = this.f144e.f150d;
        lVar.getClass();
        long a2 = l.a(new File(lVar.f151a.getFilesDir(), "assetpacks"));
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("blocking.intent");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("nonblocking.intent");
        PendingIntent pendingIntent3 = (PendingIntent) bundle.getParcelable("blocking.destructive.intent");
        PendingIntent pendingIntent4 = (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent");
        HashMap hashMap = new HashMap();
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("update.precondition.failures:blocking.destructive.intent");
        HashSet hashSet = new HashSet();
        if (integerArrayList != null) {
            hashSet.addAll(integerArrayList);
        }
        hashMap.put("blocking.destructive.intent", hashSet);
        ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("update.precondition.failures:nonblocking.destructive.intent");
        HashSet hashSet2 = new HashSet();
        if (integerArrayList2 != null) {
            hashSet2.addAll(integerArrayList2);
        }
        hashMap.put("nonblocking.destructive.intent", hashSet2);
        ArrayList<Integer> integerArrayList3 = bundle.getIntegerArrayList("update.precondition.failures:blocking.intent");
        HashSet hashSet3 = new HashSet();
        if (integerArrayList3 != null) {
            hashSet3.addAll(integerArrayList3);
        }
        hashMap.put("blocking.intent", hashSet3);
        ArrayList<Integer> integerArrayList4 = bundle.getIntegerArrayList("update.precondition.failures:nonblocking.intent");
        HashSet hashSet4 = new HashSet();
        if (integerArrayList4 != null) {
            hashSet4.addAll(integerArrayList4);
        }
        hashMap.put("nonblocking.intent", hashSet4);
        taskCompletionSource.trySetResult(new a(this.f143d, i3, i4, i5, num, i6, j2, a2, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, hashMap));
    }
}
