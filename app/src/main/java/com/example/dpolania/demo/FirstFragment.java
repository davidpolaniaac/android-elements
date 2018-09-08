package com.example.dpolania.demo;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first, container, false);
        showNotes();
        return view;
    }

    public void showNotes() {

        LinearLayout notesContainer = view.findViewById(R.id.notesContainer);
        notesContainer.removeAllViews();

        NotesDbAdapter notesDbAdapter = new NotesDbAdapter(getActivity());
        notesDbAdapter.open();
        Cursor cursor = notesDbAdapter.fetchAllNotes();
        if (cursor.moveToFirst()){
            do {
                String note = cursor.getString(cursor.getColumnIndex(NotesDbAdapter.KEY_BODY));
                TextView textView = new TextView(getActivity());
                textView.setText(note);
                notesContainer.addView(textView);

            }while (cursor.moveToNext());
        }
        notesDbAdapter.close();
    }

}
