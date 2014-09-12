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
public final class SimpleConfirmDialog extends SimpleDialogBase<SimpleConfirmDialog.ConfirmStatus>{
    public enum ConfirmStatus {YES, NO, CANCEL};
    public enum ConfirmMode {YES_NO, YES_NO_CANCEL};
    
    public SimpleConfirmDialog(Window owner) {
        super(owner);
    }
    
    public ConfirmStatus showDialog(String title, String message){
        return showDialog(MessageType.PLAIN, title, message);
    }
    
    public ConfirmStatus showDialog(MessageType type, String title, String message){
        return showDialog(ConfirmMode.YES_NO, type, title, message);
    }
    
    public ConfirmStatus showDialog(ConfirmMode mode, MessageType type ,String title, String message){
        this.setTitle(title);
        
        //FooterButton
        String[] texts = {"Yes","No","Cancel"};
        Consumer<ActionEvent>[] runs = new Consumer[3];
        runs[0] = (ActionEvent t) -> {
            status = ConfirmStatus.YES;
            this.close();
        };
        runs[1] = (ActionEvent t) -> {
            status = ConfirmStatus.NO;
            this.close();
        };
        runs[2] = (ActionEvent t) -> {
            status = ConfirmStatus.CANCEL;
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
        if(mode == ConfirmMode.YES_NO){
            init(contents, DialogMode.CONFIRM, texts, runs);
        }else {
            init(contents, DialogMode.CONFIRM_AND_CANCEL, texts, runs);
        }
        return super.showDialog();
    }
}
