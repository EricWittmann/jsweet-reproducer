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
import io.apicurio.datamodels.core.visitors.IVisitor;
import io.apicurio.datamodels.openapi.models.OasOperation;
import io.apicurio.datamodels.openapi.models.OasPathItem;
import io.apicurio.datamodels.openapi.v3.visitors.IOas30Visitor;

/**
 * Models a callback path item.
 * @author eric.wittmann@gmail.com
 */
public class Oas30CallbackPathItemImpl extends ExtensibleNodeImpl implements Oas30CallbackPathItem {

    public String summary;
    public String description;
    public Oas30Operation trace;

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Oas30Operation trace() {
        return trace;
    }

    /**
     * Constructor.
     * @param path
     */
    public Oas30CallbackPathItemImpl(String path) {
        this._path = path;
    }

    /**
     * @see OasPathItem#createOperation(String)
     */
    @Override
    public OasOperation createOperation(String method) {
        OasOperation rval = new Oas30OperationImpl(method);
        rval.setDocument(this.ownerDocument());
        rval.setParent(this);
        return rval;
    }

    private String _path;
    public String $ref;
    public OasOperation get;
    public OasOperation put;
    public OasOperation post;
    public OasOperation delete;
    public OasOperation options;
    public OasOperation head;
    public OasOperation patch;

    @Override
    public OasOperation get() {
        return get;
    }

    @Override
    public OasOperation put() {
        return put;
    }

    @Override
    public OasOperation post() {
        return post;
    }

    @Override
    public OasOperation delete() {
        return delete;
    }

    @Override
    public OasOperation options() {
        return options;
    }

    @Override
    public OasOperation head() {
        return head;
    }

    @Override
    public OasOperation patch() {
        return patch;
    }

    /**
     * Rename the path item (change its path value).
     * @param newPath
     */
    public void rename(String newPath) {
        this._path = newPath;
    }

    @Override
    public String getReference() {
        return $ref;
    }

    @Override
    public void setReference(String reference) {
        $ref = reference;
    }

    /**
     * Gets the path string.
     */
    public String getPath() {
        return this._path;
    }

    /**
     * @see io.apicurio.datamodels.openapi.models.OasPathItem#accept(IVisitor)
     */
    @Override
    public void accept(IVisitor visitor) {
        IOas30Visitor viz = (IOas30Visitor) visitor;
        viz.visitCallbackPathItem(this);
    }

}
