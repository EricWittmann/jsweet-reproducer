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

import io.apicurio.datamodels.core.Constants;
import io.apicurio.datamodels.core.models.DocumentType;
import io.apicurio.datamodels.openapi.models.OasDocument;
import io.apicurio.datamodels.openapi.models.OasPaths;

/**
 * Models the root document of the OpenAPI 2.0 (aka Swagger) data model.
 * @author eric.wittmann@gmail.com
 */
public class Oas30Document extends OasDocument {

    public String openapi;

    /**
     * Constructor.
     */
    public Oas30Document() {
        this.openapi = Constants.OPEN_API_30_DEFAULT_VERSION;
    }

    /**
     * @see io.apicurio.datamodels.core.models.Document#getDocumentType()
     */
    @Override
    public final DocumentType getDocumentType() {
        return DocumentType.openapi3;
    }

    /**
     * @see io.apicurio.datamodels.openapi.models.OasDocument#createPaths()
     */
    @Override
    public OasPaths createPaths() {
        OasPaths rval = new Oas30Paths();
        rval._ownerDocument = this.ownerDocument();
        rval._parent = this;
        return rval;
    }

}
