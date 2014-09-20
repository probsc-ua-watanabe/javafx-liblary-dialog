package jfxlibrary.jfx.gui.component.window.dialog.simpledialog;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Window;

public class SimpleDialog {
    public static Boolean showMessageDialog(Window owner, SimpleDialogBase.MessageType type ,String title, String message){
        SimpleDialogBase<Boolean> dialog = new SimpleDialogBase<Boolean>() {
            @Override
            public Boolean showDialog() {
                this.setTitle(title);

                //FooterButton
                List<Button> btns = new ArrayList<>();
                Button btnOK = new Button("OK");
                btnOK.setOnAction((ActionEvent event) -> {
                    this.close();
                });
                btns.add(btnOK);
                //Contents
                HBox contents = createBody(type, message);
                init(contents, btns);

                return super.showModalDialog(owner);
            }
        };
        return dialog.showDialog();
    }
    public static Boolean showMessageDialog(Window owner, String title, String message){
        return SimpleDialog.showMessageDialog(owner, SimpleDialogBase.MessageType.PLAIN, title, message);
    }
    public static Boolean showMessageDialog(Window owner, String message){
        return SimpleDialog.showMessageDialog(owner, SimpleDialogBase.MessageType.PLAIN, "", message);
    }
    
    public static SimpleDialogBase.ConfirmStatus showYesNoDialog(Window owner, SimpleDialogBase.MessageType type ,String title, String message){
        SimpleDialogBase<SimpleDialogBase.ConfirmStatus> dialog = new SimpleDialogBase<SimpleDialogBase.ConfirmStatus>() {
            @Override
            public SimpleDialogBase.ConfirmStatus showDialog() {
                this.setTitle(title);

                //FooterButton
                List<Button> btns = new ArrayList<>();
                Button btnYes = new Button("Yes");
                btnYes.setOnAction((ActionEvent event) -> {
                    status = SimpleDialogBase.ConfirmStatus.YES;
                    this.close();
                });
                Button btnNo = new Button("No");
                btnNo.setOnAction((ActionEvent event) -> {
                    status = SimpleDialogBase.ConfirmStatus.NO;
                    this.close();
                });
                btns.add(btnYes);
                btns.add(btnNo);
                //Contents
                HBox contents = createBody(type, message);
                init(contents, btns);

                return super.showModalDialog(owner);
            }
        };
        return dialog.showDialog();
    }
    public static SimpleDialogBase.ConfirmStatus showYesNoDialog(Window owner, String title, String message){
        return SimpleDialog.showYesNoDialog(owner, SimpleDialogBase.MessageType.PLAIN, title, message);
    }
    public static SimpleDialogBase.ConfirmStatus showYesNoDialog(Window owner, String message){
        return SimpleDialog.showYesNoDialog(owner, SimpleDialogBase.MessageType.PLAIN, "", message);
    }
    
    
    public static SimpleDialogBase.ConfirmStatus showYesNoCancelDialog(Window owner, SimpleDialogBase.MessageType type ,String title, String message){
        SimpleDialogBase<SimpleDialogBase.ConfirmStatus> dialog = new SimpleDialogBase<SimpleDialogBase.ConfirmStatus>() {
            @Override
            public SimpleDialogBase.ConfirmStatus showDialog() {
                this.setTitle(title);

                //FooterButton
                List<Button> btns = new ArrayList<>();
                Button btnYes = new Button("Yes");
                btnYes.setOnAction((ActionEvent event) -> {
                    status = SimpleDialogBase.ConfirmStatus.YES;
                    this.close();
                });
                Button btnNo = new Button("No");
                btnNo.setOnAction((ActionEvent event) -> {
                    status = SimpleDialogBase.ConfirmStatus.NO;
                    this.close();
                });
                Button btnCancel = new Button("Cancel");
                btnCancel.setOnAction((ActionEvent event) -> {
                    status = SimpleDialogBase.ConfirmStatus.CANCEL;
                    this.close();
                });
                btns.add(btnYes);
                btns.add(btnNo);
                btns.add(btnCancel);
                //Contents
                HBox contents = createBody(type, message);
                init(contents, btns);

                return super.showModalDialog(owner);
            }
        };
        return dialog.showDialog();
    }
    public static SimpleDialogBase.ConfirmStatus showYesNoCancelDialog(Window owner, String title, String message){
        return SimpleDialog.showYesNoCancelDialog(owner, SimpleDialogBase.MessageType.PLAIN, title, message);
    }
    public static SimpleDialogBase.ConfirmStatus showYesNoCancelDialog(Window owner, String message){
        return SimpleDialog.showYesNoCancelDialog(owner, SimpleDialogBase.MessageType.PLAIN, "", message);
    }
}
