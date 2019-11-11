package com.example.presidents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.presidents.adapter.PresidentsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    //Toolbar mActionBarToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        List<Presidents> presidentsList = new ArrayList<>();
        presidentsList.add(new Presidents("Vidhya Devi Bhandari",R.drawable.v,"Bidhya Devi Bhandari is a Nepalese politician who is the current President of Nepal. She is the first woman to hold the office. She was the vice-chairperson of the Communist Party of Nepal and chair of the All Nepal Women Association before winning the presidential election on 28 October 2015."));
        presidentsList.add(new Presidents("Narendra Modi",R.drawable.n,"Narendra Damodardas Modi is an Indian politician serving as the 14th and current Prime Minister of India since 2014. He was the Chief Minister of Gujarat from 2001 to 2014 and is the Member of Parliament for Varanasi."));
        presidentsList.add(new Presidents("Xi Jinping",R.drawable.x,"Xi Jinping is a Chinese politician serving as General Secretary of the Communist Party of China, President of the People's Republic of China and Chairman of the Central Military Commission."));
        presidentsList.add(new Presidents("Barack Obama",R.drawable.b,"Barack Hussein Obama II is an American attorney and politician who served as the 44th president of the United States from 2009 to 2017."));
        presidentsList.add(new Presidents("Donald Trump",R.drawable.d,"Donald John Trump is the 45th and current president of the United States. Before entering politics, he was a businessman and television personality. "));
        presidentsList.add(new Presidents("George W. Bush",R.drawable.g,"George Walker Bush is an American politician and businessman who served as the 43rd president of the United States from 2001 to 2009. He had previously served as the 46th governor of Texas from 1995 to 2000."));

        PresidentsAdapter presidentsAdapter = new PresidentsAdapter(this,presidentsList);
        recyclerView.setAdapter(presidentsAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}
