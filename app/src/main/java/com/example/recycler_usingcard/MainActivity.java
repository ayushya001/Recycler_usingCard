package com.example.recycler_usingcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.recycler_usingcard.Adapterclass.MyAdapter;
import com.example.recycler_usingcard.Modelclass.Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        rcv = findViewById(R.id.rcv);


        //getSupportFragmentManager().beginTransaction().replace(R.id.fm,new dataFragment()).commit();

//for vertical view -->
      //  rcv.setLayoutManager(new LinearLayoutManager(this));
       // adapter = new MyAdapter(dataqueqe()); --> send only arraylist not for clickonlistner

        // for add onClicklistner
        adapter = new MyAdapter(dataqueqe(),getApplicationContext());

        rcv.setAdapter(adapter);
        //getSupportActionBar().hide();

 //for horizontal view -->
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        rcv.setLayoutManager(linearLayoutManager);

// for gridal layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcv.setLayoutManager(gridLayoutManager);


    }
    public ArrayList<Model> dataqueqe(){
        ArrayList<Model> holder = new ArrayList<>();

        Model ob1 = new Model();
        ob1.setHeader("Ayush thakur holdings");
        ob1.setDesc("An multinational company");
        ob1.setImgname(R.drawable.nature2);
        holder.add(ob1);

        Model ob2 = new Model();
        ob2.setHeader("Ayush realstate");
        ob2.setDesc("An multinational company");
        ob2.setImgname(R.drawable.nature3);
        holder.add(ob2);

        Model ob3 = new Model();
        ob3.setHeader("Ayush thakur ");
        ob3.setDesc("An  company");
        ob3.setImgname(R.drawable.nature4);
        holder.add(ob3);

        Model ob4 = new Model();
        ob4.setHeader("Ayush  holdings");
        ob4.setDesc("An international company");
        ob4.setImgname(R.drawable.nature5);
        holder.add(ob4);

        Model ob5 = new Model();
        ob5.setHeader("Ayushya thakur holdings");
        ob5.setDesc("An multinational company");
        ob5.setImgname(R.drawable.nature6);
        holder.add(ob5);

        Model ob6 = new Model();
        ob6.setHeader("Ayushya holdings");
        ob6.setDesc("Nothing is impossible");
        ob6.setImgname(R.drawable.nature7);
        holder.add(ob6);

        return holder;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mainicon,menu);
        MenuItem item=menu.findItem(R.id.searh_menu);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}