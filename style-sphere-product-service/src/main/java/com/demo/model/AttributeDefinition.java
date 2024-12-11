	package com.demo.model;
	
	import java.util.List;
	
	import jakarta.persistence.*;
	
	@Entity
	public class AttributeDefinition {
		@Id
		private long id;
		private String name;
		
		@Enumerated(EnumType.STRING)
		private AttributeType type;
		
		@ElementCollection
		private List<String> allowedValues;
	
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public AttributeType getType() {
			return type;
		}
	
		public void setType(AttributeType type) {
			this.type = type;
		}
	
		public List<String> getAllowedValues() {
			return allowedValues;
		}
	
		public void setAllowedValues(List<String> allowedValues) {
			this.allowedValues = allowedValues;
		}
	
		@Override
		public String toString() {
			return "AttributeDefinition [id=" + id + ", name=" + name + ", type=" + type + ", allowedValues="
					+ allowedValues + "]";
		}
	
		public AttributeDefinition() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		public AttributeDefinition(long id, String name, AttributeType type, List<String> allowedValues) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.allowedValues = allowedValues;
		}
		
		
	}
