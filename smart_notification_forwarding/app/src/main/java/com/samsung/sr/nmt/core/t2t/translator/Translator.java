package com.samsung.sr.nmt.core.t2t.translator;

import android.os.Handler;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.languagedetector.DetectionCandidate;
import com.samsung.sr.nmt.core.t2t.translator.pipeline.engine.NotAvailableDirectionException;
import com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Translator.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H'J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH&J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0013\u001a\u00020\u000bH&JB\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0007J4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f2\u0006\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0007J.\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H$J8\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H$J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J\b\u0010%\u001a\u00020\u0004H&J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH&J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H&J\u0016\u0010.\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH&¨\u00060"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/Translator;", JsonProperty.USE_DEFAULT_NAME, "()V", "clear", JsonProperty.USE_DEFAULT_NAME, "dispose", "getLanguageDirectionStateMap", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/core/t2t/translator/utils/LanguageDirection;", "Lcom/samsung/sr/nmt/core/t2t/translator/LanguageDirectionState;", "getResourcePackPackageName", JsonProperty.USE_DEFAULT_NAME, "sourceLanguageCode", "targetLanguageCode", "getSourceLanguageList", JsonProperty.USE_DEFAULT_NAME, "getSourceLanguageListWithTargetLanguage", "targetLanguage", "getTargetLanguageList", "sourceLanguage", "identifyLanguage", "text", "fallbackLanguage", "filterSupportedLanguage", JsonProperty.USE_DEFAULT_NAME, "differentiate", "threshold", JsonProperty.USE_DEFAULT_NAME, "verbose", "identifyLanguageAndGetCandidates", "Lcom/samsung/sr/nmt/core/t2t/translator/languagedetector/DetectionCandidate;", "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "identifyLanguageAndGetCandidatesDefault", "identifyLanguageInner", "isAvailableDirection", "isTaggedTranslationSupported", "refresh", "segment", "sentence", "language", "translate", "task", "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput;", "handler", "Landroid/os/Handler;", "updateTranslatorSpec", "languageDirections", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class Translator {
    public abstract void clear();

    @Deprecated(message = "Currently, it doesn't have a specific role comparing to use method `clean`. It can be removed soon")
    public abstract void dispose();

    public abstract Map<LanguageDirection, LanguageDirectionState> getLanguageDirectionStateMap();

    public abstract String getResourcePackPackageName(String sourceLanguageCode, String targetLanguageCode);

    public abstract List<String> getSourceLanguageList();

    public abstract List<String> getSourceLanguageListWithTargetLanguage(String targetLanguage);

    public abstract List<String> getTargetLanguageList(String sourceLanguage);

    public final String identifyLanguage(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return identifyLanguage$default(this, text, null, false, false, 0.0f, false, 62, null);
    }

    public final String identifyLanguage(String text, String fallbackLanguage) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        return identifyLanguage$default(this, text, fallbackLanguage, false, false, 0.0f, false, 60, null);
    }

    public final String identifyLanguage(String text, String fallbackLanguage, boolean filterSupportedLanguage) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        return identifyLanguage$default(this, text, fallbackLanguage, filterSupportedLanguage, false, 0.0f, false, 56, null);
    }

    public final String identifyLanguage(String text, String fallbackLanguage, boolean filterSupportedLanguage, boolean differentiate) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        return identifyLanguage$default(this, text, fallbackLanguage, filterSupportedLanguage, differentiate, 0.0f, false, 48, null);
    }

    public final String identifyLanguage(String text, String fallbackLanguage, boolean filterSupportedLanguage, boolean differentiate, float threshold) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        return identifyLanguage$default(this, text, fallbackLanguage, filterSupportedLanguage, differentiate, threshold, false, 32, null);
    }

    public final List<DetectionCandidate> identifyLanguageAndGetCandidates(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return identifyLanguageAndGetCandidates$default(this, text, 0, false, false, 14, null);
    }

    public final List<DetectionCandidate> identifyLanguageAndGetCandidates(String text, int maxCandidate) {
        Intrinsics.checkNotNullParameter(text, "text");
        return identifyLanguageAndGetCandidates$default(this, text, maxCandidate, false, false, 12, null);
    }

    public final List<DetectionCandidate> identifyLanguageAndGetCandidates(String text, int maxCandidate, boolean differentiate) {
        Intrinsics.checkNotNullParameter(text, "text");
        return identifyLanguageAndGetCandidates$default(this, text, maxCandidate, differentiate, false, 8, null);
    }

    protected abstract List<DetectionCandidate> identifyLanguageAndGetCandidatesDefault(String text, int maxCandidate, boolean differentiate, boolean verbose);

    protected abstract String identifyLanguageInner(String text, String fallbackLanguage, boolean filterSupportedLanguage, boolean differentiate, float threshold, boolean verbose);

    public abstract boolean isAvailableDirection(String sourceLanguageCode, String targetLanguageCode);

    public abstract boolean isTaggedTranslationSupported(String sourceLanguageCode, String targetLanguageCode);

    public abstract void refresh();

    public abstract List<String> segment(String sentence, String language);

    public abstract void translate(TranslatorInput task, Handler handler) throws NotAvailableDirectionException;

    public abstract void updateTranslatorSpec(List<LanguageDirection> languageDirections);

    public static /* synthetic */ String identifyLanguage$default(Translator translator, String str, String str2, boolean z, boolean z2, float f, boolean z3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identifyLanguage");
        }
        if ((i & 2) != 0) {
            str2 = "en";
        }
        String str3 = str2;
        boolean z4 = (i & 4) != 0 ? false : z;
        boolean z5 = (i & 8) != 0 ? false : z2;
        if ((i & 16) != 0) {
            f = 0.0f;
        }
        return translator.identifyLanguage(str, str3, z4, z5, f, (i & 32) != 0 ? false : z3);
    }

    public final String identifyLanguage(String text, String fallbackLanguage, boolean filterSupportedLanguage, boolean differentiate, float threshold, boolean verbose) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        return identifyLanguageInner(text, fallbackLanguage, filterSupportedLanguage, differentiate, threshold, verbose);
    }

    public static /* synthetic */ List identifyLanguageAndGetCandidates$default(Translator translator, String str, int i, boolean z, boolean z2, int i2, Object obj) {
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
        return translator.identifyLanguageAndGetCandidates(str, i, z, z2);
    }

    public final List<DetectionCandidate> identifyLanguageAndGetCandidates(String text, int maxCandidate, boolean differentiate, boolean verbose) {
        Intrinsics.checkNotNullParameter(text, "text");
        return identifyLanguageAndGetCandidatesDefault(text, maxCandidate, differentiate, verbose);
    }
}
