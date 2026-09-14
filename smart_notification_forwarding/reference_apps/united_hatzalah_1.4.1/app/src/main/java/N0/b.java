package N0;

import F0.AbstractC0008a;
import F0.b3;
import J.S;
import a.AbstractC0228a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import g.AbstractC0424a;
import io.flutter.embedding.android.KeyboardMap;
import java.nio.ByteBuffer;
import m.AbstractC0565q0;
import m.C0567s;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f1427a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1428b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1429c;

    public b(ImageView imageView) {
        this.f1427a = 0;
        this.f1428b = imageView;
    }

    public static b b(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 8) {
            byteBuffer.position(byteBuffer.limit());
            return null;
        }
        int position = byteBuffer.position();
        int i = byteBuffer.getShort() & 65535;
        int i3 = 65535 & byteBuffer.getShort();
        long j2 = byteBuffer.getInt() & KeyboardMap.kValueMask;
        if (j2 - 8 > byteBuffer.remaining()) {
            byteBuffer.position(byteBuffer.limit());
            return null;
        }
        if (i3 >= 8) {
            if (i3 <= j2) {
                int i4 = i3 + position;
                long j3 = position + j2;
                b bVar = new b(i, d.f(position, byteBuffer, i4), d.g(byteBuffer, i4, j3));
                byteBuffer.position((int) j3);
                return bVar;
            }
            throw new Exception("Malformed chunk: header too long: " + i3 + " bytes. Chunk size: " + j2 + " bytes");
        }
        throw new Exception(AbstractC0008a.j(i3, "Malformed chunk: header too short: ", " bytes"));
    }

    public void a() {
        F.c cVar;
        ImageView imageView = (ImageView) this.f1428b;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            AbstractC0565q0.a(drawable);
        }
        if (drawable != null && (cVar = (F.c) this.f1429c) != null) {
            C0567s.d(drawable, cVar, imageView.getDrawableState());
        }
    }

    public ByteBuffer c() {
        ByteBuffer byteBuffer = (ByteBuffer) this.f1429c;
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return slice;
    }

    public void d(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.f1428b;
        Context context = imageView.getContext();
        int[] iArr = AbstractC0424a.f4632f;
        b3 t3 = b3.t(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) t3.f470c;
        S.h(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) t3.f470c, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = AbstractC0228a.q(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                AbstractC0565q0.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(t3.n(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(AbstractC0565q0.c(typedArray.getInt(3, -1), null));
            }
            t3.v();
        } catch (Throwable th) {
            t3.v();
            throw th;
        }
    }

    public b(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        this.f1427a = i;
        this.f1428b = byteBuffer;
        this.f1429c = byteBuffer2;
    }
}
