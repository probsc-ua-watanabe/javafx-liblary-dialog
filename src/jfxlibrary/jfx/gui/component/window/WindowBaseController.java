package jfxlibrary.jfx.gui.component.window;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

abstract public class WindowBaseController implements Initializable{
    @FXML protected Node titleBar;
    
    protected Stage parent;
    private double offsetX;
    private double offsetY;
    
    public void init(Stage parent){
        this.parent = parent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleBar.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent event) -> {
            offsetX = event.getSceneX();
            offsetY = event.getSceneY();
        });
        titleBar.addEventHandler(MouseEvent.MOUSE_DRAGGED, (MouseEvent event) -> {
            parent.setX(event.getScreenX()-offsetX);
            parent.setY(event.getScreenY()-offsetY);
        });
    }
}
