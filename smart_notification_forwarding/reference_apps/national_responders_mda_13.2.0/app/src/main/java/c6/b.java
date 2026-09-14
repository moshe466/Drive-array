package c6;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import il.org.mda.health.R;
import java.util.List;
import w6.l0;

/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    Context f4396f;

    /* renamed from: g, reason: collision with root package name */
    List<com.groboot.mdaemergency.enums.b> f4397g = com.groboot.mdaemergency.enums.b.toList();

    /* renamed from: h, reason: collision with root package name */
    LayoutInflater f4398h;

    /* renamed from: i, reason: collision with root package name */
    a f4399i;

    /* renamed from: j, reason: collision with root package name */
    com.groboot.mdaemergency.enums.b f4400j;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.groboot.mdaemergency.enums.b bVar);
    }

    /* renamed from: c6.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0078b {

        /* renamed from: a, reason: collision with root package name */
        TextView f4401a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f4402b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f4403c;

        C0078b(b bVar) {
        }
    }

    public b(Context context, com.groboot.mdaemergency.enums.b bVar, a aVar) {
        this.f4396f = context;
        this.f4398h = LayoutInflater.from(context);
        this.f4399i = aVar;
        this.f4400j = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.groboot.mdaemergency.enums.b bVar, View view) {
        this.f4399i.a(bVar);
        this.f4400j = bVar;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4397g.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View view2;
        C0078b c0078b;
        if (view == null) {
            c0078b = new C0078b(this);
            view2 = this.f4398h.inflate(R.layout.listview_item, viewGroup, false);
            c0078b.f4401a = (TextView) view2.findViewById(R.id.tv_text);
            c0078b.f4402b = (ImageView) view2.findViewById(R.id.iv_icon);
            c0078b.f4403c = (ImageView) view2.findViewById(R.id.img_choose);
            view2.setTag(c0078b);
        } else {
            view2 = view;
            c0078b = (C0078b) view.getTag();
        }
        final com.groboot.mdaemergency.enums.b bVar = this.f4397g.get(i10);
        c0078b.f4401a.setText(bVar.getResTitle());
        TextView textView = c0078b.f4401a;
        Context context = this.f4396f;
        com.groboot.mdaemergency.enums.b bVar2 = com.groboot.mdaemergency.enums.b.NOT_AVAILABLE;
        int i11 = R.color.red_text;
        textView.setTextColor(androidx.core.content.a.d(context, bVar == bVar2 ? R.color.disabled_color : R.color.red_text));
        c0078b.f4402b.setImageDrawable(l0.G(this.f4396f, "user_status_" + bVar.getNum()));
        ImageView imageView = c0078b.f4402b;
        Context context2 = this.f4396f;
        if (bVar == bVar2) {
            i11 = R.color.grey;
        }
        imageView.setColorFilter(androidx.core.content.a.d(context2, i11), PorterDuff.Mode.SRC_IN);
        c0078b.f4403c.setVisibility(bVar != this.f4400j ? 4 : 0);
        view2.setOnClickListener(new View.OnClickListener() { // from class: c6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                b.this.b(bVar, view3);
            }
        });
        return view2;
    }
}
