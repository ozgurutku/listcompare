package deneme;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {

/*        Data data = new Data();
        TestData testData = converter(data);
        System.out.println(testData.equals(data));*/

        TestData testData1 = new TestData();
        TestElma testElma = new TestElma("1","2");
        TestElma testElma1 = new TestElma("3","4");
        testData1.getElmas().add(testElma);
        testData1.getElmas().add(testElma1);
        TestArmut testArmut = new TestArmut("3","4");
        TestArmut testArmut1 = new TestArmut("1","2");

        testData1.getArmuts().add(testArmut);
        testData1.getArmuts().add(testArmut1);

        Data data = new Data();
        Elma elma = new Elma("3","4");
        Elma elma1 = new Elma("1","2");
        data.getElmas().add(elma);
        data.getElmas().add(elma1);
        Armut armut = new Armut("3","4");
        Armut armut1 = new Armut("1","2");
        data.getArmuts().add(armut);
        data.getArmuts().add(armut1);



        List<TestData> testDataList = new ArrayList<>();
        testDataList.add(testData1);
        List<Data> dataList = new ArrayList<>();
        dataList.add(data);

/*
        System.out.println(testData1.equals(data));
*/
        System.out.println(compareDataAndTestData(data,testData1));
    }

    public static boolean compareDataAndTestData(Data data, TestData testData){
        if (testData.getArmuts().size() != data.getArmuts().size() || testData.getElmas().size() != data.getElmas().size()){
            return false;
        }
        testData.getElmas().removeAll(data.getElmas());
        testData.getArmuts().removeAll(data.getArmuts());

        return testData.getElmas().isEmpty() && testData.getArmuts().isEmpty();
    }

    public static TestData converter(Data data){
        TestData testData = (TestData) objectMapper(data);
        return testData;
    }

    public static Object objectMapper(Object object){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        TestData testData = mapper.convertValue(object, TestData.class);
        return testData;
    }
}
