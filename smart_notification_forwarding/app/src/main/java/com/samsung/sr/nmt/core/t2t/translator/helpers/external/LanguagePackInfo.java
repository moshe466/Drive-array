package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguagePackInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/LanguagePackInfo;", JsonProperty.USE_DEFAULT_NAME, "packageType", JsonProperty.USE_DEFAULT_NAME, "version", "(Ljava/lang/String;Ljava/lang/String;)V", "getPackageType", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class LanguagePackInfo {
    private final String packageType;
    private final String version;

    public static /* synthetic */ LanguagePackInfo copy$default(LanguagePackInfo languagePackInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = languagePackInfo.packageType;
        }
        if ((i & 2) != 0) {
            str2 = languagePackInfo.version;
        }
        return languagePackInfo.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageType() {
        return this.packageType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final LanguagePackInfo copy(String packageType, String version) {
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(version, "version");
        return new LanguagePackInfo(packageType, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguagePackInfo)) {
            return false;
        }
        LanguagePackInfo languagePackInfo = (LanguagePackInfo) other;
        return Intrinsics.areEqual(this.packageType, languagePackInfo.packageType) && Intrinsics.areEqual(this.version, languagePackInfo.version);
    }

    public int hashCode() {
        return (this.packageType.hashCode() * 31) + this.version.hashCode();
    }

    public String toString() {
        return "LanguagePackInfo(packageType=" + this.packageType + ", version=" + this.version + ')';
    }

    public LanguagePackInfo(String packageType, String version) {
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(version, "version");
        this.packageType = packageType;
        this.version = version;
    }

    public final String getPackageType() {
        return this.packageType;
    }

    public final String getVersion() {
        return this.version;
    }
}
