
package com.ashwani.newsfeed.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultDomain {

    private String title;
    private String _abstract;
    private String publishedDate;
    private List<MediumDomain> media;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<MediumDomain> getMedia() {
        return media;
    }

    public void setMedia(List<MediumDomain> media) {
        this.media = media;
    }


}
