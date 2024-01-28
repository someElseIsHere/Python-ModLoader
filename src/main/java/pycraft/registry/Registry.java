package pycraft.registry;

import pycraft.Registries;

import java.util.Map;

public abstract class Registry<T> {
    public Registries manager;
    public Map<String, T> registry;

    public Registry(Registries manager) {
        this.manager = manager;
    }

    public void register(T object, String id){
        registry.put(id, object);
    };

    public void register(String id){
        throw new UnsupportedOperationException("Operation not supported by this Type of Registry");
    }

    public abstract void register();
}
