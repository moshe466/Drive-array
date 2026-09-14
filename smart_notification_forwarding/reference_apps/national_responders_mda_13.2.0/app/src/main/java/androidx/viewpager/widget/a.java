package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class a {
    public a() {
        new DataSetObservable();
    }

    public abstract void a(ViewGroup viewGroup, int i10, Object obj);

    public abstract void b(ViewGroup viewGroup);

    public abstract int c();

    public int d(Object obj) {
        return -1;
    }

    public float e(int i10) {
        return 1.0f;
    }

    public abstract Object f(ViewGroup viewGroup, int i10);

    public abstract boolean g(View view, Object obj);

    public abstract void h(Parcelable parcelable, ClassLoader classLoader);

    public abstract Parcelable i();

    public abstract void j(ViewGroup viewGroup, int i10, Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(DataSetObserver dataSetObserver) {
        synchronized (this) {
        }
    }

    public abstract void l(ViewGroup viewGroup);
}
