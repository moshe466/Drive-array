package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
final class p implements SplitInstallManager {
    private final r a;
    private final n b;
    private final l c;
    private final aj d;
    private final Handler e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(r rVar, Context context) {
        this(rVar, context, context.getPackageName());
    }

    private p(r rVar, Context context, String str) {
        this.e = new Handler(Looper.getMainLooper());
        this.c = new l(context, str);
        this.a = rVar;
        this.b = n.a(context);
        this.d = new aj(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> b(List<Locale> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Locale locale : list) {
            if (Build.VERSION.SDK_INT >= 21) {
                arrayList.add(locale.toLanguageTag());
            }
        }
        return arrayList;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> cancelInstall(int i) {
        return this.a.b(i);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredInstall(List<String> list) {
        return this.a.b(list);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Build.VERSION.SDK_INT < 21 ? Tasks.a((Exception) new SplitInstallException(-5)) : this.a.c(b(list));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Build.VERSION.SDK_INT < 21 ? Tasks.a((Exception) new SplitInstallException(-5)) : this.a.d(b(list));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredUninstall(List<String> list) {
        this.d.a(list);
        return this.a.a(list);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledLanguages() {
        Set<String> b = this.c.b();
        return b == null ? Collections.emptySet() : b;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledModules() {
        return this.c.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return this.a.a(i);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return this.a.a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final synchronized void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.b.a((StateUpdatedListener) splitInstallStateUpdatedListener);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) {
        if (splitInstallSessionState.status() != 8 || splitInstallSessionState.resolutionIntent() == null) {
            return false;
        }
        activity.startIntentSenderForResult(splitInstallSessionState.resolutionIntent().getIntentSender(), i, null, 0, 0, 0);
        return true;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        boolean containsAll;
        if (!splitInstallRequest.getLanguages().isEmpty() && Build.VERSION.SDK_INT < 21) {
            return Tasks.a((Exception) new SplitInstallException(-5));
        }
        List<Locale> languages = splitInstallRequest.getLanguages();
        Set<String> b = this.c.b();
        if (b == null) {
            containsAll = true;
        } else {
            HashSet hashSet = new HashSet();
            Iterator<Locale> it = languages.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getLanguage());
            }
            containsAll = b.containsAll(hashSet);
        }
        if (containsAll) {
            if (getInstalledModules().containsAll(splitInstallRequest.getModuleNames()) && (Build.VERSION.SDK_INT < 21 || Collections.disjoint(splitInstallRequest.getModuleNames(), this.d.a()))) {
                this.e.post(new o(this, splitInstallRequest));
                return Tasks.a(0);
            }
        }
        return this.a.a(splitInstallRequest.getModuleNames(), b(splitInstallRequest.getLanguages()));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final synchronized void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.b.b(splitInstallStateUpdatedListener);
    }
}
