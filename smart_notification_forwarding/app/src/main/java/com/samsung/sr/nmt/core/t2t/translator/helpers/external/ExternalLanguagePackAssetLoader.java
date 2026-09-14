package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.AndroidFileDescriptorContainer;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.RawFileDescriptor;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalLanguagePackAssetLoader.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\"\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ExternalLanguagePackAssetLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "languagePackManager", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/LanguagePackManager;", "packageHash", JsonProperty.USE_DEFAULT_NAME, "contextExtension", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ContextExtension;", "hashCalculator", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/HashCalculator;", "uriFactory", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/UriFactory;", "(Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/LanguagePackManager;Ljava/lang/String;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ContextExtension;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/HashCalculator;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/UriFactory;)V", "clearCache", JsonProperty.USE_DEFAULT_NAME, "createURI", "Landroid/net/Uri;", "authority", ExternalLanguagePackAssetLoader.PATH_QUERY, "existResource", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", "getAssetFileDescriptor", "Landroid/content/res/AssetFileDescriptor;", "getAuthority", "getInputStream", "Ljava/io/InputStream;", "getRawFileDescriptor", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/RawFileDescriptor;", "getResourcePackageName", "getVersion", "isValidResourcePackage", "Companion", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExternalLanguagePackAssetLoader extends FileLoader {
    public static final String PATH_QUERY = "path";
    private final ContextExtension contextExtension;
    private final HashCalculator hashCalculator;
    private final LanguagePackManager languagePackManager;
    private final String packageHash;
    private final UriFactory uriFactory;

    public ExternalLanguagePackAssetLoader(LanguagePackManager languagePackManager, String packageHash, ContextExtension contextExtension, HashCalculator hashCalculator, UriFactory uriFactory) {
        Intrinsics.checkNotNullParameter(languagePackManager, "languagePackManager");
        Intrinsics.checkNotNullParameter(packageHash, "packageHash");
        Intrinsics.checkNotNullParameter(contextExtension, "contextExtension");
        Intrinsics.checkNotNullParameter(hashCalculator, "hashCalculator");
        Intrinsics.checkNotNullParameter(uriFactory, "uriFactory");
        this.languagePackManager = languagePackManager;
        this.packageHash = packageHash;
        this.contextExtension = contextExtension;
        this.hashCalculator = hashCalculator;
        this.uriFactory = uriFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b A[LOOP:0: B:6:0x0023->B:13:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[SYNTHETIC] */
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isValidResourcePackage(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "sourceLanguage"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "targetLanguage"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r10 = r9.getResourcePackageName(r10, r11)
            java.lang.String r11 = "com.samsung.android.nmt.apps.t2t.languagepack"
            r0 = 0
            r1 = 2
            r2 = 0
            boolean r11 = kotlin.text.StringsKt.startsWith$default(r10, r11, r0, r1, r2)
            r3 = 1
            if (r11 == 0) goto L1b
            return r3
        L1b:
            com.samsung.sr.nmt.core.t2t.translator.helpers.external.ContextExtension r11 = r9.contextExtension
            android.content.pm.Signature[] r10 = r11.getPackageSignatures(r10)
            int r11 = r10.length
            r4 = r0
        L23:
            if (r4 >= r11) goto L5e
            r5 = r10[r4]
            com.samsung.sr.nmt.core.t2t.translator.helpers.external.HashCalculator r6 = r9.hashCalculator
            byte[] r7 = r5.toByteArray()
            java.lang.String r8 = "toByteArray(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.String r6 = com.samsung.sr.nmt.core.t2t.translator.helpers.external.HashCalculator.getHash$default(r6, r7, r2, r1, r2)
            java.lang.String r7 = r9.packageHash
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 != 0) goto L56
            com.samsung.sr.nmt.core.t2t.translator.helpers.external.HashCalculator r6 = r9.hashCalculator
            byte[] r5 = r5.toByteArray()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            java.lang.String r5 = com.samsung.sr.nmt.core.t2t.translator.helpers.external.HashCalculator.getHash$default(r6, r5, r2, r1, r2)
            java.lang.String r6 = "4lrqkFQpAU+HdHjmui7noPB6ZTnAGMoPZBRU2UCgOkQ="
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L54
            goto L56
        L54:
            r5 = r0
            goto L57
        L56:
            r5 = r3
        L57:
            if (r5 == 0) goto L5b
            r0 = r3
            goto L5e
        L5b:
            int r4 = r4 + 1
            goto L23
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader.isValidResourcePackage(java.lang.String, java.lang.String):boolean");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public String getResourcePackageName(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return this.languagePackManager.getResourcePackageName(sourceLanguage, targetLanguage);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public boolean existResource(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return this.languagePackManager.existResource(sourceLanguage, targetLanguage);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public InputStream getInputStream(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(sourceLanguage, targetLanguage, path);
        return assetFileDescriptor != null ? assetFileDescriptor.createInputStream() : null;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public RawFileDescriptor getRawFileDescriptor(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(sourceLanguage, targetLanguage, path);
        if (assetFileDescriptor == null) {
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptor = assetFileDescriptor.getParcelFileDescriptor();
        Intrinsics.checkNotNullExpressionValue(parcelFileDescriptor, "getParcelFileDescriptor(...)");
        return new RawFileDescriptor(new AndroidFileDescriptorContainer(parcelFileDescriptor), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    private final AssetFileDescriptor getAssetFileDescriptor(String sourceLanguage, String targetLanguage, String path) {
        Object m107constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ExternalLanguagePackAssetLoader externalLanguagePackAssetLoader = this;
            ContentResolver contentResolver = this.contextExtension.getContentResolver();
            r0 = contentResolver != null ? contentResolver.openAssetFileDescriptor(createURI(getAuthority(sourceLanguage, targetLanguage), path), JsonProperty.USE_DEFAULT_NAME, new CancellationSignal()) : null;
            m107constructorimpl = Result.m107constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(m107constructorimpl);
        if (m110exceptionOrNullimpl != null) {
            m110exceptionOrNullimpl.printStackTrace();
            if (r0 != null) {
                r0.close();
            }
        }
        Result.m113isFailureimpl(m107constructorimpl);
        return r0;
    }

    private final String getAuthority(String sourceLanguage, String targetLanguage) {
        return this.languagePackManager.getAuthority(sourceLanguage, targetLanguage);
    }

    public final Uri createURI(String authority, String path) {
        Intrinsics.checkNotNullParameter(authority, "authority");
        Intrinsics.checkNotNullParameter(path, "path");
        Uri build = this.uriFactory.parse("content://" + authority).buildUpon().appendQueryParameter(PATH_QUERY, path).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public void clearCache() {
        this.languagePackManager.clearCache();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader
    public String getVersion(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return this.languagePackManager.getVersion(sourceLanguage, targetLanguage);
    }
}
