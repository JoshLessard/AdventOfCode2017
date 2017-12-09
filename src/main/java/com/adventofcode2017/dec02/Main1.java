package com.adventofcode2017.dec02;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Main1 {

    public static void main( String[] args ) throws Exception {
        try ( BufferedReader reader = new BufferedReader( new FileReader( "./src/main/resources/dec02/input.txt" ) ) ) {
            int checksum = reader.lines()
                .map( s -> s.split( "\\s" ) )
                .map( toInts() )
                .mapToInt( toChecksum() )
                .sum();

            System.out.println( "Checksum: " + checksum );
        }
    }

    private static Function<String[], List<Integer>> toInts() {
        return numbersAsStrings -> Stream.of( numbersAsStrings )
            .map( Integer::valueOf )
            .sorted()
            .collect( toList() );
    }

    private static ToIntFunction<List<Integer>> toChecksum() {
        return ints -> ints.get( ints.size() - 1 ) - ints.get( 0 );
    }
}
