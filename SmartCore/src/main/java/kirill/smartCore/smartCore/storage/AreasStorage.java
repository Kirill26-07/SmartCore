/**
 * Класс предназначен для хранения автоматизированных зон, созданных пользователем при первом старте и
 * идентификаторов для получения хранимых зон
 */
package kirill.smartCore.smartCore.storage;

import kirill.smartCore.smartCore.areas.IHomeArea;

import java.util.ArrayList;
import java.util.Iterator;

public class AreasStorage implements Iterable<IHomeArea> {

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
