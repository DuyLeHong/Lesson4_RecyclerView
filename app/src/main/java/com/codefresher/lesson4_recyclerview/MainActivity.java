package com.codefresher.lesson4_recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Calendar;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_modify_3:
                //Sửa đội phần tử số 3
                Student student = arrDatas.get(2);
                student.setsName("TÊN MỚI SỐ 3: "
                        + Calendar.getInstance().getTimeInMillis());

                long millis = System.currentTimeMillis();

                student.setAge(2000);

                //studentAdapter.notifyDataSetChanged();
                studentAdapter.notifyItemChanged(2);

                //adapter.notifyDataSetChanged();
                return true;

            case R.id.menu_insert_2:
                //Thêm một sinh viên mới vào vị trí số 2
                Student newStudent = new Student("SINH VIÊN 2:"
                        + Calendar.getInstance().getTimeInMillis(), 1990);
                arrDatas.add(1, newStudent);
                studentAdapter.notifyItemInserted(1);
                return true;

            case R.id.menu_remove_first:
                //Xóa sinh viên ở vị trí đầu tiên
                arrDatas.remove(0);
                studentAdapter.notifyItemRemoved(0);
                return true;
            case R.id.menu_new_7:
                //Danh sách 7 sinh viên mới

                arrDatas.clear();//Xóa bỏ danh sách cũ

                //Thêm 7 sinh viên mới
                for (int i = 1; i <= 7; i++)
                    arrDatas.add(new Student("SV Mới " + i, 1990 + i));

                //Thông báo toàn bộ dữ liệu thay đổi
                studentAdapter.notifyDataSetChanged();

                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}