package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguagePackKey;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LanguagePackManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/LanguagePackManager;", JsonProperty.USE_DEFAULT_NAME, "contextExtension", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ContextExtension;", "androidLanguagePackOnly", JsonProperty.USE_DEFAULT_NAME, "srLanguagePackOnly", "(Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ContextExtension;ZZ)V", "packageCache", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/LanguagePackInfo;", "clearCache", JsonProperty.USE_DEFAULT_NAME, "detectAndroidLanguagePack", "languagePackKey", "detectSrLanguagePack", "existResource", "sourceLanguage", "targetLanguage", "getAuthority", "getResourcePackageName", "getVersion", "getPackageInfoSafe", "Landroid/content/pm/PackageInfo;", "Landroid/content/pm/PackageManager;", "packageName", "flags", JsonProperty.USE_DEFAULT_NAME, "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LanguagePackManager {
    private final boolean androidLanguagePackOnly;
    private final ContextExtension contextExtension;
    private final Map<String, LanguagePackInfo> packageCache;
    private final boolean srLanguagePackOnly;

    public LanguagePackManager(ContextExtension contextExtension, boolean androidLanguagePackOnly, boolean srLanguagePackOnly) {
        Intrinsics.checkNotNullParameter(contextExtension, "contextExtension");
        this.contextExtension = contextExtension;
        this.androidLanguagePackOnly = androidLanguagePackOnly;
        this.srLanguagePackOnly = srLanguagePackOnly;
        this.packageCache = new LinkedHashMap();
    }

    public final String getResourcePackageName(String sourceLanguage, String targetLanguage) {
        String str;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        String str2 = LanguagePackKey.INSTANCE.get(sourceLanguage, targetLanguage);
        LanguagePackInfo languagePackInfo = this.packageCache.get(str2);
        if (languagePackInfo != null && (str = "com.samsung." + languagePackInfo.getPackageType() + ".nmt.apps.t2t.languagepack." + str2) != null) {
            return str;
        }
        if (this.androidLanguagePackOnly) {
            return "com.samsung.android.nmt.apps.t2t.languagepack." + str2;
        }
        return "com.samsung.sr.nmt.apps.t2t.languagepack." + str2;
    }

    public final boolean existResource(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        String str = LanguagePackKey.INSTANCE.get(sourceLanguage, targetLanguage);
        if (!this.srLanguagePackOnly) {
            detectAndroidLanguagePack(str);
        } else {
            detectSrLanguagePack(str);
        }
        return this.packageCache.get(str) != null;
    }

    public final String getAuthority(String sourceLanguage, String targetLanguage) {
        String str;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        String str2 = LanguagePackKey.INSTANCE.get(sourceLanguage, targetLanguage);
        LanguagePackInfo languagePackInfo = this.packageCache.get(str2);
        if (languagePackInfo != null && (str = "com.samsung." + languagePackInfo.getPackageType() + ".nmt.core.t2t.languagepack." + str2) != null) {
            return str;
        }
        if (this.androidLanguagePackOnly) {
            return "com.samsung.android.nmt.core.t2t.languagepack." + str2;
        }
        return "com.samsung.sr.nmt.core.t2t.languagepack." + str2;
    }

    public final String getVersion(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        LanguagePackInfo languagePackInfo = this.packageCache.get(LanguagePackKey.INSTANCE.get(sourceLanguage, targetLanguage));
        if (languagePackInfo != null) {
            return languagePackInfo.getVersion();
        }
        return null;
    }

    public final void clearCache() {
        this.packageCache.clear();
    }

    private final PackageInfo getPackageInfoSafe(PackageManager $this$getPackageInfoSafe, String packageName, int flags) {
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = $this$getPackageInfoSafe.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(flags));
            Intrinsics.checkNotNull(packageInfo);
            return packageInfo;
        }
        PackageInfo packageInfo2 = $this$getPackageInfoSafe.getPackageInfo(packageName, flags);
        Intrinsics.checkNotNull(packageInfo2);
        return packageInfo2;
    }

    private final void detectAndroidLanguagePack(String languagePackKey) {
        Object m107constructorimpl;
        String str = "com.samsung.android.nmt.apps.t2t.languagepack." + languagePackKey;
        try {
            Result.Companion companion = Result.INSTANCE;
            LanguagePackManager languagePackManager = this;
            m107constructorimpl = Result.m107constructorimpl(getPackageInfoSafe(this.contextExtension.getPackageManager(), str, 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m114isSuccessimpl(m107constructorimpl)) {
            Map<String, LanguagePackInfo> map = this.packageCache;
            String versionName = ((PackageInfo) m107constructorimpl).versionName;
            Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
            map.put(languagePackKey, new LanguagePackInfo("android", versionName));
        }
        if (Result.m110exceptionOrNullimpl(m107constructorimpl) == null || this.androidLanguagePackOnly) {
            return;
        }
        detectSrLanguagePack(languagePackKey);
    }

    private final void detectSrLanguagePack(String languagePackKey) {
        Object m107constructorimpl;
        String str = "com.samsung.sr.nmt.apps.t2t.languagepack." + languagePackKey;
        try {
            Result.Companion companion = Result.INSTANCE;
            LanguagePackManager languagePackManager = this;
            m107constructorimpl = Result.m107constructorimpl(getPackageInfoSafe(this.contextExtension.getPackageManager(), str, 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m114isSuccessimpl(m107constructorimpl)) {
            Map<String, LanguagePackInfo> map = this.packageCache;
            String str2 = ((PackageInfo) m107constructorimpl).versionName;
            Intrinsics.checkNotNull(str2);
            String substring = str2.substring(0, StringsKt.indexOf$default((CharSequence) str2, '-', 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            map.put(languagePackKey, new LanguagePackInfo("sr", substring));
        }
    }
}
