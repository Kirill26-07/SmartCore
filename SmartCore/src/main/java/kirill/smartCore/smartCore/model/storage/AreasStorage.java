/**
 * Класс предназначен для хранения автоматизированных зон, созданных пользователем при первом старте и
 * идентификаторов для получения хранимых зон. Также класс хранит name и ID зон в открытом доступе
 */
package kirill.smartCore.smartCore.model.storage;

import kirill.smartCore.smartCore.model.IHomeArea;

import java.util.ArrayList;
import java.util.Iterator;

public class AreasStorage implements Iterable<IHomeArea> {

    public static final String KITCHEN_AREA_NAME = "Kitchen";
    public static final String BAD_ROOM_AREA_NAME = "Bad room";
    public static final String LIVING_ROOM_AREA_NAME = "Living room";
    public static final String LOBBY_AREA_NAME = "Lobby";
    public static final String BATHROOM_AREA_NAME = "Bathroom";
    public static final String TOILET_AREA_NAME = "Toilet";

    public static final int KITCHEN_AREA_ID = 0;
    public static final int BAD_ROOM_AREA_ID = 1;
    public static final int LIVING_ROOM_AREA_ID = 2;
    public static final int LOBBY_AREA_ID = 3;
    public static final int BATHROOM_AREA_ID = 4;
    public static final int TOILET_AREA_ID = 5;

    private static ArrayList<IHomeArea> homeAreas = new ArrayList<>();

    public static void addHomeArea(final IHomeArea homeArea){

        homeAreas.add(homeArea);
    }

    public static IHomeArea getHomeArea(final int areaID){

        return homeAreas.get(areaID);

    }

    @Override
    public Iterator<IHomeArea> iterator() {
        return homeAreas.iterator();
    }
}
