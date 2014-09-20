package jfxlibrary.jfx.gui.component.window.dialog.simpledialog;

import java.util.Optional;
import java.util.function.Function;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import jfxlibrary.jfx.gui.component.window.dialog.DialogBase;

public abstract class SimpleDialogBase<T> extends DialogBase<T>{
    public enum MessageType {INFORMATION, ERROR, WARNING, QUESTION, PLAIN}
    public enum ConfirmStatus {YES, NO, CANCEL};
    
    protected Optional<ImageView> createIcon(MessageType type){
        ImageView icon = null;
        Function<String, ImageView> createImageView = (String t) -> {
            Image img = new Image(getClass().getResourceAsStream("resource/img/"+t));
            ImageView imgView = new ImageView(img);
            imgView.setFitHeight(32);
            imgView.setFitWidth(32);
            return imgView;
        };
        
        switch(type){
            case INFORMATION:
                icon = createImageView.apply("icon-info.png");
                break;
            case WARNING:
                icon = createImageView.apply("icon-warn.png");
                break;
            case ERROR:
                icon = createImageView.apply("icon-err.png");
                break;
            case QUESTION:
                icon = createImageView.apply("icon-question.png");
                break;
            default:
        }
        return Optional.ofNullable(icon);
    }
    
    protected HBox createBody(MessageType type, String message){
        HBox contents = new HBox();
        contents.setMinSize(284, 80);
        contents.setPrefWidth(280);
        contents.setSpacing(10);
        contents.setPadding(new Insets(5, 10, 0, 10));
        contents.setAlignment(Pos.CENTER_LEFT);
        createIcon(type).ifPresent((ImageView imgView) -> {
            contents.getChildren().add(imgView);
        });
        Label mesLbl = new Label(message);
        mesLbl.setWrapText(true);
        contents.getChildren().add(mesLbl);
        
        return contents;
    }
}
