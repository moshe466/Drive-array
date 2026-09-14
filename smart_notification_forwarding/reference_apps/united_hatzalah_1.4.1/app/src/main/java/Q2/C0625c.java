package q2;

import F0.Q2;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.uh.sf.R;
import io.flutter.FlutterInjector;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.j;

/* renamed from: q2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0625c implements MethodChannel.MethodCallHandler {

    /* renamed from: a, reason: collision with root package name */
    public Context f6156a;

    /* renamed from: b, reason: collision with root package name */
    public Toast f6157b;

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall call, MethodChannel.Result result) {
        int i;
        Toast toast;
        Context context = this.f6156a;
        j.e(call, "call");
        j.e(result, "result");
        String str = call.method;
        View view = null;
        if (j.a(str, "showToast")) {
            String valueOf = String.valueOf(call.argument("msg"));
            String valueOf2 = String.valueOf(call.argument("length"));
            String valueOf3 = String.valueOf(call.argument("gravity"));
            Number number = (Number) call.argument("bgcolor");
            Number number2 = (Number) call.argument("textcolor");
            Number number3 = (Number) call.argument("fontSize");
            String str2 = (String) call.argument("fontAsset");
            if (valueOf3.equals("top")) {
                i = 48;
            } else if (valueOf3.equals("center")) {
                i = 17;
            } else {
                i = 80;
            }
            boolean equals = valueOf2.equals("long");
            if (number != null) {
                Object systemService = context.getSystemService("layout_inflater");
                j.c(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View inflate = ((LayoutInflater) systemService).inflate(R.layout.toast_custom, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.text);
                textView.setText(valueOf);
                Drawable drawable = context.getDrawable(R.drawable.corner);
                j.b(drawable);
                drawable.setColorFilter(number.intValue(), PorterDuff.Mode.SRC_IN);
                textView.setBackground(drawable);
                if (number3 != null) {
                    textView.setTextSize(number3.floatValue());
                }
                if (number2 != null) {
                    textView.setTextColor(number2.intValue());
                }
                Toast toast2 = new Toast(context);
                this.f6157b = toast2;
                toast2.setDuration(equals ? 1 : 0);
                if (str2 != null) {
                    AssetManager assets = context.getAssets();
                    j.d(assets, "getAssets(...)");
                    String lookupKeyForAsset = FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str2);
                    j.d(lookupKeyForAsset, "getLookupKeyForAsset(...)");
                    textView.setTypeface(Typeface.createFromAsset(assets, lookupKeyForAsset));
                }
                Toast toast3 = this.f6157b;
                if (toast3 != null) {
                    toast3.setView(inflate);
                }
            } else {
                Toast makeText = Toast.makeText(context, valueOf, equals ? 1 : 0);
                this.f6157b = makeText;
                if (Build.VERSION.SDK_INT < 30) {
                    if (makeText != null) {
                        view = makeText.getView();
                    }
                    j.b(view);
                    View findViewById = view.findViewById(android.R.id.message);
                    j.d(findViewById, "findViewById(...)");
                    TextView textView2 = (TextView) findViewById;
                    if (number3 != null) {
                        textView2.setTextSize(number3.floatValue());
                    }
                    if (number2 != null) {
                        textView2.setTextColor(number2.intValue());
                    }
                    if (str2 != null) {
                        AssetManager assets2 = context.getAssets();
                        j.d(assets2, "getAssets(...)");
                        String lookupKeyForAsset2 = FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str2);
                        j.d(lookupKeyForAsset2, "getLookupKeyForAsset(...)");
                        textView2.setTypeface(Typeface.createFromAsset(assets2, lookupKeyForAsset2));
                    }
                }
            }
            if (number != null) {
                try {
                    if (i != 17) {
                        if (i != 48) {
                            Toast toast4 = this.f6157b;
                            if (toast4 != null) {
                                toast4.setGravity(i, 0, 100);
                            }
                        } else {
                            Toast toast5 = this.f6157b;
                            if (toast5 != null) {
                                toast5.setGravity(i, 0, 100);
                            }
                        }
                    } else {
                        Toast toast6 = this.f6157b;
                        if (toast6 != null) {
                            toast6.setGravity(i, 0, 0);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new Q2(this, 16));
            } else {
                Toast toast7 = this.f6157b;
                if (toast7 != null) {
                    toast7.show();
                }
            }
            if (Build.VERSION.SDK_INT >= 30 && (toast = this.f6157b) != null) {
                toast.addCallback(new C0624b(this));
            }
            result.success(Boolean.TRUE);
            return;
        }
        if (j.a(str, "cancel")) {
            Toast toast8 = this.f6157b;
            if (toast8 != null) {
                toast8.cancel();
                this.f6157b = null;
            }
            result.success(Boolean.TRUE);
            return;
        }
        result.notImplemented();
    }
}
