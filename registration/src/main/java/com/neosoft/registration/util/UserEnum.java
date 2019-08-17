package com.neosoft.registration.util;

public class UserEnum {

	public enum GENDER {
		MALE((byte) 1), FEMALE((byte) 0);

		private final byte value;

		GENDER(final byte newValue) {
			value = newValue;
		}

		public byte getValue() {
			return value;
		}
	}

	public enum USER_EXPIRED {

		EXPIRED((byte) 1), UN_EXPIRED((byte) 0);

		private final byte value;

		USER_EXPIRED(final byte newValue) {
			value = newValue;
		}

		public byte getValue() {
			return value;
		}
	}
	
	public enum USER_LOCKED {

		LOCKED((byte) 1), UN_LOCKED((byte) 0);

		private final byte value;

		USER_LOCKED(final byte newValue) {
			value = newValue;
		}
		public byte getValue() {
			return value;
		}
	}
	
	public enum CREDENTIAL {

		EXPIRED((byte) 1), UN_EXPIRED((byte) 0);

		private final byte value;

		CREDENTIAL(final byte newValue) {
			value = newValue;
		}
		public byte getValue() {
			return value;
		}
	}
	public enum USER_ENABLE {

		ENABLE((byte) 1), DESABLE((byte) 0);

		private final byte value;

		USER_ENABLE(final byte newValue) {
			value = newValue;
		}
		public byte getValue() {
			return value;
		}
	}

}
