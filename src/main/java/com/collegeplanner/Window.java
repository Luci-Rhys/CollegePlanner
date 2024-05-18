package com.collegeplanner;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
This class contains methods for window movement and design(CSS stylesheets)
 */
public class Window {

    private HBox titleBar;
    private Stage primaryStage;

    public Window(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    //Enables movement of window by clicking and dragging the top pane of the window
    public void dragWindow(HBox title){

            title.setOnMousePressed(press -> {
                title.setOnMouseDragged(drag -> {
                    primaryStage.setX(drag.getScreenX() - press.getSceneX());
                    primaryStage.setY(drag.getScreenY() - press.getSceneY());
                });
            });
    }

    //Method links a class's scene to its respective stylesheet(s)
    public void linkStyleSheet(String styleSheetPath, Scene styledScene){
        String sceneCSS = getClass().getResource(styleSheetPath).toExternalForm();
        styledScene.getStylesheets().add(sceneCSS);
    }

    public void linkStyle(Node node, String cssSelector){
        node.getStyleClass().add(cssSelector);
    }
}