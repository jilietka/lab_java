import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanAlgorithm {

    public static void main(String[] args) { //вводим текст, проверка на правильность и ввыводы
        String mes = "кукумбер";
        if (mes.length() <= 2) {
            System.out.println("Внимание, введенное сообщение должно содержать больше 2 символов! Повторите попытку");
            return;
        }
        System.out.println("Введенное сообщение: " + mes);

        Node hufTree = createHuffmanTree(mes);
        Map<Character, String> hufCode = generateHuffmanCodes(hufTree);

        System.out.println("Кодовая таблица:");
        for (Map.Entry<Character, String> entry : hufCode.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String encodedMes = encode(mes, hufCode);
        System.out.println("Закодированное сообщение: " + encodedMes);

        String decodedMes = decode(encodedMes, hufTree);
        System.out.println("Раскодированное сообщение: " + decodedMes);
    }

    public static Node createHuffmanTree(String text) { //метод для создания дерева
        Map<Character, Integer> freqMap = new HashMap<>(); //создаем "частоту" появления символа
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> priority = new PriorityQueue<>(); //создаем приоритетную очередь для создания дерева
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            priority .offer(new Node(entry.getKey(), entry.getValue()));
        }

        while (priority.size() > 1) { //раскидываем сообщение на дерево
            Node leftChild = priority.poll();
            Node rightChild = priority.poll();
            int combinedFreq = leftChild.freq + rightChild.freq;
            priority.offer(new Node('\0', combinedFreq, leftChild, rightChild));
        }

        return priority.poll();
    }

    public static Map<Character, String> generateHuffmanCodes(Node root) { //созадние кодов для символос
        Map<Character, String> hufCode = new HashMap<>();
        encode(root, "", hufCode);
        return hufCode;
    }

    public static void encode(Node root, String str, Map<Character, String> hufCode) { //кодирование сообщения
        if (root == null) {
            return;
        }

        if (root.leftChild == null && root.rightChild == null) {
            hufCode.put(root.ch, str);
        }

        encode(root.leftChild, str + "0", hufCode);
        encode(root.rightChild, str + "1", hufCode);
    }

    public static String encode(String text, Map<Character, String> huffmanCode) {
        StringBuilder encodedMes = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedMes.append(huffmanCode.get(ch));
        }
        return encodedMes.toString();
    }

    public static String decode(String encodedMes, Node root) { //раскодирование сообщения
        StringBuilder decodedMes = new StringBuilder();
        Node current = root;
        for (char bit : encodedMes.toCharArray()) {
            if (bit == '0') {
                current = current.leftChild;
            } else if (bit == '1') {
                current = current.rightChild;
            }

            if (current.leftChild == null && current.rightChild == null) {
                decodedMes.append(current.ch);
                current = root;
            }
        }
        return decodedMes.toString();
    }
}
