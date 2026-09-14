package w6;

import android.content.Context;
import android.os.Build;
import il.org.mda.health.R;
import java.util.ArrayList;
import w6.t;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    static com.groboot.mdaemergency.enums.a f15262a;

    public static ArrayList<t> a(Context context) {
        t tVar;
        f15262a = m.m();
        ArrayList<t> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 23) {
            tVar = new t();
            tVar.f15258b = context.getString(R.string.permission_irrelevant);
            tVar.f15257a = context.getString(R.string.permission_irrelevant_description);
        } else {
            t tVar2 = new t();
            tVar2.f15258b = context.getString(R.string.permission_phone_status);
            tVar2.f15257a = context.getString(R.string.permission_phone_status_description);
            tVar2.f15259c.add("android.permission.READ_PHONE_STATE");
            tVar2.f15261e = t.a.Phone;
            arrayList.add(tVar2);
            com.groboot.mdaemergency.enums.a aVar = f15262a;
            com.groboot.mdaemergency.enums.a aVar2 = com.groboot.mdaemergency.enums.a.MADA;
            if (aVar == aVar2) {
                t tVar3 = new t();
                tVar3.f15258b = context.getString(R.string.video_recording);
                tVar3.f15257a = context.getString(R.string.permission_video_recording_description);
                tVar3.f15259c.add("android.permission.RECORD_AUDIO");
                tVar3.f15261e = t.a.Audio;
                arrayList.add(tVar3);
            }
            if (m.t()) {
                t tVar4 = new t();
                tVar4.f15258b = context.getString(R.string.location_a_device);
                tVar4.f15257a = context.getString(R.string.permission_location_a_device_descrption);
                tVar4.f15259c.add("android.permission.ACCESS_COARSE_LOCATION");
                tVar4.f15259c.add("android.permission.ACCESS_FINE_LOCATION");
                tVar4.f15261e = t.a.Location;
                arrayList.add(tVar4);
            }
            if (f15262a != com.groboot.mdaemergency.enums.a.CREW) {
                t tVar5 = new t();
                tVar5.f15258b = context.getString(R.string.permission_access_to_file);
                tVar5.f15257a = context.getString(R.string.permission_access_to_file_description);
                tVar5.f15259c.add("android.permission.READ_EXTERNAL_STORAGE");
                tVar5.f15259c.add("android.permission.WRITE_EXTERNAL_STORAGE");
                tVar5.f15261e = t.a.IO;
                t tVar6 = new t();
                tVar6.f15258b = context.getString(R.string.camera);
                tVar6.f15257a = context.getString(R.string.permission_camera_description);
                tVar6.f15259c.add("android.permission.CAMERA");
                tVar6.f15261e = t.a.Camera;
                arrayList.add(tVar6);
            }
            tVar = new t();
            tVar.f15258b = context.getString(R.string.permission_view_over_apps);
            tVar.f15257a = context.getString(f15262a != aVar2 ? R.string.permission_view_over_apps_description_2 : R.string.permission_view_over_apps_description);
            tVar.f15260d = true;
            tVar.f15261e = t.a.Overlay;
        }
        arrayList.add(tVar);
        return arrayList;
    }
}
