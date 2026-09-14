package com.samsung.sr.nmt.t2t.translator.core.pipeline.spec;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageSpecFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B&\b\u0007\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004R%\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/LanguageSpecFactory;", JsonProperty.USE_DEFAULT_NAME, "languageSpecMap", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "Ljavax/inject/Provider;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/LanguageSpec;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;)V", "create", "language", "mode", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LanguageSpecFactory {
    private final Map<String, Provider<LanguageSpec>> languageSpecMap;

    @Inject
    public LanguageSpecFactory(Map<String, Provider<LanguageSpec>> languageSpecMap) {
        Intrinsics.checkNotNullParameter(languageSpecMap, "languageSpecMap");
        this.languageSpecMap = languageSpecMap;
    }

    public static /* synthetic */ LanguageSpec create$default(LanguageSpecFactory languageSpecFactory, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "plain";
        }
        return languageSpecFactory.create(str, str2);
    }

    public final LanguageSpec create(String language, String mode) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Provider<LanguageSpec> provider = this.languageSpecMap.get("en-" + Modes.INSTANCE.testMode(mode));
        LanguageSpec languageSpec = provider != null ? provider.get() : null;
        if (languageSpec != null) {
            return languageSpec;
        }
        throw new IllegalStateException("Language spec is not loaded".toString());
    }
}
