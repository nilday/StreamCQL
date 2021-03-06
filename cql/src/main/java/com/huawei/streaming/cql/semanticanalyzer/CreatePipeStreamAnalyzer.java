/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.streaming.cql.semanticanalyzer;

import com.huawei.streaming.cql.exception.SemanticAnalyzerException;
import com.huawei.streaming.cql.semanticanalyzer.analyzecontext.AnalyzeContext;
import com.huawei.streaming.cql.semanticanalyzer.parser.context.ColumnNameTypeListContext;
import com.huawei.streaming.cql.semanticanalyzer.parser.context.CreatePipeStatementContext;
import com.huawei.streaming.cql.semanticanalyzer.parser.context.ParseContext;

/**
 * 创建管道流语义分析
 * 
 */
public class CreatePipeStreamAnalyzer extends CreateStreamAnalyzer
{
    private CreatePipeStatementContext createPipeStreamParseContext = null;
    
    /**
     * <默认构造函数>
     * @param parseContext 语法解析内容
     * @throws SemanticAnalyzerException 语义分析内容
     */
    public CreatePipeStreamAnalyzer(ParseContext parseContext)
        throws SemanticAnalyzerException
    {
        super(parseContext);
        createPipeStreamParseContext = (CreatePipeStatementContext)parseContext;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public AnalyzeContext analyze()
        throws SemanticAnalyzerException
    {
        String streamName = createPipeStreamParseContext.getStreamName();
        ColumnNameTypeListContext columns = createPipeStreamParseContext.getColumns();
        getAnalyzeContext().setStreamName(streamName);
        getAnalyzeContext().setSchema(createSchema(streamName, columns));
        return getAnalyzeContext();
        
    }
    
}
