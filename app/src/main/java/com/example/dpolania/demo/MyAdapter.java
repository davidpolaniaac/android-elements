package com.example.dpolania.demo;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private Cursor mDataset;

    public void setmDataset(Cursor mDataset) {
        this.mDataset = mDataset;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewTittle;
        public TextView mTextViewBody;
        public ViewHolder(View v) {
            super(v);
            mTextViewTittle = v.findViewById(R.id.textViewTitle);
            mTextViewBody = v.findViewById(R.id.textViewBody);
        }
    }

    public MyAdapter(Cursor myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        mDataset.moveToPosition(position);
        holder.mTextViewTittle.setText(mDataset.getString(mDataset.getColumnIndex(NotesDbAdapter.KEY_TITLE)));
        holder.mTextViewTittle.setText(mDataset.getString(mDataset.getColumnIndex(NotesDbAdapter.KEY_BODY)));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.getCount();
    }
}

