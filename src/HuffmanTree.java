import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int freq;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node left;
    Node right;

    @Override
    public int compareTo(Node o) {
        return Integer.compare(o.freq, this.freq);
    }
}
public class HuffmanTree {
    private ArrayList<Node> nodes;
    private Map<Character, String> code;
    public HuffmanTree(String str) {
        makeHuffmanTree(str);
    }

    private void makeHuffmanTree(String str) {
        nodes = new ArrayList<>();
        code = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            nodes.add(new Node(ch, freq));
        }
        Collections.sort(nodes);
        while(nodes.size() > 1) {
            Node leaf1 = nodes.remove(nodes.size() - 1);
            Node leaf2 = nodes.remove(nodes.size() - 1);
            int newFreq = leaf1.freq + leaf2.freq;
            Node newNode = new Node(' ',newFreq); // 공이 과연 이게 맞을까?
            newNode.left = leaf2;
            newNode.right = leaf1;
            nodes.add(newNode);
            Collections.sort(nodes);
        }
        generateCode(nodes.get(0), "");
    }

    private void generateCode(Node root, String append) {
        if(root.ch != ' ') {
            code.put(root.ch, append);
            return;
        }
        if(root.left != null) {
            generateCode(root.left, append + "0");
        }
        if(root.right != null) {
            generateCode(root.right, append + "1");
        }
    }

    public Map<Character, String> getCode() {
        return code;
    }
}
