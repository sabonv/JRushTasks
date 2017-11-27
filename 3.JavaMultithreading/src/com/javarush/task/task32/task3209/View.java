package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


/**
 * Created by v.usov on 23.11.2017.
 */
public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Новый" : {
                controller.createNewDocument();
                break;
            }
            case "Открыть" : {
                controller.openDocument();
                break;
            }
            case "Сохранить" : {
                controller.saveDocument();
                break;
            }
            case "Сохранить как..." : {
                controller.saveDocumentAs();
                break;
            }
            case "Выход" : {
                controller.exit();
                break;
            }
            case "О программе" : {
                showAbout();
                break;
            }

        }

    }


    public void init(){

        initGui();
        this.addWindowListener(new FrameListener(this));
        this.setVisible(true);

    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(this, "This about", "This about", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isHtmlTabSelected() {

        return tabbedPane.getSelectedIndex() == 0;
    }

    public void undo() {
        try {
            undoManager.undo();
        }catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }

    public void redo() {
        try {
            undoManager.redo();
        }catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public void selectedTabChanged(){

        switch (tabbedPane.getSelectedIndex()) {
            case 0 : {
                controller.setPlainText(plainTextPane.getText());
                break;
            }
            case 1 : {
                plainTextPane.setText(controller.getPlainText());
                break;
            }
        }
        resetUndo();
    }

    public void initMenuBar() {

        JMenuBar jMenuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);

        this.getContentPane().add(jMenuBar, BorderLayout.NORTH);

    }

    public void initEditor() {

        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(100, 100));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void initGui() {

        initMenuBar();
        initEditor();
        pack();

    }

    public void exit(){
        controller.exit();
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }
}
