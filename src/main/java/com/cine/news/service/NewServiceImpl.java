package com.cine.news.service;

import com.cine.news.model.News;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class NewServiceImpl implements INewsService {

    private static final Logger LOG = Logger.getLogger(NewServiceImpl.class);

    @Override
    public void save(News news) {
        LOG.info(news.toString());
    }
}
