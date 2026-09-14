package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModelFactory.kt */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/ModelFactory;", JsonProperty.USE_DEFAULT_NAME, "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "environmentHelper", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;)V", "create", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/Model;", "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ModelFactory {
    private final EnvironmentHelper environmentHelper;
    private final FileLoader fileLoader;

    @Inject
    public ModelFactory(FileLoader fileLoader, EnvironmentHelper environmentHelper) {
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(environmentHelper, "environmentHelper");
        this.fileLoader = fileLoader;
        this.environmentHelper = environmentHelper;
    }

    public final Model create(EngineSpec engineSpec) {
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        if (Intrinsics.areEqual(engineSpec.getEngineType(), "SrCpp")) {
            return new SrCppModel(engineSpec, this.fileLoader, this.environmentHelper, new SrCppModelJni());
        }
        throw new IllegalArgumentException("Engine type " + engineSpec.getEngineType() + " is not defined");
    }
}
