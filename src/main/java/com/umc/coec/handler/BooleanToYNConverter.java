package com.umc.coec.handler;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true) //모든 boolean 타입에 자동 적용
public class BooleanToYNConverter implements AttributeConverter<Boolean,String>{

      @Override
      public String convertToDatabaseColumn(Boolean attribute) {
            return (attribute !=null && attribute) ? "Y" :"N";
      }

      @Override
      public Boolean convertToEntityAttribute(String dbData) {
            return "Y".equals(dbData);
      }
}
