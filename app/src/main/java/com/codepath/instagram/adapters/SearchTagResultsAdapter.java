package com.codepath.instagram.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codepath.instagram.R;
import com.codepath.instagram.helpers.Utils;
import com.codepath.instagram.models.InstagramSearchTag;

import java.util.List;

/**
 * Created by trit on 10/31/15.
 */
public class SearchTagResultsAdapter extends RecyclerView.Adapter<SearchTagResultsAdapter.InstagramSearchTagViewHolder> {
    private List<InstagramSearchTag> tags;


    public SearchTagResultsAdapter(List<InstagramSearchTag> tags) {
        this.tags = tags;
    }

    public void replaceAll(List<InstagramSearchTag> tags) {
        this.tags.clear();
        this.tags.addAll(tags);
        this.notifyDataSetChanged();
    }

    @Override
    public InstagramSearchTagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_tag_result, parent, false);
        return new InstagramSearchTagViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InstagramSearchTagViewHolder holder, int position) {
        InstagramSearchTag tag = tags.get(position);
        String postFix = tag.count == 1 ? "post" : "posts";
        holder.tvPostCount.setText(Utils.formatNumberForDisplay(tag.count) + " " + postFix);
        holder.tvTag.setText("#" + tag.tag);
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public class InstagramSearchTagViewHolder extends RecyclerView.ViewHolder {
        TextView tvTag;
        TextView tvPostCount;

        public InstagramSearchTagViewHolder(View itemView) {
            super(itemView);
            tvTag = (TextView) itemView.findViewById(R.id.tvTag);
            tvPostCount = (TextView) itemView.findViewById(R.id.tvPostCount);
        }

    }
}
