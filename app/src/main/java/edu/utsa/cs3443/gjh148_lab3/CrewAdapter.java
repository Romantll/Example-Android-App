package edu.utsa.cs3443.gjh148_lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example_android_app.R;

import java.util.List;

import edu.utsa.cs3443.gjh148_lab3.model.CrewMember;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewViewHolder> {

    private Context context;
    private List<CrewMember> crewList;

    public CrewAdapter(Context context, List<CrewMember> crewList) {
        this.context = context;
        this.crewList = crewList;
    }

    @NonNull
    @Override
    public CrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.crew_member_item, parent, false);
        return new CrewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewViewHolder holder, int position) {
        CrewMember cm = crewList.get(position);

        holder.tvPosition.setText(cm.getPosition());
        holder.tvNameRank.setText(cm.getRank() + " " + cm.getFullName());

        // Get last name from full name (last word)
        String[] nameParts = cm.getFullName().toLowerCase().split(" ");
        String imageName = nameParts[nameParts.length - 1];

        int imageResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        if (imageResId != 0) {
            holder.imageView.setImageResource(imageResId);
        } else {
            holder.imageView.setImageResource(R.drawable.default_crew); // fallback image
        }
    }

    @Override
    public int getItemCount() {
        return crewList.size();
    }

    public static class CrewViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvPosition, tvNameRank;

        public CrewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvNameRank = itemView.findViewById(R.id.tvNameRank);
        }
    }
}
