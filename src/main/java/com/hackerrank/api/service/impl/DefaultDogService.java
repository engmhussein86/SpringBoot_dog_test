package com.hackerrank.api.service.impl;

import com.hackerrank.api.exception.ElementNotFoundException;
import com.hackerrank.api.model.Dog;
import com.hackerrank.api.repository.DogRepository;
import com.hackerrank.api.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultDogService implements DogService {
  private final DogRepository dogRepository;

  @Autowired
  DefaultDogService(DogRepository dogRepository) {
    this.dogRepository = dogRepository;
  }

  @Override
  public List<Dog> getAllDog() {
    return dogRepository.findAll();
  }


  @Override
  public Dog createNewDog(Dog dog) {
    return dogRepository.save(dog);
  }

  @Override
  public Dog getDogById(Long id) {
    return dogRepository
            .findById(id)
            .orElseThrow(() -> new ElementNotFoundException("Dog with ID not found"));
  }
}
