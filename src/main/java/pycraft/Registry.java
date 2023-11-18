package pycraft;

import net.minecraft.util.Identifier;

public abstract class Registry<T> {
    public String modId;
    public net.minecraft.registry.Registry<T> registry;

    public Registry(String modId, net.minecraft.registry.Registry<T> registry){
        this.modId = modId;
        this.registry = registry;
    }

    public void register(String id, T object){
        net.minecraft.registry.Registry.register(registry, new Identifier(modId, id), object);
    }

    public abstract void register(String id);
}
