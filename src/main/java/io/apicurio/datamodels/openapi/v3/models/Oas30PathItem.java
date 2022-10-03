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

import io.apicurio.datamodels.openapi.models.OasOperation;
import io.apicurio.datamodels.openapi.models.OasPathItem;

/**
 * Models an OpenAPI 3.0.x path item.
 * @author eric.wittmann@gmail.com
 */
public class Oas30PathItem extends OasPathItem {
    
    public String summary;
    public String description;
    public Oas30Operation trace;

    /**
     * Constructor.
     * @param path
     */
    public Oas30PathItem(String path) {
        super(path);
    }

    /**
     * @see io.apicurio.datamodels.openapi.models.OasPathItem#createOperation(java.lang.String)
     */
    @Override
    public OasOperation createOperation(String method) {
        OasOperation rval = new Oas30Operation(method);
        rval._ownerDocument = this.ownerDocument();
        rval._parent = this;
        return rval;
    }

}
