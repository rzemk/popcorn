package com.chyld.services;

import com.chyld.entities.Studio;
import com.chyld.repositories.IStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudioService {
    private IStudioRepository repository;

    @Autowired
    public void setRepository(IStudioRepository repository) {
        this.repository = repository;
    }

    public Page<Studio> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Studio findOne(int id) {
        return this.repository.findOne(id);
    }

    public Studio create(Studio s) {
        return this.repository.save(s);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Studio update(int id, Studio s) {
        Studio studio = this.repository.findOne(id);
        studio.setName(s.getName());
        studio.setEst(s.getEst());
        return this.repository.save(studio);
    }
}
