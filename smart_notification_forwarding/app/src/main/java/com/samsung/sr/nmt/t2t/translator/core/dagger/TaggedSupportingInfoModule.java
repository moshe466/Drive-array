package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import dagger.Module;
import dagger.Provides;
import java.util.Map;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaggedSupportingInfoModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TaggedSupportingInfoModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideTaggedSupportingInfo", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", JsonProperty.USE_DEFAULT_NAME, "taggedSupportingInfoFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TaggedSupportingInfoFactory;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class TaggedSupportingInfoModule {
    @Provides
    @Named("tagged-supporting-info")
    public final Map<LanguageDirection, String> provideTaggedSupportingInfo(TaggedSupportingInfoFactory taggedSupportingInfoFactory) {
        Intrinsics.checkNotNullParameter(taggedSupportingInfoFactory, "taggedSupportingInfoFactory");
        return taggedSupportingInfoFactory.create();
    }
}
