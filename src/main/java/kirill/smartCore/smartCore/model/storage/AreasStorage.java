/**
 * Класс предназначен для хранения автоматизированных зон, созданных пользователем при первом старте и
 * идентификаторов для получения хранимых зон. Также класс хранит name и ID зон в открытом доступе
 */
package kirill.smartCore.smartCore.model.storage;

import kirill.smartCore.smartCore.exceptions.WrongInputDataException;
import kirill.smartCore.smartCore.model.HomeArea;
import kirill.smartCore.smartCore.model.IHomeArea;

import java.util.HashMap;
import java.util.Map;

public class AreasStorage {

    private static Map<String, IHomeArea> homeAreas = new HashMap<>();
    public static final String NOT_FOUND = "NOT FOUND";

    public static boolean addHomeArea(final IHomeArea homeArea) {
        String homeAreaName = homeArea.getName();

        if (homeAreas.containsKey(homeAreaName)) {
            System.out.println("This area has already been created");
            return false;
        } else {
            homeAreas.put(homeAreaName, homeArea);
            return true;
        }
    }

    public static IHomeArea getHomeArea(final String homeAreaName) {
        return homeAreas.getOrDefault(homeAreaName, new HomeArea(NOT_FOUND));
    }

    public static String getAreaName(final byte id) throws WrongInputDataException {
        switch (id) {
            case 0: {
                return AreaName.KITCHEN.getName();
            }
            case 1: {
                return AreaName.BAD_ROOM.getName();
            }
            case 2: {
                return AreaName.LIVING_ROOM.getName();
            }
            case 3: {
                return AreaName.LOBBY.getName();
            }
            case 4: {
                return AreaName.BATHROOM.getName();
            }
            case 5: {
                return AreaName.TOILET.getName();
            }
            default: {
                System.out.println("Wrong input value!");
                throw new WrongInputDataException();
            }
        }
    }

    public enum AreaName {
        KITCHEN("Kitchen"),
        BAD_ROOM("Bad room"),
        LIVING_ROOM("Living room"),
        LOBBY("Lobby"),
        BATHROOM("Bathroom"),
        TOILET("Toilet");

        private String name;

        AreaName(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
