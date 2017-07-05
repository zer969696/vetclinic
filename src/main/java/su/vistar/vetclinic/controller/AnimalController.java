package su.vistar.vetclinic.controller;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.service.AnimalService;
import su.vistar.vetclinic.mongo.service.ImageService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Evgeniy Evzerov on 10.03.17.
 * VIstar
 */

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/photo{animalId}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getAnimalPhoto(@PathVariable Integer animalId) throws IOException {
        Animal animal = animalService.findById(animalId);

        GridFSDBFile animalPhoto = imageService.getImageById(animal.getPhotoId());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        animalPhoto.writeTo(baos);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, animalPhoto.getContentType());

        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
    }
}
