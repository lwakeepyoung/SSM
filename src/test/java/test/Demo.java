package test;

public class Demo {
	private String name;
	private String sex;
	private String address;
	
	static class Builder{
		private String name;
		private String sex;
		private String address;
		
		public Builder setName(String name){
			this.name = name;
			return this;
		}
		
		public Builder setSex(String sex){
			this.sex = sex;
			return this;
		}
		
		public Builder setAddress(String address){
			this.address = address;
			return this;
		}
	}
	
}
