package util;

import java.lang.reflect.Constructor;

public class AssertUtil {

	/**
	 * 如果target为空，则抛出异常，否则返回清理空格后的字符串
	 * 
	 * @param message
	 * @param target
	 * @return
	 */
	public static String isNotBlank(String message, String target) {
		if (target == null || (target = target.trim()).length() == 0) {
			throw new BMSException(message);
		}
		return target;
	}

	public static <T extends Throwable> String isNotBlank(String message, String target, Class<T> type) throws T {

		if (target == null || (target = target.trim()).length() == 0) {
			try {
				Constructor<T> declaredConstructor = type.getDeclaredConstructor(String.class);
				declaredConstructor.setAccessible(true);
				throw declaredConstructor.newInstance(message);
			} catch (Exception e) {
			}
		}
		return target;
	}

	/**
	 * isNotBlank 方法的别名方法，便于调用
	 * 
	 * @param message
	 * @param target
	 * @return
	 */
	public static String $(String message, String target) {
		return isNotBlank(message, target);
	}
	public static <T extends Throwable>String $(String message, String target,Class<T> type) throws T {
		return isNotBlank(message, target,type);
	}

	public static void isNotNull(String message, Object target) {
		if (target == null)
			throw new BMSException(message);
	}

	public static void isNull(String message, Object target) {
		if (target != null)
			throw new BMSException(message);
	}

	public static void isEquals(String message, Object a, Object b) {
		if (a == null ? a != b : !a.equals(b))
			throw new BMSException(message);
	}
	public static void isTrue(String message,boolean b) {
		if (!b)throw new BMSException(message);
	}
	public static void isFlase(String message,boolean b) {
		if (b)throw new BMSException(message);
	}
	public static void isNotEquals(String message, Object a, Object b) {
		if (a == null ? a == b : a.equals(b))
			throw new BMSException(message);
	}

}
