package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.bjdj;

import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

import java.io.*;

/**
 * Created by Administrator on 2015/6/16.
 */
public class ComplexDynamicSqlElementGenerator extends AbstractXmlElementGenerator{

    @Override
    public void addElements(XmlElement parentElement) {
        InputStream inputStream = this.getClass().getResourceAsStream("/bjdj/dynamic-template.xml");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try{
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null){
                parentElement.addElement(new TextElement(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
