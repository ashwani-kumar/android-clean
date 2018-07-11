
package com.ashwani.newsfeed.domain.model;

import java.util.List;

public class MediumDomain {

    private List<MediaMetadatumDomain> mediaMetadata = null;

    public List<MediaMetadatumDomain> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatumDomain> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

}
