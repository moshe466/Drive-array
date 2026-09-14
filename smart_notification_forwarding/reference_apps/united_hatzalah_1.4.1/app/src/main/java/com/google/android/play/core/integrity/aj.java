package com.google.android.play.core.integrity;

import I1.AbstractC0111a;
import I1.B;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class aj {

    /* renamed from: a, reason: collision with root package name */
    final I1.d f3916a;

    /* renamed from: b, reason: collision with root package name */
    private final I1.y f3917b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3918c;

    /* renamed from: d, reason: collision with root package name */
    private final at f3919d;

    /* renamed from: e, reason: collision with root package name */
    private final k f3920e;

    public aj(Context context, I1.y yVar, at atVar, k kVar) {
        this.f3918c = context.getPackageName();
        this.f3917b = yVar;
        this.f3919d = atVar;
        this.f3920e = kVar;
        I1.y yVar2 = I1.e.f919a;
        try {
            if (context.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                if (I1.e.a(context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures)) {
                    this.f3916a = new I1.d(context, yVar, "IntegrityService", ak.f3921a, new B() { // from class: com.google.android.play.core.integrity.ae
                        @Override // I1.B
                        public final Object a(IBinder iBinder) {
                            int i = I1.s.f928j;
                            if (iBinder == null) {
                                return null;
                            }
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IIntegrityService");
                            if (queryLocalInterface instanceof I1.t) {
                                return (I1.t) queryLocalInterface;
                            }
                            return new AbstractC0111a(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
                        }
                    });
                    return;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        Object[] objArr = new Object[0];
        yVar.getClass();
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", I1.y.c(yVar.f929a, "Phonesky is not installed.", objArr));
        }
        this.f3916a = null;
    }

    public static Bundle a(aj ajVar, byte[] bArr, Long l3, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", ajVar.f3918c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l3 != null) {
            bundle.putLong("cloud.prj", l3.longValue());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new I1.l(3, System.currentTimeMillis()));
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(T.b.a(arrayList)));
        return bundle;
    }

    public final Task b(Activity activity, Bundle bundle) {
        if (this.f3916a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        int i = bundle.getInt("dialog.intent.type");
        this.f3917b.b("requestAndShowDialog(%s, %s)", this.f3918c, Integer.valueOf(i));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f3916a.c(new ag(this, taskCompletionSource, bundle, activity, taskCompletionSource, i), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task c(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f3916a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (integrityTokenRequest instanceof ao) {
            }
            this.f3917b.b("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f3916a.c(new af(this, taskCompletionSource, decode, cloudProjectNumber, null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e4) {
            return Tasks.forException(new IntegrityServiceException(-13, e4));
        }
    }
}
