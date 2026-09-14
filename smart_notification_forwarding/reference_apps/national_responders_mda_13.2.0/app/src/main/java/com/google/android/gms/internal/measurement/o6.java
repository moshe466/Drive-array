package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
/* loaded from: classes.dex */
public final class o6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Method f5513b = c();

    /* renamed from: c, reason: collision with root package name */
    private static final Method f5514c = d();

    /* renamed from: a, reason: collision with root package name */
    private final JobScheduler f5515a;

    private o6(JobScheduler jobScheduler) {
        this.f5515a = jobScheduler;
    }

    private final int a(JobInfo jobInfo, String str, int i10, String str2) {
        Method method = f5513b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f5515a, jobInfo, str, Integer.valueOf(i10), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return this.f5515a.schedule(jobInfo);
    }

    public static int b(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        return (f5513b == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) ? jobScheduler.schedule(jobInfo) : new o6(jobScheduler).a(jobInfo, str, e(), str2);
    }

    private static Method c() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Method d() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        return null;
    }

    private static int e() {
        Method method = f5514c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return 0;
    }
}
