package jfxlibrary.jfx.gui.component.window.dialog;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
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
    public enum DialogMode {MESSAGE, CONFIRM, CONFIRM_AND_CANCEL}
    
    protected T status;
    
    protected DialogBase init(Parent contents, DialogMode mode, String[] btnTexts, Consumer<ActionEvent>[] btnRuns){
        //Footer
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPrefHeight(20);
        footer.setStyle(
                "-fx-spacing:5px;\n"
                +"-fx-padding:5px 0px;"
        );
        footer.getChildren().addAll(createFooterButtons(mode, btnTexts, btnRuns));

        //Root
        VBox root = new VBox();
        root.getChildren().addAll(contents, footer);
        this.setScene(new Scene(root, null));
        
        return this;
    }

    public DialogBase(Window owner) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.WINDOW_MODAL);
        this.initOwner(owner);
        this.setResizable(false);
    }
    
    protected T showDialog(){
        this.showAndWait();
        return this.status;
    }
    
    public T getStatus(){
        return this.status;
    }
    
    public void setStatus(T param){
        this.status = param;
    }
    
    private List<Button> createFooterButtons(DialogMode mode, String[] btnTexts, Consumer<ActionEvent>[] btnRuns){
        List<Button> btns = new ArrayList<>();
        if(mode == null){
            mode = DialogMode.MESSAGE;
        }
        Consumer<Integer> addBtn = (Integer index) -> {
            Button btn = new Button(btnTexts[index]);
            btn.setOnAction((ActionEvent event) -> {
                btnRuns[index].accept(event);
            });
            btns.add(btn);
        };
        
        switch(mode){
            case MESSAGE:
                addBtn.accept(0);
                break;
            case CONFIRM:
                addBtn.accept(0);
                addBtn.accept(1);
                break;
            case CONFIRM_AND_CANCEL:
                addBtn.accept(0);
                addBtn.accept(1);
                addBtn.accept(2);
                break;
            default:
        }
        
        return btns;
    }
}