package com.demo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HuffmanCode {

	public static void main(String[] args) {
		String content="i like like like java do you like a java";
		//转成byte数组
		byte[] bytes = content.getBytes();
		//进行赫夫曼编码压缩
		byte[] huffmanBytes = huffmanZip(bytes);
		
	}
	
	/**
	 * 将 content 进程赫夫曼编码，返回的就是 按 赫夫曼编码后的 byte数组
	 * 比如: "i like like like java do you like a java" => 
	 * 101010011011110111101001101111011110100..  但是 是按照 byte数组来存放的,每8位 放入到一个 byte中!
	 * 比如：huffmanBytes[0] = -41(10101001)  huffmanBytes[1] = -61(10111101) ...
	 * @param bytes
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		//先统计每一个byte出现的次数，并放入一个集合中
		List<Node> nodes = getNodes(bytes);
		//创建一颗赫夫曼树
		Node root = createHuffmanTree(nodes);
		//测试一下 赫夫曼树 是否创建成功!
		//输出root 的 值
		//System.out.println(root + " " + root.left + " " + root.right);
		//创建一个赫夫曼编码表
		Map<Byte, String> huffmanCodes = getCodes(root);
		//测试一把, 看看 	赫夫曼编码表 是否正确
		//32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011
		//System.out.println(huffmanCodes);
		//遍历一把
		Set<Byte> keySet = huffmanCodes.keySet();
		for(Byte key: keySet) {
			System.out.print((char)key.intValue() + "=" + huffmanCodes.get(key) + " ");
		}
		//对 bytes 进行哈夫曼编码，返回的是 一个byte数组
		//"i like like like java do you like a java" 
		//对应的 是 "1010100010111111110.."
		//huffmanBytes[0] = 10101000 = -88
		//huffmanBytes[1] = 10111111 = -65
		byte[] huffmanBytes = zip(bytes,huffmanCodes);
		//测试一个 
		System.out.println("\n" + Arrays.toString(huffmanBytes));
		return huffmanBytes;
		
	}
	
	
	//某个叶子节点存储路径
	static StringBuilder stringBuilder = new StringBuilder();
	//存储赫夫曼编码
	static Map<Byte, String> huffmanCodes = new HashMap<>();
	
	/**
	 * 传入赫夫曼树的根节点，返回对应的赫夫曼编码 Map<Byte, String>
	 * 即形式如(和生成的赫夫曼树有关系)： 	
	 * 			o: 1000   	u: 10010  	d: 100110  		y: 100111  		i: 101
				a: 110     k: 1110    	e: 1111       	j: 0000       	v: 0001
				l: 001 		 : 01

	 * @param root
	 * @return
	 */
	private static Map<Byte, String> getCodes(Node root) {
		
		if(root==null) {
			return null;
		}
		//处理root的左子树
		getCodes(root.left,"0",stringBuilder);
		//处理root的右子树
		getCodes(root.right,"1",stringBuilder);
		return huffmanCodes;
		
	}
	
	
	/**
	 * 该方法会node 节点的所有叶子节点的赫夫曼编码,并存放在huffmanCodes集合中
	 * 其形式如：{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
	 * @param node
	 * @param code
	 * @param stringBuilder
	 */
	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if(node != null) {
			if (node.data == null) {
				getCodes(node.left, "0", stringBuilder2);
				getCodes(node.right, "1", stringBuilder2);
			} else {
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}
	
	/**
	 * 
	 * @param bytes 传入的"i like .." 对应的字节数组，和 哈夫曼编码表
	 * @param huffCodes 返回哈夫曼编码后的byte[]
	 * @return
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder stringBuilder = new StringBuilder();
		//把需要压缩的byte数组处理成一个二进制的字符串
		//stringBuilder 就是 形式如 "10101001101111011110..."
		for(byte b:bytes) {
			stringBuilder.append(huffmanCodes.get(b)); 
		}
		System.out.println("stringBuilder(就是哈夫曼编码后的串)=" + stringBuilder);
		//定义就是需要多少个byte来存储，这样就可以定义byte[] 的大小了
		//也可以一句话 len = (stringBuilder.length()+7) / 8
		int len; 
		if (stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}
		//用于存储压缩后的byte
		byte[] by = new byte[len];
		//记录新byte的位置
		int index = 0;
		for(int i=0;i<stringBuilder.length();i+=8) {
			String strByte;
			if(i+8>stringBuilder.length()) {
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i, i+8);
			}
			byte byt = (byte)Integer.parseInt(strByte, 2);
			by[index]=byt;
			index++;
		}
		return by;
	}

	/**
	 * 
	 * @param bytes byte数组，就是内容字符串对应的byte数组
	 * @return List<Node> 形式如 {Node{'i', 3}, Node{'a', 5}...}
	 */
	private static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes = new ArrayList<>();
		//存储每一个byte出现了多少次。
		Map<Byte, Integer> counts = new HashMap<>();
		//统计每一个byte出现的次数
		for(byte b:bytes) {
			Integer count = counts.get(b);
			if(count==null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
		}
		//把每一个键值对转为一个node对象,并加入到 nodes集合
		for(Map.Entry<Byte, Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}
	
	/**
	 * 创建赫夫曼树
	 * @param nodes 传入的是一个node集合
	 * @return 返回赫夫曼树的根节点
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		
		// 循环处理，
		while (nodes.size() > 1) { // 保证可以get(0) 和 get(1)
			// 排序
			// 说明
			// 1. 需要nodes 集合存放的对象实现 Comparable接口
			Collections.sort(nodes);
			// 取出来权值最小的两个二叉树
			Node left = nodes.get(0);
			// 取出最权值次小的二叉树, 作为新的二叉树的右子树
			Node right = nodes.get(1);
			// 创建一颗新的二叉树 ， 新的节点 data 没有，权值为两颗子树权值和
			Node parent = new Node(null, left.weight + right.weight);
			// 把之前取出来的两颗二叉树设置为新创建的二叉树的子树
			parent.left = left;
			parent.right = right;
			// 把取出来的两个二叉树移除
			nodes.remove(left);
			nodes.remove(right);
			// 放入原来的二叉树集合中
			nodes.add(parent);
		}
		// 返回的节点就是赫夫曼树的根节点.
		return nodes.get(0);
	}


}

//实现 Comparable<Node> 接口是让Node 对象可以进行排序
class Node implements Comparable<Node> {
	Byte data;  // 数据本身 , char 本质就是 Byte
	int weight; // 可以理解成权值, 即字符出现的次数
	Node left;
	Node right;

	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	
	@Override
	public int compareTo(Node node) {
		//这样写是从小到大排序
		return this.weight - node.weight;
	}

	
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}


	// 前序遍历
	public void preOrder() {
		System.out.println(this);// 先输出父节点
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
}


