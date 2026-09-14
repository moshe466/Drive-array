package com.google.firebase.sessions;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import t2.AbstractC0707i;
import t2.AbstractC0709k;
import t2.C0716r;

/* loaded from: classes.dex */
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider INSTANCE = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    private final ProcessDetails buildProcessDetails(String str, int i, int i3, boolean z3) {
        return new ProcessDetails(str, i, i3, z3);
    }

    public static /* synthetic */ ProcessDetails buildProcessDetails$default(ProcessDetailsProvider processDetailsProvider, String str, int i, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        if ((i4 & 8) != 0) {
            z3 = false;
        }
        return processDetailsProvider.buildProcessDetails(str, i, i3, z3);
    }

    public final List<ProcessDetails> getAppProcessDetails(Context context) {
        ActivityManager activityManager;
        j.e(context, "context");
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> list = null;
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        } else {
            activityManager = null;
        }
        if (activityManager != null) {
            list = activityManager.getRunningAppProcesses();
        }
        if (list == null) {
            list = C0716r.f6476a;
        }
        ArrayList d02 = AbstractC0707i.d0(list);
        ArrayList arrayList = new ArrayList();
        int size = d02.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = d02.get(i4);
            i4++;
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0709k.Y(arrayList, 10));
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj2;
            String str2 = runningAppProcessInfo.processName;
            j.d(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new ProcessDetails(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, j.a(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final ProcessDetails getCurrentProcessDetails(Context context) {
        Object obj;
        j.e(context, "context");
        int myPid = Process.myPid();
        Iterator<T> it = getAppProcessDetails(context).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((ProcessDetails) obj).getPid() == myPid) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        if (processDetails == null) {
            return buildProcessDetails$default(this, getProcessName$com_google_firebase_firebase_sessions(), myPid, 0, false, 12, null);
        }
        return processDetails;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        r0 = android.app.Application.getProcessName();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getProcessName$com_google_firebase_firebase_sessions() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r0 <= r1) goto L10
            java.lang.String r0 = F0.H2.q()
            java.lang.String r1 = "myProcessName()"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        L10:
            r1 = 28
            if (r0 < r1) goto L1b
            java.lang.String r0 = K.c.n()
            if (r0 == 0) goto L1b
            return r0
        L1b:
            java.lang.String r0 = com.google.android.gms.common.util.ProcessUtils.getMyProcessName()
            if (r0 == 0) goto L22
            return r0
        L22:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.ProcessDetailsProvider.getProcessName$com_google_firebase_firebase_sessions():java.lang.String");
    }
}
