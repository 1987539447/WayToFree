/**
 * Created by Zhan on 2017-07-07.
 */

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class Test {

    public static void main(String[] args) throws IOException {

        language();
    }

    private static void language(){
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String,String> languageNames = locales.collect(
                Collectors.toMap(l->l.getDisplayLanguage(),
                        l->l.getDisplayLanguage(l),
                        (existingValue,newValue)->existingValue)
        );
        System.out.println("-----------default lan vs local lan-----------");
        languageNames.forEach((k,v)->{
            System.out.println("k--"+k+"--value--"+v);
        });

        //流已关闭 需要重新创建
        locales = Stream.of(Locale.getAvailableLocales());

        Map<String,Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(
                        l->l.getDisplayCountry(),
                        l->Collections.singleton(l.getDisplayLanguage()),
                        (a,b)->{
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }
                )
        );
        locales.collect(Collectors.groupingBy(
                l->l.getDisplayCountry(),
                Collectors.mapping(l->l.getDisplayLanguage(),Collectors.toSet())
        ));
        System.out.println("-----------country vs lan-----------");
        countryLanguageSets.forEach((k,v)->{
            System.out.println("----k--"+k);
            v.forEach(e-> System.out.println("------------v--"+e));
        });

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String,List<Locale>> countryToLocale = locales.collect(
                Collectors.groupingBy(Locale::getCountry)
        );
        countryToLocale.get("CH").forEach(e-> System.out.println(e));

        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean,List<Locale>> engelishAndOther = locales.collect(
                Collectors.partitioningBy(l->l.getLanguage().equals("en"))
        );
        engelishAndOther.get(true).forEach(System.out::println);

        Map<String,Set<Locale>> countryToLocaleSet = locales.collect(
                Collectors.groupingBy(Locale::getCountry,Collectors.toSet())
        );



    }

    private static void partA() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("d:/temp/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long start = System.nanoTime();
        long count = words.stream().filter(w->w.length() >5).count();
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        long parCount = words.parallelStream().filter(w->w.length()>5).count();
        System.out.println(System.nanoTime() - start);
        System.out.println(parCount);


        Stream<String> wordSteam = Stream.of(contents);
        Stream<String> song = Stream.of("gently","down","stream");
        Stream<String> silence = Stream.empty();
        Stream<String> echos = Stream.generate(()->"Echo");
        Stream<Double> randoms = Stream.generate(Math::random).limit(100).skip(1);
        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO,n->n.add(BigInteger.ONE));
        Stream<String> splitWords = Pattern.compile("").splitAsStream("");

        Stream<String> longWords = words.stream().filter(w->w.length()>12);
        Stream<String> lowerCaseWords = words.stream().map(String::toLowerCase);
        Stream<Character> firstChar = words.stream().map(w->w.charAt(0));
        Stream<Stream<Character>> result = words.stream().map(w->characterStream(w));
        Stream<Character> letters = words.stream().flatMap(w->characterStream(w));
        Stream<Character> combine = Stream.concat(characterStream("hello"),characterStream("world"));
        Object[] powers = Stream.iterate(1.0,p->p*2).peek(e-> System.out.println(e)).limit(20).toArray();

        Stream<String> uniqueWords = words.stream().distinct();
        Stream<String> longestFirst = wordSteam.sorted(Comparator.comparing(String::length).reversed());
        Optional<String> largest = wordSteam.max(String::compareToIgnoreCase);
        Optional<String> startWithQ = wordSteam.filter(w->w.startsWith("Q")).findAny();//.findFirst();
        boolean awordStartWithQ = wordSteam.parallel().anyMatch(w->w.startsWith("Q"));

        startWithQ.ifPresent(System.out::println);
        //Optional<boolean> isPrint = startWithQ.map(result::add);
        Optional<String> optionalString = Optional.of("abcdefg");
        String value = optionalString.orElse(System.getProperty("user.dir"));
        optionalString.orElseThrow(NoSuchElementException::new);
        Test.inverse(0.4).flatMap(Test::inverse);

        Double sum = randoms.reduce(0.0,(x,y)->x+y);
        int totalLength = wordSteam.reduce(0,(totle,word)->totle+word.length(),(totalX,totalY)->totalX+totalY);

        List<String> wordList = wordSteam.collect(Collectors.toList());
        Set<String> wordSet = wordSteam.collect(Collectors.toSet());
        TreeSet<String> wordTreeSet = wordSteam.collect(Collectors.toCollection(TreeSet::new));
        String joinWord = wordSteam.collect(Collectors.joining("-"));
        IntSummaryStatistics summary = wordSteam.collect(Collectors.summarizingInt(String::length));
        double avgWordLength = summary.getAverage();
        double maxLength = summary.getMax();

        Stream<Person> allMan = Stream.of(new Person(1, "jack"),new Person(2, "rose"),new Person(3, "tom"));
        Map<Integer,String> idToName = allMan.collect(Collectors.toMap(Person::getId,Person::getName));
        Map<Integer,Person> idToPerson = allMan.collect(
                Collectors.toMap(Person::getId,
                        Function.identity(),
                        (existingValue,newValue)->{throw new IllegalStateException();},TreeMap::new));
    }

    private static Stream<Character> characterStream(String w) {
        List<Character> result = new ArrayList<>();
        for (Character character : w.toCharArray()) {
            result.add(character);
        }

        return result.stream();
    }

    public static Optional<Double> inverse(Double value){
        return value == 0 ? Optional.empty() : Optional.of(1/value);
    }

    private static class Person {
        private int id;
        private String name;

        private Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
