package lecture_51;
import java.util.*;

class Node{
    char val;
    Node left;
    Node right;
    public Node(char val){
        this.val = val;
    }
}
public class expre_Tree {
    public static void main(String[] args) {
        String s = "2-3/(5*2)+1";
        String str = postfix(s);
        Node root = createTree(str);
        print(root);
    }
    public static void print(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.val+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }
    public static Node createTree(String str){
        Stack<Node> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='0' && ch<='9'){
                st.push(new Node(ch));
            }else{
                Node right = st.pop();
                Node left = st.pop();
                Node nn = new Node(ch);
                nn.left = left;
                nn.right = right;
                st.push(nn);
            }
        }
        return st.peek();
    }

    public static String postfix(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                sb.append(ch);
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
            }else{
                while(!st.isEmpty() && getValue(st.peek())>=getValue(ch)){
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public static int getValue(char ch){
        if(ch=='*' || ch=='/'){
            return 2;
        }else if(ch=='+' || ch=='-'){
            return 1;
        }else{
            return -1;
        }
    }
}