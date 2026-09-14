package c6;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.TestsSite;
import com.groboot.mdaemergency.ui.views.c;
import il.org.mda.health.R;
import java.util.List;
import java.util.Objects;
import w6.l0;

/* loaded from: classes.dex */
public final class f extends ArrayAdapter<TestsSite> implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    private final List<TestsSite> f4415f;

    /* renamed from: g, reason: collision with root package name */
    private final String f4416g;

    /* renamed from: h, reason: collision with root package name */
    private final c.a f4417h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, List<TestsSite> list, String str, c.a aVar) {
        super(context, R.layout.hmo_item, list);
        y8.k.e(context, "context");
        y8.k.e(list, "items");
        y8.k.e(str, "innerRedText");
        this.f4415f = list;
        this.f4416g = str;
        this.f4417h = aVar;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        y8.k.e(viewGroup, "parent");
        if (view == null) {
            view = null;
        }
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.site_item, (ViewGroup) null);
            y8.k.d(view, "from(context).inflate(R.layout.site_item, null)");
        }
        TestsSite testsSite = this.f4415f.get(i10);
        int i11 = g5.h.S;
        ((TextView) view.findViewById(i11)).setText(testsSite.getSite().value);
        if (!l0.l0(this.f4416g)) {
            ((TextView) view.findViewById(i11)).setText(Html.fromHtml(l0.P(testsSite.getSite().value, this.f4416g)));
        }
        ((TextView) view.findViewById(g5.h.Q)).setText(String.valueOf(testsSite.getCount()));
        view.setOnClickListener(this);
        view.setTag(testsSite.getSite());
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a aVar = this.f4417h;
        if (aVar == null) {
            return;
        }
        y8.k.b(view);
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.groboot.mdaemergency.models.Kv");
        aVar.h((Kv) tag);
    }
}
