package com.cine.banner.service;

import com.cine.banner.entity.Banner;

import java.util.List;

public interface IBannerService {

    void save(Banner banner);

    List<Banner> getAll();
}
