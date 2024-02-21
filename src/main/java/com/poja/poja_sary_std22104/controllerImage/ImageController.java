package com.poja.poja_sary_std22104.controllerImage;

import com.poja.poja_sary_std22104.model_image.ImageModel;
import com.poja.poja_sary_std22104.serviceImage.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/convertToBlackAndWhite")
    public ResponseEntity<byte[]> convertToBlackAndWhite(@RequestBody ImageModel imageModel) {
        try {
            byte[] blackAndWhiteImage = imageService.convertToBlackAndWhite(imageModel.getData());
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(blackAndWhiteImage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/resize")
    public ResponseEntity<byte[]> resizeImage(@RequestBody ImageModel imageModel, @RequestParam int width, @RequestParam int height) {
        try {
            byte[] resizedImage = imageService.resizeImage(imageModel.getData(), width, height);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resizedImage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
