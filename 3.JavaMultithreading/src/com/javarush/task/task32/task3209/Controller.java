package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

/**
 * Created by v.usov on 23.11.2017.
 */
public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {

    }

}
