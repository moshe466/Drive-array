package com.google.android.gms.common;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.k;
import b2.b0;
import b2.e0;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.r1;
import com.google.android.gms.common.api.internal.s1;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {m2.d.class, m2.e.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f5090d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static final b f5091e = new b();

    /* renamed from: c, reason: collision with root package name */
    private String f5092c;

    public static b p() {
        return f5091e;
    }

    @Override // com.google.android.gms.common.c
    public Intent d(Context context, int i10, String str) {
        return super.d(context, i10, str);
    }

    @Override // com.google.android.gms.common.c
    public PendingIntent e(Context context, int i10, int i11) {
        return super.e(context, i10, i11);
    }

    @Override // com.google.android.gms.common.c
    public final String g(int i10) {
        return super.g(i10);
    }

    @Override // com.google.android.gms.common.c
    public int i(Context context) {
        return super.i(context);
    }

    @Override // com.google.android.gms.common.c
    public int j(Context context, int i10) {
        return super.j(context, i10);
    }

    @Override // com.google.android.gms.common.c
    public final boolean m(int i10) {
        return super.m(i10);
    }

    public Dialog n(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        return s(activity, i10, e0.b(activity, d(activity, i10, "d"), i11), onCancelListener);
    }

    public PendingIntent o(Context context, a aVar) {
        return aVar.s() ? aVar.l() : e(context, aVar.g(), 0);
    }

    public boolean q(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog n10 = n(activity, i10, i11, onCancelListener);
        if (n10 == null) {
            return false;
        }
        v(activity, n10, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void r(Context context, int i10) {
        w(context, i10, null, f(context, i10, 0, "n"));
    }

    final Dialog s(Context context, int i10, e0 e0Var, DialogInterface.OnCancelListener onCancelListener) {
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(b0.d(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c10 = b0.c(context, i10);
        if (c10 != null) {
            builder.setPositiveButton(c10, e0Var);
        }
        String g10 = b0.g(context, i10);
        if (g10 != null) {
            builder.setTitle(g10);
        }
        String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i10));
        new IllegalArgumentException();
        return builder.create();
    }

    public final Dialog t(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(b0.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        v(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final s1 u(Context context, r1 r1Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        s1 s1Var = new s1(r1Var);
        m2.h.j(context, s1Var, intentFilter);
        s1Var.a(context);
        if (l(context, "com.google.android.gms")) {
            return s1Var;
        }
        r1Var.a();
        s1Var.b();
        return null;
    }

    final void v(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof androidx.fragment.app.j) {
                z1.f.j2(dialog, onCancelListener).i2(((androidx.fragment.app.j) activity).d0(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        z1.b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    final void w(Context context, int i10, String str, PendingIntent pendingIntent) {
        int i11;
        String str2;
        String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i10), null);
        new IllegalArgumentException();
        if (i10 == 18) {
            x(context);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String f10 = b0.f(context, i10);
        String e10 = b0.e(context, i10);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) b2.p.k(context.getSystemService("notification"));
        k.e y10 = new k.e(context).q(true).f(true).k(f10).y(new k.c().h(e10));
        if (g2.i.c(context)) {
            b2.p.n(g2.l.e());
            y10.w(context.getApplicationInfo().icon).t(2);
            if (g2.i.d(context)) {
                y10.a(x1.a.f15387a, resources.getString(x1.b.f15402o), pendingIntent);
            } else {
                y10.i(pendingIntent);
            }
        } else {
            y10.w(R.drawable.stat_sys_warning).z(resources.getString(x1.b.f15395h)).C(System.currentTimeMillis()).i(pendingIntent).j(e10);
        }
        if (g2.l.h()) {
            b2.p.n(g2.l.h());
            synchronized (f5090d) {
                str2 = this.f5092c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String b10 = b0.b(context);
                if (notificationChannel == null) {
                    notificationChannel = new NotificationChannel("com.google.android.gms.availability", b10, 4);
                } else if (!b10.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(b10);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            y10.g(str2);
        }
        Notification b11 = y10.b();
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            e.f5096b.set(false);
            i11 = 10436;
        } else {
            i11 = 39789;
        }
        notificationManager.notify(i11, b11);
    }

    final void x(Context context) {
        new g(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean y(Activity activity, com.google.android.gms.common.api.internal.k kVar, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog s10 = s(activity, i10, e0.c(kVar, d(activity, i10, "d"), 2), onCancelListener);
        if (s10 == null) {
            return false;
        }
        v(activity, s10, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean z(Context context, a aVar, int i10) {
        PendingIntent o10;
        if (i2.a.a(context) || (o10 = o(context, aVar)) == null) {
            return false;
        }
        w(context, aVar.g(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, o10, i10, true), m2.i.f12014a | 134217728));
        return true;
    }
}
