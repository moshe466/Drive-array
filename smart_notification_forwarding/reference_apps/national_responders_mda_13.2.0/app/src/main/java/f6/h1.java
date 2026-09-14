package f6;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.Message;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import com.groboot.mdaemergency.ui.main.MainActivity;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class h1 extends a6.a {
    public WebViewMDA A0;
    ProgressBar B0;
    RelativeLayout C0;
    v6.k D0;
    Message E0;
    public Feature F0;
    WebViewMDA.k G0;
    boolean H0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.InterfaceC0098b {
        a() {
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (!aVar.f7614b) {
                h1.this.B0.setVisibility(8);
                if (aVar.f7617e != null) {
                    a6.h.o(h1.this.t(), aVar.f7617e);
                    return;
                }
                return;
            }
            try {
                h1.this.F0.Content = aVar.e("HtmlContent");
                h1 h1Var = h1.this;
                h1Var.A0.setMessage(h1Var.F0.toMessage());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                h1.this.W1();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements v6.l {
        c() {
        }

        @Override // v6.l
        public void a() {
            WebViewMDA webViewMDA = h1.this.A0;
            h1.w2(webViewMDA, webViewMDA.getHeight(), ((a6.a) h1.this).f306w0.getHeight());
        }

        @Override // v6.l
        public void b(int i10) {
            if (i10 == -1) {
                i10 = ((a6.a) h1.this).f306w0.getHeight() / 2;
            }
            WebViewMDA webViewMDA = h1.this.A0;
            h1.w2(webViewMDA, webViewMDA.getHeight(), ((a6.a) h1.this).f306w0.getHeight() - i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements WebViewMDA.i {
        d() {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void a(String str) {
            h1 h1Var = h1.this;
            if (!h1Var.H0 || h1Var.t() == null) {
                return;
            }
            ((MainActivity) h1.this.t()).a(str);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void b() {
            h1.this.B0.setVisibility(8);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void c() {
            h1 h1Var = h1.this;
            if (h1Var.H0) {
                h1Var.t().d0().Z0();
            } else {
                h1Var.W1();
            }
        }
    }

    public h1() {
    }

    @SuppressLint({"ValidFragment"})
    public h1(Feature feature, WebViewMDA.k kVar) {
        this.F0 = feature;
        this.G0 = kVar;
    }

    @SuppressLint({"ValidFragment"})
    public h1(Message message, WebViewMDA.k kVar) {
        this.E0 = message;
        this.G0 = kVar;
    }

    private void u2() {
        Message message;
        Feature feature = this.F0;
        l2(((feature == null || feature.HtmlOpen != 2) && ((message = this.E0) == null || message.HtmlOpen != 2)) ? R.layout.administrative_message : R.layout.fragment_message);
        if (Z1() != null && Z1().getWindow() != null) {
            Z1().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            Z1().getWindow().requestFeature(1);
        }
        this.B0 = (ProgressBar) k2(R.id.progressBar);
        this.A0 = (WebViewMDA) k2(R.id.wv_message);
        this.C0 = (RelativeLayout) k2(R.id.view_content);
        this.A0.setActionHandler(t2());
        this.A0.setClickHandler(this.G0);
        Feature feature2 = this.F0;
        if (feature2 == null && this.E0 == null) {
            return;
        }
        if (feature2 != null) {
            setTitle(R.string.administrative_title);
            this.H0 = this.F0.HtmlOpen == 2;
            this.B0.setVisibility(0);
            a(this.F0.Description);
            if (this.F0.getHtmlType() == 3) {
                com.groboot.mdaemergency.async.d.v().C(t(), this.F0.MessageID, new a());
            } else if (this.F0.getHtmlType() == 1) {
                this.A0.setMessage(this.F0.toMessage());
            }
        } else {
            Message message2 = this.E0;
            if (message2 != null) {
                this.A0.setMessage(message2);
                this.H0 = this.E0.HtmlOpen == 2;
            }
        }
        if (this.H0) {
            setTitle(R.string.administrative_title);
            g(true);
        } else {
            ImageView imageView = (ImageView) k2(R.id.close);
            if (imageView != null) {
                imageView.setOnClickListener(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v2(View view, ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        view.getLayoutParams().height = num.intValue();
        view.requestLayout();
    }

    public static void w2(final View view, int i10, int i11) {
        ValueAnimator duration = ValueAnimator.ofInt(i10, i11).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: f6.g1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h1.v2(view, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(duration);
        animatorSet.start();
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public void I0() {
        super.I0();
        y2();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    /* renamed from: W0 */
    public void o3() {
        super.o3();
        v6.k kVar = this.D0;
        if (kVar != null) {
            kVar.o();
        }
    }

    @Override // a6.a
    protected void n2() {
        u2();
    }

    @Override // a6.a
    public void o2() {
    }

    public WebViewMDA.i t2() {
        return new d();
    }

    public void x2(w5.a aVar) {
        v6.k kVar = new v6.k(t(), aVar, new c());
        this.D0 = kVar;
        kVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.C0.addView(this.D0);
        LockPatternActivity.B();
    }

    public void y2() {
        v6.k kVar = this.D0;
        if (kVar != null) {
            kVar.q();
        }
    }
}
