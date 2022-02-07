package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.News;
import com.gmail.karpovych.springdemoboot.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News findById(Integer newsId){
        return newsRepository.getOne(newsId);
    }

    public List<News> findAll(){
        return newsRepository.findAll();
    }

    public News saveNews(News news){
        return newsRepository.save(news);
    }

    public void deleteById(Integer newsId){
        newsRepository.deleteById(newsId);
    }
}
