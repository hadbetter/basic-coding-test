package com.kjh.study.test.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kjh.study.test.code.NameDetector;

public class NameDetectorTest {
	
	private String[] nameArray;
	private NameDetector nameDetector;
	
	@Before
	public void setup() {
		
		nameArray = new String[] {
				"이유덕", "이재영", "권종표", "이재영", "박민호", "강상희", 
				"이재영", "김지완", "최승혁", "이성연", "박영서", "박민호", 
				"전경헌", "송정환", "김재성", "이유덕", "전경헌"
		};
		
		nameDetector = new NameDetector(nameArray);
		
	}
	
	@Test
	public void getLastNameCount() {
		
		int kimLastNameCount = nameDetector.getCountForLastName("김");
		int leeLastNameCount = nameDetector.getCountForLastName("이");
		assertEquals(2, kimLastNameCount);
		assertEquals(6, leeLastNameCount);
		
	}

	@Test
	public void getFullNameCount() {
		
		int ljyFullNameCount = nameDetector.getCountForFullName("이재영");
		assertEquals(2, ljyFullNameCount);
		
	}
	
	@Test
	public void getDeduplicatedNameArray() {
		
		String[] dedupArray = nameDetector.getDeduplicatedNameArray();
		for (String name : dedupArray) {
			System.out.print(name + " ");
		}
	}
	
	@Test
	public void getAscendingNameArray() {
		String[] ascArray = nameDetector.getAscendingNameArray(nameDetector.getDeduplicatedNameArray());
		for (String name : ascArray) {
			System.out.print(name + " ");
		}
		
	}

}
