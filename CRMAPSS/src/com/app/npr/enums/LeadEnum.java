package com.app.npr.enums;

public class LeadEnum {
	public enum LeadSourceType {
		NONE(0, "Select Lead Source"), MARKETING(1, "MARKETING"), EMAIL(2, "EMAIL");
		private int id;
		private String sourceName;

		private LeadSourceType(int id, String sourceName) {
			this.id = id;
			this.sourceName = sourceName;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSourceName() {
			return sourceName;
		}

		public void setSourceName(String sourceName) {
			this.sourceName = sourceName;
		}

	}

	public enum LeadStatus {
		NONE(0, "Select Status"), ACTIVE(1, "ACTIVE"), DEACTIVE(2, "DEACTIVE"), DEAD(3, "DEAD"), WORKING(4, "WORKING");
		private int id;
		private String fullName;

		public String getFullName() {
			return fullName;
		}

		private LeadStatus(int id, String fullName) {
			this.id = id;
			this.fullName = fullName;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public static LeadStatus getEnum(String value) {
			for (LeadStatus v : values())
				if (v.fullName.equalsIgnoreCase(value))
					return v;
			throw new IllegalArgumentException();
		}
	}

	public enum IndustryType {
		NONE(0,"Select Type Of Industry"),INDUSTRY1(1, "TYPE ONE"), INDUSTRY2(2, "TYPE TWO");
		private IndustryType(int id, String description) {
			this.id = id;
			this.description = description;
		}

		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		private String description;

		public static IndustryType getEnum(String value) {
			for (IndustryType v : values())
				if (v.description.equalsIgnoreCase(value))
					return v;
			throw new IllegalArgumentException();
		}
	}

	public static LeadSourceType getLeadSourceTypeEnum(int param) {

		switch (param) {
		case 0:
			return LeadSourceType.NONE;
		case 1:
			return LeadSourceType.MARKETING;
		case 2:
			return LeadSourceType.EMAIL;
		}
		return LeadSourceType.NONE;
	}

	public static LeadSourceType getLeadSourceTypeEnum(LeadSourceType type){
	  switch(type){
	    case NONE:
	    	return LeadSourceType.NONE;
	    case MARKETING:
	    	return LeadSourceType.MARKETING;
	    case EMAIL:
	    return LeadSourceType.EMAIL;
	  }
	  return LeadSourceType.NONE;
  }

	public static IndustryType getIndustryEnum(int param) {
		switch (param) {
		case 1:
			return IndustryType.INDUSTRY1;
		case 2:
			return IndustryType.INDUSTRY2;
		case 0:
			return IndustryType.NONE;
		default:
			break;
		}
		return IndustryType.INDUSTRY1;

	}

	public static IndustryType getIndustryEnum(IndustryType type) {
		switch (type) {
		case INDUSTRY1:
			return IndustryType.INDUSTRY1;
		case INDUSTRY2:
			return IndustryType.INDUSTRY2;
		case NONE:
			return IndustryType.NONE;
		default:
			break;
		}
		return IndustryType.INDUSTRY1;

	}

	public static LeadStatus getLeadEnum(LeadStatus sts) {
		switch (sts) {
		case ACTIVE:
			return LeadStatus.ACTIVE;
		case DEACTIVE:
			return LeadStatus.DEACTIVE;
		case DEAD:
			return LeadStatus.DEAD;
		case WORKING:
			return LeadStatus.WORKING;
		}
		return LeadStatus.NONE;

	}

	public static LeadStatus getLeadEnum(int param) {
		switch (param) {
		case 1:
			return LeadStatus.ACTIVE;
		case 2:
			return LeadStatus.DEACTIVE;
		case 3:
			return LeadStatus.DEAD;
		case 4:
			return LeadStatus.WORKING;
		}
		return LeadStatus.NONE;
	}
}