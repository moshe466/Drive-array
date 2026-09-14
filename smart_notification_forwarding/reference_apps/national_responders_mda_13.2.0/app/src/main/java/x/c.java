package x;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: n, reason: collision with root package name */
    private int f15384n;

    /* renamed from: o, reason: collision with root package name */
    private int f15385o;

    /* renamed from: p, reason: collision with root package name */
    private LayoutInflater f15386p;

    @Deprecated
    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f15385o = i10;
        this.f15384n = i10;
        this.f15386p = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // x.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15386p.inflate(this.f15385o, viewGroup, false);
    }

    @Override // x.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15386p.inflate(this.f15384n, viewGroup, false);
    }
}
