package com.samsung.sr.nmt.t2t.translator.core.pipeline.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.Sequence;

/* compiled from: DataExchanger.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H$J\b\u0010\u0011\u001a\u00020\u0007H\u0004J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/DataExchanger;", "T", "C", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/DataKeeper;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/DataRecover;", "()V", "dataCounter", JsonProperty.USE_DEFAULT_NAME, "dataStorage", JsonProperty.USE_DEFAULT_NAME, "storageStream", "Lkotlin/sequences/Sequence;", "getStorageStream", "()Lkotlin/sequences/Sequence;", "generateDataTag", JsonProperty.USE_DEFAULT_NAME, "currentDataCount", "getCurrentDataCount", "keep", "data", "(Ljava/lang/Object;)Ljava/lang/String;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class DataExchanger<T, C> implements DataKeeper<T>, DataRecover<C> {
    private int dataCounter;
    private final List<T> dataStorage;
    private final Sequence<T> storageStream;

    protected abstract String generateDataTag(int currentDataCount);

    public DataExchanger() {
        ArrayList arrayList = new ArrayList();
        this.dataStorage = arrayList;
        this.storageStream = CollectionsKt.asSequence(arrayList);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataKeeper
    public String keep(T data) {
        this.dataStorage.add(data);
        int i = this.dataCounter;
        this.dataCounter = i + 1;
        return generateDataTag(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getCurrentDataCount, reason: from getter */
    public final int getDataCounter() {
        return this.dataCounter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Sequence<T> getStorageStream() {
        return this.storageStream;
    }
}
