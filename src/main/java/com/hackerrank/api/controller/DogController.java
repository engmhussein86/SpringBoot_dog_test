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
  public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
    if(dog.getId() == null) {
      return new ResponseEntity<>(dogService.createNewDog(dog), HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }



  @GetMapping("/{id}")
  public ResponseEntity<Dog> getDogById(@PathVariable String id) {

    try {
      Long dogId = Long.parseLong(id);
      if (dogId <= 0) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      Dog dog = dogService.getDogById(dogId);
      if (dog == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(dog, HttpStatus.OK);
    } catch (NumberFormatException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }
}
