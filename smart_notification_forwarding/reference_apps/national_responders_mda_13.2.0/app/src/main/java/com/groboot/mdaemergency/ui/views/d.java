package com.groboot.mdaemergency.ui.views;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import il.org.mda.health.R;
import w6.l0;

/* loaded from: classes.dex */
public class d extends ArrayAdapter<Kv> {

    /* renamed from: f, reason: collision with root package name */
    boolean f8442f;

    /* renamed from: g, reason: collision with root package name */
    boolean[] f8443g;

    /* renamed from: h, reason: collision with root package name */
    b f8444h;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int U = l0.U(view.getTag().toString());
            if (d.this.getItem(U).key != -999) {
                d.this.f8443g[U] = !r0[U];
            }
            d dVar = d.this;
            b bVar = dVar.f8444h;
            if (bVar != null) {
                bVar.a(dVar.getItem(U), d.this.f8443g[U], U);
            }
            d.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Kv kv, boolean z10, int i10);
    }

    public d(Context context, KvTable kvTable, boolean[] zArr, boolean z10, b bVar) {
        super(context, R.layout.kv_item_radio, kvTable);
        this.f8442f = z10;
        this.f8443g = zArr;
        this.f8444h = bVar;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        CheckBox checkBox;
        boolean z10;
        Kv item = getItem(i10);
        if (e.p2(item)) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.kv_item_caption, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tv_caption)).setText(item.value);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.kv_item_radio, (ViewGroup) null);
        inflate2.findViewById(R.id.ll_main).setOnClickListener(new a());
        if (item.key != -999 || item.value.equals(Kv.OTHER_TEXT)) {
            ((TextView) inflate2.findViewById(R.id.ksv_item_value)).setText(item.value);
            checkBox = (CheckBox) inflate2.findViewById(R.id.ksv_item_selected);
            z10 = this.f8443g[i10];
        } else {
            ((TextView) inflate2.findViewById(R.id.ksv_item_value)).setText(Html.fromHtml(l0.N("אחר: ") + item.value));
            checkBox = (CheckBox) inflate2.findViewById(R.id.ksv_item_selected);
            z10 = true;
        }
        checkBox.setChecked(z10);
        inflate2.findViewById(R.id.ll_main).setTag(i10 + "");
        if (this.f8442f) {
            ((TextView) inflate2.findViewById(R.id.ksv_item_key)).setText(item.key + "");
        } else {
            ((TextView) inflate2.findViewById(R.id.ksv_item_key)).setText("");
        }
        return inflate2;
    }
}
