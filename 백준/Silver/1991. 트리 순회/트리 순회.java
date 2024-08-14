import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static class Node {
		char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static HashMap<Character, Node> nodes = new HashMap<>();
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		initialize();
		전위순회(nodes.get('A'));
		output.append('\n');
		중위순회(nodes.get('A'));
		output.append('\n');
		후위순회(nodes.get('A'));
		System.out.println(output);
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		for (int n = 0; n < N; n++) {
			char[] node = input.readLine().replace(" ", "").toCharArray();
			char parent = node[0];
			char left = node[1];
			char right = node[2];
			nodes.putIfAbsent(parent, new Node(parent));
			if (left != '.') {
				nodes.putIfAbsent(left, new Node(left));
				nodes.get(parent).left = nodes.get(left);
			}
			if (right != '.') {
				nodes.putIfAbsent(right, new Node(right));
				nodes.get(parent).right = nodes.get(right);
			}
		}
	}

	static void 전위순회(Node root) {
		if (root != null) {
			output.append(root.data);
			전위순회(root.left);
			전위순회(root.right);
		}
	}

	static void 중위순회(Node root) {
		if (root != null) {
			중위순회(root.left);
			output.append(root.data);
			중위순회(root.right);
		}
	}

	static void 후위순회(Node root) {
		if (root != null) {
			후위순회(root.left);
			후위순회(root.right);
			output.append(root.data);
		}
	}
}