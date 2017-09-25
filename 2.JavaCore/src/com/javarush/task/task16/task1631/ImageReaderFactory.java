package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by v.usov on 25.09.2017.
 */
public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes vhod)
    {

        if(vhod == ImageTypes.BMP) return new BmpReader();
        else if(vhod == ImageTypes.PNG) return new PngReader();
        else if(vhod == ImageTypes.JPG) return new JpgReader();

        throw new IllegalArgumentException("Vot tak");


    }

}
