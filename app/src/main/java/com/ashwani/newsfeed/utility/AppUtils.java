package com.ashwani.newsfeed.utility;

import com.ashwani.newsfeed.domain.model.MediaMetadatumDomain;
import com.ashwani.newsfeed.domain.model.MediumDomain;
import com.ashwani.newsfeed.domain.model.ResultDomain;
import com.ashwani.newsfeed.entity.model.MediaMetadatum;
import com.ashwani.newsfeed.entity.model.Medium;
import com.ashwani.newsfeed.entity.model.Result;

import java.util.List;

public class AppUtils {
    public static String getImageUrlFromResult(ResultDomain result) {
        String url = null;
        if (result != null) {
            List<MediumDomain> media = result.getMedia();
            if (media != null || !media.isEmpty()) {
                List<MediaMetadatumDomain> metaDataList = media.get(0).getMediaMetadata();
                if (metaDataList != null || !metaDataList.isEmpty()) {
                    url = metaDataList.get(4).getUrl();
                }
            }
        }
        return url;
    }
}
