package A;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class l extends E1.b {
    public static Font B(FontFamily fontFamily, int i) {
        int i3;
        int i4;
        if ((i & 1) != 0) {
            i3 = 700;
        } else {
            i3 = 400;
        }
        if ((i & 2) != 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        FontStyle fontStyle = new FontStyle(i3, i4);
        Font font = fontFamily.getFont(0);
        int E3 = E(fontStyle, font.getStyle());
        for (int i5 = 1; i5 < fontFamily.getSize(); i5++) {
            Font font2 = fontFamily.getFont(i5);
            int E4 = E(fontStyle, font2.getStyle());
            if (E4 < E3) {
                font = font2;
                E3 = E4;
            }
        }
        return font;
    }

    public static int E(FontStyle fontStyle, FontStyle fontStyle2) {
        int i;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i = 0;
        } else {
            i = 2;
        }
        return abs + i;
    }

    public final FontFamily C(G.i[] iVarArr, ContentResolver contentResolver) {
        Font font;
        String str;
        ParcelFileDescriptor openFileDescriptor;
        FontFamily.Builder builder = null;
        for (G.i iVar : iVarArr) {
            if (Objects.equals(iVar.f791a.getScheme(), "systemfont")) {
                font = D(iVar);
            } else {
                try {
                    Uri uri = iVar.f791a;
                    str = iVar.f795e;
                    openFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    font = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(openFileDescriptor).setWeight(iVar.f793c).setSlant(iVar.f794d ? 1 : 0).setTtcIndex(iVar.f792b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        font = ttcIndex.build();
                        openFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                }
            }
            if (font != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(font);
                } else {
                    builder.addFont(font);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font D(G.i iVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    @Override // E1.b
    public final Typeface e(Context context, z.e eVar, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (z.f fVar : eVar.f6779a) {
                try {
                    Font build = new Font.Builder(resources, fVar.f6785f).setWeight(fVar.f6781b).setSlant(fVar.f6782c ? 1 : 0).setTtcIndex(fVar.f6784e).setFontVariationSettings(fVar.f6783d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(B(build2, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // E1.b
    public final Typeface f(Context context, G.i[] iVarArr, int i) {
        try {
            FontFamily C3 = C(iVarArr, context.getContentResolver());
            if (C3 != null) {
                return new Typeface.CustomFallbackBuilder(C3).setStyle(B(C3, i).getStyle()).build();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // E1.b
    public final Typeface g(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily C3 = C((G.i[]) list.get(0), contentResolver);
            if (C3 != null) {
                Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(C3);
                for (int i3 = 1; i3 < list.size(); i3++) {
                    FontFamily C4 = C((G.i[]) list.get(i3), contentResolver);
                    if (C4 != null) {
                        customFallbackBuilder.addCustomFallback(C4);
                    }
                }
                return customFallbackBuilder.setStyle(B(C3, i).getStyle()).build();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // E1.b
    public final Typeface h(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // E1.b
    public final Typeface i(Context context, Resources resources, int i, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // E1.b
    public final G.i o(G.i[] iVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
