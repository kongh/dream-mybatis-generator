package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.bjdj;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 * Created by Administrator on 2015/6/16.
 */
public class ComplexFindOneElementGenerator extends AbstractXmlElementGenerator{

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute("id", "findOne"));
        answer.addAttribute(new Attribute("parameterType", BJDJConstants.PARAMETER_TYPE)); //$NON-NLS-1$
        answer.addAttribute(new Attribute(
                "resultMap", introspectedTable.getBaseResultMapId())); //$NON-NLS-1$
        context.getCommentGenerator().addComment(answer);

        StringBuffer buffer = new StringBuffer();
        buffer.append("select ");
        buffer.append(BJDJConstants.REFID + " ");
        buffer.append(" from ");
        buffer.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(buffer.toString())); //$NON-NLS-1$

        //where reference
        buffer.delete(0, buffer.length());
        buffer.append(BJDJConstants.WHERE_REFERENCE);
        answer.addElement(new TextElement(buffer.toString()));

        //order reference
        buffer.delete(0, buffer.length());
        buffer.append(BJDJConstants.ROW_LOCK_REFERENCE);
        answer.addElement(new TextElement(buffer.toString()));

        parentElement.addElement(answer);
    }

}
