package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.bjdj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2015/6/16.
 */
public class BJDJConstants {
    static {
        InputStream inputStream = BJDJConstants.class.getResourceAsStream("/bjdj/constants.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PARAMETER_TYPE =  (String)prop.get("paramerter_type");
    }
    /**
     * parameterType
     */
    public static String PARAMETER_TYPE;

    /**
     * REFID
     */
    public static String REFID = "<include refid=\"Base_Column_List\" />";

    /**
     * whereReference
     */
    public static String WHERE_REFERENCE = "<include refid=\"whereReference\" />";

    /**
     * orderReference
     */
    public static String ORDER_REFERENCE = "<include refid=\"orderReference\" />";

    /**
     * pageReference
     */
    public static String PAGE_REFERENCE = "<include refid=\"pageReference\" />";

    /**
     * rowLockReference
     */
    public static String ROW_LOCK_REFERENCE = "<include refid=\"rowLockReference\"/>";
}
