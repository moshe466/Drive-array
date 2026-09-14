package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextExtension.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ContextExtension;", JsonProperty.USE_DEFAULT_NAME, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContentResolver", "Landroid/content/ContentResolver;", "getPackageManager", "Landroid/content/pm/PackageManager;", "getPackageSignatures", JsonProperty.USE_DEFAULT_NAME, "Landroid/content/pm/Signature;", "packageName", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;)[Landroid/content/pm/Signature;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ContextExtension {
    private final Context context;

    public ContextExtension(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final PackageManager getPackageManager() {
        PackageManager packageManager = this.context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        return packageManager;
    }

    public final ContentResolver getContentResolver() {
        return this.context.getContentResolver();
    }

    public final Signature[] getPackageSignatures(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (Build.VERSION.SDK_INT >= 28) {
            Signature[] apkContentsSigners = this.context.getPackageManager().getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            Intrinsics.checkNotNull(apkContentsSigners);
            return apkContentsSigners;
        }
        Signature[] signatureArr = this.context.getPackageManager().getPackageInfo(packageName, 64).signatures;
        Intrinsics.checkNotNull(signatureArr);
        return signatureArr;
    }
}
