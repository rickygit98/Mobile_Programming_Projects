package com.example.utsapp_31120013_rickyyohanes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Story_RecycleViewAdapter extends RecyclerView.Adapter<Story_RecycleViewAdapter.StoryViewHolder> {

    // From Stories Model Class
    private Context context;
    private ArrayList<Stories> storyArrayList;

    // For Onclick selected item / story
    private final RecyclerViewInterface recyclerViewInterface;

    public Story_RecycleViewAdapter(Context context, ArrayList<Stories> stories, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.storyArrayList = stories;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public Story_RecycleViewAdapter.StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_story,parent,false);
        return new Story_RecycleViewAdapter.StoryViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Story_RecycleViewAdapter.StoryViewHolder holder, int position) {
        //bind data from stories
        holder.storyTitle.setText(storyArrayList.get(position).getStoryTitle());
        holder.storySlug.setText(storyArrayList.get(position).getStorySlug());
        holder.storyImage.setImageResource(storyArrayList.get(position).getStoryImages());
    }

    @Override
    public int getItemCount() {
        // just want to know the number of item displayed
        return storyArrayList.size();
        //return (storyArrayList!=null) ? storyArrayList.size() : 0 ;
    }

    // Like constructor
    public static class StoryViewHolder extends RecyclerView.ViewHolder {

        private ImageView storyImage;
        private TextView storyTitle, storySlug;

        public StoryViewHolder(View itemView, RecyclerViewInterface recyclerViewInterface){
            super(itemView);
            storyTitle = itemView.findViewById(R.id.storyTitle);
            storySlug = itemView.findViewById(R.id.storySlug);
            storyImage = itemView.findViewById(R.id.storyImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
