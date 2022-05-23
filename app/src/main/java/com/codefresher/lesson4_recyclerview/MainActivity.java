package com.codefresher.lesson4_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> arrDatas = new ArrayList<>();

    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rclView = findViewById(R.id.rcl_view);

        for (int i = 1; i <= 50; i++) {
            arrDatas.add(new Student("Student name " + i, 2000 + (i % 2)));
        }

        studentAdapter = new StudentAdapter(arrDatas, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        rclView.setAdapter(studentAdapter);
        rclView.setLayoutManager(linearLayoutManager);

    }
}