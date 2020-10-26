package AlgoExpert.graph;

import java.util.*;

public class AirportConnections {
    public static void main(String[] args) {
    List<String> airports
            = Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN"
            , "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD", "mik");

    List<List<String>> routes = new ArrayList<>();
    routes.add(Arrays.asList("DSM", "ORD"));
    routes.add(Arrays.asList("ORD", "BGI"));
    routes.add(Arrays.asList("BGI", "LGA"));
    routes.add(Arrays.asList("SIN", "CDG"));
    routes.add(Arrays.asList("CDG", "SIN"));
    routes.add(Arrays.asList("CDG", "BUD"));
    routes.add(Arrays.asList("DEL", "DOH"));
    routes.add(Arrays.asList("DEL", "CDG"));
    routes.add(Arrays.asList("TLV", "DEL"));
    routes.add(Arrays.asList("EWR", "HND"));
    routes.add(Arrays.asList("HND", "ICN"));
    routes.add(Arrays.asList("HND", "JFK"));
    routes.add(Arrays.asList("ICN", "JFK"));
    routes.add(Arrays.asList("JFK", "LGA"));
    routes.add(Arrays.asList("EYW", "LHR"));
    routes.add(Arrays.asList("LHR", "SFO"));
    routes.add(Arrays.asList("SFO", "SAN"));
    routes.add(Arrays.asList("SFO", "DSM"));
    routes.add(Arrays.asList("SAN", "EYW"));
    routes.add(Arrays.asList("LGA", "mik"));
        System.out.println(airportConnections(airports,routes,"LGA"));
    }
    public static int airportConnections(
            List<String> airports, List<List<String>> routes, String startingAirport) {
        Map<String, AirportNode> airportGraph = createAirportGraph(airports,routes);

        List<AirportNode> unreachableAirportNodes = getUnreachableAirportNodes(airportGraph,airports,startingAirport);

        markUnreachableConnections(airportGraph,unreachableAirportNodes);
        unreachableAirportNodes.forEach(k-> System.out.println(k.airport + " " + k.isReachable));
        return getMinNumberOfNewConnections(airportGraph,unreachableAirportNodes);
    }

    private static Map<String,AirportNode> createAirportGraph(List<String> airports, List<List<String>> routes) {
        Map<String, AirportNode> airportGraph = new HashMap<>();
        for (String airport: airports) {
            airportGraph.put(airport, new AirportNode(airport));
        }
        for (List<String> route : routes){
            String airport = route.get(0);
            String connection = route.get(1);
            airportGraph.get(airport).connections.add(connection);
        }


        return airportGraph;
    }

    private static List<AirportNode> getUnreachableAirportNodes(Map<String, AirportNode> airportGraph, List<String> airports, String startingAirport) {
        Set<String> visitedAirports = new HashSet<>();
        dfsAirports(airportGraph, startingAirport, visitedAirports);

        List<AirportNode> unreachableAirportNodes = new ArrayList<>();
        for(String airport: airports){
            if(visitedAirports.contains(airport))
                continue;
            AirportNode airportNode = airportGraph.get(airport);
            airportNode.isReachable = false;
            unreachableAirportNodes.add(airportNode);
        }
        return unreachableAirportNodes;
    }

    private static void dfsAirports(Map<String, AirportNode> airportGraph, String airport, Set<String> visitedAirports) {
        if (visitedAirports.contains(airport)) {
            return;
        }
        visitedAirports.add(airport);
        List<String> connections = airportGraph.get(airport).connections;
        for (String connection: connections) {
            dfsAirports(airportGraph,connection,visitedAirports);
        }
    }

    private static void markUnreachableConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
        for (AirportNode airportNode: unreachableAirportNodes) {
            String airport = airportNode.airport;
            List<String> unreachableConnections = new ArrayList<>();
            Set<String> visitedAirports = new HashSet<>();
            dfsUnreachableConnections(airportGraph, airport,unreachableConnections,visitedAirports);
            airportNode.unreachableConnections = unreachableConnections;
        }
    }

    private static void dfsUnreachableConnections(Map<String, AirportNode> airportGraph, String airport, List<String> unreachableConnections, Set<String> visitedAirports) {
        if (airportGraph.get(airport).isReachable) {
            return;
        }
        if (visitedAirports.contains(airport)) {
            return;
        }
        visitedAirports.add(airport);
        unreachableConnections.add(airport);
        List<String> connections = airportGraph.get(airport).connections;
        for (String connection : connections) {
            dfsUnreachableConnections(airportGraph,connection,unreachableConnections,visitedAirports);
        }

    }

    private static int getMinNumberOfNewConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
        unreachableAirportNodes.sort((a1,a2) -> a2.unreachableConnections.size()-a1.unreachableConnections.size());
        int numberOfNewConnections =0;
        for (AirportNode airportNode: unreachableAirportNodes) {
            if (airportNode.isReachable) {
                continue;
            }
            numberOfNewConnections++;
            for (String connection: airportNode.unreachableConnections){
                airportGraph.get(connection).isReachable = true;
            }
        }

        return numberOfNewConnections;
    }
    static class AirportNode{

        String airport;
        List<String> connections;
        boolean isReachable;
        List<String> unreachableConnections;

        public AirportNode(String airport) {
            this.airport = airport;
            connections= new ArrayList<>();
            isReachable =true;
            unreachableConnections = new ArrayList<>();
        }
    }
}
