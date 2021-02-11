package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextField input;

    @FXML
    public TextField output;

    @FXML
    public MenuItem inputMenu1;

    @FXML
    public MenuItem inputMenu2;

    @FXML
    public MenuItem outputMenu1;

    @FXML
    public MenuItem outputMenu2;

    @FXML
    public TextField need;

    @FXML
    public TextField become;

    @FXML
    public MenuItem outputMenu3;

    @FXML
    public MenuItem inputMenu3;

    @FXML
    public MenuItem inputMenu4;

    @FXML
    public MenuItem outputMenu4;

    @FXML
    public void writeIn1(){
        need.clear();
        need.appendText(inputMenu1.getText());
    }

    @FXML
    public void writeIn2() {
        need.clear();
        need.appendText(inputMenu2.getText());
    }

    @FXML
    public void writeIn3() {
        need.clear();
        need.appendText(inputMenu3.getText());
    }

    @FXML
    public void writeIn4(){
        need.clear();
        need.appendText(inputMenu4.getText());
    }

    @FXML
    public void writeOut1(){
        become.clear();
        become.appendText(outputMenu1.getText());
    }

    @FXML
    public void writeOut2(){
        become.clear();
        become.appendText(outputMenu2.getText());
    }

    @FXML
    public void writeOut3(){
        become.clear();
        become.appendText(outputMenu3.getText());
    }

    @FXML
    public void writeOut4(){
        become.clear();
        become.appendText(outputMenu4.getText());
    }

    @FXML
    public void btnOneClickAction(ActionEvent actionEvent) {
        double enter = 0;
        output.clear();
        try {
            enter = Double.parseDouble(input.getText());
            if (need.getText().equals("метр") && become.getText().equals("ярд")) {
                enter = enter * 1.0936132983377078;
            }
            if (need.getText().equals("метр") && become.getText().equals("километр")) {
                enter = enter / 1000;
            }
            if (need.getText().equals("метр") && become.getText().equals("миля")) {
                enter = enter / 1604;
            }
            if (need.getText().equals("миля") && become.getText().equals("метр")) {
                enter = enter * 1604;
            }
            if (need.getText().equals("миля") && become.getText().equals("километр")) {
                enter = enter * 1.604;
            }
            if (need.getText().equals("миля") && become.getText().equals("ярд")) {
                enter = enter * 1760.003280839895;
            }
            if (need.getText().equals("километр") && become.getText().equals("миля")) {
                enter = enter / 1.604;
            }
            if (need.getText().equals("километр") && become.getText().equals("метр")) {
                enter = enter * 1000;
            }
            if (need.getText().equals("километр") && become.getText().equals("ярд")) {
                enter = enter * 1093.6132983377079;
            }
            if (need.getText().equals("ярд") && become.getText().equals("метр")) {
                enter = enter / 1.0936132983377078;
            }
            if (need.getText().equals("ярд") && become.getText().equals("километр")) {
                enter = enter / 1093.6132983377079;
            }
            if (need.getText().equals("ярд") && become.getText().equals("миля")) {
                enter = enter / 1760.003280839895;
            }
            output.setText(String.format("%.3f",enter));
        } catch (NumberFormatException e) {
            output.setText("Введите число");
        }
        input.requestFocus();
    }

    @FXML
    public void clearChat(ActionEvent actionEvent) {
        output.clear();
    }



}
