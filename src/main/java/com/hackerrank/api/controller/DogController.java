package com.hackerrank.api.controller;

import com.hackerrank.api.model.Dog;
import com.hackerrank.api.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {
  private final DogService dogService;

  @Autowired
  public DogController(DogService dogService) {
    this.dogService = dogService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Dog> getAllDog() {
    return dogService.getAllDog();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
    return new ResponseEntity<>(dogService.createNewDog(dog), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Dog getDogById(@PathVariable Long id) {
    if (id < 1) {
      return new Dog();
    }
    return dogService.getDogById(id);
  }
}
