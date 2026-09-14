package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;

/* compiled from: LanguageDetector.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H&J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", JsonProperty.USE_DEFAULT_NAME, "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", JsonProperty.USE_DEFAULT_NAME, "predict", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "input", JsonProperty.USE_DEFAULT_NAME, "verbose", "predictAndGetCandidates", JsonProperty.USE_DEFAULT_NAME, "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "unload", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface LanguageDetector {
    boolean isLoaded();

    void load();

    DetectionCandidate predict(String input, boolean verbose);

    List<DetectionCandidate> predictAndGetCandidates(String input, int maxCandidate, boolean verbose);

    void unload();

    /* compiled from: LanguageDetector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ List predictAndGetCandidates$default(LanguageDetector languageDetector, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: predictAndGetCandidates");
            }
            if ((i2 & 2) != 0) {
                i = 10;
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            return languageDetector.predictAndGetCandidates(str, i, z);
        }

        public static /* synthetic */ DetectionCandidate predict$default(LanguageDetector languageDetector, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: predict");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return languageDetector.predict(str, z);
        }
    }
}
