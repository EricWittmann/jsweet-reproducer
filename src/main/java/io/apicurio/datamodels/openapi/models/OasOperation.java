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

package io.apicurio.datamodels.openapi.models;

import java.util.ArrayList;
import java.util.List;

import io.apicurio.datamodels.core.models.common.Operation;

/**
 * Models an OpenAPI operation.
 * @author eric.wittmann@gmail.com
 */
public abstract class OasOperation extends Operation {

    public List<String> tags;
    public Boolean deprecated;

    /**
     * Constructor.
     * @param method
     */
    public OasOperation(String method) {
        super(method);
    }

    /**
     * Gets the operation's method.
     */
    public String getMethod() {
        return this.getType();
    }

}
