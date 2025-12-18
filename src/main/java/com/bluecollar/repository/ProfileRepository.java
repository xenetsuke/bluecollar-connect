package com.bluecollar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluecollar.entity.Profile;

public interface ProfileRepository extends MongoRepository<Profile, Long> {

}
