package atlow.chemi.mymada.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.classes.Volunteer;
import atlow.chemi.mymada.helpers.Event;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.MyViewHolder> {
    public Event<ChangeVolunteer> DeleteVolunteerEvent = new Event<>();
    public Event<ChangeVolunteer> EditVolunteerEvent = new Event<>();
    private List<Volunteer> albumList;
    private Context mContext;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface ChangeVolunteer {
        void invoke(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        int a;

        private MyMenuItemClickListener(int i) {
            this.a = i;
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.action_delete) {
                Iterator<ChangeVolunteer> it = VolunteerAdapter.this.DeleteVolunteerEvent.listeners().iterator();
                while (it.hasNext()) {
                    it.next().invoke(this.a);
                }
                return true;
            }
            if (itemId != R.id.action_edit) {
                return false;
            }
            Iterator<ChangeVolunteer> it2 = VolunteerAdapter.this.EditVolunteerEvent.listeners().iterator();
            while (it2.hasNext()) {
                it2.next().invoke(this.a);
            }
            return true;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView count;
        private ImageView overflow;
        private ImageView thumbnail;
        private TextView title;

        public MyViewHolder(View view) {
            super(view);
            view.setRotationY(180.0f);
            this.title = (TextView) view.findViewById(R.id.title);
            this.count = (TextView) view.findViewById(R.id.count);
            this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            this.overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }

    public VolunteerAdapter(Context context, List<Volunteer> list) {
        this.mContext = context;
        this.albumList = list;
    }

    private void showPopupMenu(View view, int i) {
        PopupMenu popupMenu = new PopupMenu(this.mContext, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu2, popupMenu.getMenu());
        popupMenu.setGravity(GravityCompat.START);
        popupMenu.setOnMenuItemClickListener(new MyMenuItemClickListener(i));
        popupMenu.show();
    }

    public /* synthetic */ void a(MyViewHolder myViewHolder, View view) {
        showPopupMenu(myViewHolder.overflow, myViewHolder.getAdapterPosition());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.albumList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        Volunteer volunteer = this.albumList.get(myViewHolder.getAdapterPosition());
        int[] iArr = {R.color.hovesh, R.color.hovesh, R.color.para, R.color.para, R.color.noar, R.color.hovesh, R.color.hovesh};
        String str = new String[]{"נהג", "חובש", "פראמדיק", "רופא", "מתנדב", "משתלם", "שירות לאומי"}[volunteer.getJob()];
        myViewHolder.title.setText(volunteer.getName());
        myViewHolder.count.setText(str);
        Typeface createFromAsset = Typeface.createFromAsset(this.mContext.getAssets(), "fonts/opensanshebrew.ttf");
        myViewHolder.title.setTypeface(createFromAsset);
        myViewHolder.count.setTypeface(createFromAsset);
        myViewHolder.thumbnail.setColorFilter(this.mContext.getResources().getColor(iArr[volunteer.getJob()]));
        myViewHolder.overflow.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.adapters.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VolunteerAdapter.this.a(myViewHolder, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.volunteer_layout, viewGroup, false));
    }
}
