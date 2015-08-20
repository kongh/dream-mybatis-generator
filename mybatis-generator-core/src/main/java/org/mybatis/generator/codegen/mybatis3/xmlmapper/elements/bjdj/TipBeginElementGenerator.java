package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.bjdj;

import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 * Created by Administrator on 2015/6/18.
 */
public class TipBeginElementGenerator extends AbstractXmlElementGenerator{

    @Override
    public void addElements(XmlElement parentElement) {
        TextElement answer = new TextElement("<!--引入BaseMapper功能，增删列优先用生成器生成新的文件，若有新的sql语句，请在最后面加入-->");
        parentElement.addElement(answer);
    }
}
