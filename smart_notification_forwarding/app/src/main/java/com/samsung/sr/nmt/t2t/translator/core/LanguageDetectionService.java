package com.samsung.sr.nmt.t2t.translator.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.DetectionCandidate;
import java.util.List;
import kotlin.Metadata;

/* compiled from: LanguageDetectionService.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J:\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\bH&J4\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH&¨\u0006\u0012"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionService;", JsonProperty.USE_DEFAULT_NAME, "clear", JsonProperty.USE_DEFAULT_NAME, "identifyLanguage", JsonProperty.USE_DEFAULT_NAME, "text", "differentiate", JsonProperty.USE_DEFAULT_NAME, "threshold", JsonProperty.USE_DEFAULT_NAME, "fallbackLanguage", "verbose", "identifyLanguageAndGetCandidates", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface LanguageDetectionService {
    void clear();

    String identifyLanguage(String text, boolean differentiate, float threshold, String fallbackLanguage, boolean verbose);

    List<DetectionCandidate> identifyLanguageAndGetCandidates(String text, int maxCandidate, boolean differentiate, boolean verbose);

    /* compiled from: LanguageDetectionService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ String identifyLanguage$default(LanguageDetectionService languageDetectionService, String str, boolean z, float f, String str2, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identifyLanguage");
            }
            boolean z3 = (i & 2) != 0 ? false : z;
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i & 8) != 0) {
                str2 = "en";
            }
            return languageDetectionService.identifyLanguage(str, z3, f2, str2, (i & 16) != 0 ? false : z2);
        }

        public static /* synthetic */ List identifyLanguageAndGetCandidates$default(LanguageDetectionService languageDetectionService, String str, int i, boolean z, boolean z2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identifyLanguageAndGetCandidates");
            }
            if ((i2 & 2) != 0) {
                i = 10;
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                z2 = false;
            }
            return languageDetectionService.identifyLanguageAndGetCandidates(str, i, z, z2);
        }
    }
}
