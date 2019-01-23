package android.example.com.json_app.controller;

import android.content.Intent;
import android.example.com.json_app.DisplayActivity;
import android.example.com.json_app.R;
import android.example.com.json_app.models.Android;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {
    List<Android> androidArrayList;

    public AndroidAdapter(List<Android> androidArrayList) {
        this.androidArrayList = androidArrayList;
    }

    @NonNull
    @Override
    public AndroidViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.android_list_view, viewGroup, false);
        return new AndroidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AndroidViewHolder androidViewHolder, int i) {
        androidViewHolder.onBind(androidArrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return androidArrayList.size();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder {
        TextView versionTextview;
        TextView nameTextview;
        TextView apiTextview;

        public AndroidViewHolder(@NonNull View itemView) {
            super(itemView);
            this.versionTextview = itemView.findViewById(R.id.version_textview);
            this.nameTextview = itemView.findViewById(R.id.name_textview);
            this.apiTextview = itemView.findViewById(R.id.api_textview);
        }

        public void onBind(final Android android) {
            versionTextview.setText(android.getVersion());
            nameTextview.setText(android.getName());
            apiTextview.setText(android.getApiLevel());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                    intent.putExtra("android", android.toString());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

}
