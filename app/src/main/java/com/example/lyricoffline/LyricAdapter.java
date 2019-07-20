package com.example.lyricoffline;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LyricAdapter extends RecyclerView.Adapter<LyricAdapter.LyricViewHolder>{
    private List<Lyric> lyrics;
    private Context mCtx;

    public LyricAdapter(ArrayList<Lyric> lyrics, Context mCtx) {
        this.lyrics = lyrics;
        this.mCtx = mCtx;
    }
    @Override
    public LyricViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new LyricViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LyricViewHolder holder, int position) {
        Lyric lyric = lyrics.get(position);
        holder.txtTitle.setText(lyric.getTitle());
        holder.txtArtist.setText(lyric.getArtist());
    }

    @Override
    public int getItemCount() {
        return lyrics.size();
    }

    public class LyricViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle, txtArtist;

        public LyricViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtArtist = (TextView) itemView.findViewById(R.id.txt_artist);
        }
    }
}
