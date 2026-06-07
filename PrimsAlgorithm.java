import java.util.*;

class Edge {
    int destination;
    int weight;

    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class PrimsAlgorithm {
    private int vertices;
    private List<List<Edge>> adjacencyList;

    PrimsAlgorithm(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    void primMST() {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        int[] key = new int[vertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, (a, b) -> a.weight - b.weight);
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.destination;

            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            for (Edge edge : adjacencyList.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Edge(v, weight));
                }
            }
        }

        System.out.println("\nEdge \tWeight");
        int totalWeight = 0;
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + key[i]);
            totalWeight += key[i];
        }
        System.out.println("Total MST Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        PrimsAlgorithm graph = new PrimsAlgorithm(5);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        System.out.println("Prim's Algorithm - MST using Priority Queue");
        graph.primMST();
    }
}
