package com.samsung.sr.nmt.t2t.translator.core.dataclass;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatorSpec.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;", JsonProperty.USE_DEFAULT_NAME, "version", JsonProperty.USE_DEFAULT_NAME, "directions", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "(Ljava/lang/String;Ljava/util/List;)V", "getDirections", "()Ljava/util/List;", "getVersion", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TranslatorSpec {
    private final List<LanguageDirection> directions;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TranslatorSpec copy$default(TranslatorSpec translatorSpec, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = translatorSpec.version;
        }
        if ((i & 2) != 0) {
            list = translatorSpec.directions;
        }
        return translatorSpec.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<LanguageDirection> component2() {
        return this.directions;
    }

    public final TranslatorSpec copy(String version, List<LanguageDirection> directions) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(directions, "directions");
        return new TranslatorSpec(version, directions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslatorSpec)) {
            return false;
        }
        TranslatorSpec translatorSpec = (TranslatorSpec) other;
        return Intrinsics.areEqual(this.version, translatorSpec.version) && Intrinsics.areEqual(this.directions, translatorSpec.directions);
    }

    public int hashCode() {
        return (this.version.hashCode() * 31) + this.directions.hashCode();
    }

    public String toString() {
        return "TranslatorSpec(version=" + this.version + ", directions=" + this.directions + ")";
    }

    public TranslatorSpec(String version, List<LanguageDirection> directions) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(directions, "directions");
        this.version = version;
        this.directions = directions;
    }

    public final List<LanguageDirection> getDirections() {
        return this.directions;
    }

    public final String getVersion() {
        return this.version;
    }
}
