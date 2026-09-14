package m;

import F0.C0021d0;
import F0.C0035g2;
import F0.b3;
import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import g.AbstractC0424a;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.tika.pipes.PipesConfigBase;

/* renamed from: m.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0522A {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f5493d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5494a = 2;

    /* renamed from: b, reason: collision with root package name */
    public View f5495b;

    /* renamed from: c, reason: collision with root package name */
    public Object f5496c;

    public /* synthetic */ C0522A() {
    }

    public KeyListener a(KeyListener keyListener) {
        if (!(keyListener instanceof NumberKeyListener)) {
            ((C0021d0) ((C0035g2) this.f5496c).f526b).getClass();
            if (keyListener instanceof X.e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new X.e(keyListener);
        }
        return keyListener;
    }

    public void b(AttributeSet attributeSet, int i) {
        switch (this.f5494a) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f5495b;
                b3 t3 = b3.t(absSeekBar.getContext(), attributeSet, f5493d, i);
                Drawable p = t3.p(0);
                if (p != null) {
                    if (p instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) p;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i3 = 0; i3 < numberOfFrames; i3++) {
                            Drawable e4 = e(animationDrawable.getFrame(i3), true);
                            e4.setLevel(PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS);
                            animationDrawable2.addFrame(e4, animationDrawable.getDuration(i3));
                        }
                        animationDrawable2.setLevel(PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS);
                        p = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(p);
                }
                Drawable p2 = t3.p(1);
                if (p2 != null) {
                    absSeekBar.setProgressDrawable(e(p2, false));
                }
                t3.v();
                return;
            default:
                TypedArray obtainStyledAttributes = ((EditText) this.f5495b).getContext().obtainStyledAttributes(attributeSet, AbstractC0424a.i, i, 0);
                try {
                    boolean z3 = true;
                    if (obtainStyledAttributes.hasValue(14)) {
                        z3 = obtainStyledAttributes.getBoolean(14, true);
                    }
                    obtainStyledAttributes.recycle();
                    d(z3);
                    return;
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public X.b c(InputConnection inputConnection, EditorInfo editorInfo) {
        C0035g2 c0035g2 = (C0035g2) this.f5496c;
        if (inputConnection == null) {
            c0035g2.getClass();
            inputConnection = null;
        } else {
            C0021d0 c0021d0 = (C0021d0) c0035g2.f526b;
            c0021d0.getClass();
            if (!(inputConnection instanceof X.b)) {
                inputConnection = new X.b((EditText) c0021d0.f479a, inputConnection, editorInfo);
            }
        }
        return (X.b) inputConnection;
    }

    public void d(boolean z3) {
        X.i iVar = (X.i) ((C0021d0) ((C0035g2) this.f5496c).f526b).f480b;
        if (iVar.f2573c != z3) {
            if (iVar.f2572b != null) {
                V.k a2 = V.k.a();
                X.h hVar = iVar.f2572b;
                a2.getClass();
                I.d.c(hVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a2.f2397a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a2.f2398b.remove(hVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            iVar.f2573c = z3;
            if (z3) {
                X.i.a(iVar.f2571a, V.k.a().b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable e(Drawable drawable, boolean z3) {
        boolean z4;
        if (drawable instanceof B.d) {
            ((B.e) ((B.d) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    Drawable drawable2 = layerDrawable.getDrawable(i);
                    if (id != 16908301 && id != 16908303) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    drawableArr[i] = e(drawable2, z4);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    layerDrawable2.setId(i3, layerDrawable.getId(i3));
                    layerDrawable2.setLayerGravity(i3, layerDrawable.getLayerGravity(i3));
                    layerDrawable2.setLayerWidth(i3, layerDrawable.getLayerWidth(i3));
                    layerDrawable2.setLayerHeight(i3, layerDrawable.getLayerHeight(i3));
                    layerDrawable2.setLayerInsetLeft(i3, layerDrawable.getLayerInsetLeft(i3));
                    layerDrawable2.setLayerInsetRight(i3, layerDrawable.getLayerInsetRight(i3));
                    layerDrawable2.setLayerInsetTop(i3, layerDrawable.getLayerInsetTop(i3));
                    layerDrawable2.setLayerInsetBottom(i3, layerDrawable.getLayerInsetBottom(i3));
                    layerDrawable2.setLayerInsetStart(i3, layerDrawable.getLayerInsetStart(i3));
                    layerDrawable2.setLayerInsetEnd(i3, layerDrawable.getLayerInsetEnd(i3));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f5496c) == null) {
                    this.f5496c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                if (z3) {
                    return new ClipDrawable(shapeDrawable, 3, 1);
                }
                return shapeDrawable;
            }
        }
        return drawable;
    }

    public C0522A(AbsSeekBar absSeekBar) {
        this.f5495b = absSeekBar;
    }

    public C0522A(EditText editText) {
        this.f5495b = editText;
        this.f5496c = new C0035g2(editText);
    }
}
