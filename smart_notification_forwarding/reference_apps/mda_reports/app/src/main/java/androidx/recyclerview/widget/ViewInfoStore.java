package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewInfoStore {
    private static final boolean DEBUG = false;

    @VisibleForTesting
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> a = new SimpleArrayMap<>();

    @VisibleForTesting
    final LongSparseArray<RecyclerView.ViewHolder> b = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InfoRecord {
        static Pools.Pool<InfoRecord> d = new Pools.SimplePool(20);
        int a;

        @Nullable
        RecyclerView.ItemAnimator.ItemHolderInfo b;

        @Nullable
        RecyclerView.ItemAnimator.ItemHolderInfo c;

        private InfoRecord() {
        }

        static void a() {
            do {
            } while (d.acquire() != null);
        }

        static void a(InfoRecord infoRecord) {
            infoRecord.a = 0;
            infoRecord.b = null;
            infoRecord.c = null;
            d.release(infoRecord);
        }

        static InfoRecord b() {
            InfoRecord acquire = d.acquire();
            return acquire == null ? new InfoRecord() : acquire;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processDisappeared(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processPersistent(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void unused(RecyclerView.ViewHolder viewHolder);
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int i) {
        InfoRecord valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int indexOfKey = this.a.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (valueAt = this.a.valueAt(indexOfKey)) != null) {
            int i2 = valueAt.a;
            if ((i2 & i) != 0) {
                valueAt.a = (i ^ (-1)) & i2;
                if (i == 4) {
                    itemHolderInfo = valueAt.b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    itemHolderInfo = valueAt.c;
                }
                if ((valueAt.a & 12) == 0) {
                    this.a.removeAt(indexOfKey);
                    InfoRecord.a(valueAt);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ViewHolder a(long j) {
        return this.b.get(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.a.clear();
        this.b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, RecyclerView.ViewHolder viewHolder) {
        this.b.put(j, viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.a.put(viewHolder, infoRecord);
        }
        infoRecord.a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.a.put(viewHolder, infoRecord);
        }
        infoRecord.a |= 2;
        infoRecord.b = itemHolderInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ProcessCallback processCallback) {
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder keyAt = this.a.keyAt(size);
            InfoRecord removeAt = this.a.removeAt(size);
            int i = removeAt.a;
            if ((i & 3) != 3) {
                if ((i & 1) != 0) {
                    itemHolderInfo = removeAt.b;
                    itemHolderInfo2 = itemHolderInfo != null ? removeAt.c : null;
                } else {
                    if ((i & 14) != 14) {
                        if ((i & 12) == 12) {
                            processCallback.processPersistent(keyAt, removeAt.b, removeAt.c);
                        } else if ((i & 4) != 0) {
                            itemHolderInfo = removeAt.b;
                        } else if ((i & 8) == 0) {
                        }
                        InfoRecord.a(removeAt);
                    }
                    processCallback.processAppeared(keyAt, removeAt.b, removeAt.c);
                    InfoRecord.a(removeAt);
                }
                processCallback.processDisappeared(keyAt, itemHolderInfo, itemHolderInfo2);
                InfoRecord.a(removeAt);
            }
            processCallback.unused(keyAt);
            InfoRecord.a(removeAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        InfoRecord.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.a.put(viewHolder, infoRecord);
        }
        infoRecord.c = itemHolderInfo;
        infoRecord.a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.a.get(viewHolder);
        return (infoRecord == null || (infoRecord.a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.a.put(viewHolder, infoRecord);
        }
        infoRecord.b = itemHolderInfo;
        infoRecord.a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.a.get(viewHolder);
        return (infoRecord == null || (infoRecord.a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public RecyclerView.ItemAnimator.ItemHolderInfo d(RecyclerView.ViewHolder viewHolder) {
        return popFromLayoutStep(viewHolder, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public RecyclerView.ItemAnimator.ItemHolderInfo e(RecyclerView.ViewHolder viewHolder) {
        return popFromLayoutStep(viewHolder, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.a.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RecyclerView.ViewHolder viewHolder) {
        int size = this.b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (viewHolder == this.b.valueAt(size)) {
                this.b.removeAt(size);
                break;
            }
            size--;
        }
        InfoRecord remove = this.a.remove(viewHolder);
        if (remove != null) {
            InfoRecord.a(remove);
        }
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        f(viewHolder);
    }
}
