package com.playroom.child;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class Child {
	/*
	 CHILD_NAME	VARCHAR2(10 BYTE)
CHILD_AGE	NUMBER
CHILD_PARENTS	VARCHAR2(10 BYTE)
CHILD_CLASS	VARCHAR2(10 BYTE)
CHILD_EXPLAIN	VARCHAR2(4000 BYTE)
	 */
	private String childName;
	private int childAge;
	private String childParents;
	private String childClass;
	private String childExplain;
	
}
