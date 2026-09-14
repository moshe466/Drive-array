package X;

import A.n;
import V.k;
import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f2557a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2558b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        int i;
        n nVar = new n(15);
        this.f2557a = editText;
        this.f2558b = nVar;
        if (k.f2396j != null) {
            k a2 = k.a();
            if (a2.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            V.f fVar = a2.f2401e;
            fVar.getClass();
            Bundle bundle = editorInfo.extras;
            W.b bVar = (W.b) fVar.f2393c.f1102a;
            int a4 = bVar.a(4);
            if (a4 != 0) {
                i = ((ByteBuffer) bVar.f946d).getInt(a4 + bVar.f943a);
            } else {
                i = 0;
            }
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i);
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i3) {
        Editable editableText = this.f2557a.getEditableText();
        this.f2558b.getClass();
        if (!n.e(this, editableText, i, i3, false) && !super.deleteSurroundingText(i, i3)) {
            return false;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i3) {
        Editable editableText = this.f2557a.getEditableText();
        this.f2558b.getClass();
        if (n.e(this, editableText, i, i3, true) || super.deleteSurroundingTextInCodePoints(i, i3)) {
            return true;
        }
        return false;
    }
}
