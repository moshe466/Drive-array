package com.samsung.sr.nmt.t2t.translator.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: TranslatorConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/TranslatorConfig;", JsonProperty.USE_DEFAULT_NAME, "characterBatchSize", JsonProperty.USE_DEFAULT_NAME, "(I)V", "getCharacterBatchSize", "()I", "component1", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TranslatorConfig {
    private final int characterBatchSize;

    public static /* synthetic */ TranslatorConfig copy$default(TranslatorConfig translatorConfig, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = translatorConfig.characterBatchSize;
        }
        return translatorConfig.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCharacterBatchSize() {
        return this.characterBatchSize;
    }

    public final TranslatorConfig copy(int characterBatchSize) {
        return new TranslatorConfig(characterBatchSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TranslatorConfig) && this.characterBatchSize == ((TranslatorConfig) other).characterBatchSize;
    }

    public int hashCode() {
        return Integer.hashCode(this.characterBatchSize);
    }

    public String toString() {
        return "TranslatorConfig(characterBatchSize=" + this.characterBatchSize + ")";
    }

    public TranslatorConfig(int i) {
        this.characterBatchSize = i;
    }

    public final int getCharacterBatchSize() {
        return this.characterBatchSize;
    }
}
