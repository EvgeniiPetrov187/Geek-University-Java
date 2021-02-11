package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextArea textArea;

    @FXML
    public TextField textField;

    @FXML
    public void btnOneClickAction(ActionEvent actionEvent){
        textArea.appendText(textField.getText()+"\n");
        textField.clear();
        textField.requestFocus();
    }

    @FXML
    public void clearChat(ActionEvent actionEvent) {
        textArea.clear();
    }
}
