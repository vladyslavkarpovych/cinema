package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Promotions;
import com.gmail.karpovych.springdemoboot.repository.PromotionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionsService {
    private final PromotionsRepository promotionsRepository;

    @Autowired
    public PromotionsService(PromotionsRepository promotionsRepository) {
        this.promotionsRepository = promotionsRepository;
    }

    public Promotions findById(Integer promotionsId) {
        return promotionsRepository.getOne(promotionsId);
    }

    public List<Promotions> findAll() {
        return promotionsRepository.findAll();
    }

    public Promotions savePromotions(Promotions promotions) {
        return promotionsRepository.save(promotions);
    }

    public void deleteById(Integer promotionsId) {
        promotionsRepository.deleteById(promotionsId);
    }
}
