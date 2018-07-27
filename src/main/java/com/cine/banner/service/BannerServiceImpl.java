package com.cine.banner.service;

import com.cine.banner.entity.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BannerServiceImpl implements IBannerService {

    private List<Banner> listBanners;

    public BannerServiceImpl() {
        this.listBanners = createListBanners();
    }

    @Override
    public void save(Banner banner) {
        listBanners.add(banner);
    }

    @Override
    public List<Banner> getAll() {
        return listBanners;
    }

    private List<Banner> createListBanners() {
        listBanners = new ArrayList<>();
        Banner banner = new Banner();
        banner.setId(1);
        banner.setTitle("Logan");

        Banner banner1 = new Banner();
        banner1.setId(2);
        banner1.setTitle("Dead Pool");

        Banner banner2 = new Banner();
        banner2.setId(3);
        banner2.setTitle("SpiderMan");

        Banner banner3 = new Banner();
        banner3.setId(4);
        banner3.setTitle("Jumaji");

        listBanners.add(banner);
        listBanners.add(banner1);
        listBanners.add(banner2);
        listBanners.add(banner3);

        return listBanners;
    }
}
