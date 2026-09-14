package c0;

import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f4346a;

    /* renamed from: c0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0075a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final EditText f4347a;

        /* renamed from: b, reason: collision with root package name */
        private final g f4348b;

        C0075a(EditText editText, boolean z10) {
            this.f4347a = editText;
            g gVar = new g(editText, z10);
            this.f4348b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(c0.b.getInstance());
        }

        @Override // c0.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // c0.a.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f4347a, inputConnection, editorInfo);
        }

        @Override // c0.a.b
        void c(boolean z10) {
            this.f4348b.c(z10);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        void c(boolean z10) {
        }
    }

    public a(EditText editText, boolean z10) {
        androidx.core.util.h.g(editText, "editText cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.f4346a = new b();
        } else {
            this.f4346a = new C0075a(editText, z10);
        }
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f4346a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f4346a.b(inputConnection, editorInfo);
    }

    public void c(boolean z10) {
        this.f4346a.c(z10);
    }
}
