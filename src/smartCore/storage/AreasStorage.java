/**
 * Класс предназначен для хранения автоматизированных зон, созданных пользователем при первом старте
 * и добавленных в процессе использования системы
 */
package smartCore.storage;

import smartCore.areas.HomeArea;
import java.util.ArrayList;

public class AreasStorage {

    private static ArrayList<HomeArea> homeAreas = new ArrayList<>();

    /**
     * Метод добавляет новую зону в список.
     *
     * @param homeArea - принимает зону, которую необходимо поместить в список существующих зон.
     */

    public static void addHomeArea(HomeArea homeArea){

        homeAreas.add(homeArea);
    }

    /**
     * Метод возвращает хранящуюся сконфигурированную зону по ее ID.
     *
     * @param areaID - принимает ID зоны.
     * @return - возвращает запрашиваемую зону.
     */

    public static HomeArea getHomeArea(int areaID){

        return homeAreas.get(areaID);

    }
}
