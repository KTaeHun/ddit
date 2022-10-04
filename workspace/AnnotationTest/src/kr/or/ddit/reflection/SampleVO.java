package kr.or.ddit.reflection;

import java.io.Serializable;

public class SampleVO implements Serializable, Comparable<String> {

	public String id;
	protected String name;
	private int age;
	
	
	// 생성자 1
	public SampleVO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	// 생성자 2
	public SampleVO() {
	
	}
	
	@Deprecated // 예전에는 썼지만 지금은 쓰는것을 권장하지 않는다는 의미의 Annotation
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "SampleVO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
