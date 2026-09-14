package c1;

import F0.C0021d0;
import F0.C0035g2;
import F0.C0047j2;
import F0.C0084t0;
import F0.G1;
import F0.b3;
import R1.n;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.hardware.input.InputManager;
import android.media.MediaCodecList;
import android.media.RingtoneManager;
import android.os.StatFs;
import androidx.lifecycle.N;
import com.google.firebase.remoteconfig.internal.Code;
import d1.C0358a;
import f1.C0378A;
import java.io.File;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import s2.C0680e;

/* loaded from: classes.dex */
public final class c extends k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3872a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f3873b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Context context, int i) {
        super(0);
        this.f3872a = i;
        this.f3873b = context;
    }

    @Override // F2.a
    public final Object invoke() {
        int i = this.f3872a;
        StatFs statFs = null;
        Context context = this.f3873b;
        switch (i) {
            case 0:
                ContentResolver contentResolver = context.getContentResolver();
                j.b(contentResolver);
                return contentResolver;
            case 1:
                return new RingtoneManager(context);
            case 2:
                AssetManager assets = context.getAssets();
                j.b(assets);
                return assets;
            case 3:
                Resources resources = context.getResources();
                j.b(resources);
                Configuration configuration = resources.getConfiguration();
                j.b(configuration);
                return configuration;
            case 4:
                Object systemService = context.getSystemService("device_policy");
                j.c(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
                return (DevicePolicyManager) systemService;
            case 5:
                Object systemService2 = context.getSystemService("keyguard");
                j.c(systemService2, "null cannot be cast to non-null type android.app.KeyguardManager");
                return (KeyguardManager) systemService2;
            case 6:
                return new C.b(context);
            case 7:
                int i3 = e.f3877a;
                N n4 = new N(7);
                Object G3 = T.b.G(1000L, new c(context, 11));
                if (G3 instanceof C0680e) {
                    G3 = null;
                }
                ActivityManager activityManager = (ActivityManager) G3;
                Object G4 = T.b.G(1000L, d.f3875c);
                if (G4 instanceof C0680e) {
                    G4 = null;
                }
                StatFs statFs2 = (StatFs) G4;
                int i4 = 12;
                Object G5 = T.b.G(1000L, new c(context, i4));
                if (G5 instanceof C0680e) {
                    G5 = null;
                }
                C0084t0 c0084t0 = new C0084t0(activityManager, statFs2);
                int i5 = 14;
                Object G6 = T.b.G(1000L, new c(context, i5));
                if (G6 instanceof C0680e) {
                    G6 = null;
                }
                G1 g12 = new G1((SensorManager) G6, 15);
                Object G7 = T.b.G(1000L, new c(context, 10));
                if (G7 instanceof C0680e) {
                    G7 = null;
                }
                C0035g2 c0035g2 = new C0035g2((InputManager) G7, i4);
                E1.e eVar = new E1.e(context, 1);
                N n5 = new N(6);
                Object G8 = T.b.G(1000L, new c(context, 8));
                if (G8 instanceof C0680e) {
                    G8 = null;
                }
                G1 g13 = new G1((ActivityManager) G8, i5);
                N n6 = new N(8);
                Object G9 = T.b.G(1000L, d.f3874b);
                if (G9 instanceof C0680e) {
                    G9 = null;
                }
                C0035g2 c0035g22 = new C0035g2((MediaCodecList) G9, 11);
                Object G10 = T.b.G(1000L, new c(context, 4));
                if (G10 instanceof C0680e) {
                    G10 = null;
                }
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) G10;
                Object G11 = T.b.G(1000L, new c(context, 5));
                if (G11 instanceof C0680e) {
                    G11 = null;
                }
                C0021d0 c0021d0 = new C0021d0(devicePolicyManager, (KeyguardManager) G11);
                Object G12 = T.b.G(1000L, new c(context, 13));
                if (G12 instanceof C0680e) {
                    G12 = null;
                }
                C0047j2 c0047j2 = new C0047j2((PackageManager) G12, 14);
                Object G13 = T.b.G(1000L, new c(context, 15));
                if (G13 instanceof C0680e) {
                    G13 = null;
                }
                C0358a c0358a = new C0358a((ContentResolver) G13);
                Object G14 = T.b.G(1000L, new c(context, 1));
                if (G14 instanceof C0680e) {
                    G14 = null;
                }
                RingtoneManager ringtoneManager = (RingtoneManager) G14;
                Object G15 = T.b.G(1000L, new c(context, 2));
                if (G15 instanceof C0680e) {
                    G15 = null;
                }
                AssetManager assetManager = (AssetManager) G15;
                Object G16 = T.b.G(1000L, new c(context, 3));
                if (G16 instanceof C0680e) {
                    G16 = null;
                }
                b3 b3Var = new b3(ringtoneManager, assetManager, (Configuration) G16, 8);
                Object G17 = T.b.G(1000L, new c(context, 6));
                if (G17 instanceof C0680e) {
                    G17 = null;
                }
                int i6 = 12;
                C0378A c0378a = new C0378A(n4, c0084t0, g12, c0035g2, eVar, n5, g13, n6, c0035g22, c0021d0, c0047j2, c0358a, b3Var, new C0047j2((C.b) G17, 13));
                Object G18 = T.b.G(1000L, new c(context, 9));
                if (G18 instanceof C0680e) {
                    G18 = null;
                }
                C0047j2 c0047j22 = new C0047j2((ContentResolver) G18, i6);
                Object G19 = T.b.G(1000L, new c(context, 0));
                if (G19 instanceof C0680e) {
                    G19 = null;
                }
                return new g(c0378a, new n(c0047j22, new C0358a((ContentResolver) G19), new N(4)));
            case 8:
                Object systemService3 = context.getSystemService("activity");
                j.c(systemService3, "null cannot be cast to non-null type android.app.ActivityManager");
                return (ActivityManager) systemService3;
            case 9:
                ContentResolver contentResolver2 = context.getContentResolver();
                j.b(contentResolver2);
                return contentResolver2;
            case 10:
                Object systemService4 = context.getSystemService("input");
                j.c(systemService4, "null cannot be cast to non-null type android.hardware.input.InputManager");
                return (InputManager) systemService4;
            case 11:
                Object systemService5 = context.getSystemService("activity");
                j.c(systemService5, "null cannot be cast to non-null type android.app.ActivityManager");
                return (ActivityManager) systemService5;
            case Code.UNIMPLEMENTED /* 12 */:
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    if (!externalFilesDir.canRead()) {
                        externalFilesDir = null;
                    }
                    if (externalFilesDir != null) {
                        String absolutePath = externalFilesDir.getAbsolutePath();
                        j.b(absolutePath);
                        statFs = new StatFs(absolutePath);
                    }
                }
                j.b(statFs);
                return statFs;
            case 13:
                PackageManager packageManager = context.getPackageManager();
                j.b(packageManager);
                return packageManager;
            case 14:
                Object systemService6 = context.getSystemService("sensor");
                j.c(systemService6, "null cannot be cast to non-null type android.hardware.SensorManager");
                return (SensorManager) systemService6;
            default:
                ContentResolver contentResolver3 = context.getContentResolver();
                j.b(contentResolver3);
                return contentResolver3;
        }
    }
}
