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

import java.util.Collection;
import java.util.List;

/**
 * Base class for all node types in all data models.
 * @author eric.wittmann@gmail.com
 */
public interface Node extends IVisitable {

    /**
     * Gets the owner document.
     */
    public Document ownerDocument();

	public void setDocument(Document doc);

    /**
     * Returns true if this node is extensible.
     */
    public boolean isExtensible();

    /**
     * Gets the parent.
     */
    public Node parent();

	public void setParent(Node parent);

    /**
     * Gets the model's unique ID.
     */
    public int modelId();

	/**
	 * Gets a single attribute by name.
	 * @param attributeName
	 */
	public Object getAttribute(String attributeName);

	/**
	 * Sets a single named attribute value.
	 * @param attributeName
	 * @param attributeValue
	 */
	public void setAttribute(String attributeName, Object attributeValue);
	
	/**
	 * Gets a collection of all the attribute names.
	 */
	public Collection<String> getAttributeNames();
	
	/**
	 * Deletes all attributes in the node.
	 */
	public void clearAttributes();

    /**
     * Adds an extra property to the data model.  This is called when the reader encounters a property
     * that is unexpected based on the expected schema.
     * @param key
     * @param value
     */
    public void addExtraProperty(String key, Object value);
    
    public Object removeExtraProperty(String name);

    public boolean hasExtraProperties();

    public List<String> getExtraPropertyNames();

    public Object getExtraProperty(String name);

	/**
	 * Determine if this node has a parent and owner document defined.
	 *
	 * @throws java.lang.IllegalStateException if the state is inconsistent, i.e. one is set but not the other
	 */
	public boolean isAttached();

	/**
	 * Set this {@link io.apicurio.datamodels.core.models.Node} to have the argument as its parent,
	 * and the same {@link io.apicurio.datamodels.core.models.Document}.
	 *
	 * Warning: The parent MUST attach this child node separately.
	 *
	 * @throws java.lang.IllegalArgumentException if the parent is not attached itself
	 * @throws java.lang.IllegalStateException if the parent's {@link Node#isAttached()} throws the exception
	 */
	public void attachToParent(Node parent);

}
