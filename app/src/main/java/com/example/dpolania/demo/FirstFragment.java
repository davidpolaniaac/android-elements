package com.example.dpolania.demo;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;
    private NotesDbAdapter notesDbAdapter;
    private Cursor cursor;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        notesDbAdapter = new NotesDbAdapter(getActivity());
        notesDbAdapter.open();
        cursor = notesDbAdapter.fetchAllNotes();
        mAdapter = new MyAdapter(cursor);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        notesDbAdapter.close();
    }

    public void updateNotes() {

        cursor = notesDbAdapter.fetchAllNotes();
        mAdapter.setmDataset(cursor);
        mAdapter.notifyDataSetChanged();

    }
}
