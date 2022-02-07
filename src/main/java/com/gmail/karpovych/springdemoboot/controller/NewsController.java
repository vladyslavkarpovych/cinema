package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.News;
import com.gmail.karpovych.springdemoboot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public String findAll(Model model) {
        List<News> news = newsService.findAll();
        model.addAttribute("news", news);
        return "news/news-list";
    }

    @GetMapping("/news-create")
    public String createNewsForm(News news) {
        return "news/news-create";
    }

    @PostMapping("/news-create")
    public String createNews(News news) {
        newsService.saveNews(news);
        return "redirect:/news";
    }

    @GetMapping("news-delete/{id}")
    public String deleteNews(@PathVariable("id") Integer newsId) {
        newsService.deleteById(newsId);
        return "redirect:/news";
    }

    @GetMapping("news/news-update/{id}")
    public String updateNewsForm(@PathVariable("id") Integer newsId, Model model) {
        News news = newsService.findById(newsId);
        model.addAttribute("news", news);
        return "news/news-update";
    }

    @PostMapping("/news-update")
    public String updateNews(News news) {
        newsService.saveNews(news);
        return "redirect:/news";
    }
}
