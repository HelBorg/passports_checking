package com.elena.passports_checking.Repository;

import com.elena.passports_checking.Model.Passport;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PassRepos extends ElasticsearchRepository<Passport, String> {
    
}
