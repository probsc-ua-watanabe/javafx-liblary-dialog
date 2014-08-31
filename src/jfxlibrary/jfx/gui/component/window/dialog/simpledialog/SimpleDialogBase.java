/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfxlibrary.jfx.gui.component.window.dialog.simpledialog;

import java.util.Optional;
import java.util.function.Function;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Window;
import jfxlibrary.jfx.gui.component.window.dialog.DialogBase;

/**
 *
 * @author ws
 */
public abstract class SimpleDialogBase<T> extends DialogBase<T>{

    public SimpleDialogBase(Window owner) {
        super(owner);
    }
    public enum MessageType {INFORMATION, ERROR, WARNING, QUESTION, PLAIN}
    
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
}
