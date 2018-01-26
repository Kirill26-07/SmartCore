/** Класс-заглушка для эмуляции сигнала с внешних датчиков. Предназначен для тестирования функционала
 * без подключения физических устройств */
import serverClientInteraction.inputControllers.InputRouter;

public class SensorEmulator {

    public void sensorSignal(){

        InputRouter<String, Integer> externalInput = new InputRouter<>();

        externalInput.input("kitchenLighting",1);
    }

}
