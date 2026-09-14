package androidx.appcompat.view.menu;

import F0.b3;
import J.S;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.uh.sf.R;
import g.AbstractC0424a;
import java.util.WeakHashMap;
import l.InterfaceC0497A;
import l.o;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC0497A, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public o f2783a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f2784b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f2785c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f2786d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f2787e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f2788f;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f2789j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f2790k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout f2791l;

    /* renamed from: m, reason: collision with root package name */
    public final Drawable f2792m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2793n;

    /* renamed from: o, reason: collision with root package name */
    public final Context f2794o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public final Drawable f2795q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f2796r;

    /* renamed from: s, reason: collision with root package name */
    public LayoutInflater f2797s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2798t;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b3 t3 = b3.t(getContext(), attributeSet, AbstractC0424a.f4642r, R.attr.listMenuViewStyle);
        this.f2792m = t3.o(5);
        TypedArray typedArray = (TypedArray) t3.f470c;
        this.f2793n = typedArray.getResourceId(1, -1);
        this.p = typedArray.getBoolean(7, false);
        this.f2794o = context;
        this.f2795q = t3.o(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f2796r = obtainStyledAttributes.hasValue(0);
        t3.v();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f2797s == null) {
            this.f2797s = LayoutInflater.from(getContext());
        }
        return this.f2797s;
    }

    private void setSubMenuArrowVisible(boolean z3) {
        int i;
        ImageView imageView = this.f2789j;
        if (imageView != null) {
            if (z3) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2790k;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2790k.getLayoutParams();
            rect.top = this.f2790k.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121  */
    @Override // l.InterfaceC0497A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l.o r11) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.b(l.o):void");
    }

    @Override // l.InterfaceC0497A
    public o getItemData() {
        return this.f2783a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = S.f954a;
        setBackground(this.f2792m);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f2786d = textView;
        int i = this.f2793n;
        if (i != -1) {
            textView.setTextAppearance(this.f2794o, i);
        }
        this.f2788f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f2789j = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f2795q);
        }
        this.f2790k = (ImageView) findViewById(R.id.group_divider);
        this.f2791l = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        if (this.f2784b != null && this.p) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2784b.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i, i3);
    }

    public void setCheckable(boolean z3) {
        CompoundButton compoundButton;
        View view;
        if (z3 || this.f2785c != null || this.f2787e != null) {
            if ((this.f2783a.f5449x & 4) != 0) {
                if (this.f2785c == null) {
                    RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                    this.f2785c = radioButton;
                    LinearLayout linearLayout = this.f2791l;
                    if (linearLayout != null) {
                        linearLayout.addView(radioButton, -1);
                    } else {
                        addView(radioButton, -1);
                    }
                }
                compoundButton = this.f2785c;
                view = this.f2787e;
            } else {
                if (this.f2787e == null) {
                    CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                    this.f2787e = checkBox;
                    LinearLayout linearLayout2 = this.f2791l;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(checkBox, -1);
                    } else {
                        addView(checkBox, -1);
                    }
                }
                compoundButton = this.f2787e;
                view = this.f2785c;
            }
            if (z3) {
                compoundButton.setChecked(this.f2783a.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox2 = this.f2787e;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.f2785c;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z3) {
        CompoundButton compoundButton;
        if ((this.f2783a.f5449x & 4) != 0) {
            if (this.f2785c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f2785c = radioButton;
                LinearLayout linearLayout = this.f2791l;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f2785c;
        } else {
            if (this.f2787e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f2787e = checkBox;
                LinearLayout linearLayout2 = this.f2791l;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f2787e;
        }
        compoundButton.setChecked(z3);
    }

    public void setForceShowIcon(boolean z3) {
        this.f2798t = z3;
        this.p = z3;
    }

    public void setGroupDividerEnabled(boolean z3) {
        int i;
        ImageView imageView = this.f2790k;
        if (imageView != null) {
            if (!this.f2796r && z3) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z3;
        if (!this.f2783a.f5440n.f5416s && !this.f2798t) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 || this.p) {
            ImageView imageView = this.f2784b;
            if (imageView != null || drawable != null || this.p) {
                if (imageView == null) {
                    ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                    this.f2784b = imageView2;
                    LinearLayout linearLayout = this.f2791l;
                    if (linearLayout != null) {
                        linearLayout.addView(imageView2, 0);
                    } else {
                        addView(imageView2, 0);
                    }
                }
                if (drawable == null && !this.p) {
                    this.f2784b.setVisibility(8);
                    return;
                }
                ImageView imageView3 = this.f2784b;
                if (!z3) {
                    drawable = null;
                }
                imageView3.setImageDrawable(drawable);
                if (this.f2784b.getVisibility() != 0) {
                    this.f2784b.setVisibility(0);
                }
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2786d.setText(charSequence);
            if (this.f2786d.getVisibility() != 0) {
                this.f2786d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f2786d.getVisibility() != 8) {
            this.f2786d.setVisibility(8);
        }
    }
}
