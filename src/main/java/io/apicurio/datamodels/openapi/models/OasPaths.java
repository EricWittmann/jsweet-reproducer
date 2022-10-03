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

import io.apicurio.datamodels.core.models.ExtensibleNode;
import io.apicurio.datamodels.core.models.IIndexedNode;

import java.util.List;

/**
 * Modles the OpenAPI paths.
 * @author eric.wittmann@gmail.com
 */
public interface OasPaths extends ExtensibleNode, IIndexedNode<OasPathItem> {

    /**
     * Returns a single path item by name.
     * @param name
     */
    public OasPathItem getPathItem(String name);

    /**
     * Returns an array of all the path items.
     */
    public List<OasPathItem> getPathItems();

    /**
     * Adds a path item.
     * @param name
     * @param pathItem
     */
    public OasPathItem addPathItem(String name, OasPathItem pathItem);

    /**
     * Gets a list of all the path names.
     */
    public List<String> getPathItemNames();

    /**
     * Removes a single path item child model by name.
     * @param path
     */
    public OasPathItem removePathItem(String path);

    /**
     * Creates an OAS path item object.
     * @param path
     */
    public OasPathItem createPathItem(String path);

}
