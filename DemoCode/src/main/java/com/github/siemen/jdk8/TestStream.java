package com.github.siemen.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Zhan on 2017/2/28 0028.
 *
 * Stream API
 */
public class TestStream {

    public static void main(String[] args) {

        //testCollection();
        //testSupplier();
        testFabonicc();
    }

    public static void testCollection() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream = numbers.stream();
        stream.filter(x -> x%2 == 0).map( x -> x*x).forEach(System.out::println);
    }

    public static void testSupplier(){
        Stream<Long> natural = Stream.generate(new NaturalSupplier());
        natural.map(x -> x*x).limit(10).forEach(System.out::println);
    }

    public static void testFabonicc(){
        Stream<Long> fabonicc = Stream.generate(new FabonacciSupplier());
        fabonicc.limit(10).forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<Long> temList = fabonicc.skip(10).limit(10).collect(Collectors.toList());
        for (Long aLong : temList) {
            System.out.println(aLong);
        }
    }

    static class NaturalSupplier implements Supplier<Long>{
        long value = 0;

        @Override
        public Long get() {
            this.value = this.value + 1;
            return this.value;
        }
    }

    static class FabonacciSupplier implements Supplier<Long>{
        long a = 0;
        long b = 1;

        @Override
        public Long get() {
            long x = a+b;
            a = b;
            b = x;
            return a;
        }
    }
}
