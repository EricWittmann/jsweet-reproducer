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

package io.apicurio.datamodels.core.models;

import io.apicurio.datamodels.core.visitors.IVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Base class for all node types in all data models.
 * @author eric.wittmann@gmail.com
 */
public abstract class NodeImpl implements Node {
    
    private static int __modelIdCounter = 0;

    public Document _ownerDocument;
    public Node _parent;
    protected int _modelId = __modelIdCounter++;
    protected Map<String, Object> _attributes;

	/**
	 * Properties that are present in the source document,
	 * but are not defined in the specification for this node,
	 * so they can't be read directly into the data model fields.
	 */
	protected Map<String, Object> _extraProperties;

    /**
     * Gets the owner document.
     */
    public Document ownerDocument() {
        return this._ownerDocument;
    }

	@Override
	public void setDocument(Document doc) {
		this._ownerDocument = doc;
	}

	@Override
	public void setParent(Node parent) {
		this._parent = parent;
	}

	/**
     * Returns true if this node is extensible.
     */
    public boolean isExtensible() {
        return false;
    }

    /**
     * Gets the parent.
     */
    public Node parent() {
        return this._parent;
    }

    /**
     * Gets the model's unique ID.
     */
    public int modelId() {
        return this._modelId;
    }

	/**
	 * @see IVisitable#accept(IVisitor)
	 */
	public abstract void accept(IVisitor visitor);
	
	/**
	 * Gets a single attribute by name.
	 * @param attributeName
	 */
	public Object getAttribute(String attributeName) {
	    if (this._attributes != null) {
	        return this._attributes.get(attributeName);
	    } else {
	        return null;
	    }
	}

	/**
	 * Sets a single named attribute value.
	 * @param attributeName
	 * @param attributeValue
	 */
	public void setAttribute(String attributeName, Object attributeValue) {
	    if (this._attributes == null) {
	        this._attributes = new HashMap<>();
	    }
	    this._attributes.put(attributeName, attributeValue);
	}
	
	/**
	 * Gets a collection of all the attribute names.
	 */
	public Collection<String> getAttributeNames() {
	    if (this._attributes != null) {
	        return this._attributes.keySet();
	    } else {
	        return Collections.emptyList();
	    }
	}
	
	/**
	 * Deletes all attributes in the node.
	 */
	public void clearAttributes() {
	    if (this._attributes != null) {
	        this._attributes.clear();
	    }
	}

    /**
     * Adds an extra property to the data model.  This is called when the reader encounters a property
     * that is unexpected based on the expected schema.
     * @param key
     * @param value
     */
    public void addExtraProperty(String key, Object value) {
        if (this._extraProperties == null) {
            this._extraProperties = new LinkedHashMap<>();
        }
        this._extraProperties.put(key, value);
    }
    
    public Object removeExtraProperty(String name) {
        if (this._extraProperties != null && this._extraProperties.containsKey(name)) {
            return this._extraProperties.remove(name);
        }
        return null;
    }

    public boolean hasExtraProperties() {
        return this._extraProperties != null && this._extraProperties.size() > 0;
    }

    public List<String> getExtraPropertyNames() {
        if (this.hasExtraProperties()) {
            return new ArrayList<String>(this._extraProperties.keySet());
        }
        return Collections.emptyList();
    }

    public Object getExtraProperty(String name) {
        if (this.hasExtraProperties()) {
            return this._extraProperties.get(name);
        }
        return null;
    }

	/**
	 * Determine if this node has a parent and owner document defined.
	 *
	 * @throws IllegalStateException if the state is inconsistent, i.e. one is set but not the other
	 */
	public boolean isAttached() {
    	if (_parent == null || _ownerDocument == null) {
			if (_parent == null && _ownerDocument == null)
				return false;
			else
				throw new IllegalStateException("Partially attached.");
		}
    	return true;
	}

	/**
	 * Set this {@link NodeImpl} to have the argument as its parent,
	 * and the same {@link Document}.
	 *
	 * Warning: The parent MUST attach this child node separately.
	 *
	 * @throws IllegalArgumentException if the parent is not attached itself
	 * @throws IllegalStateException if the parent's {@link NodeImpl#isAttached()} throws the exception
	 */
	public void attachToParent(Node parent) {
		if (!parent.isAttached()) {
			throw new IllegalArgumentException("Target parent node (method argument) is not itself attached.");
		}
    	this._ownerDocument = parent.ownerDocument();
    	this._parent = parent;
	}

}
