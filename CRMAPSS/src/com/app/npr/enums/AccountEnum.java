package com.app.npr.enums;

import org.springframework.security.web.header.writers.frameoptions.StaticAllowFromStrategy;

public class AccountEnum {

	public enum AccountType {
		NONE(0, "NONE"), PROSPECT(1, "PROSPECT"), CUSTOMER(2, "CUSTOMER"), VENDOR(3, "VENDOR");

		private int typeId;
		private String typeName;

		// Enum Constructor only private
		private AccountType(int typeId, String typeName) {
			this.typeId = typeId;
			this.typeName = typeName;
		}

		public int getTypeId() {
			return typeId;
		}

		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}

		public String getTypeName() {
			return typeName;
		}

		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}

		public static AccountType getAcountType(int param) {
			switch (param) {
			case 0:
				return AccountType.NONE;
			case 1:
				return AccountType.PROSPECT;
			case 2:
				return AccountType.CUSTOMER;
			case 3:
				return AccountType.VENDOR;
			default:
				return AccountType.NONE;
			}
		}

		public static AccountType getAccountTypeEnum(AccountType type) {

			switch (type) {
			case NONE:
				return AccountType.NONE;
			case PROSPECT:
				return AccountType.PROSPECT;
			case CUSTOMER:
				return AccountType.CUSTOMER;
			case VENDOR:
				return AccountType.VENDOR;
			default:
				return AccountType.NONE;

			}

		}

	}
}
