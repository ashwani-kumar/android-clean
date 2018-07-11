package com.ashwani.newsfeed.domain.model;

import com.ashwani.newsfeed.entity.model.MediaMetadatum;
import com.ashwani.newsfeed.entity.model.Medium;
import com.ashwani.newsfeed.entity.model.Result;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedEntityDomainMapper {

    public List<ResultDomain> mapResults(List<Result> results) {
        List<ResultDomain> resultDomainList = new ArrayList<>();
        if (results != null || results.size() > 0) {
            for (Result resultEntity : results) {
                ResultDomain resultDomain = new ResultDomain();
                resultDomain.setTitle(resultEntity.getTitle());
                resultDomain.setAbstract(resultEntity.getAbstract());
                resultDomain.setPublishedDate(resultEntity.getPublishedDate());
                List<MediumDomain> mediumDomain = mapMedia(resultEntity.getMedia());
                resultDomain.setMedia(mediumDomain);
                resultDomainList.add(resultDomain);
            }
        }
        return resultDomainList;
    }

    private List<MediumDomain> mapMedia(List<Medium> media) {
        List<MediumDomain> mediumDomains = new ArrayList<>();
        if (media != null || media.size() > 0) {
            for (Medium medium : media) {
                MediumDomain mediumDomain = new MediumDomain();
                List<MediaMetadatumDomain> mediaMetadatumDomains = mapMediaMetaData(medium.getMediaMetadata());
                mediumDomain.setMediaMetadata(mediaMetadatumDomains);
                mediumDomains.add(mediumDomain);
            }
        }
        return mediumDomains;
    }

    private List<MediaMetadatumDomain> mapMediaMetaData(List<MediaMetadatum> mediaMetadata) {
        List<MediaMetadatumDomain> mediaMetadatumDomains = new ArrayList<>();
        if (mediaMetadata != null || mediaMetadata.size() > 0) {
            for (MediaMetadatum mediaMetadatum : mediaMetadata) {
                MediaMetadatumDomain mediaMetadatumDomain = new MediaMetadatumDomain();
                mediaMetadatumDomain.setUrl(mediaMetadatum.getUrl());
                mediaMetadatumDomain.setFormat(mediaMetadatum.getFormat());
                mediaMetadatumDomains.add(mediaMetadatumDomain);
            }
        }
        return mediaMetadatumDomains;
    }
}
