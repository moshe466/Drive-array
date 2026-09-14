package com.samsung.sr.nmt.core.t2t.translator.helpers.internal;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.AndroidFileDescriptorContainer;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguagePackKey;
import com.samsung.sr.nmt.t2t.translator.core.utils.RawFileDescriptor;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: InternalAssetLoader.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\f\u001a\u00020\n2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000e\"\u00020\nH\u0002¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/internal/InternalAssetLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearCache", JsonProperty.USE_DEFAULT_NAME, "existResource", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "getFilePath", ExternalLanguagePackAssetLoader.PATH_QUERY, JsonProperty.USE_DEFAULT_NAME, "([Ljava/lang/String;)Ljava/lang/String;", "getInputStream", "Ljava/io/InputStream;", "getRawFileDescriptor", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/RawFileDescriptor;", "getResourcePackageName", "getVersion", "isValidResourcePackage", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class InternalAssetLoader extends FileLoader {
    private final Context context;

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public boolean isValidResourcePackage(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return true;
    }

    public InternalAssetLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public String getResourcePackageName(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNull(packageName);
        return packageName;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public boolean existResource(String sourceLanguage, String targetLanguage) {
        Object m107constructorimpl;
        Boolean bool;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        try {
            Result.Companion companion = Result.INSTANCE;
            InternalAssetLoader internalAssetLoader = this;
            boolean z = true;
            String[] list = this.context.getAssets().list(getFilePath(LanguagePackKey.INSTANCE.get(sourceLanguage, targetLanguage)));
            if (list != null) {
                if (list.length == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            m107constructorimpl = Result.m107constructorimpl(bool);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool2 = (Boolean) (Result.m113isFailureimpl(m107constructorimpl) ? null : m107constructorimpl);
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public InputStream getInputStream(String sourceLanguage, String targetLanguage, String path) {
        Object m107constructorimpl;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            Result.Companion companion = Result.INSTANCE;
            InternalAssetLoader internalAssetLoader = this;
            m107constructorimpl = Result.m107constructorimpl(this.context.getAssets().open(getFilePath(LanguagePackKey.INSTANCE.get(sourceLanguage, targetLanguage), path)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(m107constructorimpl);
        if (m110exceptionOrNullimpl != null) {
            m110exceptionOrNullimpl.printStackTrace();
            Timber.d("Failed to load " + path, new Object[0]);
        }
        if (Result.m113isFailureimpl(m107constructorimpl)) {
            m107constructorimpl = null;
        }
        return (InputStream) m107constructorimpl;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public RawFileDescriptor getRawFileDescriptor(String sourceLanguage, String targetLanguage, String path) {
        Object m107constructorimpl;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            Result.Companion companion = Result.INSTANCE;
            InternalAssetLoader internalAssetLoader = this;
            AssetFileDescriptor openFd = this.context.getAssets().openFd(getFilePath(LanguagePackKey.INSTANCE.get(sourceLanguage, targetLanguage), path));
            ParcelFileDescriptor parcelFileDescriptor = openFd.getParcelFileDescriptor();
            Intrinsics.checkNotNullExpressionValue(parcelFileDescriptor, "getParcelFileDescriptor(...)");
            m107constructorimpl = Result.m107constructorimpl(new RawFileDescriptor(new AndroidFileDescriptorContainer(parcelFileDescriptor), openFd.getStartOffset(), openFd.getLength()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(m107constructorimpl);
        if (m110exceptionOrNullimpl != null) {
            m110exceptionOrNullimpl.printStackTrace();
            Timber.d("Failed to load " + path, new Object[0]);
        }
        if (Result.m113isFailureimpl(m107constructorimpl)) {
            m107constructorimpl = null;
        }
        return (RawFileDescriptor) m107constructorimpl;
    }

    private final String getFilePath(String... path) {
        return ArraysKt.joinToString$default(path, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public void clearCache() {
        Timber.d("[InternalAssetLoader] Cache Cleared", new Object[0]);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public String getVersion(String sourceLanguage, String targetLanguage) {
        byte[] readAllBytes;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        InputStream inputStream = getInputStream(sourceLanguage, targetLanguage, "version");
        if (inputStream == null || (readAllBytes = inputStream.readAllBytes()) == null) {
            return null;
        }
        return readAllBytes.toString();
    }
}
