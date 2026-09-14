package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LanguageDetectorJni.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0011\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0082 J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u0019\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aJ4\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 ¢\u0006\u0002\u0010 J\f\u0010!\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetectorJni;", JsonProperty.USE_DEFAULT_NAME, "assetLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "threshold", JsonProperty.USE_DEFAULT_NAME, "modelPath", JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;FLjava/lang/String;)V", "langDetectorAddress", JsonProperty.USE_DEFAULT_NAME, "clear", JsonProperty.USE_DEFAULT_NAME, "clearInner", "address", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", "loadModelInner", "byteArray", JsonProperty.USE_DEFAULT_NAME, "predictAndGetCandidates", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "input", "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "predictLineAndGetCandidatesInner", JsonProperty.USE_DEFAULT_NAME, "modelAddress", "sentence", "numCandidates", "(JLjava/lang/String;IF)[Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "appendNewLineForEos", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LanguageDetectorJni {
    private static final float MAX_PROB = 1.0f;
    private static final String NEW_LINE = "\n";
    private static final long NULL_ADDRESS = -1;
    private static final String PREFIX_LABEL = "__label__";
    private final AssetLoader assetLoader;
    private long langDetectorAddress;
    private final String modelPath;
    private final float threshold;

    private final native void clearInner(long address);

    private final native long loadModelInner(byte[] byteArray, float threshold);

    private final native DetectionCandidate[] predictLineAndGetCandidatesInner(long modelAddress, String sentence, int numCandidates, float threshold);

    public LanguageDetectorJni(AssetLoader assetLoader, float f, String modelPath) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        Intrinsics.checkNotNullParameter(modelPath, "modelPath");
        this.assetLoader = assetLoader;
        this.threshold = f;
        this.modelPath = modelPath;
        this.langDetectorAddress = -1L;
    }

    public /* synthetic */ LanguageDetectorJni(AssetLoader assetLoader, float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetLoader, (i & 2) != 0 ? -1.0f : f, (i & 4) != 0 ? "langdetect176.ftz" : str);
    }

    static {
        System.loadLibrary("srcb_langid_lib");
    }

    public final void load() {
        synchronized (this) {
            InputStream open = this.assetLoader.open(this.modelPath);
            try {
                byte[] readBytes = ByteStreamsKt.readBytes(open);
                CloseableKt.closeFinally(open, null);
                this.langDetectorAddress = loadModelInner(readBytes, this.threshold);
                Unit unit = Unit.INSTANCE;
            } finally {
            }
        }
    }

    public final void clear() {
        synchronized (this) {
            if (isLoaded()) {
                clearInner(this.langDetectorAddress);
                this.langDetectorAddress = -1L;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isLoaded() {
        boolean z;
        synchronized (this) {
            z = this.langDetectorAddress != -1;
        }
        return z;
    }

    public final List<DetectionCandidate> predictAndGetCandidates(String input, int maxCandidate) {
        Intrinsics.checkNotNullParameter(input, "input");
        synchronized (this) {
            long j = this.langDetectorAddress;
            if (j == -1) {
                return CollectionsKt.listOf(new DetectionCandidate("en", MAX_PROB));
            }
            DetectionCandidate[] predictLineAndGetCandidatesInner = predictLineAndGetCandidatesInner(j, appendNewLineForEos(input), maxCandidate, this.threshold);
            ArrayList arrayList = new ArrayList(predictLineAndGetCandidatesInner.length);
            for (DetectionCandidate detectionCandidate : predictLineAndGetCandidatesInner) {
                arrayList.add(detectionCandidate.copy(StringsKt.removePrefix(detectionCandidate.getLanguageCode(), (CharSequence) PREFIX_LABEL), Math.min(detectionCandidate.getProbability(), MAX_PROB)));
            }
            return CollectionsKt.toList(arrayList);
        }
    }

    private final String appendNewLineForEos(String str) {
        return StringsKt.trim((CharSequence) StringsKt.replace$default(str, NEW_LINE, " ", false, 4, (Object) null)).toString() + NEW_LINE;
    }
}
