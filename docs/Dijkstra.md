### 1.二叉树的层序遍历

#### a.while + for

```java
public class Solution {
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.println("Node " + node.id + " is on the " + step + "th level.");

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            step++;
        }
    }
}
```

---

#### b.while

```java
public class Solution {
    private class State {
        public TreeNode node;
        public int step;

        public State(TreeNode node, int step) {
            this.node = node;
            this.step = step;
        }
    }

    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(root, 1));

        while (!queue.isEmpty()) {
            int size = queue.size();

            State state = queue.poll();
            System.out.println("Node " + state.node.id + " is on the " + state.step + "th level.");

            if (state.node.left != null) {
                queue.offer(new State(state.node.left, state.step + 1));
            }
            if (state.node.right != null) {
                queue.offer(new State(state.node.right, state.step + 1));
            }
        }
    }
}
```

---

### 2.N叉树的层序遍历

#### a.while+for

```java

public class Solution {
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.println("Node " + node.id + " is on the " + step + "th level.");

                for (TreeNode child : node.children()) {
                    queue.offer(child);
                }
            }

            step++;
        }
    }
}
```

---

#### b.while

```java

public class Solution {
    private class State {
        public TreeNode node;
        public int step;

        public State(TreeNode node, int step) {
            this.node = node;
            this.step = step;
        }
    }

    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(root, 1));

        while (!queue.isEmpty()) {
            int size = queue.size();

            State state = queue.poll();
            System.out.println("Node " + state.node.id + " is on the " + state.step + "th level.");

            for (TreeNode child : state.node.children()) {
                queue.offer(new State(child, state.step + 1));
            }
        }
    }
}
```

---

我们可以把图看成是一种特殊的N叉树，二者的区别
- [x] a.普通N叉树的根结点的入度为0，其余任意一个节点的入度为1；图的任意一个节点的入度 >= 0
- [x] b.普通N叉树的边只能是单向的；图的边可以是单向或者双向
- [x] c.图的边是可以是有权重的，当无权重时可以看作是权重 = 1

BFS广度优先算法只适用于**有向无权图**的最短路径求解，和N叉树的层序遍历类似（**注：需要用一个数组visited[]记录访问过的点，避免重复访问**）

### 3.Dijkstra算法
```java
public class Solution {
    int weight(int from, int to);

    List<Integer> adj(int s);

    int[] dijkstra(int start, List<Integer>[] graph) {
        int V = graph.length;

        int[] distTo = new int[V];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        distTo[start] = 0;

        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            for (int nextNodeID : adj(curNodeID)) {
                int distToNextNode = distTo[curNodeID] + weight(curNodeID, nextNodeID);

                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }
}
```