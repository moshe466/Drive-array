package com.groboot.mdaemergency.ptt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.groboot.mdaemergency.ptt.d;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ui.VolumeView;
import il.org.mda.health.R;
import java.util.ArrayList;
import w6.l0;

/* loaded from: classes.dex */
public class b extends BaseAdapter implements Filterable {

    /* renamed from: f, reason: collision with root package name */
    Context f7793f;

    /* renamed from: g, reason: collision with root package name */
    w6.r f7794g;

    /* renamed from: h, reason: collision with root package name */
    w6.r f7795h;

    /* renamed from: i, reason: collision with root package name */
    private h f7796i;

    /* renamed from: k, reason: collision with root package name */
    private LayoutInflater f7798k;

    /* renamed from: l, reason: collision with root package name */
    g f7799l;

    /* renamed from: m, reason: collision with root package name */
    String f7800m;

    /* renamed from: o, reason: collision with root package name */
    f f7802o;

    /* renamed from: j, reason: collision with root package name */
    e f7797j = new e(this, null);

    /* renamed from: n, reason: collision with root package name */
    w6.r f7801n = null;

    /* renamed from: p, reason: collision with root package name */
    String f7803p = "";

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !view.getTag().equals("running")) {
                view.setTag("running");
                view.findViewById(R.id.pb_search).setVisibility(0);
                view.findViewById(R.id.iv_search).setVisibility(8);
                b bVar = b.this;
                bVar.f7802o.a(bVar.f7800m);
            }
        }
    }

    /* renamed from: com.groboot.mdaemergency.ptt.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0108b implements View.OnClickListener {

        /* renamed from: com.groboot.mdaemergency.ptt.b$b$a */
        /* loaded from: classes.dex */
        class a implements p.b0 {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ w6.p f7806a;

            a(w6.p pVar) {
                this.f7806a = pVar;
            }

            @Override // com.groboot.mdaemergency.ptt.p.b0
            public void a() {
                Context context = b.this.f7793f;
                a6.h.j(context, context.getString(R.string.message_ptt_not_available2), true, null);
            }

            @Override // com.groboot.mdaemergency.ptt.p.b0
            public void b(p pVar) {
                pVar.f7903c.e(this.f7806a, w6.q.f15243p);
                b.this.f7799l.a(this.f7806a);
            }
        }

        ViewOnClickListenerC0108b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.d0(b.this.f7793f, new a((w6.p) view.getTag()));
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements p.b0 {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ w6.p f7809a;

            /* renamed from: com.groboot.mdaemergency.ptt.b$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0109a implements Runnable {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ p f7811f;

                RunnableC0109a(p pVar) {
                    this.f7811f = pVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f7811f.f7903c.v(a.this.f7809a, !r1.f15240f);
                    b.this.notifyDataSetChanged();
                }
            }

            a(w6.p pVar) {
                this.f7809a = pVar;
            }

            @Override // com.groboot.mdaemergency.ptt.p.b0
            public void a() {
            }

            @Override // com.groboot.mdaemergency.ptt.p.b0
            public void b(p pVar) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0109a(pVar));
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.d0(b.this.f7793f, new a((w6.p) view.getTag()));
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.groboot.mdaemergency.ptt.d dVar;
            d.e eVar;
            String str = view.getTag() + "";
            if (p.c0().f7903c.n(str)) {
                dVar = p.c0().f7903c;
                eVar = d.e.None;
            } else {
                dVar = p.c0().f7903c;
                eVar = d.e.Alwaze;
            }
            dVar.u(str, eVar);
            b.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    private class e extends Filter {
        private e() {
        }

        /* synthetic */ e(b bVar, a aVar) {
            this();
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            int size;
            String str;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                w6.r rVar = b.this.f7794g;
                filterResults.values = rVar;
                size = rVar.size();
            } else {
                String lowerCase = charSequence.toString().toLowerCase();
                b bVar = b.this;
                w6.r rVar2 = bVar.f7801n;
                if (rVar2 == null) {
                    rVar2 = bVar.f7794g;
                }
                int size2 = rVar2.size();
                w6.r rVar3 = new w6.r();
                for (int i10 = 0; i10 < size2; i10++) {
                    w6.p pVar = rVar2.get(i10);
                    String str2 = pVar.f15238d;
                    if ((str2 != null && str2.indexOf(lowerCase) > -1) || ((str = pVar.f15236b) != null && str.indexOf(lowerCase) > -1)) {
                        rVar3.add(pVar);
                    }
                }
                if (b.this.f7801n == null && rVar3.size() < 14) {
                    w6.p pVar2 = new w6.p();
                    pVar2.f15239e = 22;
                    rVar3.add(pVar2);
                }
                filterResults.values = rVar3;
                size = rVar3.size();
            }
            filterResults.count = size;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (filterResults == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("results=null\n\n");
                sb2.append(g5.c.a(new Throwable()));
            } else {
                b bVar = b.this;
                bVar.f7795h = (w6.r) filterResults.values;
                bVar.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(w6.p pVar);

        void b(String str);
    }

    /* loaded from: classes.dex */
    public enum h {
        AllContacts,
        Favorites,
        Groups,
        LastUsers
    }

    public b(Context context, ArrayList<w6.p> arrayList, g gVar, h hVar, f fVar, a6.f fVar2) {
        this.f7794g = null;
        this.f7795h = null;
        this.f7800m = "";
        this.f7793f = context;
        this.f7799l = gVar;
        w6.r rVar = (w6.r) arrayList.clone();
        this.f7794g = rVar;
        this.f7795h = rVar;
        this.f7796i = hVar;
        this.f7798k = LayoutInflater.from(context);
        this.f7802o = fVar;
        this.f7800m = "";
    }

    public void a(String str) {
        if (l0.l0(str) || this.f7803p.length() > str.length()) {
            this.f7801n = null;
        }
        this.f7800m = str;
        this.f7797j.filter(str);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7795h.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return this.f7797j;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f7795h.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"RestrictedApi"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        ImageView imageView;
        int i11;
        VolumeView volumeView;
        VolumeView.c cVar;
        w6.p pVar = this.f7795h.get(i10);
        int i12 = pVar.f15239e;
        if (i12 == 21) {
            View inflate = this.f7798k.inflate(R.layout.ptt_contact_item_caption, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.tv_caption)).setText(pVar.f15238d);
            return inflate;
        }
        if (i12 == 22) {
            View inflate2 = this.f7798k.inflate(R.layout.ptt_contact_item_server_search, viewGroup, false);
            inflate2.findViewById(R.id.pb_search).setVisibility(8);
            inflate2.findViewById(R.id.iv_search).setVisibility(0);
            ((TextView) inflate2.findViewById(R.id.tv_search)).setText(Html.fromHtml(this.f7793f.getString(R.string.search_by) + l0.O(this.f7800m)));
            inflate2.setOnClickListener(new a());
            return inflate2;
        }
        View inflate3 = this.f7798k.inflate(R.layout.ptt_contact_item_new, viewGroup, false);
        ((TextView) inflate3.findViewById(R.id.tv_name)).setText(Html.fromHtml(l0.P(pVar.f15238d, this.f7800m)));
        ((TextView) inflate3.findViewById(R.id.tv_number)).setText(Html.fromHtml(l0.P(pVar.f15236b, this.f7800m)));
        inflate3.findViewById(R.id.ll_main).setTag(pVar);
        inflate3.findViewById(R.id.ll_main).setOnClickListener(new ViewOnClickListenerC0108b());
        inflate3.findViewById(R.id.iv_available).setVisibility(l0.T(pVar.f15241g) == 1 ? 0 : 8);
        inflate3.findViewById(R.id.iv_favorites).setVisibility(0);
        ((ImageView) inflate3.findViewById(R.id.iv_favorites)).setImageResource(pVar.f15240f ? R.drawable.favorite_new : R.drawable.favorite_gray_new);
        inflate3.findViewById(R.id.iv_favorites).setTag(pVar);
        inflate3.findViewById(R.id.iv_favorites).setOnClickListener(new c());
        int i13 = pVar.f15239e;
        if (i13 == 2) {
            imageView = (ImageView) inflate3.findViewById(R.id.iv_user);
            i11 = R.drawable.users;
        } else if (i13 == 3) {
            imageView = (ImageView) inflate3.findViewById(R.id.iv_user);
            i11 = R.drawable.mda_user;
        } else {
            imageView = (ImageView) inflate3.findViewById(R.id.iv_user);
            i11 = R.drawable.user;
        }
        imageView.setImageResource(i11);
        inflate3.findViewById(R.id.vv_volume).setTag(pVar.f15235a);
        if (this.f7796i == h.Groups) {
            inflate3.findViewById(R.id.vv_volume).setVisibility(0);
            if (p.c0().f7903c.n(pVar.f15235a)) {
                volumeView = (VolumeView) inflate3.findViewById(R.id.vv_volume);
                cVar = VolumeView.c.off;
            } else {
                volumeView = (VolumeView) inflate3.findViewById(R.id.vv_volume);
                cVar = VolumeView.c.on;
            }
            volumeView.setMode(cVar);
            ((VolumeView) inflate3.findViewById(R.id.vv_volume)).setOnClickListener(new d());
        }
        inflate3.findViewById(R.id.iv_available).setTag(pVar.f15235a);
        return inflate3;
    }
}
