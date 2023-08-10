package com.navi.UserDetailsAPI.services;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

public class NewsResponse
{
    private List<Source> sources;

    public NewsResponse()
    {
        sources = new ArrayList<>();
    }
    public List<Source> getSource()
    {
        return sources;
    }
    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public static class Source
    {
        private String description;

        private String id;

        public Source()
        {}
        public Source(String id,String description) {
            this.description = description;
            this.id = id;
        }

        public String getDescription ()
        {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        public String getId () {return id;}
        public void setId(String id) {this.id = id;}
    }

    public List<Source> getSources() {
        return sources;
    }
    public void addSources(Source s) {
        sources.add(s);
    }
}



