package c6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import il.org.mda.health.R;
import java.util.List;

/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    List<com.groboot.mdaemergency.enums.b> f4404f = com.groboot.mdaemergency.enums.b.toList();

    /* renamed from: g, reason: collision with root package name */
    LayoutInflater f4405g;

    /* renamed from: h, reason: collision with root package name */
    b f4406h;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.enums.b f4407f;

        a(com.groboot.mdaemergency.enums.b bVar) {
            this.f4407f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f4406h.a(this.f4407f);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(com.groboot.mdaemergency.enums.b bVar);
    }

    /* renamed from: c6.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0079c {

        /* renamed from: a, reason: collision with root package name */
        TextView f4409a;

        C0079c(c cVar) {
        }
    }

    public c(Context context, b bVar) {
        this.f4405g = LayoutInflater.from(context);
        this.f4406h = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4404f.size();
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
        C0079c c0079c;
        if (view == null) {
            c0079c = new C0079c(this);
            view2 = this.f4405g.inflate(R.layout.listview_item_old, viewGroup, false);
            c0079c.f4409a = (TextView) view2.findViewById(R.id.title);
            view2.setTag(c0079c);
        } else {
            view2 = view;
            c0079c = (C0079c) view.getTag();
        }
        com.groboot.mdaemergency.enums.b bVar = this.f4404f.get(i10);
        c0079c.f4409a.setText(bVar.getResTitle());
        view2.setOnClickListener(new a(bVar));
        return view2;
    }
}
