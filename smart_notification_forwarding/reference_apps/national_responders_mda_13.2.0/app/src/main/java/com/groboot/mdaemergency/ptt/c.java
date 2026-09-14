package com.groboot.mdaemergency.ptt;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.groboot.mdaemergency.ptt.b;
import com.groboot.mdaemergency.ptt.p;
import il.org.mda.health.R;
import w6.l0;

/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    Context f7815f;

    /* renamed from: g, reason: collision with root package name */
    w6.s f7816g;

    /* renamed from: h, reason: collision with root package name */
    private LayoutInflater f7817h;

    /* renamed from: i, reason: collision with root package name */
    b.g f7818i;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: com.groboot.mdaemergency.ptt.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0110a implements p.b0 {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ w6.q f7820a;

            /* renamed from: com.groboot.mdaemergency.ptt.c$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0111a implements Runnable {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ p f7822f;

                RunnableC0111a(p pVar) {
                    this.f7822f = pVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f7822f.f7903c.e(C0110a.this.f7820a, w6.q.f15243p);
                    C0110a c0110a = C0110a.this;
                    c.this.f7818i.a(c0110a.f7820a);
                }
            }

            C0110a(w6.q qVar) {
                this.f7820a = qVar;
            }

            @Override // com.groboot.mdaemergency.ptt.p.b0
            public void a() {
                Context context = c.this.f7815f;
                a6.h.j(context, context.getString(R.string.message_ptt_not_available2), true, null);
            }

            @Override // com.groboot.mdaemergency.ptt.p.b0
            public void b(p pVar) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0111a(pVar));
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null) {
                return;
            }
            p.d0(c.this.f7815f, new C0110a((w6.q) view.getTag()));
        }
    }

    public c(Context context, w6.s sVar, b.g gVar) {
        this.f7816g = null;
        this.f7815f = context;
        this.f7818i = gVar;
        this.f7817h = LayoutInflater.from(context);
        this.f7816g = sVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7816g.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f7816g.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        ImageView imageView;
        int i12;
        w6.q qVar = this.f7816g.get(i10);
        View inflate = this.f7817h.inflate(R.layout.ptt_contact_item_call_log_new, viewGroup, false);
        if (qVar == null) {
            return inflate;
        }
        ((TextView) inflate.findViewById(R.id.tv_dateTitle)).setText(l0.d0(qVar.f15245i));
        ((ImageView) inflate.findViewById(R.id.iv_transaction)).setImageResource(qVar.f15244h == w6.q.f15242o ? R.drawable.back_arrow : R.drawable.next_arrow);
        ((TextView) inflate.findViewById(R.id.tv_name)).setText(qVar.f15238d);
        ((TextView) inflate.findViewById(R.id.tv_number)).setText(l0.l0(qVar.f15236b) ? "" : qVar.f15236b);
        int i13 = 8;
        if (qVar.f15244h == w6.q.f15243p) {
            int i14 = qVar.f15247k != null ? 0 : 8;
            i11 = qVar.f15248l <= 0 ? 8 : 0;
            i13 = i14;
        } else {
            i11 = 8;
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.img_verification1);
        imageView2.setImageDrawable(this.f7815f.getResources().getDrawable(qVar.f15248l > 0 ? R.drawable.verification_blue : R.drawable.verification));
        imageView2.setVisibility(i13);
        inflate.findViewById(R.id.img_verification2).setVisibility(i11);
        inflate.findViewById(R.id.ll_main).setTag(qVar);
        inflate.findViewById(R.id.ll_main).setOnClickListener(new a());
        int i15 = qVar.f15239e;
        if (i15 == 2) {
            imageView = (ImageView) inflate.findViewById(R.id.iv_user);
            i12 = R.drawable.users;
        } else if (i15 == 3) {
            imageView = (ImageView) inflate.findViewById(R.id.iv_user);
            i12 = R.drawable.mda_user;
        } else {
            imageView = (ImageView) inflate.findViewById(R.id.iv_user);
            i12 = R.drawable.user;
        }
        imageView.setImageResource(i12);
        return inflate;
    }
}
