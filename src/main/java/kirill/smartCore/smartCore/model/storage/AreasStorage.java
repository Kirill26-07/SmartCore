/**
 * Класс предназначен для хранения автоматизированных зон, созданных пользователем при первом старте и
 * идентификаторов для получения хранимых зон. Также класс хранит name и ID зон в открытом доступе
 */
package kirill.smartCore.smartCore.model.storage;

import kirill.smartCore.smartCore.model.HomeArea;
import kirill.smartCore.smartCore.model.IHomeArea;

import java.util.HashMap;
import java.util.Map;

public class AreasStorage {

    private static Map<String, IHomeArea> homeAreas = new HashMap<>();
    public static final String NOT_FOUND = "NOT FOUND";

    public static void addHomeArea(final IHomeArea homeArea) {

        String homeAreaName = homeArea.getName();

        if(homeAreas.containsKey(homeAreaName)){
            System.out.println("This area has already been created");
        }
        else {
            homeAreas.put(homeAreaName, homeArea);
        }
    }

    public static IHomeArea getHomeArea(final String homeAreaName) {

        return homeAreas.getOrDefault(homeAreaName, new HomeArea(NOT_FOUND));
    }

    public enum AreaName {

        KITCHEN("Kitchen"),
        BAD_ROOM("Bad room"),
        LIVING_ROOM("Living room"),
        LOBBY("Lobby"),
        BATHROOM("Bathroom"),
        TOILET("Toilet");

        String name;

        AreaName(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
