package com.example.recyclerviewcomplete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter(List<ModelClass> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int imageResource = userList.get(position).getImage();
        String nameResource = userList.get(position).getName();
        String messageResource = userList.get(position).getMessage();
        String timeResource = userList.get(position).getTime();

        holder.setData(imageResource, nameResource, messageResource, timeResource);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;
        private TextView message;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textName);
            message = itemView.findViewById(R.id.textMessage);
            time = itemView.findViewById(R.id.textTime);
        }

        public void setData(int imageResource, String nameResource, String messageResource, String timeResource) {
            image.setImageResource(imageResource);
            name.setText(nameResource);
            message.setText(messageResource);
            time.setText(timeResource);
        }
    }
}
