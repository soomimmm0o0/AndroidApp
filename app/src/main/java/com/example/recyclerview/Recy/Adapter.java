package com.example.recyclerview.Recy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<ItemData> itemData;
    public Adapter(ArrayList<ItemData> itemData) {
        this.itemData = itemData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycle, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        ItemData item = itemData.get(position);
        holder.rank.setText(item.getSgrade());
        holder.cite.setText(item.getScite());
        holder.id.setText(item.getSId());
        holder.date.setText(item.getSdate());
        holder.contents.setText(item.getScontents());

    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView contents;
        TextView date;
        TextView id;
        TextView cite;
        TextView rank;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            contents = itemView.findViewById(R.id.contents);
            date=itemView.findViewById(R.id.review_date);
            id=itemView.findViewById(R.id.reviewId);
            cite=itemView.findViewById(R.id.cite);
            rank=itemView.findViewById(R.id.grade_num);
        }

    }
}
