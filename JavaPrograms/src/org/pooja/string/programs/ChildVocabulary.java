package org.pooja.string.programs;

public class ChildVocabulary {

	public static void main(String[] args) {
		String[] vocabArr = {"baba","ga" ,"dada","gaga"};
		String input = "gadadagagababa";
		for(int i =0;i<vocabArr.length;i++){
			String currentWord = vocabArr[i];
			int index = input.indexOf(currentWord);
			if(index == 0){
				continue;
			}else{
				input = input.substring(0,index)+" "+input.substring(index);
			}
		}
		System.out.println(input);
	}
	
}
