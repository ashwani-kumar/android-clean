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
import com.ashwani.newsfeed.domain.model.Result;
import com.squareup.picasso.Picasso;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Picasso picasso;
    private Context mContext;
    private List<Result> mNewsFeedResults;
    private NewsFeedClickListener mClickListener;

    @Inject
    public NewsFeedAdapter(Context context, Picasso picasso) {
        this.mContext = context;
        this.picasso = picasso;
    }

    public void setNewsFeedModel(List<Result> newsFeeds) {
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
        Result result = mNewsFeedResults.get(position);
        if(result != null){
            Map<String, Object> additionalProperties = result.getAdditionalProperties();
            if(additionalProperties != null || !additionalProperties.isEmpty()){
                List<LinkedHashMap> media = (List<LinkedHashMap>) additionalProperties.get("media");
                if(media != null || !media.isEmpty()){
                    LinkedHashMap<String, List> mediaMap = null;
                    mediaMap = (LinkedHashMap<String, List>) media.get(0);
                    if(mediaMap != null || !mediaMap.isEmpty()) {
                        List<LinkedHashMap> metaDataList = (List<LinkedHashMap>)mediaMap.get("media-metadata");
                        if(metaDataList != null  || !metaDataList.isEmpty()){
                            Map<String, String> imageDetails = metaDataList.get(0);
                            if(imageDetails != null  || !imageDetails.isEmpty()) {
                                String url = imageDetails.get("url");
                                if (url != null) {
                                    picasso.with(mContext).load(url).into(holder.mNewsFeedImage);
                                }
                            }
                        }
                    }
                }
            }
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
