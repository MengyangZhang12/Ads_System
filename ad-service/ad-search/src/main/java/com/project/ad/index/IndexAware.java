package com.project.ad.index;

//索引的增删改查
public interface IndexAware<K, V> {

    /**
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     *
     * @param key
     * @param value
     */
    void add(K key, V value);


    /**
     *
     * @param key
     * @param value
     */
    void update(K key, V value);

    /**
     *
     * @param key
     * @param value
     */
    void delete(K key, V value);
}
