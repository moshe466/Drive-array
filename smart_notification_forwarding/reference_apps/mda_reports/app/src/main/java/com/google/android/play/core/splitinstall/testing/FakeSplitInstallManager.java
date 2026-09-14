package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.play.core.internal.ac;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ba;
import com.google.android.play.core.internal.bh;
import com.google.android.play.core.internal.q;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.j;
import com.google.android.play.core.splitinstall.l;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class FakeSplitInstallManager implements SplitInstallManager {
    private static final long b = TimeUnit.SECONDS.toMillis(1);
    private static final AtomicReference<SplitInstallSessionState> k = new AtomicReference<>(SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList()));
    private final Handler a;
    private final Context c;
    private final ac d;
    private final l e;
    private final bh f;
    private final q<SplitInstallSessionState> g;
    private final Executor h;
    private final a i;
    private final File j;
    private final Set<String> l;
    private final Set<String> m;
    private final AtomicBoolean n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        default a() {
        }

        default void a() {
            SystemClock.sleep(FakeSplitInstallManager.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new j(), new l(context, context.getPackageName()), new bh(context), new ba(context, new com.google.android.play.core.splitcompat.c(context), new ag()), new a(), com.google.android.play.core.splitcompat.a.a());
    }

    private FakeSplitInstallManager(Context context, File file, j jVar, l lVar, bh bhVar, ba baVar, a aVar, Executor executor) {
        this.a = new Handler(Looper.getMainLooper());
        this.l = Collections.synchronizedSet(new HashSet());
        this.m = Collections.synchronizedSet(new HashSet());
        this.n = new AtomicBoolean(false);
        this.i = aVar;
        this.g = new q<>();
        this.c = context;
        this.j = file;
        this.e = lVar;
        this.f = bhVar;
        com.google.android.play.core.splitcompat.c cVar = new com.google.android.play.core.splitcompat.c(context);
        this.h = executor;
        this.d = new ac(context, executor, baVar, cVar, jVar);
    }

    private static String a(File file) {
        if (file.getName().endsWith(".apk")) {
            return file.getName().substring(0, file.getName().length() - 4).replace("base-", "config.").replace("-", ".config.").replace(".config.master", "");
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    private static String a(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    private final void a(@SplitInstallSessionStatus int i, @SplitInstallErrorCode int i2) {
        a(i, i2, null, null, null, null);
    }

    private final void a(int i, int i2, Long l, Long l2, List<String> list, Integer num) {
        SplitInstallSessionState splitInstallSessionState = k.get();
        k.set(SplitInstallSessionState.create((num == null ? Integer.valueOf(splitInstallSessionState.sessionId()) : num).intValue(), i, i2, (l == null ? Long.valueOf(splitInstallSessionState.bytesDownloaded()) : l).longValue(), (l2 == null ? Long.valueOf(splitInstallSessionState.totalBytesToDownload()) : l2).longValue(), list == null ? splitInstallSessionState.moduleNames() : list, new ArrayList(getInstalledModules())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<File> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (File file : list) {
            String a2 = a(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.c.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", a(a2));
            intent.putExtra("split_id", a2);
            arrayList.add(intent);
            arrayList2.add(a(a(file)));
        }
        this.h.execute(new d(this, k.get().totalBytesToDownload(), arrayList, arrayList2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<Intent> list, List<String> list2, long j) {
        a(list, list2, j, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<Intent> list, List<String> list2, long j, boolean z) {
        this.d.b(list, new c(this, list2, j, z, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i, int i2) {
        a(i, i2);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i, int i2, Long l, Long l2, List<String> list, Integer num) {
        a(i, i2, l, l2, list, num);
        c();
    }

    private final void c() {
        this.a.post(new com.google.android.play.core.splitinstall.testing.a(this));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Task<Void> cancelInstall(int i) {
        int status = k.get().status();
        if (i != k.get().sessionId() || status != 1) {
            return Tasks.a((Exception) new SplitInstallException(-3));
        }
        b(7, k.get().errorCode());
        return Tasks.a((Object) null);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Task<Void> deferredInstall(List<String> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Task<Void> deferredUninstall(List<String> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Set<String> getInstalledLanguages() {
        return new HashSet(this.m);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Set<String> getInstalledModules() {
        return new HashSet(this.l);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Task<SplitInstallSessionState> getSessionState(int i) {
        return Tasks.a(k.get());
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public Task<List<SplitInstallSessionState>> getSessionStates() {
        return Tasks.a(Arrays.asList(k.get()));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.g.a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.n.set(z);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d5  */
    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.play.core.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r21) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.play.core.tasks.Task");
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.g.b(splitInstallStateUpdatedListener);
    }
}
