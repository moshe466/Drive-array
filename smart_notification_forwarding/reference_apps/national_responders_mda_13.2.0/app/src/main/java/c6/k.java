package c6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import il.org.mda.health.R;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k extends ArrayAdapter<a> {

    /* renamed from: f, reason: collision with root package name */
    private final List<a> f4431f;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f4432a;

        /* renamed from: b, reason: collision with root package name */
        private String f4433b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4434c;

        public a() {
            this.f4433b = "";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str, int i10, boolean z10) {
            this();
            y8.k.e(str, "_name");
            this.f4433b = str;
            this.f4432a = i10;
            this.f4434c = z10;
        }

        public /* synthetic */ a(String str, int i10, boolean z10, int i11, y8.g gVar) {
            this(str, i10, (i11 & 4) != 0 ? false : z10);
        }

        public final boolean a() {
            return this.f4434c;
        }

        public final int b() {
            return this.f4432a;
        }

        public final String c() {
            return this.f4433b;
        }

        public final void d(boolean z10) {
            this.f4434c = z10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, List<a> list) {
        super(context, R.layout.hmo_item, list);
        y8.k.e(context, "context");
        y8.k.e(list, "items");
        this.f4431f = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        y8.k.e(viewGroup, "parent");
        if (view == null) {
            view = null;
        }
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.hmo_item, (ViewGroup) null);
            y8.k.d(view, "from(context).inflate(R.layout.hmo_item, null)");
        }
        View findViewById = view.findViewById(R.id.txt_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        View findViewById2 = view.findViewById(R.id.txt_count);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        a aVar = this.f4431f.get(i10);
        ((TextView) findViewById).setText(aVar.c());
        ((TextView) findViewById2).setText(String.valueOf(aVar.b()));
        return view;
    }
}
