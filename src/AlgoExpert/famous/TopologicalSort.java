package AlgoExpert.famous;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer []{1,2});
        deps.add(new Integer []{1,3});
        deps.add(new Integer []{3,2});
        deps.add(new Integer []{4,2});
        deps.add(new Integer []{4,3});

        topologicalSort(Arrays.asList(1,2,3,4), deps).forEach(k-> System.out.println(k));

    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps){
        JobGraph jobGraph = createJobGraph( jobs, deps);
        return getOrderedJobs(jobGraph);
    }

    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = new JobGraph(jobs);
        
        for (Integer[] dep : deps){
            graph.addPrereq(dep[1], dep[0] );
        }

        return graph;
    }

    private static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> orderedJobs = new ArrayList<>();
        List<JobNode> nodes = new ArrayList<>(graph.nodes);
        while (nodes.size()>0) {
            JobNode node = nodes.get(nodes.size()-1);
            nodes.remove(nodes.size()-1);
            boolean containsCycle = dfs(node, orderedJobs);
            if (containsCycle)
                return new ArrayList<>();
        }
        return orderedJobs;
    }

    private static boolean dfs(JobNode node, List<Integer> orderedJobs) {
        if (node.visited) {
            return false;
        }
        if (node.visiting) {
            return true;
        }
        node.visiting = true;
        for (JobNode prereqNode : node.prereqs){
            boolean containsCycle = dfs(prereqNode, orderedJobs);
            if (containsCycle) {
                return true;
            }
        }
        node.visited = true;
        node.visiting = false;
        orderedJobs.add(node.job);
        return false;
    }

    static class JobGraph {

        public List<JobNode> nodes;
        public Map<Integer,JobNode> graph;

        public JobGraph(List<Integer> jobs) {
            nodes = new ArrayList<JobNode>();
            graph = new HashMap<Integer, JobNode>();
            for (Integer job : jobs){
                addNode(job);
            }
        }

        private void addNode(Integer job) {
            graph.put(job, new JobNode(job));
            nodes.add(graph.get(job));
        }

        public void addPrereq(Integer job, Integer prereq ){

            JobNode jobNode = getNode(job);
            JobNode prereqNode= getNode(prereq);
            jobNode.prereqs.add(prereqNode);

//            getNode(job).prereqs.add(getNode(prereq));
        }

        private JobNode getNode(Integer job) {

            if(!graph.containsKey(job))
                addNode(job);

            return graph.get(job);
        }
    }


    static class JobNode {
        public Integer job;
        public List<JobNode> prereqs;
        public boolean visited;
        public boolean visiting;

        public JobNode(Integer i) {
            this.job = i;
            this.prereqs = new ArrayList<JobNode>();
            this.visited = false;
            this.visiting = false;
        }


    }
}