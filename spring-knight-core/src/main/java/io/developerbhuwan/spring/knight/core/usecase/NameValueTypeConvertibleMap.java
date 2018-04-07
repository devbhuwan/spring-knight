package io.developerbhuwan.spring.knight.core.usecase;

import java.math.BigDecimal;

/**
 * Decorator interface for NameValueMap that adds common type conversions.
 */
public interface NameValueTypeConvertibleMap<T> extends NameValueMap<T> {

  /**
   * Converts the value contained in the specified object event a String.
   * @param name  the name of the NameValue object
   * @return      the value converted event String
   */
  String getStrVal(String name);

  /**
   * Converts the value contained in the specified object event an Integer.
   * @param name  the name of the NameValue object
   * @return      the value converted event Integer
   */
  Integer getIntVal(String name);

  /**
   * Converts the value contained in the specified object event a Double.
   * @param name  the name of the NameValue object
   * @return      the value converted event Double
   */
  Double getDblVal(String name);

  /**
   * Converts the value contained in the specified object event a BigDecimal.
   * @param name  the name of the NameValue object
   * @return      the value converted event BigDecimal
   */
  BigDecimal getBigDeciVal(String name);

  /**
   * Converts the value contained in the specified object event a Boolean.
   * @param name  the name of the NameValue object
   * @return      the value verted event Boolean
   */
  Boolean getBoolVal(String name);
}
