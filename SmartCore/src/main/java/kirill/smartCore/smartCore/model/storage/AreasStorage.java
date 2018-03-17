/**
 * Класс предназначен для хранения автоматизированных зон, созданных пользователем при первом старте и
 * идентификаторов для получения хранимых зон. Также класс хранит name и ID зон в открытом доступе
 */
package kirill.smartCore.smartCore.model.storage;

import kirill.smartCore.smartCore.model.IHomeArea;

import java.util.HashMap;
import java.util.Map;

public class AreasStorage {

    public static final String KITCHEN_AREA_NAME = "Kitchen";
    public static final String BAD_ROOM_AREA_NAME = "Bad room";
    public static final String LIVING_ROOM_AREA_NAME = "Living room";
    public static final String LOBBY_AREA_NAME = "Lobby";
    public static final String BATHROOM_AREA_NAME = "Bathroom";
    public static final String TOILET_AREA_NAME = "Toilet";

    private static Map<String, IHomeArea> homeAreas = new HashMap<>();

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

        return homeAreas.get(homeAreaName);
    }
}
