package com.kjh.study.test.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 주어진 문자열(공백 없이 쉼표로 구분되어 있음)을 가지고 아래 문제에 대한 프로그램을 작성하세요.

    이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌

    1. 김씨와 이씨는 각각 몇 명 인가요?
    2. "이재영"이란 이름이 몇 번 반복되나요?
    3. 중복을 제거한 이름을 출력하세요.
    4. 중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.

 */
public class NameDetector {
	
	private String[] nameArray;
	
	public NameDetector(String[] nameArray) {
		this.nameArray = nameArray;
	}
	
	public int getCountForLastName(String lastName) {
		
		int count = 0;
		
		for (String name : nameArray) {
			String memberLastName = name.substring(0, 1);
			if (lastName.equals(memberLastName)) {
				System.out.println("같은 녀석 : " + name);
				count++;
			}
		}
		return count;
	}
	
	public int getCountForFullName(String fullName) {
		
		int count = 0;
		
		for (String name : nameArray) {
			if (name.equals(fullName)) {
				count ++;
			}
		}
		return count;
	}
	
	public String[] getDeduplicatedNameArray() {
		
		List<String> deduplicatedList = new ArrayList<String>();
		
		for (String name : nameArray) {
			if (!deduplicatedList.contains(name)) {
				deduplicatedList.add(name);
			}
		}
		return deduplicatedList.toArray(new String[deduplicatedList.size()]);
	}
	
	public String[] getAscendingNameArray(String[] deduplicatedArray) {
		
		List<String> ascendingList = new ArrayList<String>();
		
		/* Algorith 활용 */
		//Selection Sort 
//		String[] sortedArray = selectionSort(deduplicatedArray);
//		return sortedArray;
		
		//
		
		/* List API 활용 */
		ascendingList = Arrays.asList(deduplicatedArray);
		getAscendingNameArrayUsingListAPI(ascendingList);
		return ascendingList.toArray(new String[ascendingList.size()]);
	}
	
	private String[] selectionSort(final String[] array) {
		
		String[] sortedArray = new String[array.length];
		System.arraycopy(array, 0, sortedArray, 0, array.length);
		
//		System.out.println("---------- base array -----------");
//		for (String name : sortedArray) {
//			System.out.print(name + " ");
//		}
//		System.out.println();
		
		for (int i = 0 ; i < sortedArray.length -1 ; i++) {
			String minName = sortedArray[i];
			for (int j = i + 1 ; j < sortedArray.length ; j++) {
				if (sortedArray[j].compareTo(minName) < 0) { 
					minName = sortedArray[j];
					String temp = sortedArray[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = temp;
				}
			}
//			System.out.print("선택정렬 " + (i+1) + " 단계 : ");
//			for (String n : sortedArray) {
//				System.out.print(n + " ");
//			}
//			System.out.println();
		}
		
//		System.out.println("---------- sorted array ----------");
//		for (String name : sortedArray) {
//			System.out.print(name + " ");
//		}
//		System.out.println();
		return sortedArray;
	}
	
	private String[] getAscendingNameArrayUsingListAPI(List<String> ascendingList) {
		ascendingList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		return ascendingList.toArray(new String[ascendingList.size()]);
	}
	
}
