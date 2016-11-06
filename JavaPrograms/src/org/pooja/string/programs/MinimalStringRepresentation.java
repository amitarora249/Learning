package org.pooja.string.programs;

public class MinimalStringRepresentation {

	public static void main(String[] args) {
		String sequence = "aaabbaaaacccbbbbcc";
		char[] charArray = sequence.toCharArray();
		String minimal = "";
		for(int i=0;i< sequence.length();){
				int count =0;
				int j =i;
				for(;j<charArray.length;j++){
					if(charArray[i] == charArray[j]){
						count++;
					}else{
						break;
					}
				}
				if(count > 2){
					minimal = minimal+String.valueOf(count)+charArray[i];
					i+=count;
					
				}else{
					minimal = minimal+charArray[i];
					i++;
				}
		}
		System.out.println("Minimal = "+minimal);
	}
}
