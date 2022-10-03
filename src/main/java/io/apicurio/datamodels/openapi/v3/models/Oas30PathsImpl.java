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
import io.apicurio.datamodels.core.models.IIndexedNode;
import io.apicurio.datamodels.core.visitors.IVisitor;
import io.apicurio.datamodels.openapi.models.OasPathItem;
import io.apicurio.datamodels.openapi.models.OasPaths;
import io.apicurio.datamodels.openapi.visitors.IOasVisitor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eric.wittmann@gmail.com
 */
public class Oas30PathsImpl extends ExtensibleNodeImpl implements Oas30Paths {

    private Map<String, OasPathItem> _pathItems = new LinkedHashMap<>();

    /**
     * @see io.apicurio.datamodels.core.models.Node#accept(IVisitor)
     */
    @Override
    public void accept(IVisitor visitor) {
        IOasVisitor oasVisitor = (IOasVisitor) visitor;
        oasVisitor.visitPaths(this);
    }

    /**
     * Returns a single path item by name.
     * @param name
     */
    public OasPathItem getPathItem(String name) {
        return this._pathItems.get(name);
    }

    /**
     * Returns an array of all the path items.
     */
    public List<OasPathItem> getPathItems() {
        List<OasPathItem> rval = new ArrayList<>();
        rval.addAll(this._pathItems.values());
        return rval;
    }

    /**
     * Adds a path item.
     * @param name
     * @param pathItem
     */
    public OasPathItem addPathItem(String name, OasPathItem pathItem) {
        this._pathItems.put(name, pathItem);
        return pathItem;
    }

    /**
     * Gets a list of all the path names.
     */
    public List<String> getPathItemNames() {
        List<String> names = new ArrayList<>();
        names.addAll(this._pathItems.keySet());
        return names;
    }

    /**
     * Removes a single path item child model by name.
     * @param path
     */
    public OasPathItem removePathItem(String path) {
        return this._pathItems.remove(path);
    }

    /**
     * @see IIndexedNode#addItem(String, io.apicurio.datamodels.core.models.Node)
     */
    @Override
    public void addItem(String name, OasPathItem item) {
        this.addPathItem(name, item);
    }

    /**
     * @see IIndexedNode#deleteItem(String)
     */
    @Override
    public OasPathItem deleteItem(String name) {
        return this.removePathItem(name);
    }

    /**
     * @see IIndexedNode#getItem(String)
     */
    @Override
    public OasPathItem getItem(String name) {
        return this.getPathItem(name);
    }

    /**
     * @see IIndexedNode#getItemNames()
     */
    @Override
    public List<String> getItemNames() {
        return this.getPathItemNames();
    }

    /**
     * @see IIndexedNode#getItems()
     */
    @Override
    public List<OasPathItem> getItems() {
        return this.getPathItems();
    }

    /**
     * @see OasPaths#createPathItem(String)
     */
    @Override
    public OasPathItem createPathItem(String path) {
        Oas30PathItem pathItem = new Oas30PathItemImpl(path);
        pathItem.setDocument(this.ownerDocument());
        pathItem.setParent(this);
        return pathItem;
    }

}
