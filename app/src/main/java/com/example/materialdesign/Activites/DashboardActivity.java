package com.example.materialdesign.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.materialdesign.Adapter.TrendsAdapter;
import com.example.materialdesign.Domains.TrendsDomain;
import com.example.materialdesign.R;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTrendList;
    private RecyclerView recyclerViewTrends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initRecyclerView();
        BottomNavigation();
        

    }

    private void BottomNavigation() {
        LinearLayout profileBtn =findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,ProfileActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<TrendsDomain> items= new ArrayList<>();
        items.add(new TrendsDomain("AI's Healthcare Evolution:", "Precision Medicine and Diagnostics Redefined","trends"));
        items.add(new TrendsDomain("Ethical AI:", "Navigating Bias and Accountability in Technology","trends2"));
        items.add(new TrendsDomain("Ethical AI:", "Navigating Bias and Accountability in Technology","trends"));


        recyclerViewTrends=findViewById(R.id.view);
        recyclerViewTrends.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterTrendList = new TrendsAdapter(items);
        recyclerViewTrends.setAdapter(adapterTrendList);
    }
}