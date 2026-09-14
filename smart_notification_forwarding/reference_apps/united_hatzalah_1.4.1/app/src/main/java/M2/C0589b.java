package m2;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: m2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0589b implements MethodChannel.MethodCallHandler {

    /* renamed from: a, reason: collision with root package name */
    public final PackageManager f5867a;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityManager f5868b;

    /* renamed from: c, reason: collision with root package name */
    public final ContentResolver f5869c;

    public C0589b(PackageManager packageManager, ActivityManager activityManager, ContentResolver contentResolver) {
        this.f5867a = packageManager;
        this.f5868b = activityManager;
        this.f5869c = contentResolver;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00da, code lost:
    
        if (N2.n.M(r1, "generic") == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0193 A[LOOP:1: B:24:0x0191->B:25:0x0193, LOOP_END] */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMethodCall(io.flutter.plugin.common.MethodCall r11, io.flutter.plugin.common.MethodChannel.Result r12) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.C0589b.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
