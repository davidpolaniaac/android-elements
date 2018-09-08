package com.example.dpolania.demo;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TabsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private FloatingActionButton fabBtn ;
    public static final int CREATE_NOTE = 1;
    private ViewPager mViewPager;
    private MyPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        fabBtn = (FloatingActionButton) findViewById(R.id.fabBtn);

        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TabsActivity.this, CreateNoteActivity.class);
                startActivityForResult(intent,CREATE_NOTE);
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(data!=null){
            if(requestCode == CREATE_NOTE){
                String note = data.getStringExtra(CreateNoteActivity.EXTRA_MESSAGE);
                saveNote(note);
                ((FirstFragment)mViewPagerAdapter.getItem(0)).showNotes();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void saveNote(String note) {
        NotesDbAdapter notesDbAdapter = new NotesDbAdapter(this);
        notesDbAdapter.open();
        notesDbAdapter.createNote("",note);
        notesDbAdapter.close();
    }
}
