
package com.ashwani.newsfeed.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NewsFeedDomain {

    private List<ResultDomain> resultDomains = null;

    public List<ResultDomain> getResultDomains() {
        return resultDomains;
    }

    @JsonProperty("resultDomains")
    public void setResultDomains(List<ResultDomain> resultDomains) {
        this.resultDomains = resultDomains;
    }

}
