package com.example.recyclerviewcomplete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.hardware.lights.LightState;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<ModelClass> userList = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();
    }

    public void initRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void initData() {

        userList.add(new ModelClass(R.drawable.u1, "Anand", "How are you ?", "10:45 AM"));
        userList.add(new ModelClass(R.drawable.u2, "Ajay", "Are you free ?", "11:45 AM"));
        userList.add(new ModelClass(R.drawable.u3, "Meet", "Good Morning", "12:45 AM"));
        userList.add(new ModelClass(R.drawable.u4, "Ria", "How are you ?", "1:45 AM"));
        userList.add(new ModelClass(R.drawable.u1, "Jay", "Let's have a meet ?", "2:45 PM"));
        userList.add(new ModelClass(R.drawable.u2, "Sia", "Har Har Mahadev", "5:45 PM"));
        userList.add(new ModelClass(R.drawable.u3, "Rose", "What's the time", "7:45 PM"));
        userList.add(new ModelClass(R.drawable.u4, "Joise", "How are you ?", "10:45 PM"));
    }
}