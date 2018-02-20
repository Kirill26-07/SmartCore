/**
 * Класс предназначен для хранения автоматизированных зон, созданных пользователем при первом старте и
 * идентификаторов для получения хранимых зон
 */
package kirill.smartCore.smartCore.storage;

import kirill.smartCore.smartCore.areas.HomeArea;
import java.util.ArrayList;
import java.util.Iterator;

public class AreasStorage implements Iterable<HomeArea> {

    private static ArrayList<HomeArea> homeAreas = new ArrayList<>();

    public static void addHomeArea(final HomeArea homeArea){

        homeAreas.add(homeArea);
    }

    public static HomeArea getHomeArea(final int areaID){

        return homeAreas.get(areaID);

    }

    @Override
    public Iterator<HomeArea> iterator() {
        return homeAreas.iterator();
    }
}
