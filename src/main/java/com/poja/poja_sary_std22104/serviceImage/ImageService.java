package com.poja.poja_sary_std22104.serviceImage;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

// Service

@Service
public class ImageService {

    public byte[] convertToBlackAndWhite(byte[] imageData) {
        byte[] result = new byte[imageData.length];
        for (int i = 0; i < imageData.length; i++) {
            result[i] = (byte) (255 - (imageData[i] & 0xFF));
        }
        return result;
    }

    public byte[] resizeImage(byte[] imageData, int width, int height) {
        return Arrays.copyOf(imageData, width * height);
    }
}




