package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import android.os.ParcelFileDescriptor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.AndroidFileDescriptorContainer;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguagePackKey;
import com.samsung.sr.nmt.t2t.translator.core.utils.RawFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalFileLoader.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ExternalFileLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "resourceDirectory", "Ljava/io/File;", "parcelFileDescriptorFactory", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ParcelFileDescriptorFactory;", "(Ljava/io/File;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ParcelFileDescriptorFactory;)V", "clearCache", JsonProperty.USE_DEFAULT_NAME, "existResource", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "getDirectory", "getInputStream", "Ljava/io/InputStream;", ExternalLanguagePackAssetLoader.PATH_QUERY, "getRawFileDescriptor", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/RawFileDescriptor;", "getResourcePackageName", "getVersion", "isValidResourcePackage", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExternalFileLoader extends FileLoader {
    private final ParcelFileDescriptorFactory parcelFileDescriptorFactory;
    private final File resourceDirectory;

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public String getResourcePackageName(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return JsonProperty.USE_DEFAULT_NAME;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public boolean isValidResourcePackage(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return true;
    }

    public ExternalFileLoader(File resourceDirectory, ParcelFileDescriptorFactory parcelFileDescriptorFactory) {
        Intrinsics.checkNotNullParameter(resourceDirectory, "resourceDirectory");
        Intrinsics.checkNotNullParameter(parcelFileDescriptorFactory, "parcelFileDescriptorFactory");
        this.resourceDirectory = resourceDirectory;
        this.parcelFileDescriptorFactory = parcelFileDescriptorFactory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if ((r2.length == 0) != false) goto L9;
     */
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean existResource(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "sourceLanguage"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "targetLanguage"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.File r2 = r1.getDirectory(r2, r3)
            java.lang.String[] r2 = r2.list()
            r3 = 1
            if (r2 == 0) goto L1e
            int r2 = r2.length
            r0 = 0
            if (r2 != 0) goto L1b
            r2 = r3
            goto L1c
        L1b:
            r2 = r0
        L1c:
            if (r2 == 0) goto L1f
        L1e:
            r0 = r3
        L1f:
            r2 = r0 ^ 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalFileLoader.existResource(java.lang.String, java.lang.String):boolean");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public InputStream getInputStream(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(getDirectory(sourceLanguage, targetLanguage), path);
        if (file.exists()) {
            return new FileInputStream(file);
        }
        return null;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public RawFileDescriptor getRawFileDescriptor(String sourceLanguage, String targetLanguage, String path) {
        Object m107constructorimpl;
        File file;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            Result.Companion companion = Result.INSTANCE;
            ExternalFileLoader externalFileLoader = this;
            file = new File(getDirectory(sourceLanguage, targetLanguage), path);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        if (!file.exists()) {
            throw new NullPointerException("Raw File does not Exist");
        }
        ParcelFileDescriptor open = this.parcelFileDescriptorFactory.open(file, ParcelFileDescriptorFactory.MODE_READ_ONLY);
        m107constructorimpl = Result.m107constructorimpl(new RawFileDescriptor(new AndroidFileDescriptorContainer(open), 0L, open.getStatSize()));
        Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(m107constructorimpl);
        if (m110exceptionOrNullimpl != null) {
            m110exceptionOrNullimpl.printStackTrace();
        }
        if (Result.m113isFailureimpl(m107constructorimpl)) {
            m107constructorimpl = null;
        }
        return (RawFileDescriptor) m107constructorimpl;
    }

    private final File getDirectory(String sourceLanguage, String targetLanguage) {
        return new File(this.resourceDirectory, LanguagePackKey.INSTANCE.get(sourceLanguage, targetLanguage));
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public void clearCache() {
        System.out.print((Object) JsonProperty.USE_DEFAULT_NAME);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public String getVersion(String sourceLanguage, String targetLanguage) {
        Object m107constructorimpl;
        File file;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        try {
            Result.Companion companion = Result.INSTANCE;
            ExternalFileLoader externalFileLoader = this;
            file = new File(getDirectory(sourceLanguage, targetLanguage), "version");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        if (file.exists()) {
            m107constructorimpl = Result.m107constructorimpl(new FileInputStream(file).readAllBytes().toString());
            if (Result.m113isFailureimpl(m107constructorimpl)) {
                m107constructorimpl = null;
            }
            return (String) m107constructorimpl;
        }
        throw new FileNotFoundException("Version information is not found");
    }
}
