package com.poja.poja_sary_std22104.serviceImage;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ImageService {

    public byte[] convertToBlackAndWhite(byte[] imageData) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(inputStream).scale(1).outputFormat("jpg").toOutputStream(outputStream);
        return outputStream.toByteArray();
    }

    public byte[] resizeImage(byte[] imageData, int width, int height) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(inputStream).size(width, height).outputFormat("jpg").toOutputStream(outputStream);
        return outputStream.toByteArray();
    }
}

