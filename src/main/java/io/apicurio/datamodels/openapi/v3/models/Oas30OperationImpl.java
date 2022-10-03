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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Models an OpenAPI 3.0.x operation.
 * @author eric.wittmann@gmail.com
 */
public class Oas30OperationImpl extends ExtensibleNodeImpl implements Oas30Operation {

    public Map<String, Oas30Callback> callbacks = new LinkedHashMap<>();

    @Override
    public Map<String, Oas30Callback> callbacks() {
        return callbacks;
    }

    /**
     * Constructor.
     * @param method
     */
    public Oas30OperationImpl(String method) {
        this._type = method;
    }

    /**
     * Creates a callback.
     * @param name
     */
    public Oas30Callback createCallback(String name) {
        Oas30Callback rval = new Oas30CallbackImpl(name);
        rval.setDocument(this.ownerDocument());
        rval.setParent(this);
        return rval;
    }

    /**
     * Adds a callback.
     * @param name
     * @param callback
     */
    public void addCallback(String name, Oas30Callback callback) {
        this.callbacks.put(name, callback);
    }

    /**
     * Gets a single callback by name.
     * @param name
     */
    public Oas30Callback getCallback(String name) {
        return this.callbacks.get(name);
    }

    /**
     * Removes a single callback and returns it.  This may return null or undefined if none found.
     * @param name
     */
    public Oas30Callback removeCallback(String name) {
        return this.callbacks.remove(name);
    }

    public List<String> tags;
    public Boolean deprecated;

    /**
     * Gets the operation's method.
     */
    @Override
    public String getMethod() {
        return this.getType();
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    @Override
    public Boolean isDeprecated() {
        return deprecated;
    }

    /**
     * Gets a list of all callbacks.
     */
    public List<Oas30Callback> getCallbacks() {
        List<Oas30Callback> rval = new ArrayList<>();
        rval.addAll(this.callbacks.values());
        return rval;
    }

    protected String _type;
    public String operationId;
    public String summary;
    public String description;

    /**
     * Gets the operation type.
     */
    public String getType() {
        return this._type;
    }

    /**
     * @see io.apicurio.datamodels.core.models.Node#accept(io.apicurio.datamodels.core.visitors.IVisitor)
     */
    @Override
    public void accept(IVisitor visitor) {
        visitor.visitOperation(this);
    }

}
