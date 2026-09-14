package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.UnauthorizedResourceException;
import com.samsung.sr.nmt.t2t.translator.core.utils.RawFileDescriptor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* compiled from: FileLoader.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ \u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&J\"\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u0016"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", JsonProperty.USE_DEFAULT_NAME, "()V", "clearCache", JsonProperty.USE_DEFAULT_NAME, "existResource", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "getAuthorizedInputStream", "Ljava/io/InputStream;", ExternalLanguagePackAssetLoader.PATH_QUERY, "getAuthorizedRawFileDescriptor", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/RawFileDescriptor;", "getAuthorizedStringLines", JsonProperty.USE_DEFAULT_NAME, "getInputStream", "getRawFileDescriptor", "getResourcePackageName", "getVersion", "isValidResourcePackage", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class FileLoader {
    public abstract void clearCache();

    public abstract boolean existResource(String sourceLanguage, String targetLanguage);

    public abstract InputStream getInputStream(String sourceLanguage, String targetLanguage, String path);

    public abstract RawFileDescriptor getRawFileDescriptor(String sourceLanguage, String targetLanguage, String path);

    public abstract String getResourcePackageName(String sourceLanguage, String targetLanguage);

    public abstract String getVersion(String sourceLanguage, String targetLanguage);

    public abstract boolean isValidResourcePackage(String sourceLanguage, String targetLanguage);

    public final InputStream getAuthorizedInputStream(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!isValidResourcePackage(sourceLanguage, targetLanguage)) {
            throw new UnauthorizedResourceException("Unauthorized resources | " + sourceLanguage + " | " + targetLanguage + " | " + path);
        }
        return getInputStream(sourceLanguage, targetLanguage, path);
    }

    public final RawFileDescriptor getAuthorizedRawFileDescriptor(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!isValidResourcePackage(sourceLanguage, targetLanguage)) {
            throw new UnauthorizedResourceException(null, 1, null);
        }
        return getRawFileDescriptor(sourceLanguage, targetLanguage, path);
    }

    public final List<String> getAuthorizedStringLines(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        InputStream authorizedInputStream = getAuthorizedInputStream(sourceLanguage, targetLanguage, path);
        if (authorizedInputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = authorizedInputStream;
        try {
            Reader inputStreamReader = new InputStreamReader(bufferedReader, Charsets.UTF_8);
            BufferedReader bufferedReader2 = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            bufferedReader = bufferedReader2 instanceof BufferedReader ? bufferedReader2 : new BufferedReader(bufferedReader2, 8192);
            try {
                List<String> list = SequencesKt.toList(TextStreamsKt.lineSequence(bufferedReader));
                CloseableKt.closeFinally(bufferedReader, null);
                CloseableKt.closeFinally(bufferedReader, null);
                return list;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
            }
        }
    }
}
