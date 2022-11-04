package com.example.utsapp_31120013_rickyyohanes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class StoryTeller extends AppCompatActivity implements RecyclerViewInterface{

    private RecyclerView recyclerView;
    private Story_RecycleViewAdapter storyRecycleViewAdapter;

    private ArrayList<Stories> storyArrayList = new ArrayList<>();
    int[] storyImages = {
            R.drawable.story1,
            R.drawable.story2,
            R.drawable.story3,
            R.drawable.story4,
            R.drawable.story5,
            R.drawable.story6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_teller);

        setUpStoriesModel();

        recyclerView = findViewById(R.id.storyRecycleView);

        storyRecycleViewAdapter = new Story_RecycleViewAdapter(this, storyArrayList, this);
        recyclerView.setAdapter(storyRecycleViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(StoryTeller.this));

    }

    // Data from array list in string value
    public void setUpStoriesModel(){
        String[] storiesTitle = getResources().getStringArray(R.array.story_title);
        String[] storiesSlug = getResources().getStringArray(R.array.story_slug);
        String[] storiesDescription = getResources().getStringArray(R.array.story_description);
        String[] storiesMoral = getResources().getStringArray(R.array.story_moral);

        for (int i = 0; i < storiesTitle.length; i++){
            storyArrayList.add(new Stories(storiesTitle[i],storiesSlug[i], storiesDescription[i], storiesMoral[i], storyImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(StoryTeller.this,Story_Detail.class);

        intent.putExtra("TITLE",storyArrayList.get(position).getStoryTitle());
        intent.putExtra("IMG",storyArrayList.get(position).getStoryImages());
        intent.putExtra("DESC",storyArrayList.get(position).getStoryDescription());
        intent.putExtra("MORAL",storyArrayList.get(position).getStoryMoral());

        startActivity(intent);
    }
}