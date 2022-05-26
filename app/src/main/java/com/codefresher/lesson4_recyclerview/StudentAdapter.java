package com.codefresher.lesson4_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder>{

    //Dữ liệu hiện thị là danh sách sinh viên
    private ArrayList<Student> mStutents;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;

    public StudentAdapter(ArrayList<Student> _student, Context mContext) {
        this.mStutents = _student;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View studentView = null;

        switch (viewType) {
            case TYPE1:
                studentView =
                        inflater.inflate(R.layout.student_item,
                                parent, false);
                break;
            case TYPE2:
                studentView =
                        inflater.inflate(R.layout.student_item2,
                                parent, false);
                break;
        }

        MyViewHolder viewHolder = new MyViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student student = mStutents.get(position);


        holder.studentname.setText(student.getsName());
        holder.birthyear.setText(student.getAge() + "");
    }

    //Hằng số hai kiểu hiện thị phần tử

    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;

    /**
     * Những phần tử chia hết cho 3 có kiểu 1, còn lại kiểu 0
     */

//    @Override
//    public int getItemViewType(int position) {
//        if (position % 3 == 0)
//            return TYPE2;
//        else
//            return TYPE1;
//    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0)
            return TYPE2;
        else
            return TYPE1;
    }

    @Override
    public int getItemCount() {
        return mStutents.size();
    }

    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        //private View itemview;
        public TextView studentname;
        public TextView birthyear;
        public Button detail_button;

        public MyViewHolder(View itemView) {
            super(itemView);
            //itemview = itemView;
            studentname = itemView.findViewById(R.id.studentname);
            birthyear = itemView.findViewById(R.id.birthyear);
            detail_button = itemView.findViewById(R.id.detail_button);

            //Xử lý khi nút Chi tiết được bấm
            detail_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                                    studentname.getText() + " | "
                                            + " Demo function", Toast.LENGTH_SHORT)
                            .show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),
                                    studentname.getText() + " | "
                                            + " Demo function", Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }
}
