/** Класс-заглушка для эмуляции сигнала с внешних датчиков. Предназначен для тестирования функционала
 * без подключения физических устройств */
import serverClientInteraction.inputControllers.Reader;

public class SensorEmulator {

    public void sensorSignal(){

        Reader<String, Integer> externalInput = new Reader<>();

        externalInput.input("kitchenLighting",1);
    }

}
