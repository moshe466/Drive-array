package m;

import a.AbstractC0228a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

/* renamed from: m.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0575w extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    public final C0558n f5812a;

    /* renamed from: b, reason: collision with root package name */
    public final N0.b f5813b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5814c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0575w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j1.a(context);
        this.f5814c = false;
        i1.a(this, getContext());
        C0558n c0558n = new C0558n(this);
        this.f5812a = c0558n;
        c0558n.d(attributeSet, i);
        N0.b bVar = new N0.b(this);
        this.f5813b = bVar;
        bVar.d(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0558n c0558n = this.f5812a;
        if (c0558n != null) {
            c0558n.a();
        }
        N0.b bVar = this.f5813b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0558n c0558n = this.f5812a;
        if (c0558n != null) {
            return c0558n.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0558n c0558n = this.f5812a;
        if (c0558n != null) {
            return c0558n.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        F.c cVar;
        N0.b bVar = this.f5813b;
        if (bVar == null || (cVar = (F.c) bVar.f1429c) == null) {
            return null;
        }
        return (ColorStateList) cVar.f156c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        F.c cVar;
        N0.b bVar = this.f5813b;
        if (bVar == null || (cVar = (F.c) bVar.f1429c) == null) {
            return null;
        }
        return (PorterDuff.Mode) cVar.f157d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        if (!(((ImageView) this.f5813b.f1428b).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0558n c0558n = this.f5812a;
        if (c0558n != null) {
            c0558n.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0558n c0558n = this.f5812a;
        if (c0558n != null) {
            c0558n.f(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        N0.b bVar = this.f5813b;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        N0.b bVar = this.f5813b;
        if (bVar != null && drawable != null && !this.f5814c) {
            bVar.f1427a = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (bVar != null) {
            bVar.a();
            if (!this.f5814c) {
                ImageView imageView = (ImageView) bVar.f1428b;
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setLevel(bVar.f1427a);
                }
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.f5814c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        N0.b bVar = this.f5813b;
        ImageView imageView = (ImageView) bVar.f1428b;
        if (i != 0) {
            Drawable q3 = AbstractC0228a.q(imageView.getContext(), i);
            if (q3 != null) {
                AbstractC0565q0.a(q3);
            }
            imageView.setImageDrawable(q3);
        } else {
            imageView.setImageDrawable(null);
        }
        bVar.a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        N0.b bVar = this.f5813b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0558n c0558n = this.f5812a;
        if (c0558n != null) {
            c0558n.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0558n c0558n = this.f5812a;
        if (c0558n != null) {
            c0558n.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        N0.b bVar = this.f5813b;
        if (bVar != null) {
            if (((F.c) bVar.f1429c) == null) {
                bVar.f1429c = new Object();
            }
            F.c cVar = (F.c) bVar.f1429c;
            cVar.f156c = colorStateList;
            cVar.f155b = true;
            bVar.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        N0.b bVar = this.f5813b;
        if (bVar != null) {
            if (((F.c) bVar.f1429c) == null) {
                bVar.f1429c = new Object();
            }
            F.c cVar = (F.c) bVar.f1429c;
            cVar.f157d = mode;
            cVar.f154a = true;
            bVar.a();
        }
    }
}
