package org.activiti.spring.process.variable.types;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

import org.activiti.engine.ActivitiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateExtensionVariableType extends JavaObjectExtensionVariableType {

    public static String defaultFormat = "yyyy-MM-dd";
    public DateFormat format;
    private static final Logger logger = LoggerFactory.getLogger(DateExtensionVariableType.class);


    public DateExtensionVariableType(Class clazz,DateFormat format) {
        super(clazz);
        this.format = format;
    }

    public DateFormat getFormat() {
        return format;
    }

    public void setFormat(DateFormat format) {
        this.format = format;
    }

    @Override
    public void validate(Object var, List<ActivitiException> errors) {
        super.validate(var,errors);
    }

    @Override
    public Object parseFromString(String stringValue) throws ActivitiException {

        try {
            return format.parse(String.valueOf(stringValue));
        } catch (ParseException e) {
            throw new ActivitiException("Error parsing date value " + stringValue, e);
        }
    }
}
