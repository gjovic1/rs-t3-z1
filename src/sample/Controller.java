package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;

public class Controller {
    public Button dugmic;
    public TextField Unos;
    public ListView listaIspis;


    public void initialize() {
        Unos.getStyleClass().add("poljeNijeIspravno");
        Unos.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.isEmpty()) {
                    Unos.getStyleClass().add("poljeNijeIspravno");
                    Unos.setPromptText("Unesite broj");
                } else {
                    Unos.getStyleClass().removeAll("poljeNijeIspravno");
                }
                if (!n.matches("\\d")) {
                    Unos.setText(n.replaceAll("[^\\d]", ""));
                }
            }
        });
    }


    public static int sumaCifara(int broj) {
        int sum = 0;
        while (broj != 0) {
            sum = sum + (broj % 10);
            broj = broj / 10;
        }
        return sum;
    }

    public int print(ActionEvent actionEvent) throws InvocationTargetException {
        try {
            listaIspis.getItems().clear();
            String n = Unos.getText();
            for (int i = 1; i < Integer.parseInt(n); i++)
                if (i % sumaCifara(i) == 0)
                    listaIspis.getItems().add(i);

        } catch (NumberFormatException e) {
            return 0;
        }
        return 0;
    }
}
