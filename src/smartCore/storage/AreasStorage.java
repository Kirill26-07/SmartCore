package smartCore.storage;

import smartCore.areas.HomeArea;
import java.util.ArrayList;

public class AreasStorage {


    private static ArrayList<HomeArea> homeAreas = new ArrayList<>();


    public static void addHomeArea(HomeArea homeArea){

        homeAreas.add(homeArea);
    }

    public static HomeArea getHomeArea(int areaID){

        return homeAreas.get(areaID);

    }

}