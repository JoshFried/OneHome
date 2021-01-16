package com.htne.helpthehomeless.dal.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class QRCodeService {
    private final String QR_CODE_IMAGE_PATH = "./src/main/resources/qr/";

    public void generateQRCodeImage(final String text) throws WriterException, IOException {
        final QRCodeWriter qrCodeWriter = new QRCodeWriter();
        final BitMatrix    bitMatrix    = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 240, 240);

        final Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH + UUID.randomUUID() + ".png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static byte[] getQRCodeImage(final String text) throws WriterException, IOException {
        final QRCodeWriter          qrCodeWriter    = new QRCodeWriter();
        final BitMatrix             bitMatrix       = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 240, 240);
        final ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        final byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }
}
