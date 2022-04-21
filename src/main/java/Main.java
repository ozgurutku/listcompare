import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,List<?>> objectList = getObject();
        Map<String,List<?>> dataList = getData();

        List<?> objects = objectList.get("hava");
        for (Object o: objects) {
            System.out.println(((Hava) o).getA());
            System.out.println(((Hava) o).getB());
        }

        List<Cıva> civaList1 = new ArrayList<>();
        Cıva civa = new Cıva("ankara","istanbul");
        civaList1.add(civa);
        Cıva civa2 = new Cıva("d","d");
        civaList1.add(civa2);

        List<Cıva> civaList2 = new ArrayList<>();
        Cıva civa3 = new Cıva("ankara","istanbul");
        civaList2.add(civa3);
        Cıva civa4 = new Cıva("da","d");
        civaList2.add(civa4);

        System.out.println(compareList(civaList1,civaList2));
        System.out.println(civaList1.removeAll(civaList2));
    }

    @Test
    public void whenTestingForEquality_ShouldBeEqual() throws Exception {
        Map<String,List<?>> objectList = getObject();
        List<Cıva> civaList = new ArrayList<>();
        Cıva civa = new Cıva("ankara","istanbul");
        civaList.add(civa);
        Cıva civa2 = new Cıva("d","d");
        civaList.add(civa2);
        List<Cıva> objects2 = (List<Cıva>) objectList.get("cıva");

        Assert.assertTrue(compareList(civaList,objects2));
        //Assert.assertSame(civaList, objects2);
        //Assert.assertNotEquals(civaList, objects2);
    }

    private static boolean compareList( List<?> l1, List<?> l2 ) {
        // make a copy of the list so the original list is not changed, and remove() is supported
        ArrayList<?> cp = new ArrayList<>( l1 );
        for ( Object o : l2 ) {
            if ( !cp.remove( o ) ) {
                return false;
            }
        }
        return cp.isEmpty();
    }

    public static Map<String,Map<String,List<?>>> generateObjectAndData(){
        Map<String,Map<String,List<?>>> objectAndData = new LinkedHashMap<>();
        Map<String,List<?>> dataList = new LinkedHashMap<>();

        List<String> list = new ArrayList<>();
        list.add("d1");
        list.add("d2");
        dataList.put("deneme",list);
        Map<String,List<?>> objectList = new LinkedHashMap<>();
        List<Hava> havaList = new ArrayList<>();
        List<Cıva> civaList = new ArrayList<>();
        Hava hava = new Hava("leb","lebi");
        Cıva civa2 = new Cıva("d","d");
        civaList.add(civa2);
        Cıva civa = new Cıva("ankara","istanbul");
        civaList.add(civa);
        havaList.add(hava);
        objectList.put("hava",havaList);
        objectList.put("cıva",civaList);

        objectAndData.put("dataList",dataList);
        objectAndData.put("objectList",objectList);

        return objectAndData;
    }

    public static Map<String,List<?>> getObject(){
        return generateObjectAndData().get("objectList");
    }

    public static Map<String,List<?>> getData(){
        return generateObjectAndData().get("dataList");
    }
}
