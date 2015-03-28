package org.rocklass.fullstacklab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity item
 * 
 * @author rocklass
 *
 */
@Entity
public class Item implements org.rocklass.fullstacklab.model.Entity {
    /**
     * Item id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Item check
     */
    @Column
    private boolean checked;

    /**
     * Item description
     */
    @Column
    private String description;

    /**
     * Get item id
     * 
     * @return item id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Set item id
     * 
     * @param id
     *            item id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Is item checked ?
     * 
     * @return item checked
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Set item checked
     * 
     * @param checked
     *            item checked
     */
    public void setChecked(final boolean checked) {
        this.checked = checked;
    }

    /**
     * Get item description
     * 
     * @return item description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set item description
     * 
     * @param description
     *            item description
     */
    public void setDescription(final String description) {
        this.description = description;
    }
}
