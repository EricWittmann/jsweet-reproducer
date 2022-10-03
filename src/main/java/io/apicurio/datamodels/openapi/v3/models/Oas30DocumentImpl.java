/*
 * Copyright 2019 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.datamodels.openapi.v3.models;

import io.apicurio.datamodels.core.models.ExtensibleNodeImpl;
import io.apicurio.datamodels.core.models.Node;
import io.apicurio.datamodels.core.visitors.IVisitor;
import io.apicurio.datamodels.openapi.models.OasDocument;
import io.apicurio.datamodels.openapi.models.OasPaths;

/**
 * Models the root document of the OpenAPI 2.0 (aka Swagger) data model.
 * @author eric.wittmann@gmail.com
 */
public class Oas30DocumentImpl extends ExtensibleNodeImpl implements Oas30Document {

    public String openapi;

    @Override
    public String getOpenapi() {
        return openapi;
    }

    /**
     * Constructor.
     */
    public Oas30DocumentImpl() {
        this.openapi = "3.0.2";
    }

    /**
     * @see Node#accept(IVisitor)
     */
    @Override
    public void accept(IVisitor visitor) {
        visitor.visitDocument(this);
    }

    public OasPaths paths;

    @Override
    public OasPaths getPaths() {
        return paths;
    }

    @Override
    public boolean isAttached() {
        return true;
    }
    /**
     * @see OasDocument#createPaths()
     */
    @Override
    public OasPaths createPaths() {
        OasPaths rval = new Oas30PathsImpl();
        rval.setDocument(this.ownerDocument());
        rval.setParent(this);
        return rval;
    }

}
