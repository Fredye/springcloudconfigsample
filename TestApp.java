package p.yqshare;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author DuDu
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        log("Location::" + java.time.ZoneOffset.systemDefault());
        log("SystemTime::" + java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        java.util.List<String> list = java.util.Arrays.asList("Alice", "Bob", "Charlie", "X", "Dave");
        Optional<String> sm1 = list.stream().reduce((s, e) -> s = s + "," + e);
        Optional<char[]> sk1 = sm1.map(s -> s.toCharArray());
        
        log(sm1.get());
        log(list.toArray());
        sk1.ifPresent(v -> {
            for (char c : v) {
                //log(c);
            }
        } );

        //Lambda & Stream
        list.stream()
                .sorted((t1, t2) -> {
                    return t1.length() - t2.length();
                })
                .map(s -> s.toUpperCase())
                .forEach(TestApp::log);
        
        Runnable r1 = () -> {System.out.println("Hello Lambda!");};
        Object x1 = r1;
        Object x2 = (Runnable)() -> {System.out.println("Hello Lambda!");};
        
        Optional<Integer> reduce;
        reduce = Stream.generate(() -> {
            return Double.valueOf(Math.random()*100).intValue();
        }).limit(5).reduce((sum, e) -> sum + e);
      
        //reduce = Optional.ofNullable(null);
        reduce.filter(v -> v > 0x100)
                .ifPresent(TestApp::log);
        
        log(reduce.orElse(0));
    }

    private static void log(Object... s) {
        StringBuilder sb = new StringBuilder();
        for (Object v : s) {
            sb.append(v).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    
}
