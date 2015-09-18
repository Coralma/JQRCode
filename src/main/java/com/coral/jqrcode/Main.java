package com.coral.jqrcode;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by CCC on 2015/9/18.
 */
public class Main {

    public static void main(String args[]) {

        ByteArrayOutputStream stream = QRCode.from("http://www.baidu.com").to(ImageType.JPG).stream();
        saveFile(stream);
        // get QR file from text using defaults
        /*File file = QRCode.from("http://www.baidu.com").file();
        // get QR stream from text using defaults
        ByteArrayOutputStream stream = QRCode.from("Hello World").stream();

        // override the image type to be JPG
        QRCode.from("Hello World").to(ImageType.JPG).file();
        QRCode.from("Hello World").to(ImageType.JPG).stream();

        // override image size to be 250x250
        QRCode.from("Hello World").withSize(250, 250).file();
        QRCode.from("Hello World").withSize(250, 250).stream();

        // override size and image type
        QRCode.from("Hello World").to(ImageType.GIF).withSize(250, 250).file();
        QRCode.from("Hello World").to(ImageType.GIF).withSize(250, 250).stream();

        // supply own outputstream
        QRCode.from("Hello World").to(ImageType.PNG).writeTo(outputStream);*/
    }

    public static void saveFile(ByteArrayOutputStream stream) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("hello.jpg"));
            stream.writeTo(fos);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
