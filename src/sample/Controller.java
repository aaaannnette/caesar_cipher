package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button encryptButton;

    @FXML
    private Button decipherButton;

    @FXML
    private TextArea encryptText;

    @FXML
    private TextArea encryptAns;

    @FXML
    private TextField key;

    @FXML
    void initialize() {
        encryptButton.setOnAction(ignored -> someMethod(true));            //задает действие кнопке Зашифровать

        decipherButton.setOnAction(ignored -> someMethod(false));          // задает действие кнопке Расшифровать
    }

    private void someMethod(boolean flag) {                                     //метод для зашифровки/расшифровки
        String encryptString = encryptText.getText();                           //считывание текста из окна ввода текста
        String keyText = key.getText();
        if (keyText.isEmpty() || encryptString.isEmpty()) {                     //проверка на пустоту полей
            encryptAns.setText("Введите ключ и строку для шифрования");
        } else {
            try {
                int keyInt = Integer.parseInt(flag ? keyText : "-" + keyText);  //считывание, проверка и преобразование в -+int значение ключа
                encryptAns.setText(Solution.decode(encryptString, keyInt));     //вывод результата в окне ответа и
                                                                                // вызов метода decode из статического метода Solution
            } catch (NumberFormatException ex) {
                encryptAns.setText("Ключ должен являться числом");
            }
        }
    }
}

