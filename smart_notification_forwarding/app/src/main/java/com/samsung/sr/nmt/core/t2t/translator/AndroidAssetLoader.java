package com.samsung.sr.nmt.core.t2t.translator;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.AndroidFileDescriptorContainer;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.RawFileDescriptor;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAssetLoader.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/AndroidAssetLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getRawFileDescriptor", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/RawFileDescriptor;", "filePath", JsonProperty.USE_DEFAULT_NAME, "open", "Ljava/io/InputStream;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidAssetLoader implements AssetLoader {
    private final Context context;

    public AndroidAssetLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader
    public InputStream open(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        InputStream open = this.context.getAssets().open(filePath);
        Intrinsics.checkNotNullExpressionValue(open, "open(...)");
        return open;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader
    public RawFileDescriptor getRawFileDescriptor(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        AssetFileDescriptor openFd = this.context.getAssets().openFd(filePath);
        Intrinsics.checkNotNullExpressionValue(openFd, "openFd(...)");
        ParcelFileDescriptor parcelFileDescriptor = openFd.getParcelFileDescriptor();
        Intrinsics.checkNotNullExpressionValue(parcelFileDescriptor, "getParcelFileDescriptor(...)");
        return new RawFileDescriptor(new AndroidFileDescriptorContainer(parcelFileDescriptor), openFd.getStartOffset(), openFd.getLength());
    }
}
