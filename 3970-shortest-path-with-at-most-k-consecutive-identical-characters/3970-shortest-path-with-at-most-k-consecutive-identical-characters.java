import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list for the directed graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{v, w});
        }

        // Priority Queue stores: [node, streak, distance]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        // dist[u][streak] stores minimum distance to reach node u with a given streak of identical characters
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Start from node 0. The initial streak is 1.
        pq.offer(new int[]{0, 1, 0});
        dist[0][1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int streak = curr[1];
            int d = curr[2];

            // If we reached the destination node n - 1, return the total distance
            if (u == n - 1) {
                return d;
            }

            // Skip if we already found a shorter path to this state
            if (d > dist[u][streak]) {
                continue;
            }

            char charU = labels.charAt(u);

            // Explore neighbors
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int w = neighbor[1];
                char charV = labels.charAt(v);

                // Calculate the new streak of consecutive identical characters
                int newStreak = (charV == charU) ? streak + 1 : 1;

                // Only proceed if the new streak does not exceed k
                if (newStreak <= k) {
                    if (d + w < dist[v][newStreak]) {
                        dist[v][newStreak] = d + w;
                        pq.offer(new int[]{v, newStreak, d + w});
                    }
                }
            }
        }

        // If node n - 1 cannot be reached within the constraints, return -1
        return -1;
    }
}