package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> a;
    private final AsyncListDiffer.ListListener<T> mListener;

    /* renamed from: androidx.recyclerview.widget.ListAdapter$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements AsyncListDiffer.ListListener<T> {
        final /* synthetic */ ListAdapter a;

        @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
        public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
            this.a.onCurrentListChanged(list, list2);
        }
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.a.getCurrentList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.getCurrentList().size();
    }

    public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void submitList(@Nullable List<T> list) {
        this.a.submitList(list);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        this.a.submitList(list, runnable);
    }
}
