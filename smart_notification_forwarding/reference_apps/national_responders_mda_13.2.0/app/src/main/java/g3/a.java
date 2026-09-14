package g3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList a10;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (a10 = f.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i10) : a10;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        Drawable b10;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (b10 = f.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i10) : b10;
    }
}
