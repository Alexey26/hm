package com.example.alexey.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.RealmList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;


        public ListViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.textView1);
        }

        public void setName(String nameText) {
            nameView.setText(nameText);
        }
    }

    private RealmList<String> listDo;

    public MyAdapter(RealmList<String> listDo) {
        this.listDo = listDo;
    }

    @Override
    public int getItemCount() {
        return listDo.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, null);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListViewHolder userListViewHolder = (ListViewHolder) holder;
        userListViewHolder.setName(listDo.get(position));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
