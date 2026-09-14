package w6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class o {
    @SuppressLint({"NewApi"})
    public static void a(Context context, Location location, o5.e eVar) {
        if (location == null || context == null) {
            eVar.a(null, location);
            return;
        }
        try {
            List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation != null && fromLocation.size() != 0) {
                String addressLine = fromLocation.get(0).getAddressLine(0);
                fromLocation.get(0).getLocality();
                fromLocation.get(0).getAdminArea();
                fromLocation.get(0).getCountryName();
                fromLocation.get(0).getPostalCode();
                fromLocation.get(0).getFeatureName();
                eVar.a(addressLine, location);
                return;
            }
            eVar.a(null, location);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static LatLng b(Context context, String str) {
        try {
            List<Address> fromLocationName = new Geocoder(context).getFromLocationName(str, 7);
            if (fromLocationName == null) {
                return null;
            }
            Address address = fromLocationName.get(0);
            return new LatLng(address.getLatitude(), address.getLongitude());
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
