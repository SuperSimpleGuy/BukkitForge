package org.bukkit.inventory.meta;

import java.util.List;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;

/**
 * This type represents the storage mechanism for auxiliary item data.
 * An implementation will handle the creation and application for ItemMeta.
 * This class should not be implemented by a plugin in a live environment.
 */
public interface ItemMeta extends Cloneable, ConfigurationSerializable {

    /**
     * Checks for existence of a display name
     *
     * @return true if this has a display name
     */
    boolean hasDisplayName();

    /**
     * Gets the display name that is set
     *
     * @return the display name that is set
     */
    String getDisplayName();

    /**
     * Sets the display name
     *
     * @param name the name to set
     */
    void setDisplayName(String name);

    /**
     * Checks for existence of lore
     *
     * @return true if this has lore
     */
    boolean hasLore();

    /**
     * Gets the lore that is set
     *
     * @return a list of lore that is set
     */
    List<String> getLore();

    /**
     * Sets the lore for this item
     *
     * @param lore the lore that will be set
     */
    void setLore(List<String> lore);

    /**
     * Checks for the existence of any enchantments
     *
     * @return true if an enchantment exists on this meta
     */
    boolean hasEnchants();

    /**
     * Checks for existence of the specified enchantment
     *
     * @param ench enchantment to check
     * @return true if this enchantment exists for this meta
     */
    boolean hasEnchant(Enchantment ench);

    /**
     * Checks for the level of the specified enchantment
     *
     * @param ench enchantment to check
     * @return The level that the specified enchantment has, or 0 if none
     */
    int getEnchantLevel(Enchantment ench);

    /**
     * This method gets a copy the enchantments in this ItemMeta
     *
     * @return An immutable copy of the enchantments
     */
    Map<Enchantment, Integer> getEnchants();

    /**
     * This method adds the specified enchantment to this item meta
     *
     * @param ench Enchantment to add
     * @param level Level for the enchantment
     * @param ignoreLevelRestriction this indicates the enchantment should be applied, ignoring the level limit
     * @return true if the item meta changed as a result of this call, false otherwise
     */
    boolean addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction);

    /**
     * This method removes the specified enchantment from this item meta
     *
     * @param ench Enchantment to remove
     * @return true if the item meta changed as a result of this call, false otherwise
     */
    boolean removeEnchant(Enchantment ench);

    @SuppressWarnings("javadoc")
    ItemMeta clone();
}
