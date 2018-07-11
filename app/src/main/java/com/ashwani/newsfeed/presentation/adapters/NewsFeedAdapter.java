package com.ashwani.newsfeed.presentation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ashwani.newsfeed.R;
import com.ashwani.newsfeed.customviews.CircularImageView;
import com.ashwani.newsfeed.domain.model.ResultDomain;
import com.ashwani.newsfeed.entity.model.MediaMetadatum;
import com.ashwani.newsfeed.entity.model.Medium;
import com.ashwani.newsfeed.entity.model.Result;
import com.ashwani.newsfeed.utility.AppUtils;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Picasso picasso;
    private Context mContext;
    private List<ResultDomain> mNewsFeedResults;
    private NewsFeedClickListener mClickListener;

    @Inject
    public NewsFeedAdapter(Context context, Picasso picasso) {
        this.mContext = context;
        this.picasso = picasso;
    }

    public void setNewsFeedModel(List<ResultDomain> newsFeeds) {
        mNewsFeedResults = newsFeeds;
    }

    public void setClickListener(NewsFeedClickListener clickListener) {
        this.mClickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.mContext).inflate(R.layout.layout_news_feed_item, parent, false);
        return new NewsFeedItemHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        NewsFeedItemHolder holder = (NewsFeedItemHolder) viewHolder;
        //Picasso.with(mContext).load(mNewsFeedResults.get(position).getUrl()).into(holder.mNewsFeedImage);
        ResultDomain result = mNewsFeedResults.get(position);
        String url = AppUtils.getImageUrlFromResult(result);
        if (url != null) {
            Picasso.with(mContext).load(url).into(holder.mNewsFeedImage);
        }
        holder.mNewsFeedTitle.setText(mNewsFeedResults.get(position).getTitle());
        holder.mNewsFeedDescription.setText(mNewsFeedResults.get(position).getAbstract());
        holder.mNewsFeedDate.setText(mNewsFeedResults.get(position).getPublishedDate());
    }

    @Override
    public int getItemCount() {
        return mNewsFeedResults != null ? mNewsFeedResults.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class NewsFeedItemHolder extends RecyclerView.ViewHolder {

        View mView;
        @BindView(R.id.img_news_feed)
        CircularImageView mNewsFeedImage;
        @BindView(R.id.tv_news_title)
        TextView mNewsFeedTitle;
        @BindView(R.id.tv_news_description)
        TextView mNewsFeedDescription;
        @BindView(R.id.tv_date)
        TextView mNewsFeedDate;

        public NewsFeedItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mView = itemView;
            this.mView.setOnClickListener(v -> mClickListener.listItemClicked(mNewsFeedResults.get(getAdapterPosition())));
        }
    }
}
