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

import java.util.List;
import java.util.Map;

/**
 * Models an OpenAPI 3.0.x operation.
 * @author eric.wittmann@gmail.com
 */
public interface Oas30Operation extends OasOperation {

    public Map<String, Oas30Callback> callbacks();

    /**
     * Creates a callback.
     * @param name
     */
    public Oas30Callback createCallback(String name);

    /**
     * Adds a callback.
     * @param name
     * @param callback
     */
    public void addCallback(String name, Oas30Callback callback);

    /**
     * Gets a single callback by name.
     * @param name
     */
    public Oas30Callback getCallback(String name);

    /**
     * Removes a single callback and returns it.  This may return null or undefined if none found.
     * @param name
     */
    public Oas30Callback removeCallback(String name);

    /**
     * Gets a list of all callbacks.
     */
    public List<Oas30Callback> getCallbacks();

}
