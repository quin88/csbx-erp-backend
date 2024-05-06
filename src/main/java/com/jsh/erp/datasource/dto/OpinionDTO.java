package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.ImageInfo;
import com.jsh.erp.datasource.entities.Opinion;

import java.util.List;

public class OpinionDTO  {

    private Opinion opinion;
    private List<ImageInfo> imageInfos;

    public Opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(Opinion opinion) {
        this.opinion = opinion;
    }

    public List<ImageInfo> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(List<ImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
    }
}