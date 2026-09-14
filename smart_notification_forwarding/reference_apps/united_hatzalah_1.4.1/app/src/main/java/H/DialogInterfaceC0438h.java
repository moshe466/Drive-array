package h;

import J.S;
import a.AbstractC0228a;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.uh.sf.R;
import java.util.WeakHashMap;
import k.AbstractC0458b;
import k.InterfaceC0457a;
import m.A0;

/* renamed from: h.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceC0438h extends c.n implements DialogInterface, InterfaceC0442l {

    /* renamed from: d, reason: collision with root package name */
    public y f4827d;

    /* renamed from: e, reason: collision with root package name */
    public final z f4828e;

    /* renamed from: f, reason: collision with root package name */
    public final C0437g f4829f;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v2, types: [h.z] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DialogInterfaceC0438h(android.view.ContextThemeWrapper r5, int r6) {
        /*
            r4 = this;
            int r6 = e(r5, r6)
            r0 = 1
            r1 = 2130968700(0x7f04007c, float:1.7546061E38)
            if (r6 != 0) goto L19
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r5.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L1a
        L19:
            r2 = r6
        L1a:
            r4.<init>(r5, r2)
            h.z r2 = new h.z
            r2.<init>()
            r4.f4828e = r2
            h.o r2 = r4.c()
            if (r6 != 0) goto L38
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r5.resolveAttribute(r1, r6, r0)
            int r6 = r6.resourceId
        L38:
            r5 = r2
            h.y r5 = (h.y) r5
            r5.f4897W = r6
            r2.c()
            h.g r5 = new h.g
            android.content.Context r6 = r4.getContext()
            android.view.Window r0 = r4.getWindow()
            r5.<init>(r6, r4, r0)
            r4.f4829f = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.DialogInterfaceC0438h.<init>(android.view.ContextThemeWrapper, int):void");
    }

    public static int e(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // c.n, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        y yVar = (y) c();
        yVar.w();
        ((ViewGroup) yVar.f4878D.findViewById(android.R.id.content)).addView(view, layoutParams);
        yVar.p.a(yVar.f4913o.getCallback());
    }

    public final o c() {
        if (this.f4827d == null) {
            E e4 = o.f4833a;
            this.f4827d = new y(getContext(), getWindow(), this, this);
        }
        return this.f4827d;
    }

    public final void d(Bundle bundle) {
        y yVar = (y) c();
        LayoutInflater from = LayoutInflater.from(yVar.f4912n);
        if (from.getFactory() == null) {
            from.setFactory2(yVar);
        } else {
            from.getFactory2();
        }
        super.onCreate(bundle);
        c().c();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        c().d();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC0228a.k(this.f4828e, getWindow().getDecorView(), this, keyEvent);
    }

    public final void f(CharSequence charSequence) {
        super.setTitle(charSequence);
        c().l(charSequence);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        y yVar = (y) c();
        yVar.w();
        return yVar.f4913o.findViewById(i);
    }

    public final boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        c().a();
    }

    @Override // c.n, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        boolean z3;
        int i;
        boolean z4;
        int i3;
        boolean z5;
        ListAdapter listAdapter;
        int i4;
        int i5;
        View findViewById;
        View findViewById2;
        d(bundle);
        C0437g c0437g = this.f4829f;
        c0437g.f4805b.setContentView(c0437g.f4826z);
        Context context = c0437g.f4804a;
        Window window = c0437g.f4806c;
        View findViewById3 = window.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        View view = c0437g.f4810g;
        if (view == null) {
            view = null;
        }
        int i6 = 0;
        if (view != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 || !C0437g.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z3) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (c0437g.f4811h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (c0437g.f4809f != null) {
                ((LinearLayout.LayoutParams) ((A0) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup b4 = C0437g.b(findViewById7, findViewById4);
        ViewGroup b5 = C0437g.b(findViewById8, findViewById5);
        ViewGroup b6 = C0437g.b(findViewById9, findViewById6);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        c0437g.f4819r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        c0437g.f4819r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) b5.findViewById(android.R.id.message);
        c0437g.f4823v = textView;
        if (textView != null) {
            String str = c0437g.f4808e;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setVisibility(8);
                c0437g.f4819r.removeView(c0437g.f4823v);
                if (c0437g.f4809f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) c0437g.f4819r.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(c0437g.f4819r);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(c0437g.f4809f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    b5.setVisibility(8);
                }
            }
        }
        Button button = (Button) b6.findViewById(android.R.id.button1);
        c0437g.i = button;
        ViewOnClickListenerC0433c viewOnClickListenerC0433c = c0437g.f4803F;
        button.setOnClickListener(viewOnClickListenerC0433c);
        if (TextUtils.isEmpty(c0437g.f4812j)) {
            c0437g.i.setVisibility(8);
            i = 0;
        } else {
            c0437g.i.setText(c0437g.f4812j);
            c0437g.i.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) b6.findViewById(android.R.id.button2);
        c0437g.f4814l = button2;
        button2.setOnClickListener(viewOnClickListenerC0433c);
        if (TextUtils.isEmpty(c0437g.f4815m)) {
            c0437g.f4814l.setVisibility(8);
        } else {
            c0437g.f4814l.setText(c0437g.f4815m);
            c0437g.f4814l.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) b6.findViewById(android.R.id.button3);
        c0437g.f4817o = button3;
        button3.setOnClickListener(viewOnClickListenerC0433c);
        if (TextUtils.isEmpty(c0437g.p)) {
            c0437g.f4817o.setVisibility(8);
        } else {
            c0437g.f4817o.setText(c0437g.p);
            c0437g.f4817o.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button4 = c0437g.i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button5 = c0437g.f4814l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button6 = c0437g.f4817o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            b6.setVisibility(8);
        }
        if (c0437g.f4824w != null) {
            b4.addView(c0437g.f4824w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            c0437g.f4821t = (ImageView) window.findViewById(android.R.id.icon);
            if (!TextUtils.isEmpty(c0437g.f4807d) && c0437g.f4801D) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                c0437g.f4822u = textView2;
                textView2.setText(c0437g.f4807d);
                Drawable drawable = c0437g.f4820s;
                if (drawable != null) {
                    c0437g.f4821t.setImageDrawable(drawable);
                } else {
                    c0437g.f4822u.setPadding(c0437g.f4821t.getPaddingLeft(), c0437g.f4821t.getPaddingTop(), c0437g.f4821t.getPaddingRight(), c0437g.f4821t.getPaddingBottom());
                    c0437g.f4821t.setVisibility(8);
                }
            } else {
                window.findViewById(R.id.title_template).setVisibility(8);
                c0437g.f4821t.setVisibility(8);
                b4.setVisibility(8);
            }
        }
        if (viewGroup.getVisibility() != 8) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (b4 != null && b4.getVisibility() != 8) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (b6.getVisibility() != 8) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5 && (findViewById2 = b5.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (i3 != 0) {
            NestedScrollView nestedScrollView2 = c0437g.f4819r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (c0437g.f4808e == null && c0437g.f4809f == null) {
                findViewById = null;
            } else {
                findViewById = b4.findViewById(R.id.titleDividerNoCustom);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else {
            View findViewById10 = b5.findViewById(R.id.textSpacerNoTitle);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = c0437g.f4809f;
        if (alertController$RecycleListView != null && (!z5 || i3 == 0)) {
            int paddingLeft = alertController$RecycleListView.getPaddingLeft();
            if (i3 != 0) {
                i4 = alertController$RecycleListView.getPaddingTop();
            } else {
                i4 = alertController$RecycleListView.f2769a;
            }
            int paddingRight = alertController$RecycleListView.getPaddingRight();
            if (z5) {
                i5 = alertController$RecycleListView.getPaddingBottom();
            } else {
                i5 = alertController$RecycleListView.f2770b;
            }
            alertController$RecycleListView.setPadding(paddingLeft, i4, paddingRight, i5);
        }
        if (!z4) {
            View view2 = c0437g.f4809f;
            if (view2 == null) {
                view2 = c0437g.f4819r;
            }
            if (view2 != null) {
                if (z5) {
                    i6 = 2;
                }
                View findViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View findViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = S.f954a;
                J.K.b(view2, i3 | i6, 3);
                if (findViewById11 != null) {
                    b5.removeView(findViewById11);
                }
                if (findViewById12 != null) {
                    b5.removeView(findViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = c0437g.f4809f;
        if (alertController$RecycleListView2 != null && (listAdapter = c0437g.f4825x) != null) {
            alertController$RecycleListView2.setAdapter(listAdapter);
            int i7 = c0437g.y;
            if (i7 > -1) {
                alertController$RecycleListView2.setItemChecked(i7, true);
                alertController$RecycleListView2.setSelection(i7);
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4829f.f4819r;
        if (nestedScrollView != null && nestedScrollView.d(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4829f.f4819r;
        if (nestedScrollView != null && nestedScrollView.d(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // c.n, android.app.Dialog
    public final void onStop() {
        super.onStop();
        y yVar = (y) c();
        yVar.A();
        AbstractC0431a abstractC0431a = yVar.f4915r;
        if (abstractC0431a != null) {
            abstractC0431a.q(false);
        }
    }

    @Override // h.InterfaceC0442l
    public final AbstractC0458b onWindowStartingSupportActionMode(InterfaceC0457a interfaceC0457a) {
        return null;
    }

    @Override // c.n, android.app.Dialog
    public final void setContentView(int i) {
        c().h(i);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        c().l(getContext().getString(i));
    }

    @Override // c.n, android.app.Dialog
    public final void setContentView(View view) {
        c().j(view);
    }

    @Override // c.n, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c().k(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        f(charSequence);
        C0437g c0437g = this.f4829f;
        c0437g.f4807d = charSequence;
        TextView textView = c0437g.f4822u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // h.InterfaceC0442l
    public final void onSupportActionModeFinished(AbstractC0458b abstractC0458b) {
    }

    @Override // h.InterfaceC0442l
    public final void onSupportActionModeStarted(AbstractC0458b abstractC0458b) {
    }
}
