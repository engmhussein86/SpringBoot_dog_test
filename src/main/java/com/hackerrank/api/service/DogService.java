package com.hackerrank.api.service;

import com.hackerrank.api.model.Dog;
import java.util.List;

public interface DogService {

  List<Dog> getAllDog();

  Dog createNewDog(Dog dog);

  Dog getDogById(Long id);
}
