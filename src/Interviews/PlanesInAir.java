package Interviews;

import java.util.*;

public class PlanesInAir {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight(4, 8));
        flights.add(new Flight(2, 5));
        flights.add(new Flight(17, 20));
        flights.add(new Flight(10, 21));
        flights.add(new Flight(9, 18));


        System.out.println(flightsInAir(flights));
    }

    public static int flightsInAir(List<Flight> flights) {
        int maxFlightCount = 0;


        //flights.forEach(k -> System.out.println(k));

//        flights.sort(Comparator.comparingInt(Flight::getStart));

        Collections.sort(flights,(a, b)->(a.start-b.start));

        PriorityQueue<Flight> flightsInAir = new PriorityQueue<>((Comparator.comparingInt(a -> a.end)));
        for (Flight flight : flights) {

            while (!flightsInAir.isEmpty() && flightsInAir.peek().end < flight.start) {
                flightsInAir.poll();
            }
            flightsInAir.add(flight);
            maxFlightCount = Math.max(maxFlightCount, flightsInAir.size());
        }


        flights.forEach(k -> System.out.println(k));
        return maxFlightCount;
    }

    static class Flight {
        public int start;
        public int end;

        public Flight(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Flights{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }


    }

}
