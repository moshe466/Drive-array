package m;

import F0.G1;
import J.C0116d;
import J.InterfaceC0115c;
import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* renamed from: m.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0525D {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        InterfaceC0115c interfaceC0115c;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                interfaceC0115c = new G1(clipData, 3);
            } else {
                C0116d c0116d = new C0116d();
                c0116d.f977b = clipData;
                c0116d.f978c = 3;
                interfaceC0115c = c0116d;
            }
            J.S.g(textView, interfaceC0115c.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        InterfaceC0115c interfaceC0115c;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            interfaceC0115c = new G1(clipData, 3);
        } else {
            C0116d c0116d = new C0116d();
            c0116d.f977b = clipData;
            c0116d.f978c = 3;
            interfaceC0115c = c0116d;
        }
        J.S.g(view, interfaceC0115c.build());
        return true;
    }
}
