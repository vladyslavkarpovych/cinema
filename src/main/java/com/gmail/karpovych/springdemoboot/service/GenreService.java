package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Genre;
import com.gmail.karpovych.springdemoboot.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre findById(Integer genreId){
        return genreRepository.getOne(genreId);
    }

    public List<Genre> findAll(){
        return genreRepository.findAll();
    }

    public Genre saveGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public void deleteById(Integer genreId){
        genreRepository.deleteById(genreId);
    }
}
