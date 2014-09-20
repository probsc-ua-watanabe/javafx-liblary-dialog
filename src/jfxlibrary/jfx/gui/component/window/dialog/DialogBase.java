package jfxlibrary.jfx.gui.component.window.dialog;

import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public abstract class  DialogBase<T> extends Stage{
    protected T status;
    
    protected DialogBase init(Parent contents, List<Button> btns){
        //Footer
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPrefHeight(20);
        footer.setStyle(
                "-fx-spacing:5px;\n"
                +"-fx-padding:5px 0px;"
        );
        footer.getChildren().addAll(btns);

        //Root
        VBox root = new VBox();
        root.getChildren().addAll(contents, footer);
        this.setScene(new Scene(root, null));
        
        return this;
    }

    public DialogBase() {
        this.initStyle(StageStyle.UTILITY);
        this.setResizable(false);
    }
    
    public T showModalDialog(Window owner){
        this.initOwner(owner);
        this.initModality(Modality.WINDOW_MODAL);
        this.showAndWait();
        return this.status;
    }
    public T showDialog(){
        this.initModality(Modality.NONE);
        this.show();
        return this.status;
    }
    
    public T getStatus(){
        return this.status;
    }
    
    public void setStatus(T param){
        this.status = param;
    }
}