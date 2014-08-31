package jfxlibrary.jfx.gui.component.window.dialog.simpledialog;

import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Window;

/**
 *
 * @author ws
 */
public final class SimpleMessageDialog extends SimpleDialogBase<Boolean>{
    public SimpleMessageDialog(Window owner) {
        super(owner);
        status = true;
    }
    
    public Boolean showDialog(String message){
        return showDialog("", message);
    }
    
    public Boolean showDialog(String title, String message){
        return showDialog(MessageType.PLAIN, title, message);
    }
    
    public Boolean showDialog(MessageType type ,String title, String message){
        this.setTitle(title);
        
        //FooterButton
        String[] texts = {"OK"};
        Consumer<ActionEvent>[] runs = new Consumer[1];
        runs[0] = (ActionEvent t) -> {
            this.close();
        };
        //Contents
        HBox contents = new HBox();
        contents.setMinSize(280, 80);
        contents.setPrefWidth(280);
        contents.setSpacing(10);
        contents.setPadding(new Insets(0, 10, 0, 10));
        contents.setAlignment(Pos.CENTER_LEFT);
        createIcon(type).ifPresent((ImageView imgView) -> {
            contents.getChildren().add(imgView);
        });
        Label mesLbl = new Label(message);
        mesLbl.setWrapText(true);
        contents.getChildren().add(mesLbl);
        init(contents, DialogMode.MESSAGE, texts, runs);
        
        return super.showDialog();
    }
}
