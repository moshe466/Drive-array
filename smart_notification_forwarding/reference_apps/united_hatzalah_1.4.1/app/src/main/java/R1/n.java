package R1;

import F0.C0047j2;
import W1.X;
import W1.r0;
import a.AbstractC0228a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.lifecycle.N;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.uh.sf.R;
import d1.C0358a;
import e1.C0360a;
import e1.C0361b;
import e1.C0362c;
import e1.C0363d;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import m.AbstractC0565q0;
import m.C0567s;
import m.Q0;
import m.i1;
import s2.C0682g;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2002a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2003b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2004c;

    /* renamed from: d, reason: collision with root package name */
    public final Serializable f2005d;

    /* renamed from: e, reason: collision with root package name */
    public final Serializable f2006e;

    /* renamed from: f, reason: collision with root package name */
    public final Serializable f2007f;

    public n(C0047j2 c0047j2, C0358a c0358a, N n4) {
        this.f2002a = c0047j2;
        this.f2003b = c0358a;
        this.f2004c = n4;
        this.f2005d = T.b.A(new C0361b(this, 1));
        this.f2006e = T.b.A(new C0361b(this, 0));
        this.f2007f = T.b.A(new C0361b(this, 2));
    }

    public static boolean a(int[] iArr, int i) {
        for (int i3 : iArr) {
            if (i3 == i) {
                return true;
            }
        }
        return false;
    }

    public static n b(String str, AbstractC0337i abstractC0337i, X x3, r0 r0Var, Integer num) {
        if (r0Var == r0.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new n(str, abstractC0337i, x3, r0Var, num);
    }

    public static ColorStateList c(Context context, int i) {
        int c4 = i1.c(context, R.attr.colorControlHighlight);
        int b4 = i1.b(context, R.attr.colorButtonNormal);
        int[] iArr = i1.f5690b;
        int[] iArr2 = i1.f5692d;
        int b5 = A.a.b(c4, i);
        return new ColorStateList(new int[][]{iArr, iArr2, i1.f5691c, i1.f5694f}, new int[]{b4, b5, A.a.b(c4, i), i});
    }

    public static LayerDrawable d(Q0 q02, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable c4 = q02.c(context, R.drawable.abc_star_black_48dp);
        Drawable c5 = q02.c(context, R.drawable.abc_star_half_black_48dp);
        if ((c4 instanceof BitmapDrawable) && c4.getIntrinsicWidth() == dimensionPixelSize && c4.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) c4;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            c4.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c4.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((c5 instanceof BitmapDrawable) && c5.getIntrinsicWidth() == dimensionPixelSize && c5.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) c5;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            c5.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c5.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void g(Drawable drawable, int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter e4;
        int[] iArr = AbstractC0565q0.f5752a;
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = C0567s.f5765b;
        }
        PorterDuff.Mode mode2 = C0567s.f5765b;
        synchronized (C0567s.class) {
            e4 = Q0.e(i, mode);
        }
        mutate.setColorFilter(e4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC0228a e() {
        C0682g c0682g = (C0682g) this.f2006e;
        C0682g c0682g2 = (C0682g) this.f2005d;
        c1.b bVar = c1.b.f3870d;
        c1.b bVar2 = c1.b.f3868b;
        C0363d c0363d = null;
        if (bVar.compareTo(c1.b.f3869c) <= 0 && bVar.compareTo(bVar2) >= 0) {
            C0362c c0362c = (C0362c) c0682g2.a();
            if (c0362c.f4451j.length() > 0) {
                c0363d = c0362c;
            }
            if (c0363d != null) {
                return c0363d;
            }
            return (C0360a) c0682g.a();
        }
        C0362c c0362c2 = (C0362c) c0682g2.a();
        if (c0362c2.f4451j.length() <= 0) {
            c0362c2 = null;
        }
        if (c0362c2 != null) {
            return c0362c2;
        }
        C0363d c0363d2 = (C0363d) ((C0682g) this.f2007f).a();
        if (c0363d2.f4452j.length() > 0) {
            c0363d = c0363d2;
        }
        if (c0363d != null) {
            return c0363d;
        }
        return (C0360a) c0682g.a();
    }

    public ColorStateList f(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return AbstractC0228a.o(context, R.color.abc_tint_edittext);
        }
        if (i == 2131230786) {
            return AbstractC0228a.o(context, R.color.abc_tint_switch_track);
        }
        if (i == R.drawable.abc_switch_thumb_material) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            ColorStateList d2 = i1.d(context, R.attr.colorSwitchThumbNormal);
            if (d2 != null && d2.isStateful()) {
                int[] iArr3 = i1.f5690b;
                iArr[0] = iArr3;
                iArr2[0] = d2.getColorForState(iArr3, 0);
                iArr[1] = i1.f5693e;
                iArr2[1] = i1.c(context, R.attr.colorControlActivated);
                iArr[2] = i1.f5694f;
                iArr2[2] = d2.getDefaultColor();
            } else {
                iArr[0] = i1.f5690b;
                iArr2[0] = i1.b(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = i1.f5693e;
                iArr2[1] = i1.c(context, R.attr.colorControlActivated);
                iArr[2] = i1.f5694f;
                iArr2[2] = i1.c(context, R.attr.colorSwitchThumbNormal);
            }
            return new ColorStateList(iArr, iArr2);
        }
        if (i == R.drawable.abc_btn_default_mtrl_shape) {
            return c(context, i1.c(context, R.attr.colorButtonNormal));
        }
        if (i == R.drawable.abc_btn_borderless_material) {
            return c(context, 0);
        }
        if (i == R.drawable.abc_btn_colored_material) {
            return c(context, i1.c(context, R.attr.colorAccent));
        }
        if (i != 2131230781 && i != R.drawable.abc_spinner_textfield_background_material) {
            if (a((int[]) this.f2003b, i)) {
                return i1.d(context, R.attr.colorControlNormal);
            }
            if (a((int[]) this.f2006e, i)) {
                return AbstractC0228a.o(context, R.color.abc_tint_default);
            }
            if (a((int[]) this.f2007f, i)) {
                return AbstractC0228a.o(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return AbstractC0228a.o(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        return AbstractC0228a.o(context, R.color.abc_tint_spinner);
    }

    public n(String str, AbstractC0337i abstractC0337i, X x3, r0 r0Var, Integer num) {
        this.f2002a = str;
        this.f2003b = s.b(str);
        this.f2004c = abstractC0337i;
        this.f2005d = x3;
        this.f2006e = r0Var;
        this.f2007f = num;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int[], java.io.Serializable] */
    public n() {
        this.f2002a = new int[]{2131230796, 2131230794, 2131230720};
        this.f2003b = new int[]{2131230744, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        this.f2004c = new int[]{2131230793, 2131230795, 2131230737, R.drawable.abc_text_cursor_material, 2131230790, 2131230791, 2131230792};
        this.f2005d = new int[]{2131230769, R.drawable.abc_cab_background_internal_bg, 2131230768};
        this.f2006e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        this.f2007f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
    }
}
