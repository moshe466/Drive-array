package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.IllegalResourceException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ResourceAccessException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker;
import java.io.InputStream;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EngineSpecFactory.kt */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineSpecFactory;", JsonProperty.USE_DEFAULT_NAME, "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "activeLanguageCodeChecker", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/ActiveLanguageCodeChecker;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;Lcom/samsung/sr/nmt/t2t/translator/core/utils/ActiveLanguageCodeChecker;)V", "create", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", ExternalLanguagePackAssetLoader.PATH_QUERY, "getSpecPath", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EngineSpecFactory {
    private final ActiveLanguageCodeChecker activeLanguageCodeChecker;
    private final FileLoader fileLoader;

    @Inject
    public EngineSpecFactory(FileLoader fileLoader, ActiveLanguageCodeChecker activeLanguageCodeChecker) {
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(activeLanguageCodeChecker, "activeLanguageCodeChecker");
        this.fileLoader = fileLoader;
        this.activeLanguageCodeChecker = activeLanguageCodeChecker;
    }

    public final EngineSpec create(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return create(sourceLanguage, targetLanguage, getSpecPath(sourceLanguage, targetLanguage));
    }

    public final EngineSpec create(String sourceLanguage, String targetLanguage, String path) {
        Object m107constructorimpl;
        Object readValue;
        EngineSpec engineSpec;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.registerModule(new KotlinModule.Builder().build());
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream authorizedInputStream = this.fileLoader.getAuthorizedInputStream(sourceLanguage, targetLanguage, path);
        EngineSpec engineSpec2 = null;
        if (authorizedInputStream != null) {
            InputStream inputStream = authorizedInputStream;
            try {
                InputStream inputStream2 = inputStream;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    EngineSpecFactory engineSpecFactory = this;
                    readValue = objectMapper.readValue(inputStream2, (Class<Object>) EngineSpec.class);
                    engineSpec = (EngineSpec) readValue;
                    String sourceLanguage2 = engineSpec.getSourceLanguage();
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String lowerCase = sourceLanguage2.toLowerCase(US);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    engineSpec.setSourceLanguage(lowerCase);
                    String targetLanguage2 = engineSpec.getTargetLanguage();
                    Locale US2 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US2, "US");
                    String lowerCase2 = targetLanguage2.toLowerCase(US2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                    engineSpec.setTargetLanguage(lowerCase2);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
                }
                if (!this.activeLanguageCodeChecker.isValid(engineSpec.getSourceLanguage())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (this.activeLanguageCodeChecker.isValid(engineSpec.getTargetLanguage())) {
                    m107constructorimpl = Result.m107constructorimpl((EngineSpec) readValue);
                    Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(m107constructorimpl);
                    if (m110exceptionOrNullimpl == null) {
                        EngineSpec engineSpec3 = (EngineSpec) m107constructorimpl;
                        CloseableKt.closeFinally(inputStream, null);
                        engineSpec2 = engineSpec3;
                    } else {
                        String message = m110exceptionOrNullimpl.getMessage();
                        if (message == null) {
                            message = "Failed to load file | " + sourceLanguage + " | " + targetLanguage + " | " + path;
                        }
                        throw new IllegalResourceException(message);
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } finally {
            }
        }
        if (engineSpec2 != null) {
            return engineSpec2;
        }
        throw new ResourceAccessException("Failed to load file | " + sourceLanguage + " | " + targetLanguage + " | " + path);
    }

    private final String getSpecPath(String sourceLanguage, String targetLanguage) {
        return "configs/" + sourceLanguage + "2" + targetLanguage + ".yaml";
    }
}
