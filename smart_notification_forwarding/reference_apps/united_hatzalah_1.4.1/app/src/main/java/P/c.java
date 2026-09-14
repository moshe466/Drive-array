package P;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import m.f1;

/* loaded from: classes.dex */
public abstract class c extends BaseAdapter implements Filterable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1552a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1553b;

    /* renamed from: c, reason: collision with root package name */
    public Cursor f1554c;

    /* renamed from: d, reason: collision with root package name */
    public int f1555d;

    /* renamed from: e, reason: collision with root package name */
    public a f1556e;

    /* renamed from: f, reason: collision with root package name */
    public b f1557f;

    /* renamed from: j, reason: collision with root package name */
    public d f1558j;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f1554c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.f1556e;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                b bVar = this.f1557f;
                if (bVar != null) {
                    cursor2.unregisterDataSetObserver(bVar);
                }
            }
            this.f1554c = cursor;
            if (cursor != null) {
                a aVar2 = this.f1556e;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                b bVar2 = this.f1557f;
                if (bVar2 != null) {
                    cursor.registerDataSetObserver(bVar2);
                }
                this.f1555d = cursor.getColumnIndexOrThrow("_id");
                this.f1552a = true;
                notifyDataSetChanged();
            } else {
                this.f1555d = -1;
                this.f1552a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (this.f1552a && (cursor = this.f1554c) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f1552a) {
            this.f1554c.moveToPosition(i);
            if (view == null) {
                f1 f1Var = (f1) this;
                view = f1Var.f5652m.inflate(f1Var.f5651l, viewGroup, false);
            }
            a(view, this.f1554c);
            return view;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [P.d, android.widget.Filter] */
    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f1558j == null) {
            ?? filter = new Filter();
            filter.f1559a = this;
            this.f1558j = filter;
        }
        return this.f1558j;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Cursor cursor;
        if (this.f1552a && (cursor = this.f1554c) != null) {
            cursor.moveToPosition(i);
            return this.f1554c;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        Cursor cursor;
        if (!this.f1552a || (cursor = this.f1554c) == null || !cursor.moveToPosition(i)) {
            return 0L;
        }
        return this.f1554c.getLong(this.f1555d);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f1552a) {
            if (this.f1554c.moveToPosition(i)) {
                if (view == null) {
                    view = d(viewGroup);
                }
                a(view, this.f1554c);
                return view;
            }
            throw new IllegalStateException(e0.a.c(i, "couldn't move cursor to position "));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}
