package lecture_51;
import java.util.*;
public class Group_Anagram {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[]= {"eat","tea","tan","ate","nat","bat"};
		System.out.print(group(arr));
	}
	public static List<List<String>> group(String []arr){
		HashMap<String,List<String>> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			String key=Anagram(arr[i]);
			if(!map.containsKey(key)) {
				map.put(key,new ArrayList<>());
			}
			map.get(key).add(arr[i]);
		}
		List<List<String>> ans=new ArrayList<>();
		for(String key:map.keySet()) {
			ans.add(map.get(key));
		}
		return ans;
	}
	public static String Anagram(String s) {
		int freq[]=new int[26];
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			freq[ch-97]++;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<freq.length;i++) {
			sb.append(freq[i]+" ");
		}
		return sb.toString();
	}
}
