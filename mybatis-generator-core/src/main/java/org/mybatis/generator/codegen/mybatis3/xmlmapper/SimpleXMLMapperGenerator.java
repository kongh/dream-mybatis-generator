/*
 *  Copyright 2012 The MyBatis Team
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.xmlmapper;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.XmlConstants;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.*;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.bjdj.*;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class SimpleXMLMapperGenerator extends AbstractXmlGenerator {

    public SimpleXMLMapperGenerator() {
        super();
    }

    protected XmlElement getSqlMapElement() {
        FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString("Progress.12", table.toString())); //$NON-NLS-1$
        XmlElement answer = new XmlElement("mapper"); //$NON-NLS-1$
        String namespace = introspectedTable.getMyBatis3SqlMapNamespace();
        answer.addAttribute(new Attribute("namespace", //$NON-NLS-1$
                namespace));

        context.getCommentGenerator().addRootComment(answer);

        addTipBeginElement(answer);

        addResultMapElement(answer);
        addBlankRowElement(answer);

        addBaseColumnList(answer);
        addBlankRowElement(answer);

        addComplexInsertElement(answer);
        addBlankRowElement(answer);

        addUpdateElement(answer);
        addBlankRowElement(answer);

        addListElement(answer);
        addBlankRowElement(answer);

        addFindOneElement(answer);
        addBlankRowElement(answer);

        addFindIdsElement(answer);
        addBlankRowElement(answer);

        addCountElement(answer);
        addBlankRowElement(answer);

        addDynamicElements(answer);
        addTipEndElement(answer);
        return answer;
    }

    protected void addTipBeginElement(XmlElement parentElement){
        AbstractXmlElementGenerator elementGenerator = new TipBeginElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addTipEndElement(XmlElement parentElement){
        AbstractXmlElementGenerator elementGenerator = new TipEndElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addBlankRowElement(XmlElement parentElement){
        AbstractXmlElementGenerator elementGenerator = new ComplexBlankRowElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addUpdateElement(XmlElement parentElement){
        AbstractXmlElementGenerator elementGenerator = new ComplexUpdateElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addBaseColumnList(XmlElement parentElement){
        AbstractXmlElementGenerator elementGenerator = new ComplexColumnListElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addResultMapElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateBaseResultMap()) {
            AbstractXmlElementGenerator elementGenerator = new ResultMapWithoutBLOBsElementGenerator(
                    true);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addListElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new ComplexListElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addFindOneElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new ComplexFindOneElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addFindIdsElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new ComplexFindIdsElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addCountElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new ComplexCountElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addDynamicElements(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new ComplexDynamicSqlElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addSelectByPrimaryKeyElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateSelectByPrimaryKey()) {
            AbstractXmlElementGenerator elementGenerator = new SimpleSelectByPrimaryKeyElementGenerator();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addSelectAllElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new SimpleSelectAllElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addDeleteByPrimaryKeyElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateDeleteByPrimaryKey()) {
            AbstractXmlElementGenerator elementGenerator = new DeleteByPrimaryKeyElementGenerator(true);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addComplexInsertElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new InsertDynamicElementGenerator();
        initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addInsertElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateInsert()) {
            AbstractXmlElementGenerator elementGenerator = new InsertElementGenerator(true);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addUpdateByPrimaryKeyElement(XmlElement parentElement) {
        if (introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
            AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeyWithoutBLOBsElementGenerator(
                    true);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void initializeAndExecuteGenerator(
            AbstractXmlElementGenerator elementGenerator,
            XmlElement parentElement) {
        elementGenerator.setContext(context);
        elementGenerator.setIntrospectedTable(introspectedTable);
        elementGenerator.setProgressCallback(progressCallback);
        elementGenerator.setWarnings(warnings);
        elementGenerator.addElements(parentElement);
    }

    @Override
    public Document getDocument() {
        Document document = new Document(
                XmlConstants.MYBATIS3_MAPPER_PUBLIC_ID,
                XmlConstants.MYBATIS3_MAPPER_SYSTEM_ID);
        document.setRootElement(getSqlMapElement());

        if (!context.getPlugins().sqlMapDocumentGenerated(document,
                introspectedTable)) {
            document = null;
        }

        return document;
    }
}
