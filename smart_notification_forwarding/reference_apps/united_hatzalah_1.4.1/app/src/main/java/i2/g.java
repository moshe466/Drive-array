package i2;

import F0.AbstractC0008a;
import F2.p;
import N2.n;
import P2.E;
import a.AbstractC0228a;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.DocumentsContract;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.j;
import org.apache.tika.metadata.TikaCoreProperties;
import s2.C0684i;
import t2.AbstractC0707i;
import t2.C0716r;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class g extends AbstractC0793i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f4999a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0451b f5000b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f5001c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5002d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f5003e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f5004f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Intent intent, C0451b c0451b, Activity activity, int i, boolean z3, String str, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f4999a = intent;
        this.f5000b = c0451b;
        this.f5001c = activity;
        this.f5002d = i;
        this.f5003e = z3;
        this.f5004f = str;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new g(this.f4999a, this.f5000b, this.f5001c, this.f5002d, this.f5003e, this.f5004f, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        g gVar = (g) create((E) obj, (InterfaceC0763d) obj2);
        C0684i c0684i = C0684i.f6340a;
        gVar.invokeSuspend(c0684i);
        return c0684i;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        ArrayList parcelableArrayList;
        String str;
        List list;
        String separator;
        String str2;
        List list2;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        AbstractC0228a.C(obj);
        C0684i c0684i = C0684i.f6340a;
        C0451b c0451b = this.f5000b;
        Intent intent = this.f4999a;
        if (intent == null) {
            c0451b.b("unknown_activity", "Unknown activity error, please fill an issue.");
            return c0684i;
        }
        ArrayList arrayList = new ArrayList();
        ClipData clipData = intent.getClipData();
        int i = this.f5002d;
        boolean z3 = this.f5003e;
        int i3 = 0;
        Activity activity = this.f5001c;
        if (clipData != null) {
            ClipData clipData2 = intent.getClipData();
            j.b(clipData2);
            int itemCount = clipData2.getItemCount();
            while (i3 < itemCount) {
                ClipData clipData3 = intent.getClipData();
                j.b(clipData3);
                Uri uri = clipData3.getItemAt(i3).getUri();
                j.b(uri);
                h.a(activity, h.b(activity, uri, i), z3, arrayList);
                i3++;
            }
            c0451b.c(arrayList);
            return c0684i;
        }
        if (intent.getData() != null) {
            Uri data = intent.getData();
            j.b(data);
            Uri b4 = h.b(activity, data, i);
            if (this.f5004f.equals("dir")) {
                Uri buildDocumentUriUsingTree = DocumentsContract.buildDocumentUriUsingTree(b4, DocumentsContract.getTreeDocumentId(b4));
                j.d(buildDocumentUriUsingTree, "buildDocumentUriUsingTree(...)");
                int i4 = Build.VERSION.SDK_INT;
                Collection collection = C0716r.f6476a;
                if (i4 < 30 && j.a(buildDocumentUriUsingTree.getAuthority(), "com.android.providers.downloads.documents")) {
                    String documentId = DocumentsContract.getDocumentId(buildDocumentUriUsingTree);
                    str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                    if (!j.a(documentId, "downloads")) {
                        j.b(documentId);
                        Pattern compile = Pattern.compile("^ms[df]:.*");
                        j.d(compile, "compile(...)");
                        if (compile.matcher(documentId).matches()) {
                            str2 = AbstractC0008a.o(str2, RemoteSettings.FORWARD_SLASH_STRING, h.e(activity, buildDocumentUriUsingTree));
                        } else if (n.M(documentId, "raw:")) {
                            Pattern compile2 = Pattern.compile(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
                            j.d(compile2, "compile(...)");
                            N2.f.Y(0);
                            Matcher matcher = compile2.matcher(documentId);
                            if (!matcher.find()) {
                                list2 = T.b.B(documentId.toString());
                            } else {
                                ArrayList arrayList2 = new ArrayList(10);
                                int i5 = 0;
                                do {
                                    arrayList2.add(documentId.subSequence(i5, matcher.start()).toString());
                                    i5 = matcher.end();
                                } while (matcher.find());
                                arrayList2.add(documentId.subSequence(i5, documentId.length()).toString());
                                list2 = arrayList2;
                            }
                            if (!list2.isEmpty()) {
                                ListIterator listIterator = list2.listIterator(list2.size());
                                while (true) {
                                    if (!listIterator.hasPrevious()) {
                                        break;
                                    }
                                    if (((String) listIterator.previous()).length() != 0) {
                                        collection = AbstractC0707i.m0(listIterator.nextIndex() + 1, list2);
                                        break;
                                    }
                                }
                            }
                            str2 = ((String[]) collection.toArray(new String[0]))[1];
                        } else {
                            str2 = null;
                        }
                    }
                } else {
                    String treeDocumentId = DocumentsContract.getTreeDocumentId(buildDocumentUriUsingTree);
                    j.b(treeDocumentId);
                    List b02 = N2.f.b0(treeDocumentId, new String[]{TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER}, 6);
                    if (b02.size() > 1) {
                        String str3 = (String) b02.get(0);
                        String str4 = (String) b02.get(1);
                        if ("primary".equalsIgnoreCase(str3)) {
                            str = Environment.getExternalStorageDirectory() + RemoteSettings.FORWARD_SLASH_STRING + str4;
                        } else {
                            str = e0.a.f("/storage/", str3, RemoteSettings.FORWARD_SLASH_STRING, str4);
                        }
                    } else {
                        str = Environment.getExternalStorageDirectory() + RemoteSettings.FORWARD_SLASH_STRING + AbstractC0707i.i0(b02);
                    }
                    String separator2 = File.separator;
                    j.d(separator2, "separator");
                    if (n.I(str, separator2)) {
                        str = N2.f.P(str);
                    }
                    String treeDocumentId2 = DocumentsContract.getTreeDocumentId(buildDocumentUriUsingTree);
                    j.b(treeDocumentId2);
                    Pattern compile3 = Pattern.compile(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
                    j.d(compile3, "compile(...)");
                    N2.f.Y(0);
                    Matcher matcher2 = compile3.matcher(treeDocumentId2);
                    if (!matcher2.find()) {
                        list = T.b.B(treeDocumentId2.toString());
                    } else {
                        ArrayList arrayList3 = new ArrayList(10);
                        int i6 = 0;
                        do {
                            arrayList3.add(treeDocumentId2.subSequence(i6, matcher2.start()).toString());
                            i6 = matcher2.end();
                        } while (matcher2.find());
                        arrayList3.add(treeDocumentId2.subSequence(i6, treeDocumentId2.length()).toString());
                        list = arrayList3;
                    }
                    if (!list.isEmpty()) {
                        ListIterator listIterator2 = list.listIterator(list.size());
                        while (true) {
                            if (!listIterator2.hasPrevious()) {
                                break;
                            }
                            if (((String) listIterator2.previous()).length() != 0) {
                                collection = AbstractC0707i.m0(listIterator2.nextIndex() + 1, list);
                                break;
                            }
                        }
                    }
                    String[] strArr = (String[]) collection.toArray(new String[0]);
                    if (strArr.length >= 2) {
                        separator = strArr[1];
                    } else {
                        separator = File.separator;
                        j.d(separator, "separator");
                    }
                    String separator3 = File.separator;
                    j.d(separator3, "separator");
                    if (n.I(separator, separator3)) {
                        separator = N2.f.P(separator);
                    }
                    if (separator.length() <= 0 || n.I(str, separator)) {
                        str2 = str;
                    } else if (n.M(separator, separator3)) {
                        str2 = str.concat(separator);
                    } else {
                        str2 = AbstractC0008a.o(str, separator3, separator);
                    }
                }
                if (str2 != null) {
                    c0451b.c(str2);
                    return c0684i;
                }
                c0451b.b("unknown_path", "Failed to retrieve directory path.");
                return c0684i;
            }
            h.a(activity, b4, z3, arrayList);
            if (!arrayList.isEmpty()) {
                c0451b.c(arrayList);
                return c0684i;
            }
            c0451b.b("unknown_path", "Failed to retrieve path.");
            return c0684i;
        }
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("selectedItems")) {
            Bundle extras2 = intent.getExtras();
            j.b(extras2);
            if (Build.VERSION.SDK_INT >= 33) {
                parcelableArrayList = extras2.getParcelableArrayList("selectedItems", Parcelable.class);
            } else {
                parcelableArrayList = extras2.getParcelableArrayList("selectedItems");
            }
            if (parcelableArrayList != null) {
                ArrayList arrayList4 = new ArrayList();
                int size = parcelableArrayList.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj2 = parcelableArrayList.get(i7);
                    i7++;
                    if (obj2 instanceof Uri) {
                        arrayList4.add(obj2);
                    }
                }
                int size2 = arrayList4.size();
                while (i3 < size2) {
                    Object obj3 = arrayList4.get(i3);
                    i3++;
                    h.a(activity, (Uri) obj3, z3, arrayList);
                }
            }
            c0451b.c(arrayList);
            return c0684i;
        }
        c0451b.b("unknown_activity", "Unknown activity error, please fill an issue.");
        return c0684i;
    }
}
