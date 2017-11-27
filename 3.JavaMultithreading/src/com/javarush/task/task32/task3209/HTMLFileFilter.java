package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by v.usov on 27.11.2017.
 */
public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {

        if(f.isDirectory()) return true;
        String name = f.getName().toLowerCase();
        if(name.endsWith(".html") || name.endsWith(".htm")) return true;

        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
