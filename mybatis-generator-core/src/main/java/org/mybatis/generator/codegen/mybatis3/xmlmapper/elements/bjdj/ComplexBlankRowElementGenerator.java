package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.bjdj;

import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 * Created by Administrator on 2015/6/17.
 */
public class ComplexBlankRowElementGenerator extends AbstractXmlElementGenerator{

    @Override
    public void addElements(XmlElement parentElement) {
        TextElement answer = new TextElement(System.getProperty("line.separator"));
        parentElement.addElement(answer);
    }
}
