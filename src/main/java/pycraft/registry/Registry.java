package pycraft.registry;

public abstract class Registry<T> {
    public String modId;
    public Registry(String modId) {
        this.modId = modId;
    }

    public abstract void register(T object, String id);

    public void register(String id){
        throw new UnsupportedOperationException("Operation not supported by this Type of Registry");
    }
}
