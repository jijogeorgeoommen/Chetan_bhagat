package com.example.user.chetan_bhagat;

import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView vertical_recyclerview;
    private VerticalAdapter verticalAdapter;
    private ArrayList<String>namestr;
    private int[] image={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView mImageviewFilling=findViewById(R.id.imageview_animation);
        ((AnimationDrawable) mImageviewFilling.getBackground()).start();

        vertical_recyclerview=findViewById(R.id.verticalrview);
        namestr=new ArrayList<String>();
        namestr.add("Five Point Someone");
        namestr.add("Night At The Call Center");
        namestr.add("3 Mistakes of My Life");
        namestr.add("2 States");
        namestr.add("Revolution 2020");
        namestr.add("What Young India Wants");
        namestr.add("Half Girlfriend");
        namestr.add("Making India Awesome");
        namestr.add("One Indian Girl");
        namestr.add("The Girl In Room 105");

        verticalAdapter=new VerticalAdapter(namestr);
        LinearLayoutManager verticalLayoutManager=new LinearLayoutManager(Main2Activity.this,LinearLayoutManager.VERTICAL,false);
        vertical_recyclerview.setAdapter(verticalAdapter);
        vertical_recyclerview.setLayoutManager(verticalLayoutManager);
    }
    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {
        private List<String>namlist;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView photo;
            public TextView tview;


            public MyViewHolder(View view) {
                super(view);
                photo = view.findViewById(R.id.iconid);
                tview = view.findViewById(R.id.txtviewid);
            }
        }
        public VerticalAdapter(List<String>namestr){
            this.namlist=namestr;
        }

        @NonNull
        @Override
        public VerticalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vertical, viewGroup, false);
            return new MyViewHolder(item);
        }


        @Override
        public void onBindViewHolder(final MyViewHolder myViewHolder,final int i) {
            myViewHolder.photo.setImageResource(image[i]);
            myViewHolder.tview.setText(namestr.get(i));
            myViewHolder.tview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main2Activity.this, myViewHolder.tview.getText().toString(), Toast.LENGTH_SHORT).show();
                    String nam = namestr.get(i);
                    if (i == 0) {
                        LayoutInflater inflat = LayoutInflater.from(Main2Activity.this);
                        View cuslay = inflat.inflate(R.layout.fivepoint, null);
                        final ImageView ironmanpic = cuslay.findViewById(R.id.image);
                        TextView ironman = cuslay.findViewById(R.id.text);
                        AlertDialog.Builder AB = new AlertDialog.Builder(Main2Activity.this);
                        AB.setView(cuslay);
                        final AlertDialog A = AB.create();
                        A.show();
                        ironmanpic.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ironmanpic.setBackgroundResource(R.drawable.a1);
                                A.dismiss();
                            }

                        });


                    }
                    if(i==1){
                        LayoutInflater inflat = LayoutInflater.from(Main2Activity.this);
                        View cuslay = inflat.inflate(R.layout.nightat, null);
                        final ImageView ironmanpic = cuslay.findViewById(R.id.nightimage);
                        TextView ironman = cuslay.findViewById(R.id.nighttxt);
                        AlertDialog.Builder AB = new AlertDialog.Builder(Main2Activity.this);
                        AB.setView(cuslay);
                        final AlertDialog A = AB.create();
                        A.show();
                        ironmanpic.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ironmanpic.setBackgroundResource(R.drawable.a2);
                                A.dismiss();
                            }

                        });

                    }
                }
            });
            myViewHolder.photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main2Activity.this,myViewHolder.tview.getText(), Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return namlist.size();
        }
    }
}
