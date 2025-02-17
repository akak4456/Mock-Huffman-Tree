import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String origin = "AAAAAAABBCCCDEEEEFFFFFFG";
        HuffmanTree huffmanTree = new HuffmanTree(origin);
        Map<Character, String> code = huffmanTree.getCode();
        for (Map.Entry<Character, String> entry : code.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println(origin + "의 허프만 코드는");
        StringBuilder huffmanCode = new StringBuilder();
        for(Character c : origin.toCharArray()) {
            huffmanCode.append(code.get(c));
        }
        System.out.println(huffmanCode);

    }
}