package fileread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        Map<String, String> results = solution14();
        results.forEach((o, o2) -> System.out.println(o+"  -  "+o2));

//        solution2();
//        solution3();
//        solution4();
    }

    public static Map<String, String> solution1(){
        Map<String, String> results;
        String delimiter = ":";
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("galatasaray.txt").getPath())).filter(s -> s.contains(delimiter))) {
            results = stream
                    .map(s -> s.split(delimiter))
                    .collect(Collectors.toMap(a -> a[0], a -> a[1], (a1, a2) -> a1));
        }catch(IOException e){
            System.out.println("Dosya okunurken bir şeyler ters gitti!");
            results = new HashMap<>();
        }
        return results;
    }

    public static Map<String, String> solution12(){
        String delimiter = ":";
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("galatasaray.txt").getPath())).filter(s -> s.contains(delimiter))) {
            return stream
                    .map(s -> s.split(delimiter))
                    .collect(Collectors.toMap(a -> a[0], a -> a[1], (a1, a2) -> a1));
        }catch(IOException e){
            System.out.println("Dosya okunurken bir şeyler ters gitti!");
            return new HashMap<>();
        }
    }

    public static Map<String, String> solution13(){
        Map<String, String> results = new HashMap<>();
        String delimiter = ":";
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("galatasaray.txt").getPath())).filter(s -> s.contains(delimiter))) {
            results = stream
                    .map(s -> s.split(delimiter))
                    .collect(Collectors.toMap(a -> a[0], a -> a[1], (a1, a2) -> a1));
            throw new IOException();
        }catch(IOException e){
            System.out.println("Dosya okunurken bir şeyler ters gitti!");
        }finally {
            return results;
        }
    }

    public static Map<String, String> solution14(){
        Map<String, String> results = new HashMap<>();
        String delimiter = ":";
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("galatasaray.txt").getPath())).filter(s -> s.contains(delimiter))) {
            results = stream
                    .map(s -> s.split(delimiter))
                    .collect(Collectors.toMap(a -> a[0], a -> a[1], (a1, a2) -> a1));
            throw new IOException();
        }finally {
            return results;
        }
    }

    public static void solution2(){
        try (Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("galatasaray.txt"))).lines().filter(s -> s.contains(":"))) {
            Map<String, String> results = stream
                    .map(s -> s.split(":"))
                    .collect(Collectors.toMap(a -> a[0], a -> a[1]));
            results.forEach((o, o2) -> System.out.println(o+" "+o2));
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("hata");
        }
    }

/*    public static void solution2(){
        Pattern pattern = Pattern.compile(":");
        try (Stream<String> stream = Files.lines(Paths.get("/home/ozgur/Desktop/projehitit/filesreadstream/src/galatasaray.txt"))) {
            Map<Object, Object> results =
                    stream.map(pattern::matcher)
                            .filter(Matcher::find)
                            .collect(Collectors.toMap(a -> a.group(1), a -> a.group(2)));
            results.forEach((o, o2) -> System.out.println(o+" "+o2));
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("hata");
        }
    }*/


    public static void solution3(){
        String delimiter = ":";
        Map<String, String> map = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get("/home/ozgur/Desktop/projehitit/filesreadstream/src/galatasaray.txt")).filter(line -> line.contains(delimiter))) {
            lines
                    .map(s -> s.split(":"))
                    .forEach(line -> map.putIfAbsent(line[0], line[1]));
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("hata");
        }
        System.out.println(map);
    }

    public static void solution4(){

        Pattern DELIMITER = Pattern.compile(":");
        try (Stream<String> lines = Files.lines(Paths.get("/home/ozgur/Desktop/projehitit/filesreadstream/src/galatasaray.txt")).filter(line -> line.contains(":"))) {
            Map<String, String> activityMap = lines.map(DELIMITER::split)
                .flatMap(a -> IntStream.range(0, a.length - 1).filter(i -> i % 2 == 0)
                        .mapToObj(i -> new AbstractMap.SimpleEntry<>(a[i], a[i + 1])))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a));
            System.out.println(activityMap);
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("hata");
        }
    }
}
