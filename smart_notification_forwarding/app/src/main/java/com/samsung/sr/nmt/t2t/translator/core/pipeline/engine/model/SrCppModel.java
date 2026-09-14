package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ResourceAccessException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import com.samsung.sr.nmt.t2t.translator.core.utils.RawFileDescriptor;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SrCppModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J&\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/SrCppModel;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/Model;", "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "environmentHelper", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;", "srCppModelJni", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/SrCppModelJni;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/SrCppModelJni;)V", "clear", JsonProperty.USE_DEFAULT_NAME, "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", "loadByFileDescriptor", "loadByInputStream", "translate", JsonProperty.USE_DEFAULT_NAME, "idList", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "batchSize", "verbose", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SrCppModel implements Model {
    private final EngineSpec engineSpec;
    private final EnvironmentHelper environmentHelper;
    private final FileLoader fileLoader;
    private final SrCppModelJni srCppModelJni;

    public SrCppModel(EngineSpec engineSpec, FileLoader fileLoader, EnvironmentHelper environmentHelper, SrCppModelJni srCppModelJni) {
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(environmentHelper, "environmentHelper");
        Intrinsics.checkNotNullParameter(srCppModelJni, "srCppModelJni");
        this.engineSpec = engineSpec;
        this.fileLoader = fileLoader;
        this.environmentHelper = environmentHelper;
        this.srCppModelJni = srCppModelJni;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.Model
    public void load() {
        if (isLoaded()) {
            return;
        }
        if (this.environmentHelper.getUsingInputStreamInsteadDescriptor()) {
            loadByInputStream();
        } else {
            loadByFileDescriptor();
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.Model
    public boolean isLoaded() {
        return this.srCppModelJni.isLoaded();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.Model
    public int[] translate(List<Integer> idList, int batchSize, boolean verbose) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        return this.srCppModelJni.translate(CollectionsKt.toIntArray(idList), batchSize);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.Model
    public void clear() {
        this.srCppModelJni.clear();
    }

    private final void loadByFileDescriptor() {
        Unit unit;
        RawFileDescriptor authorizedRawFileDescriptor = this.fileLoader.getAuthorizedRawFileDescriptor(this.engineSpec.getSourceLanguage(), this.engineSpec.getTargetLanguage(), this.engineSpec.getModelPath());
        Unit unit2 = null;
        if (authorizedRawFileDescriptor != null) {
            RawFileDescriptor rawFileDescriptor = authorizedRawFileDescriptor;
            try {
                RawFileDescriptor rawFileDescriptor2 = rawFileDescriptor;
                RawFileDescriptor authorizedRawFileDescriptor2 = this.fileLoader.getAuthorizedRawFileDescriptor(this.engineSpec.getSourceLanguage(), this.engineSpec.getTargetLanguage(), this.engineSpec.getHParamsPath());
                if (authorizedRawFileDescriptor2 != null) {
                    rawFileDescriptor = authorizedRawFileDescriptor2;
                    try {
                        RawFileDescriptor rawFileDescriptor3 = rawFileDescriptor;
                        this.srCppModelJni.load(rawFileDescriptor2.getFileDescriptorContainer().getFd(), rawFileDescriptor2.getOffSet(), rawFileDescriptor2.getLength(), rawFileDescriptor3.getFileDescriptorContainer().getFd(), rawFileDescriptor3.getOffSet(), rawFileDescriptor3.getLength(), this.environmentHelper.isExynosCpu(), this.engineSpec.getMaxInputLength(), this.engineSpec.getMaxOutputLength(), this.engineSpec.getModelType());
                        Unit unit3 = Unit.INSTANCE;
                        CloseableKt.closeFinally(rawFileDescriptor, null);
                        unit = Unit.INSTANCE;
                    } finally {
                    }
                } else {
                    unit = null;
                }
                CloseableKt.closeFinally(rawFileDescriptor, null);
                unit2 = unit;
            } finally {
            }
        }
        if (unit2 != null) {
            return;
        }
        throw new ResourceAccessException("Failed to access resource by FD | " + this.engineSpec.getSourceLanguage() + "2" + this.engineSpec.getTargetLanguage() + " | modelPath " + this.engineSpec.getModelPath() + " | hParamsPath " + this.engineSpec.getHParamsPath());
    }

    private final void loadByInputStream() {
        Unit unit;
        InputStream authorizedInputStream = this.fileLoader.getAuthorizedInputStream(this.engineSpec.getSourceLanguage(), this.engineSpec.getTargetLanguage(), this.engineSpec.getModelPath());
        Unit unit2 = null;
        if (authorizedInputStream != null) {
            InputStream inputStream = authorizedInputStream;
            try {
                InputStream inputStream2 = inputStream;
                InputStream authorizedInputStream2 = this.fileLoader.getAuthorizedInputStream(this.engineSpec.getSourceLanguage(), this.engineSpec.getTargetLanguage(), this.engineSpec.getHParamsPath());
                if (authorizedInputStream2 != null) {
                    inputStream = authorizedInputStream2;
                    try {
                        this.srCppModelJni.load(ByteStreamsKt.readBytes(inputStream2), ByteStreamsKt.readBytes(inputStream), this.environmentHelper.isExynosCpu(), this.engineSpec.getMaxInputLength(), this.engineSpec.getMaxOutputLength(), this.engineSpec.getModelType());
                        Unit unit3 = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                        unit = Unit.INSTANCE;
                    } finally {
                    }
                } else {
                    unit = null;
                }
                CloseableKt.closeFinally(inputStream, null);
                unit2 = unit;
            } finally {
            }
        }
        if (unit2 != null) {
            return;
        }
        throw new ResourceAccessException("Failed to access resource by stream | " + this.engineSpec.getSourceLanguage() + "2" + this.engineSpec.getTargetLanguage() + " | modelPath " + this.engineSpec.getModelPath() + " | hParamsPath " + this.engineSpec.getHParamsPath());
    }
}
