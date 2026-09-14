package x;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import x.b;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: f, reason: collision with root package name */
    protected boolean f15373f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f15374g;

    /* renamed from: h, reason: collision with root package name */
    protected Cursor f15375h;

    /* renamed from: i, reason: collision with root package name */
    protected Context f15376i;

    /* renamed from: j, reason: collision with root package name */
    protected int f15377j;

    /* renamed from: k, reason: collision with root package name */
    protected C0328a f15378k;

    /* renamed from: l, reason: collision with root package name */
    protected DataSetObserver f15379l;

    /* renamed from: m, reason: collision with root package name */
    protected x.b f15380m;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0328a extends ContentObserver {
        C0328a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f15373f = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f15373f = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        f(context, cursor, z10 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor j10 = j(cursor);
        if (j10 != null) {
            j10.close();
        }
    }

    @Override // x.b.a
    public Cursor b() {
        return this.f15375h;
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i10) {
        b bVar;
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f15374g = true;
        } else {
            this.f15374g = false;
        }
        boolean z10 = cursor != null;
        this.f15375h = cursor;
        this.f15373f = z10;
        this.f15376i = context;
        this.f15377j = z10 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i10 & 2) == 2) {
            this.f15378k = new C0328a();
            bVar = new b();
        } else {
            bVar = null;
            this.f15378k = null;
        }
        this.f15379l = bVar;
        if (z10) {
            C0328a c0328a = this.f15378k;
            if (c0328a != null) {
                cursor.registerContentObserver(c0328a);
            }
            DataSetObserver dataSetObserver = this.f15379l;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f15373f || (cursor = this.f15375h) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f15373f) {
            return null;
        }
        this.f15375h.moveToPosition(i10);
        if (view == null) {
            view = g(this.f15376i, this.f15375h, viewGroup);
        }
        e(view, this.f15376i, this.f15375h);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f15380m == null) {
            this.f15380m = new x.b(this);
        }
        return this.f15380m;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f15373f || (cursor = this.f15375h) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f15375h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        if (this.f15373f && (cursor = this.f15375h) != null && cursor.moveToPosition(i10)) {
            return this.f15375h.getLong(this.f15377j);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f15373f) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f15375h.moveToPosition(i10)) {
            if (view == null) {
                view = h(this.f15376i, this.f15375h, viewGroup);
            }
            e(view, this.f15376i, this.f15375h);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i10);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f15374g || (cursor = this.f15375h) == null || cursor.isClosed()) {
            return;
        }
        this.f15373f = this.f15375h.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f15375h;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0328a c0328a = this.f15378k;
            if (c0328a != null) {
                cursor2.unregisterContentObserver(c0328a);
            }
            DataSetObserver dataSetObserver = this.f15379l;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f15375h = cursor;
        if (cursor != null) {
            C0328a c0328a2 = this.f15378k;
            if (c0328a2 != null) {
                cursor.registerContentObserver(c0328a2);
            }
            DataSetObserver dataSetObserver2 = this.f15379l;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f15377j = cursor.getColumnIndexOrThrow("_id");
            this.f15373f = true;
            notifyDataSetChanged();
        } else {
            this.f15377j = -1;
            this.f15373f = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
